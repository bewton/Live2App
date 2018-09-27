package rtmppush.hx.com.rtmppush.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import rtmppush.hx.com.rtmppush.R;

/**
 * Created by biwei on 2018/6/3.
 */
public class FreeVideoFragment1 extends Fragment {
    private TextView free_frag1_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.freevideo_frag1, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        free_frag1_tv=(TextView)getActivity().findViewById(R.id.freevideo_frag1_tv);
        free_frag1_tv.setText(bundle.getString("content"));
    }
}
