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

  // pass file into param to read body
  public static String readContentFile(String filePath) throws IOException {
    FileInputStream fisTargetFile = new FileInputStream(SOURCE_PATH + filePath);
    return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
  }
}
