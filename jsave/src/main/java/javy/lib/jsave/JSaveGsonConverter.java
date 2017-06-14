package javy.lib.jsave;

import com.google.gson.Gson;

/**
 * Created by javy on 2017/6/13.
 */

public class JSaveGsonConverter implements JSaveConverter {
    private Gson gson;

    public JSaveGsonConverter() {
        gson=new Gson();
    }

    @Override
    public <T> String toString(T t) {
        return gson.toJson(t);
    }

    @Override
    public <T> T fromString(String str,String type) {
        try {
            return (T) gson.fromJson(str,Class.forName(type));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
