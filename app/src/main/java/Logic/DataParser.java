package Logic;

public class DataParser <T> {

    private T value;

    public DataParser(T value) {
        this.value = value;
    }


    public T getValueFrom(String json) {

       return Gson.getFromJson(T.getClass(), json);

    /*
    * <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.7</version>
</dependency>

    * */
    }

}
