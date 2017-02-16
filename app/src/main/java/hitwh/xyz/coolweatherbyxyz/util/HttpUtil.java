package hitwh.xyz.coolweatherbyxyz.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ASUS on 2017/2/15.
 */
/**
 *
 * @author 许颖正
 *
 */
public class HttpUtil {
    /**
     *
     * @param address  目标链接地址
     * @param callback 接口内有onResponse 和 onFailure 两个方法
     */
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }
}
