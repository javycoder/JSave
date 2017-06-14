#JSave for Android
JSave是一款轻量级的键值对储存android工具库。

## 使用方法

在您的Application调用

``` java
JSave.init(context);
```

###储存

可以储存基本类型float,int,double,long等

``` java
boolean isSuccess=JSave.put("text","Hello world");//储存字符串
```
``` java
JSave.put("float",3.14f);//储存单精度浮点
```
``` java
JSave.put("double",3.1415);//储存双精度浮点
```
``` java
JSave.put("boolean",false);//储存布尔值
```

也可以储存JavaBen等一些简单的Object

``` java
public class TestBean {
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}


```
``` java
TestBean tb=new TestBean();
tb.setLat(12.34567f);
tb.setLon(23.123456f);
JSave.put("object",tb);
```


###读取

``` java
String text=JSave.get("text");//
boolean boo=JSave.get("boolean");
TestBean tb=JSave.get("object");
```

###删除
``` java
//我要删除key为"text"的储存
JSave.put("text",null);
//或者这样写
Boolean isSuccess=JSave.delete("text");
//删除所有数据
int count=JSave.deleteAll();
```

###修改

``` java
//修改“text”的值为"SB"
JSave.put("text","SB");
```
