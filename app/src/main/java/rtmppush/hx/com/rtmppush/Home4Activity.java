package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.os.Bundle;
import datasource.Mine_Data;
import datasource.Mine_DataDao;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import net.GetData;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Home4Activity extends Activity implements OnClickListener{
        private TextView  title;

        private ImageView my_iv;
        private TextView  my_nametv;
        private TextView  my_name;
        private TextView  my_numtv;
        private TextView  my_num;
        private TextView  my_emailtv;
        private TextView  my_email;
        private TextView  my_settingtv;

        private LinearLayout liLayout1 ;
        private LinearLayout liLayout2 ;
        private LinearLayout liLayout3 ;
        private LinearLayout liLayout4 ;


        // ListView  listView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mine);

            title=(TextView)findViewById(R.id.mine_titletv);

            my_nametv=(TextView)findViewById(R.id.my_nametv);
            my_name=(TextView)findViewById(R.id.my_name);
            my_name.setText("李逍遥");

            my_numtv=(TextView)findViewById(R.id.my_numtv);
            my_num=(TextView)findViewById(R.id.my_num);
            my_num.setText("2016214957");

            my_emailtv=(TextView)findViewById(R.id.my_emailtv);
            my_email=(TextView)findViewById(R.id.my_email);
            my_email.setText("155632883@qq.com");

            my_settingtv=(TextView)findViewById(R.id.my_settingtv);



            my_settingtv.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    my_settingtv.setText("getData");
//
//                    String s1=null;
//                    try {
//                       s1= GetData.getJsonData("http://192.168.155.1:8080/uploadandgetdata/test");
//                    }catch (Exception e){
//                        e.getMessage();
//                    }
//                  my_settingtv.setText(s1);
                }
            });

            liLayout1= (LinearLayout) findViewById(R.id.ll_bm_live);
            liLayout2= (LinearLayout) findViewById(R.id.ll_bm_trends);
            liLayout3= (LinearLayout) findViewById(R.id.ll_bm_play);
            liLayout4= (LinearLayout) findViewById(R.id.ll_bm_my);

            liLayout1.setOnClickListener(this);
            liLayout2.setOnClickListener(this);
            liLayout3.setOnClickListener(this);
            liLayout4.setOnClickListener(this);

        }
        @Override public void onClick(View v) {
            switch(v.getId()){
                case R.id.ll_bm_live:
                    Intent intent1 = new Intent(Home4Activity.this,HomeActivity.class);
                    startActivity(intent1);
                    this.finish();
                    break;
                case R.id.ll_bm_trends:
                    Intent intent2 = new Intent(Home4Activity.this,Home2Activity.class);
                    startActivity(intent2);
                    this.finish();
                    break;
                case R.id.ll_bm_play:
                    Intent intent3 = new Intent(Home4Activity.this,Home3Activity.class);
                    startActivity(intent3);
                    this.finish();
                    break;
                case R.id.ll_bm_my:
                    //Intent intent4 = new Intent(Home3Activity.this,Home4Activity.class);
                    // startActivity(intent4);
                    // this.finish();
                    break;

            }
        }
    }



