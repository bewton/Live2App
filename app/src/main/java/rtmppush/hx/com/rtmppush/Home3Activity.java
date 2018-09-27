package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Home3Activity extends FragmentActivity implements View.OnClickListener {
//分享讨论区

    private LinearLayout liLayout1 ;
    private LinearLayout liLayout2 ;
    private LinearLayout liLayout3 ;
    private LinearLayout liLayout4 ;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home3);
        initLayout();
        initView();
        initListener();
    }

    //初始化布局
    public void initLayout() {
        setContentView(R.layout.activity_home3);

    }

    //初始化视图
    public void initView() {

        liLayout1= (LinearLayout) findViewById(R.id.ll_bm_live);
        liLayout2= (LinearLayout) findViewById(R.id.ll_bm_trends);
        liLayout3= (LinearLayout) findViewById(R.id.ll_bm_play);
        liLayout4= (LinearLayout) findViewById(R.id.ll_bm_my);
        tv1=  (TextView)(findViewById(R.id.bm_tv1));
        tv2=  (TextView)(findViewById(R.id.bm_tv2));
        tv3=  (TextView)(findViewById(R.id.bm_tv3));
        tv4=  (TextView)(findViewById(R.id.bm_tv4));

    }

    //初始化数据
    public void initData() {

    }

    //初始化监听器
    public void initListener() {

        liLayout1.setOnClickListener(this);
        liLayout2.setOnClickListener(this);
        liLayout3.setOnClickListener(this);
        liLayout4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //FragmentManager manager=getSupportFragmentManager();
       // FragmentTransaction transaction=manager.beginTransaction();
       // transaction.hide(frg1);
       // transaction.hide(frg2);


        switch(v.getId()){
            case R.id.ll_bm_live:
                Intent intent1 = new Intent(Home3Activity.this,HomeActivity.class);
                startActivity(intent1);
                this.finish();
                break;
            case R.id.ll_bm_trends:
                Intent intent2 = new Intent(Home3Activity.this,Home2Activity.class);
                startActivity(intent2);
                this.finish();
                break;
            case R.id.ll_bm_play:
               // Intent intent3 = new Intent(Home3Activity.this,Home3Activity.class);
               // startActivity(intent3);
               // this.finish();
                break;
            case R.id.ll_bm_my:
                Intent intent4 = new Intent(Home3Activity.this,Home4Activity.class);
                startActivity(intent4);
                this.finish();
                break;

        }
    }


}
