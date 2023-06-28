package common;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
    private Connection connection;

    //*******************************************//
    private String className = "org.postgresql.Driver";
    private String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
    private String USERNAME = "postgres";
    private String PASSWORD = "1234567890";

    public DatabaseUtil() throws Exception {
        Class.forName(className);
        connection = DriverManager.getConnection(connectionURL,USERNAME, PASSWORD);
    }

    public List<Map<String, Object>> getRecords(String query) throws Exception {
        QueryRunner runner = new QueryRunner();
        return runner.query(connection, query, new MapListHandler());
    }

    public void executeSQL(String filePath) throws Exception {
        String sql = getSQLFromFile(filePath);
        QueryRunner runner = new QueryRunner();
        runner.update(connection, sql, null);
    }

    private String getSQLFromFile(String filePath) throws Exception {
        FileInputStream fisTargetFile = new FileInputStream("src/test/resources/stubdata/" + filePath);
        return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
    }
}
