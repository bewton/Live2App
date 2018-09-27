package rtmppush.hx.com.rtmppush;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import datasource.VideoCourse;
import myView.MyVideoView;

import rtmppush.hx.com.rtmppush.fragment.FreeVideoFragment1;
import rtmppush.hx.com.rtmppush.fragment.FreeVideoFragment2;
import rtmppush.hx.com.rtmppush.fragment.FreeVideoFragment3;
import utils.PixeUtil;
import utils.Utils;

public class FreeVideoActivity extends FragmentActivity implements View.OnClickListener {

    //private MyVideoView free_vv;
    private VideoView videoView;
    private LinearLayout controller_layout;
    private ImageView stop_iv;
    private ImageView fullscreen_iv;
    private TextView time_current_tv;
    private TextView time_total_tv;
    private SeekBar play_seekb;
    private SeekBar volume_seekb;
    private ImageView volume_iv;
    private AudioManager am;

    private  int screen_width;
    private  int screen_height;
    private  RelativeLayout vv_relayout;
    private  LinearLayout ll1;
    private  FrameLayout  frameLayout;

    private static final int UPDATE_UI = 1;


    private TextView freevvtv1;
    private TextView freevvtv2;
    private TextView freevvtv3;

    private boolean isfullscreen = false;//全屏/窗口播放切换标志

    private FreeVideoFragment1 fvfrag1 = new FreeVideoFragment1();
    private FreeVideoFragment2 fvfrag2 = new FreeVideoFragment2();
    private FreeVideoFragment3 fvfrag3 = new FreeVideoFragment3();

    //private MyPlayerOnCompletionListener myPlayerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_free_video);

