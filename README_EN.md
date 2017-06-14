# JSave for Android
JSave is a lightweight key to store Android tool library.

## Using Android Studio
Added to the build.gradle file in Android Studio:

``` groovy
dependencies {
compile 'javy.lib:JSave:1.0'
}
```

Call this code in your Application

``` java
JSave.init(context);
```

### Save

You can store basic types such as float, int, double, long, and so on

``` java
boolean isSuccess=JSave.put("text","Hello world");//Save string
```
``` java
JSave.put("float",3.14f);
```
``` java
JSave.put("double",3.1415);
```
``` java
JSave.put("boolean",false);
```

You can also store some simple JavaBen like Object

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


### Get

``` java
String text=JSave.get("text");//
boolean boo=JSave.get("boolean");
TestBean tb=JSave.get("object");
```

### Delete
``` java
//Delete key for "text" storage
JSave.put("text",null);
//Or write like that
Boolean isSuccess=JSave.delete("text");
//Delete all 
int count=JSave.deleteAll();
```

### Modify

``` java
//Change the value of "text" to "SB""
JSave.put("text","SB");
```




