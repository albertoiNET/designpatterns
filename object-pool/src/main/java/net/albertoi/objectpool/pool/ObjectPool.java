package net.albertoi.objectpool.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.naming.SizeLimitExceededException;

public abstract class ObjectPool<T> {

  private static final int MIN_INSTANCES = 2;
  private static final int MAX_INSTANCES = 5;

  private final Set<T> free;
  private final Set<T> busy;


  public ObjectPool() {
    this.free = new HashSet<>();
    this.busy = new HashSet<>();
  }

  public synchronized void init() {
    for (int i = 0; i < MIN_INSTANCES; i++) {
      this.free.add(create());
    }
  }

  public abstract T create();

  public abstract boolean validate(T o);

  public abstract void expire(T o);

  public synchronized T get() throws SizeLimitExceededException {
    T t;
    if (!free.isEmpty()) {
      Iterator<T> iterator = free.iterator();
      while (iterator.hasNext()) {
        t = iterator.next();

        if (validate(t)) {
          busy.add(t);
          free.remove(t);
          return t;
        }

        free.remove(t);
        expire(t);
      }
    }

    if (busy.size() < MAX_INSTANCES) {
      t = create();
      busy.add(t);
      return t;
    }
    throw new SizeLimitExceededException("Max size");
  }

  public synchronized void free(T t) {
    busy.remove(t);
    free.add(t);
  }
}
