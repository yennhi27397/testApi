package common;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
  private Connection connection;

  //*******************************************//
  // Information to connect DB (Ex: postgres => search 'connect db postgres jdbc java')
  private String className = "org.postgresql.Driver";
  private String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
  private String USERNAME = "postgres";
  private String PASSWORD = "1234567890";
  //*******************************************//

  public DatabaseUtil() throws Exception {
    Class.forName(className);
    connection = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
  }

  // get list record from expected response
  public List<Map<String, Object>> getRecords(String query) throws Exception {
    QueryRunner runner = new QueryRunner();
    return runner.query(connection, query, new MapListHandler());
  }

  // run SQL
  public void executeSQL(String filePath) throws Exception {
    String sql = getSQLFromFile(filePath);
    QueryRunner runner = new QueryRunner();
    runner.update(connection, sql, null);
  }

  private String getSQLFromFile(String filePath) throws Exception {
    // read file return String.
    FileInputStream fisTargetFile = new FileInputStream("src/test/resources/" + filePath);
    return IOUtils.toString(fisTargetFile, StandardCharsets.UTF_8);
  }

  public void stop() throws SQLException {
    // stop connecting to db
    connection.close();
  }
}
