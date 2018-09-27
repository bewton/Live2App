package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import net.GetData;

public class MineActivity extends Activity implements View.OnClickListener{


    private TextView tv;



    @Override public void onClick(View v) {
        switch(v.getId()){
            case R.id.ll_bm_live:
                //Intent intent1 = new Intent(Home4Activity.this,HomeActivity.class);
                //startActivity(intent1);
                //this.finish();
                break;
            case R.id.ll_bm_trends:
                //Intent intent2 = new Intent(Home4Activity.this,Home2Activity.class);
                //startActivity(intent2);
                //this.finish();
                break;
            case R.id.ll_bm_play:
                 //Intent intent3 = new Intent(Home4Activity.this,Home3Activity.class);
                // startActivity(intent3);
                // this.finish();
                break;
            case R.id.ll_bm_my:
                //Intent intent4 = new Intent(Home3Activity.this,Home4Activity.class);
               // startActivity(intent4);
               // this.finish();
                break;

        }
    }
}
