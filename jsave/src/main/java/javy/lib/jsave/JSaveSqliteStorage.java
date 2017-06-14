package javy.lib.jsave;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by javy on 2017/6/13.
 */

public class JSaveSqliteStorage extends SQLiteOpenHelper implements JSaveStorage<JSaveDefaultBean> {
    private static final int version = 1;
    private final String tableName = "jsKeyValue";
    private static final String dbName = "jsave.db";

    private final String CREATE_TABLE_SQL = "create table " +
            tableName +
            " (" +
            "strKey TEXT UNIQUE," +
            "strValue TEXT," +
            "strType TEXT" +
            ");";

    public JSaveSqliteStorage() {
        super(JSave.mContext, dbName, null, version);
    }


    @Override
    public boolean save(JSaveDefaultBean jSaveBean) {
        String key = jSaveBean.getStrKey();
        JSaveDefaultBean bean = read(key);
        if (bean != null) {
            boolean isSuccess = delete(key);
            if (!isSuccess) {
                Log.w("jsave faile", "cover faile");
                return false;
            }
        }
        long l = getWritableDatabase().insert(tableName, null, jSaveBean.toContentValue());
        if (l > 0) {
            return true;
        } else {
            Log.w("jsave faile", "save faile");
            return false;

        }
    }

    @Override
    public JSaveDefaultBean read(String key) {
        Cursor cursor = getReadableDatabase().query(tableName, null, "strKey=?", new String[]{key}, null, null, null);
        while(cursor.moveToNext()){
            String value=cursor.getString(cursor.getColumnIndex("strValue"));
            String type=cursor.getString(cursor.getColumnIndex("strType"));
            JSaveDefaultBean jSaveDefaultBean=new JSaveDefaultBean();
            jSaveDefaultBean.setStrKey(key);
            jSaveDefaultBean.setStrType(type);
            jSaveDefaultBean.setStrValue(value);
            cursor.close();
            return jSaveDefaultBean;
        }
        return null;
    }

    @Override
    public int deleteAll() {
        return getWritableDatabase().delete(tableName, null, null);
    }

    @Override
    public boolean delete(String key) {
        int i = getWritableDatabase().delete(tableName, "strKey=?", new String[]{key});
        if (i > 0) {
            return true;
        } else {
            Log.w("jsave faile", "delete key=" + key);

            return false;

        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {

        }

    }
}
