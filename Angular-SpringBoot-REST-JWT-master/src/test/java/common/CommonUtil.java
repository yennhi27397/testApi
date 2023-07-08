package common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class CommonUtil {
  private final static String SOURCE_PATH = "src/test/resources/";
  private final static ObjectMapper mapper = new ObjectMapper();

  public static boolean compare(String actual, String expectedFile) throws IOException {
    return convertJsonNode(actual).equals(getResultJsonNode(expectedFile));
  }

  public static boolean compareIgnoreFields(String actual, String expectedFile, String... ignoredFields) throws IOException {
    FileInputStream fisTargetFile = new FileInputStream(SOURCE_PATH + expectedFile);
    Map<String, Object> actualResult = mapper.readValue(actual, Map.class);
    Map<String, Object> expectedResult = mapper.readValue(IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8), Map.class);
    Arrays.stream(ignoredFields).forEach(field -> {
      removeKeyMap(actualResult, field);
      removeKeyMap(expectedResult, field);
    });
    return actualResult.equals(expectedResult);
  }

  private static JsonNode convertJsonNode(String json) throws IOException {
    return new ObjectMapper().readTree(json);
  }

  private static JsonNode getResultJsonNode(String filePath) throws IOException {
    FileInputStream fisTargetFile = new FileInputStream(SOURCE_PATH + filePath);
    String data = IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
    return convertJsonNode(data);
  }

  public static String readBody(String filePath) throws IOException {
    FileInputStream fisTargetFile = new FileInputStream(SOURCE_PATH + filePath);
    return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
  }

  private static void removeKeyMap(Map map, String key) {
    String[] keys = key.split("\\.");
    if (keys.length == 1) {
      map.remove(keys[0]);
      return;
    }
    Map subMap = null;
    for (int i = 0; i < keys.length - 1; i++) {
      if (subMap == null) {
        subMap = (Map) map.get(keys[i]);
      } else {
        subMap = (Map) subMap.get(keys[i]);
      }
    }
    subMap.remove(keys[keys.length - 1]);
  }
}
