package net.albertoi.objectpool.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.java.Log;

@Log
public class DatabaseConnectionPool extends ObjectPool<Connection> {

  private final String url;
  private final String user;
  private final String pass;

  public DatabaseConnectionPool(String driver, String url, String user, String pass) {
    super();
    try {
      Class.forName(driver).getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.url = url;
    this.user = user;
    this.pass = pass;
  }

  @Override
  public Connection create() {
    try {
      return DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
      log.severe("Cannot create connection " + e.getErrorCode());
      return null;
    }
  }

  @Override
  public boolean validate(Connection connection) {
    try {
      return connection.isValid(0);
    } catch (SQLException e) {
      log.severe("Cannot validate connection " + e.getErrorCode());
      return false;
    }
  }

  @Override
  public void expire(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      log.severe("Cannot close connection " + e.getErrorCode());
    }
  }
}
