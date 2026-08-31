package net.albertoi.objectpool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.naming.SizeLimitExceededException;
import net.albertoi.objectpool.pool.DatabaseConnectionPool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjectPoolTest {

  private DatabaseConnectionPool pool;

  @BeforeEach
  void setUp() {
    pool = new DatabaseConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:test", "SA", "");
    pool.init();
  }

  @Test
  void testDistinctConnections() throws SizeLimitExceededException {
    Connection con1 = pool.get();
    Connection con2 = pool.get();
    Connection con3 = pool.get();
    Connection con4 = pool.get();
    Connection con5 = pool.get();

    assertTrue(pool.validate(con1));
    assertTrue(pool.validate(con2));
    assertTrue(pool.validate(con3));
    assertTrue(pool.validate(con4));
    assertTrue(pool.validate(con5));

    assertNotEquals(con1, con2);
    assertNotEquals(con1, con3);
    assertNotEquals(con1, con4);
    assertNotEquals(con1, con5);
    assertNotEquals(con2, con3);
    assertNotEquals(con2, con4);
    assertNotEquals(con2, con5);
    assertNotEquals(con3, con4);
    assertNotEquals(con3, con5);
    assertNotEquals(con4, con5);
  }

  @Test
  void testReuseConnection() throws SizeLimitExceededException {
    List<Connection> connections = new ArrayList<>();
    Connection con1 = pool.get();
    Connection con2 = pool.get();
    Connection con3 = pool.get();
    Connection con4 = pool.get();
    Connection con5 = pool.get();
    connections.add(con1);
    connections.add(con2);
    connections.add(con3);
    connections.add(con4);
    connections.add(con5);
    pool.free(con1);
    pool.free(con2);
    pool.free(con3);
    pool.free(con4);
    pool.free(con5);

    Connection con6 = pool.get();
    Connection con7 = pool.get();
    Connection con8 = pool.get();
    Connection con9 = pool.get();
    Connection con10 = pool.get();

    assertTrue(connections.contains(con6));
    assertTrue(connections.contains(con7));
    assertTrue(connections.contains(con8));
    assertTrue(connections.contains(con9));
    assertTrue(connections.contains(con10));

  }

  @Test
  void testOverSizeConnections() {
    assertThrows(SizeLimitExceededException.class, () -> {
      pool.get();
      pool.get();
      pool.get();
      pool.get();
      pool.get();
      pool.get();
    });
  }
}
