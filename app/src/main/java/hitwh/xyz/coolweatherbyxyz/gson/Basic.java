package hitwh.xyz.coolweatherbyxyz.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2017/2/16.
 *
 * JSON中字段不适合直接作为Java字段命名
 * 用@SerializedName注解的方式 使而知建立映射关系
 */

public class Basic {


    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weathrtId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }

}
