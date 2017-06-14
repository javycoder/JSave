package javy.lib.jsave;

import android.content.ContentValues;

/**
 * Created by javy on 2017/6/13.
 */

public class JSaveDefaultBean {
    private String strKey;
    private String strValue;
    private String strType;

    public String getStrKey() {
        return strKey;
    }

    public void setStrKey(String strKey) {
        this.strKey = strKey;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    public ContentValues toContentValue(){
        ContentValues contentValues=new ContentValues();
        contentValues.put("strKey",strKey);
        contentValues.put("strValue",strValue);
        contentValues.put("strType",strType);
        return contentValues;

    }
}
