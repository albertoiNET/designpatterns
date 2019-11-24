package net.albertoi.objectpool;

import java.sql.Connection;
import javax.naming.SizeLimitExceededException;
import lombok.extern.java.Log;
import net.albertoi.objectpool.pool.DatabaseConnectionPool;

@Log
public class MainObjectPool {

  public static void main(String[] args) throws SizeLimitExceededException {
    DatabaseConnectionPool connectionPool = new DatabaseConnectionPool("org.hsqldb.jdbcDriver",
        "jdbc:hsqldb:mem:test", "SA", "");
    connectionPool.init();

    Connection con = connectionPool.get();

    connectionPool.free(con);
  }
}
