package datasource;

import java.io.Serializable;

import rtmppush.hx.com.rtmppush.R;

/**
 * Created by biwei on 2018/5/3.
 */
public class Home_LV_Dao implements Serializable {
    private static Home_LV_Data[] home_LV_Datas;
    static{
        home_LV_Datas=new Home_LV_Data[4];
        home_LV_Datas[0]=new Home_LV_Data(R.drawable.goods01,"￥179.00","c++程序设计基础");
        home_LV_Datas[1]=(new Home_LV_Data(R.drawable.goods02,"￥129.00","操作系统"));
        home_LV_Datas[2]=(new Home_LV_Data(R.drawable.goods03,"￥99.00","英语写作"));
        home_LV_Datas[3]=(new Home_LV_Data(R.drawable.goods04,"￥299.00","高等数学"));

    }



    //获取所有英雄人物
    public Home_LV_Data[] getMedicines(){
        return home_LV_Datas;
    }
    //....
    public boolean addMedicine( Home_LV_Data home_LV_Data){
        //
        Home_LV_Data[] newHome_LV_Data=
                new Home_LV_Data[home_LV_Datas.length+1];
        //复制....
        home_LV_Datas=newHome_LV_Data;
        return true;
    }
}
