package rtmppush.hx.com.rtmppush;

import android.content.Intent;
import android.os.Bundle;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import utils.VideoCourseToJson;

public class HomeActivity extends FragmentActivity implements OnClickListener {

    private EditText et_search;
    private TextView home_tv1;
    private TextView home_tv2;
    private TextView home_tv3;
    private TextView home_tv4;

    Home_Fragement1 frg1 = new Home_Fragement1();
    Home_Fragement2 frg2 = new Home_Fragement2();
   // Home_Fragement3 frg3 = new Home_Fragement3();

    //List<Fragment> fragments=new ArrayList();

    private LinearLayout liLayout1;
    private LinearLayout liLayout2;
    private LinearLayout liLayout3;
    private LinearLayout liLayout4;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.home_framelayout, frg1);
        transaction.add(R.id.home_framelayout, frg2);
       // transaction.add(R.id.home_framelayout, frg3);
        //transaction.add(R.id.home1_framelayout, frg4);

        //transaction.hide(frg4);
       // transaction.hide(frg3);
        transaction.hide(frg2);
        transaction.show(frg1).commit();

        initLayout();
        initView();
        initListener();

    }

    //初始化布局
    public void initLayout() {
        setContentView(R.layout.activity_home);

    }

    public void getResponse(){
        OkHttpClient okhp=new OkHttpClient();
        Request.Builder builder=new Request.Builder();
        Request req=builder.get().url("192.168.52.1").build();
        Call call=okhp.newCall(req);
        //call.enqueue();
    }
    //初始化视图
    public void initView() {
        et_search = (EditText) findViewById(R.id.et_search);
        home_tv1 = (TextView) findViewById(R.id.tv1);
        home_tv2 = (TextView) findViewById(R.id.tv2);
        //home_tv3 = (TextView) findViewById(R.id.tv3);

        liLayout1 = (LinearLayout) findViewById(R.id.ll_bm_live);
        liLayout2 = (LinearLayout) findViewById(R.id.ll_bm_trends);
        liLayout3 = (LinearLayout) findViewById(R.id.ll_bm_play);
        liLayout4 = (LinearLayout) findViewById(R.id.ll_bm_my);
        tv1 = (TextView) (findViewById(R.id.bm_tv1));
        tv2 = (TextView) (findViewById(R.id.bm_tv2));
        tv3 = (TextView) (findViewById(R.id.bm_tv3));
        tv4 = (TextView) (findViewById(R.id.bm_tv4));
    }

    //初始化数据
    public void initData() {

    }

    //初始化监听器
    public void initListener() {

        home_tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                //transaction.hide(frg4);
                // transaction.hide(frg3);
                transaction.hide(frg2);
                transaction.show(frg1).commit();
                home_tv1.setTextColor(Color.RED);
                home_tv2.setTextColor(android.graphics.Color.BLACK);

            }
        });
        home_tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                //transaction.hide(frg4);
                // transaction.hide(frg3);
                transaction.hide(frg1);
                transaction.show(frg2).commit();
                home_tv2.setTextColor(Color.RED);
                home_tv1.setTextColor(android.graphics.Color.BLACK);
                //tv3.setTextColor(android.graphics.Color.BLACK);
            }
        });
      //  home_tv3.setOnClickListener(new OnClickListener() {
      //      @Override
      //      public void onClick(View v) {
      //          tv3.setTextColor(Color.rgb(47, 194, 125));
      //          tv2.setTextColor(android.graphics.Color.BLACK);
      //          tv1.setTextColor(android.graphics.Color.BLACK);
      //      }
      //   });
        liLayout1.setOnClickListener(this);
        liLayout2.setOnClickListener(this);
        liLayout3.setOnClickListener(this);
        liLayout4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
   //
   //     FragmentManager manager = getSupportFragmentManager();
   //     FragmentTransaction transaction = manager.beginTransaction();
   //     transaction.hide(frg1);
   //     transaction.hide(frg2);
   //     transaction.hide(frg3);
        //transaction.hide(frg4);

        switch (v.getId()) {
            case R.id.ll_bm_live:
               // tv1.setTextColor(Color.rgb(47, 194, 125));
                //tv2.setTextColor(android.graphics.Color.BLACK);
                //tv3.setTextColor(android.graphics.Color.BLACK);
                //Intent intent1 = new Intent(HomeActivity.this, HomeActivity.class);
                //startActivity(intent1);
                //this.finish();
                break;
            case R.id.ll_bm_trends:

                Intent intent2 = new Intent(HomeActivity.this, Home2Activity.class);
                startActivity(intent2);
                this.finish();
                break;
            case R.id.ll_bm_play:
                Intent intent3 = new Intent(HomeActivity.this, Home3Activity.class);
                startActivity(intent3);
                this.finish();
                break;
            case R.id.ll_bm_my:
                Intent intent4 = new Intent(HomeActivity.this, Home4Activity.class);
                startActivity(intent4);
                this.finish();
                break;


        }
    }
}