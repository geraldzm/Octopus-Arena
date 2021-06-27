package Logic;

import com.google.gson.Gson;
import java.lang.reflect.Type;

public class DataParser {

    public <T> T getValueFrom(String json, Class<T> tClass) {
        try{
            return new Gson().fromJson(json, (Type) tClass);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
