package net.albertoi.objectpool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.naming.SizeLimitExceededException;
import net.albertoi.objectpool.pool.DatabaseConnectionPool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ObjectPoolTest {

  private DatabaseConnectionPool pool;

  @Before
  public void setUp() {
    pool = new DatabaseConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:test", "SA", "");
    pool.init();
  }

  @Test
  public void testDistinctConnections() throws SizeLimitExceededException {
    Connection con1 = pool.get();
    Connection con2 = pool.get();
    Connection con3 = pool.get();
    Connection con4 = pool.get();
    Connection con5 = pool.get();

    Assert.assertTrue(pool.validate(con1));
    Assert.assertTrue(pool.validate(con2));
    Assert.assertTrue(pool.validate(con3));
    Assert.assertTrue(pool.validate(con4));
    Assert.assertTrue(pool.validate(con5));

    Assert.assertNotEquals(con1, con2);
    Assert.assertNotEquals(con1, con3);
    Assert.assertNotEquals(con1, con4);
    Assert.assertNotEquals(con1, con5);

    Assert.assertNotEquals(con2, con1);
    Assert.assertNotEquals(con2, con3);
    Assert.assertNotEquals(con2, con4);
    Assert.assertNotEquals(con2, con5);

    Assert.assertNotEquals(con3, con1);
    Assert.assertNotEquals(con3, con2);
    Assert.assertNotEquals(con3, con4);
    Assert.assertNotEquals(con3, con5);

    Assert.assertNotEquals(con4, con1);
    Assert.assertNotEquals(con4, con2);
    Assert.assertNotEquals(con4, con3);
    Assert.assertNotEquals(con4, con5);

    Assert.assertNotEquals(con5, con1);
    Assert.assertNotEquals(con5, con2);
    Assert.assertNotEquals(con5, con3);
    Assert.assertNotEquals(con5, con4);
  }

  @Test()
  public void testReuseConnection() throws SizeLimitExceededException {
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

    Assert.assertTrue(connections.contains(con6));
    Assert.assertTrue(connections.contains(con7));
    Assert.assertTrue(connections.contains(con8));
    Assert.assertTrue(connections.contains(con9));
    Assert.assertTrue(connections.contains(con10));

  }

  @Test(expected = SizeLimitExceededException.class)
  public void testOverSizeConnections() throws SizeLimitExceededException {
    pool.get();
    pool.get();
    pool.get();
    pool.get();
    pool.get();
    pool.get();
  }
}
