package net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by biwei on 2018/6/10.
 */
public class GetData {

    private  static String json_response;
    public static  String getJsonData(String url) throws IOException {
        //不同url返回不同json数据
        OkHttpClient okhp = new OkHttpClient();
        Request.Builder bulider = new Request.Builder();
        Request request = bulider.get().url(url).build();

        Call call = okhp.newCall(request);
        // Response response=call.execute();


        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

               // e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //返回json字符串;
                json_response= response.body().string();

            }
        });

        return json_response;
    }
}