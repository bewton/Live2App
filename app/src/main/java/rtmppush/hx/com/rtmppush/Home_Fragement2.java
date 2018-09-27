package rtmppush.hx.com.rtmppush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import datasource.LiveCourse;
import datasource.VideoCourse;
import datasource.VideoSource;
import rtmppush.hx.com.rtmppush.adapter.ListView_Adapter;
import rtmppush.hx.com.rtmppush.adapter.LiveCListView_Adapter;
import rtmppush.hx.com.rtmppush.fragment.FreeLiveActivity;
import utils.LiveCourseToJson;

public class Home_Fragement2 extends Fragment{

	//ListView的布局和数据源
	ListView listView;
	int layout2;
	ArrayList<LiveCourse> home_LV2_Datas;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_frgment2, null);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initUI();
		initData();
		createAdapter();
		//listView设置监听器
		listView.setOnItemClickListener(
				new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(
							AdapterView<?> parent,
							View view,
							int position,
							long id) {
						//跳转界面

						//构建意图对象

							Bundle bundle=new Bundle();
							LiveCourse lc=home_LV2_Datas.get(position);
							bundle.putSerializable("Home_LV2_Data",lc);

						   LiveCourseToJson.creatLCJsObject(lc);
                           LiveCourseToJson.creatLCJsOArray(home_LV2_Datas);
							Intent intent1 = new Intent(getActivity(), FreeLiveActivity.class);
							intent1.putExtras(bundle);
							startActivity(intent1);

							//for(int i=0;i<lc.getAskquestion().size();i++) {
							//	Log.d("ask",lc.getAskquestion().get(i));
							//}

					}
				});
	}

	public void initData() {
		// TODO Auto-generated method stub

		//ListView的布局和数据
		layout2=R.layout.home_item2;
		home_LV2_Datas=new ArrayList<LiveCourse>();

		//上传直播课程

		ArrayList<String> asks1=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks1.add(newComment);
		}
		ArrayList<String> asks2=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks2.add(newComment);
		}
		ArrayList<String> asks3=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks3.add(newComment);
		}
		ArrayList<String> asks4=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks4.add(newComment);
		}
		ArrayList<String> asks5=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks5.add(newComment);
		}
		ArrayList<String> asks6=new ArrayList();
		for(int i=1;i<8;i++){
			String newComment=""+i+"楼:这门课不错，有机会把它学完";
			asks6.add(newComment);
		}

		home_LV2_Datas.add(new LiveCourse("c语言程序设计","rtmp://203.207.99.19:1935/live/CCTV5","王洪",R.drawable.goods01,"本课程是c语言程序设计视频，由王洪老师主讲",asks1));
		home_LV2_Datas.add(new LiveCourse("数据库原理","rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov","￥139.00",R.drawable.goods02,"本课程是数据库原理，由陈明老师主讲",asks2));
		home_LV2_Datas.add(new LiveCourse("数据结构与算法","http://42.96.249.166/live/24035.m3u8","李敏",R.drawable.goods03,"本课程是数据结构与算法，由李敏老师主讲",asks3));
		home_LV2_Datas.add(new LiveCourse("离散数学","http://42.96.249.166/live/24035.m3u8","王洪",R.drawable.goods04,"本课程是离散数学，由王洪老师主讲",asks4));
		home_LV2_Datas.add(new LiveCourse("汇编语言","http://42.96.249.166/live/24035.m3u8","刘峰",R.drawable.goods04,"本课程是软件学院开的课程，由刘峰老师主讲",asks5));
		home_LV2_Datas.add(new LiveCourse("大学英语","http://42.96.249.166/live/24035.m3u8","周宇",R.drawable.englishlesson,"本课程是合工大外语学院开的课程，由周宇老师主讲",asks6));


	}

	public void initUI(){

		//tv1=(TextView) getActivity().findViewById(R.id.tv1);
		//tv2=(TextView) getActivity().findViewById(R.id.tv2);
		//tv3=(TextView) getActivity().findViewById(R.id.tv3);
		//tv4=(TextView) getActivity().findViewById(R.id.tv4);
		listView=(ListView) getActivity().findViewById(R.id.home_fra2_lv);
		//	tv_audienceNumbers=(TextView) getActivity().findViewById(R.id.audienceNumbers_tv);
	}

	public void createAdapter(){

		//构建listView适配器对象
		LiveCListView_Adapter lv_Adapter=new LiveCListView_Adapter(getActivity(),home_LV2_Datas,layout2);
		listView.setAdapter(lv_Adapter);
	}

}



