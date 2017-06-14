package javy.lib.jsave;

import android.content.Context;
import android.util.Log;

/**
 * Created by javy on 2017/6/13.
 */

public class JSave {
    protected static Context mContext;
    protected static JSaveStorage storage;
    protected static JSaveConverter converter;

    public static void init(Context context) {
        mContext = context;
        storage = new JSaveSqliteStorage();
        converter = new JSaveGsonConverter();
    }


    public static <T> boolean put(String key, T value) {

        Log.d("JSave ", "key:" + key + " value:" + value);
        if (key == null) {
            Log.e("null key", "Key must not be empty");
            return false;
        }

        if (value != null) {
            String strValue = converter.toString(value);
            JSaveDefaultBean jSaveBean = new JSaveDefaultBean();
            jSaveBean.setStrKey(key);
            jSaveBean.setStrValue(strValue);
            jSaveBean.setStrType(value.getClass().getName());
            return storage.save(jSaveBean);
        } else {
            return storage.delete(key);
        }
    }

    public static boolean delete(String key) {
        return storage.delete(key);
    }

    public static <T> T get(String key) {

        if (key == null) {
            return null;
        }
        JSaveDefaultBean bean = (JSaveDefaultBean) storage.read(key);

        if (bean == null) {
            return null;
        }

        String strValue = bean.getStrValue();
        String strClass = bean.getStrType();

        T t = converter.fromString(strValue, strClass);

        return t;
    }


    public static int deleteAll() {
        return storage.deleteAll();
    }


}
