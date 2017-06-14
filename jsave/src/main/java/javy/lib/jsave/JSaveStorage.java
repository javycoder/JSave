package javy.lib.jsave;

/**
 * Created by javy on 2017/6/13.
 */

public interface JSaveStorage<T> {
    boolean save(T t);

     T read(String key);

    int deleteAll();

    boolean delete(String key);
}
