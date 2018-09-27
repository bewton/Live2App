package net;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Created by biwei on 2018/6/10.
 */
public class PostData {
    private  static String json_response;
    //private  static String localhost="http://192.168.155.1";
    public static  String getJsonData(String url,String postJsonData) throws IOException {
        //不同url返回不同json数据

        OkHttpClient client=new OkHttpClient();
        //FormBody requestbodyBuilder=new FormBody.Builder().build();
        RequestBody  rb=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),postJsonData);

        Request.Builder builder=new Request.Builder();
        Request request=builder.url(url).post(rb).build();
        Response response=client.newCall(request).execute();
        json_response=response.body().string();




        //rb.build().url("")

        return json_response;
    }
}
