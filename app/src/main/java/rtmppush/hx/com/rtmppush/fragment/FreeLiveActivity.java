package rtmppush.hx.com.rtmppush.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import common.PlayerManager;
import datasource.LiveCourse;
import datasource.VideoCourse;
import myView.MyVideoView;
import rtmppush.hx.com.rtmppush.HomeActivity;
import rtmppush.hx.com.rtmppush.R;
import utils.Utils;
import widget.media.IjkVideoView;

public class FreeLiveActivity extends FragmentActivity implements View.OnClickListener, PlayerManager.PlayerStateListener{

    //private IjkVideoView free_vv;

    private TextView freevvtv1;
    private TextView freevvtv2;
    private PlayerManager player;

    private boolean fullscreen = true;//全屏/窗口播放切换标志

    //private String url1 = "rtmp://203.207.99.19:1935/live/CCTV5";

    private String url1;
    private FreeLiveFragment1 fvfrag1=new FreeLiveFragment1();
    private FreeLiveFragment2 fvfrag2=new FreeLiveFragment2();


    //private MyPlayerOnCompletionListener myPlayerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_free_live);

        initView();
        freevvtv1.setOnClickListener(this);
        freevvtv2.setOnClickListener(this);

        Intent intent1 =getIntent();
        //vs每一个listview项传递过来的对象
        LiveCourse lc=(LiveCourse)intent1.getSerializableExtra("Home_LV2_Data");
        Log.d("livecourseurl",lc.getUrl());
        Log.d("livecoursecontent",lc.getContent());
        Log.d("livecourseurl",lc.getComments().toString());
        //url1=lc.getUrl();

        //url1="http://123.108.164.71/etv2sb/phd27/playlist.m3u8";
        //url1="http://125.88.92.166:30001/PLTV/88888956/224/3221227692/1.m3u8";
        url1="rtmp://live.hkstv.hk.lxdns.com/live/hks";
        //url1="http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8";
        //url1=Environment.getExternalStorageDirectory().getPath()+"/fl1234.mp4" ;
        Log.d("url",url1);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        /*创建一个Bundle用来存储数据，传递到Fragment中*/
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();

        /*往bundle中添加数据*/
        bundle1.putString("content", lc.getContent());
        fvfrag1.setArguments(bundle1);

        //bundle3.putSerializable("ask",vs.getAskquestion());
        bundle2.putStringArrayList("comments",lc.getComments());
        //bundle3.putParcelableArrayList("asks",vc.getAskquestion());
        fvfrag2.setArguments(bundle2);

        /* 把Fragment添加到对应的位置 */
        transaction.add(R.id.freelc_framelayout, fvfrag1);
        transaction.add(R.id.freelc_framelayout, fvfrag2);
        /* 提交事物 */

        transaction.hide(fvfrag2);
        transaction.show(fvfrag1).commit();

        initPlayer();
        //free_vv=(MyVideoView)findViewById(R.id.free_videoView);
        //本地的视频  需要在手机SD卡根目录添加一个 fl1234.mp4 视频
        //String videoUrl1 = Environment.getExternalStorageDirectory().getPath()+"/fl1234.mp4" ;
        //网络视频

        //String videoUrl2 = Utils.videoUrl;
       // Uri uri = Uri.parse( videoUrl2 );

        //free_vv = (IjkVideoView)this.findViewById(R.id.free_videoView );


        //设置视频路径
        //free_vv.setVideoURI(uri);
        //开始播放视频
        //free_vv.start();

        /*
        if(!fullscreen){//设置RelativeLayout的全屏模式
            RelativeLayout.LayoutParams layoutParams=
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            free_vv.setLayoutParams(layoutParams);

            fullscreen = true;//改变全屏/窗口的标记
        }else{//设置RelativeLayout的窗口模式
            RelativeLayout.LayoutParams lp=new  RelativeLayout.LayoutParams(320,240);
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
            free_vv.setLayoutParams(lp);
            fullscreen = false;//改变全屏/窗口的标记
        }
        */

    }

    private void initPlayer() {
        player = new PlayerManager(this);
        //player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url1);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent i =new Intent();
        i.setClass(FreeLiveActivity.this,HomeActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {
    }


    public void initView(){
        freevvtv1=(TextView)findViewById(R.id.freelvtv1);
        freevvtv2=(TextView)findViewById(R.id.freelvtv2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.freelvtv1:
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.hide(fvfrag2);
                transaction.show(fvfrag1).commit();

                freevvtv1.setTextColor(Color.rgb(47, 194, 125));
                freevvtv2.setTextColor(Color.BLACK);

                break;
            case R.id.freelvtv2:
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();

                transaction2.hide(fvfrag1);
                transaction2.show(fvfrag2).commit();

                freevvtv2.setTextColor(Color.rgb(47, 194, 125));
                freevvtv1.setTextColor(Color.BLACK);
                break;

        }
    }


}