        am=(AudioManager)getSystemService(AUDIO_SERVICE);
        initUI();
        setPlayerEvent();
        play_seekb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updateTextView(time_current_tv,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                UIHandler.removeMessages(UPDATE_UI);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                int progress=seekBar.getProgress();
                videoView.seekTo(progress);
                UIHandler.sendEmptyMessage(UPDATE_UI);
            }
        });

        volume_seekb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                am.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        volume_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isfullscreen){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
        freevvtv1.setOnClickListener(this);
        freevvtv2.setOnClickListener(this);
        freevvtv3.setOnClickListener(this);

        Intent intent = getIntent();
        //vs每一个listview项传递过来的对象
        VideoCourse vc = (VideoCourse) intent.getSerializableExtra("Home_LV_Data");

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        /*创建一个Bundle用来存储数据，传递到Fragment中*/
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        /*往bundle中添加数据*/
        bundle1.putString("content", vc.getContent());
        fvfrag1.setArguments(bundle1);

        //bundle2.putParcelableArrayList("catelogs", vc.getCatelog());// ("fragData",fragData);
        bundle2.putSerializable("catelogs", vc.getCatelog());
        fvfrag2.setArguments(bundle2);

        //bundle3.putSerializable("ask",vs.getAskquestion());
        bundle3.putStringArrayList("asks", vc.getAskquestion());
        //bundle3.putParcelableArrayList("asks",vc.getAskquestion());
        fvfrag3.setArguments(bundle3);

        /* 把Fragment添加到对应的位置 */
        transaction.add(R.id.freevv_framelayout, fvfrag1);
        transaction.add(R.id.freevv_framelayout, fvfrag2);
        transaction.add(R.id.freevv_framelayout, fvfrag3);
        /* 提交事物 */
        transaction.hide(fvfrag3);
        transaction.hide(fvfrag2);
        transaction.show(fvfrag1).commit();

        //free_vv=(MyVideoView)findViewById(R.id.free_videoView);
        //本地的视频  需要在手机SD卡根目录添加一个 fl1234.mp4 视频
        String videoUrl1 = Environment.getExternalStorageDirectory().getPath() + "/fl1234.mp4";
        //网络视频

        String videoUrl2 = Utils.videoUrl;
        Uri uri = Uri.parse(videoUrl2);

        videoView.setVideoURI(uri);

        UIHandler.sendEmptyMessage(UPDATE_UI);

       // MediaController controller=new MediaController(this);



        //videoView.setMediaController(new MediaController(this));
        //controller.setMediaPlayer(videoView);
        //videoView.start();
        /*
        free_vv = (MyVideoView)this.findViewById(R.id.free_videoView );

        free_vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
           public void onPrepared(MediaPlayer mp)
           {

               mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);


          }
        });
        设置视频控制器
        free_vv.setMediaController(new MediaController(this));
        播放完成回调
        free_vv.setOnCompletionListener(new MyPlayerOnCompletionListener());
        设置视频路径
        free_vv.setVideoURI(uri);
        开始播放视频
        free_vv.start();

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

    private void setVideoViewScale(int width1,int height1,int width2,int height2){

        ViewGroup.LayoutParams layoutParams=videoView.getLayoutParams();
        layoutParams.width=width1;
        layoutParams.height=height1;
        videoView.setLayoutParams(layoutParams);

        ViewGroup.LayoutParams layoutParams1=vv_relayout.getLayoutParams();
        layoutParams1.width=width1;
        layoutParams1.height=height1;
        vv_relayout.setLayoutParams(layoutParams1);

        ViewGroup.LayoutParams layoutParams2=ll1.getLayoutParams();
        layoutParams2.width=width2;
        layoutParams2.height=height2;
        ll1.setLayoutParams(layoutParams2);

        ViewGroup.LayoutParams layoutParams3=frameLayout.getLayoutParams();
        layoutParams3.width=width2;
        layoutParams3.height=height2;
        frameLayout.setLayoutParams(layoutParams3);


    }

    //监听屏幕改变

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){

            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,PixeUtil.dp2px(0),PixeUtil.dp2px(0));
            volume_iv.setVisibility(View.VISIBLE);
            volume_seekb.setVisibility(View.VISIBLE);
            isfullscreen=true;
        }else {

            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, PixeUtil.dp2px(240),ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            volume_iv.setVisibility(View.INVISIBLE);
            volume_seekb.setVisibility(View.INVISIBLE);
            isfullscreen=false;
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        Intent i = new Intent();
        i.setClass(FreeVideoActivity.this, HomeActivity.class);
        startActivity(i);
        finish();
    }

    private void updateTextView(TextView tv, int millsecond) {
        int second = millsecond / 1000;
        int hh = second / 3600;
        int mm = second % 3600 / 60;
        int ss = second % 60;
        String str = null;
        if (hh != 0) {
            str = String.format("%02d:%02d:%02d", hh, mm, ss);
        } else {
            str = String.format("%02d:%02d", mm, ss);
        }
        tv.setText(str);
    }

    private Handler UIHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UPDATE_UI) {
                int currentPosition = videoView.getCurrentPosition();
                int totalduration = videoView.getDuration();
                updateTextView(time_current_tv, currentPosition);
                updateTextView(time_total_tv, totalduration);
                play_seekb.setMax(totalduration);
                play_seekb.setProgress(currentPosition);
                UIHandler.sendEmptyMessageDelayed(UPDATE_UI, 500);
            }
        }

    };


        private void setPlayerEvent() {
            stop_iv.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (videoView.isPlaying()) {
                        stop_iv.setImageResource(R.drawable.icon_stop);
                        videoView.pause();
                        UIHandler.removeMessages(UPDATE_UI);
                    } else {
                        stop_iv.setImageResource(R.drawable.icon_play);
                        videoView.start();
                        UIHandler.sendEmptyMessage(UPDATE_UI);
                    }
                }
            });

        }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        UIHandler.removeMessages(UPDATE_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void initUI() {

            PixeUtil.initContext(this);
            videoView = (VideoView) findViewById(R.id.free_videoView);
            controller_layout = (LinearLayout) findViewById(R.id.controllerbar_layout);
            stop_iv = (ImageView) findViewById(R.id.stop_iv);
            fullscreen_iv = (ImageView) findViewById(R.id.fullscreen_iv);
            time_current_tv = (TextView) findViewById(R.id.vv_time_tv);
            time_total_tv = (TextView) findViewById(R.id.vv_timetotal_tv);
            play_seekb = (SeekBar) findViewById(R.id.seekbar);
            volume_seekb = (SeekBar) findViewById(R.id.volume_seekbar);
            volume_iv=(ImageView)findViewById(R.id.volume_iv);

            screen_width=getResources().getDisplayMetrics().widthPixels;
            screen_height=getResources().getDisplayMetrics().heightPixels;
            vv_relayout=(RelativeLayout)findViewById(R.id.vv_relativelayout);
            ll1=(LinearLayout)findViewById(R.id.freevv_ll1);
            frameLayout=(FrameLayout)findViewById(R.id.freevv_framelayout);

            int  streamMaxVolume=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            int  streamVolume  =am.getStreamVolume(AudioManager.STREAM_MUSIC);
            volume_seekb.setMax(streamMaxVolume);
            volume_seekb.setProgress(streamVolume);

            freevvtv1 = (TextView) findViewById(R.id.freevvtv1);
            freevvtv2 = (TextView) findViewById(R.id.freevvtv2);
            freevvtv3 = (TextView) findViewById(R.id.freevvtv3);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.freevvtv1:
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.hide(fvfrag3);
                    transaction.hide(fvfrag2);
                    transaction.show(fvfrag1).commit();

                    freevvtv1.setTextColor(Color.rgb(47, 194, 125));
                    freevvtv2.setTextColor(android.graphics.Color.BLACK);
                    freevvtv3.setTextColor(android.graphics.Color.BLACK);
                    break;
                case R.id.freevvtv2:
                    FragmentManager manager2 = getSupportFragmentManager();
                    FragmentTransaction transaction2 = manager2.beginTransaction();
                    transaction2.hide(fvfrag3);
                    transaction2.hide(fvfrag1);
                    transaction2.show(fvfrag2).commit();

                    freevvtv2.setTextColor(Color.rgb(47, 194, 125));
                    freevvtv1.setTextColor(android.graphics.Color.BLACK);
                    freevvtv3.setTextColor(android.graphics.Color.BLACK);
                    break;
                case R.id.freevvtv3:
                    FragmentManager manager3 = getSupportFragmentManager();
                    FragmentTransaction transaction3 = manager3.beginTransaction();
                    transaction3.hide(fvfrag1);
                    transaction3.hide(fvfrag2);
                    transaction3.show(fvfrag3).commit();

                    freevvtv3.setTextColor(Color.rgb(47, 194, 125));
                    freevvtv1.setTextColor(android.graphics.Color.BLACK);
                    freevvtv2.setTextColor(android.graphics.Color.BLACK);
                    break;
            }
        }




    }

