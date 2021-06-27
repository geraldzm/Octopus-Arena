package Logic;

import com.google.gson.Gson;

public class DataParser <T> {

    public <T> T getValueFrom(String json, Class<T> value) {
        try{
            return new Gson().fromJson(json, value);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getJsonFrom(T value){
        try{
            return new Gson().toJson(value);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
