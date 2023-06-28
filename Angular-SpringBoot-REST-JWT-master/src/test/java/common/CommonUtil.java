package common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommonUtil {

    public static boolean compare(String actual, String expectedFile) throws IOException {
        return convertJsonNode(actual).equals(getResultJsonNode(expectedFile));
    }
    private static JsonNode convertJsonNode(String json) throws IOException {
        return new ObjectMapper().readTree(json);
    }

    private static JsonNode getResultJsonNode(String filePath) throws IOException {
        FileInputStream fisTargetFile = new FileInputStream("src/test/resources/expected/" + filePath);
        String data = IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
        return convertJsonNode(data);
    }

    public static String readBody(String filePath) throws IOException {
        FileInputStream fisTargetFile = new FileInputStream("src/test/resources/requestBody/" + filePath);
        return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
    }
}
