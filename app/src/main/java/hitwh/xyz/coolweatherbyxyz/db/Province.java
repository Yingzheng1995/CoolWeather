package hitwh.xyz.coolweatherbyxyz.db;

import org.litepal.crud.DataSupport;

/**
 * Created by ASUS on 2017/2/15.
 */

public class Province extends DataSupport {
    private int id;
    private String  peovinceName;
    private int provinceCode;
    //id 是不同省的特征码
    //peovinceName 省名
    // provinceCode 省的代号


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeovinceName() {
        return peovinceName;
    }

    public void setPeovinceName(String peovinceName) {
        this.peovinceName = peovinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
