package rtmppush.hx.com.rtmppush;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import net.PostData;

import java.util.ArrayList;

import datasource.LiveCourse;
import utils.LiveCourseToJson;

public class StartActivity extends Activity implements View.OnClickListener{
    public static final String RTMPURL_MESSAGE = "rtmppush.hx.com.rtmppush.rtmpurl";

    private EditText et_livename;
    private EditText et_livecontent;

    private EditText et_liveteacher;
    private EditText et_liveicon;
    private EditText et_liveurl;

    private Button _startRtmpPushButton = null;

    private String livename;
    private String livecontent;
    private String liveteacher;
    private String liveicon;
    private String liveUrl;
    private ArrayList<String> comments;

    private void InitUI(){

        et_livename=(EditText)findViewById(R.id.livename);
        et_livecontent=(EditText)findViewById(R.id.livecontent);
        et_liveteacher=(EditText)findViewById(R.id.liveteacher);
        et_liveicon=(EditText)findViewById(R.id.liveicon);
        et_liveicon.setText("1231461");
        et_liveurl = (EditText)findViewById(R.id.liveurl);
        _startRtmpPushButton = (Button)findViewById(R.id.startRtmpButton);
        et_liveurl.setText("rtmp://192.168.1.104:1935/live/12345");
        _startRtmpPushButton.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        InitUI();
    }

    @Override
    public void onClick(View v) {
         livename=et_livename.getText().toString();
         livecontent=et_livecontent.getText().toString();
         liveteacher=et_liveteacher.getText().toString();
         liveicon   =et_liveicon.getText().toString();
         liveUrl = et_liveurl.getText().toString();

         comments=new ArrayList<>();
        for(int i=0;i<10;i++){
            comments.add(i,"第"+i+"楼："+livename+"课程不错哦，希望每天都能看"+liveteacher+"老师直播课程");
        }
        LiveCourse lc=new LiveCourse(livename,liveUrl,liveteacher,Integer.parseInt(liveicon),livecontent,comments);
        String liveJsonData=LiveCourseToJson.creatLCJsObject(lc);
        Log.i("ddpost",liveJsonData);
        try {
            PostData.getJsonData("192.168.155.1:8080/uploadandgetdata/test", liveJsonData);
        }catch (Exception e){
            //异常处理
        }

        Intent i = new Intent(StartActivity.this, MainActivity.class);
        i.putExtra(StartActivity.RTMPURL_MESSAGE, liveUrl);
        StartActivity.this.startActivity(i);

    }
}
