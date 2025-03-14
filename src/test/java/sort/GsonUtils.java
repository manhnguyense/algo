package sort;

import com.google.gson.Gson;

public class GsonUtils {
    public static String toString(Object o) {
        return new Gson().toJson(o);
    }
}
