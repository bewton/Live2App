package rtmppush.hx.com.rtmppush.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import rtmppush.hx.com.rtmppush.R;
import rtmppush.hx.com.rtmppush.adapter.ListView_Adapter;
import rtmppush.hx.com.rtmppush.adapter.TextListView_Adapter;


public class FreeVideoFragment3 extends Fragment {

    private ListView lv;
    private int layout2;
    ArrayList<String> asklist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.freevideo_frag3, null);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        Bundle b3=getArguments();
        asklist=(ArrayList<String>)b3.getStringArrayList("asks");

        lv=(ListView)getActivity().findViewById(R.id.free_frag3_lv);
        layout2=R.layout.freevv_frag3lv_item;
        createAdapter();



        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        //跳转界面

                    }
                });
        //free_frag1_tv=(TextView)getActivity().findViewById(R.id.freevideo_frag1_tv);
    }

    public void createAdapter(){

        //构建listView适配器对象
        TextListView_Adapter lv_Adapter=new TextListView_Adapter(getActivity(),asklist,layout2);
        lv.setAdapter(lv_Adapter);
    }
}
