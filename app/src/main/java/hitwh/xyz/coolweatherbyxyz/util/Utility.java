package hitwh.xyz.coolweatherbyxyz.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hitwh.xyz.coolweatherbyxyz.db.City;
import hitwh.xyz.coolweatherbyxyz.db.County;
import hitwh.xyz.coolweatherbyxyz.db.Province;
import hitwh.xyz.coolweatherbyxyz.gson.Weather;

/**
 * Created by ASUS on 2017/2/15.
 */


public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     * @param response
     * @return 成功或失败
     */
    private static final String TAG = "Utility";

    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setPeovinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *
     * 解析和处理服务器返回的市级数据
     * @param response 响应信息
     * @param provinceId 所在省的编号
     * @return 成功或失败
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)) {
            try {
             Log.d(TAG, "handleCityResponse: "+response);

                JSONArray allCities = new JSONArray(response);
                for (int i = 0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceCode(provinceId);
                    city.setCityName(cityObject.getString("name"));
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return false;
    }

    /**
     *  解析和处理服务器返回的县级数据
     * @param response 获得的响应
     * @param cityId 所在市的编号
     * @return 成功或失败
     */

    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<allCounties.length();i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.save();

                }
                return true;


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather类
     * @param response
     * @return
     */
    public static Weather handleWeatherResponse(String response) {
        try {
            Log.d(TAG, "handleWeatherResponse: response"+response);
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
