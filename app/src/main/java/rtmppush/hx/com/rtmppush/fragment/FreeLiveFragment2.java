package rtmppush.hx.com.rtmppush.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import datasource.LiveCourse;
import datasource.VideoSource;
import rtmppush.hx.com.rtmppush.R;
import rtmppush.hx.com.rtmppush.adapter.CatelogLV_Adapter;
import rtmppush.hx.com.rtmppush.adapter.CommentLV_Adapter;

/**
 * Created by biwei on 2018/6/3.
 */
public class FreeLiveFragment2 extends Fragment {

    ListView fvf2_lv;
    int layout2;
    //ArrayList<LiveCourse> fvf2_LV_Datas;
    ArrayList<String> lc_comments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.freelive_frag2, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        Bundle bundle2=getArguments();
        lc_comments=(ArrayList<String>)bundle2.getSerializable("comments");
        //fvf2_LV_Datas=bundle2.getParcelableArrayList("catelogs");
        //lc_comments= new ArrayList<>();

        //for(int i=0;i<fvf2_LV_Datas.size();i++){
           // lc_comments.add(fvf2_LV_Datas.get(i).getComments());

         //   lc_comments.add(fvf2_LV_Datas.)
        //}

        initUI();
        createAdapter();
       // free_frag1_tv=(TextView)getActivity().findViewById(R.id.freevideo_frag1_tv);
        fvf2_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                //跳转界面

                //String video_url = fvf2_LV_Datas.get(position).getUrl();
                //Bundle b = new Bundle();
                //Intent i = new Intent(getActivity(), FreeVideoActivity.class);
                //b.putString("video_url",video_url);
                //i.putExtras(b);
                //startActivity(i);

                }
            });
    }

    public void initUI(){
        fvf2_lv=(ListView) getActivity().findViewById(R.id.freelive_frag2_lv);
        layout2=R.layout.freelive_frag2lv_item;
        //	tv_audienceNumbers=(TextView) getActivity().findViewById(R.id.audienceNumbers_tv);
    }

    public void createAdapter(){

        //构建listView适配器对象
        CommentLV_Adapter lv_Adapter=new CommentLV_Adapter(getActivity(),lc_comments,layout2);
        fvf2_lv.setAdapter(lv_Adapter);
    }
}
