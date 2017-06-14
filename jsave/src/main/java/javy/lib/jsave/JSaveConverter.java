package javy.lib.jsave;

/**
 * Created by javy on 2017/6/13.
 */

public interface JSaveConverter {
    <T>String toString(T t);

    <T>T fromString(String str, String type);
}
