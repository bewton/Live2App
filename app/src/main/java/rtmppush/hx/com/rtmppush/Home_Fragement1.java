package rtmppush.hx.com.rtmppush;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datasource.Home_LV_Data;
import datasource.VideoCourse;
import datasource.VideoSource;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rtmppush.hx.com.rtmppush.adapter.ListView_Adapter;
import utils.VideoCourseToJson;

public class Home_Fragement1 extends Fragment{
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	String str="dd";

	//ListView的布局和数据源
	ListView listView;
	int layout2;
	ArrayList<VideoCourse> home_LV_Datas;

	//final OkHttpClient client=new OkHttpClient();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		return inflater.inflate(R.layout.home_frgment1, null);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)  {
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
									bundle.putSerializable("Home_LV_Data",home_LV_Datas.get(position));

								VideoCourseToJson.creatVCJsObject(home_LV_Datas.get(position));
								VideoCourseToJson.creatVCJsObArray(home_LV_Datas);
 									Intent intent1 = new Intent(getActivity(), FreeVideoActivity.class);
									intent1.putExtras(bundle);
									startActivity(intent1);

							}
						});
	}

	public void initData() {
		// TODO Auto-generated method stub

		//ListView的布局和数据
		layout2=R.layout.home_item1;
		home_LV_Datas=new ArrayList<VideoCourse>();

		//上传视频课程
		ArrayList<VideoSource> vsources1=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.0"+i);
			vsources1.add(newVS);
		}
		ArrayList<VideoSource> vsources2=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.1"+i);
			vsources2.add(newVS);
		}
		ArrayList<VideoSource> vsources3=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.2"+i);
			vsources3.add(newVS);
		}
		ArrayList<VideoSource> vsources4=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.3"+i);
			vsources4.add(newVS);
		}
		ArrayList<VideoSource> vsources5=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.4"+i);
			vsources5.add(newVS);
		}
		ArrayList<VideoSource> vsources6=new ArrayList<>();
		for(int i=1;i<9;i++){
			VideoSource newVS=new VideoSource(""+i,"192.168.5"+i);
			vsources6.add(newVS);
		}

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




		home_LV_Datas.add(new VideoCourse("c语言程序设计","张江",R.drawable.icon1,"本课程是c语言程序设计视频，由张江老师主讲",vsources1,asks1));
		home_LV_Datas.add(new VideoCourse("数据库原理","￥139.00",R.drawable.icon2,"本课程是数据库原理，由陈明老师主讲",vsources2,asks2));
		home_LV_Datas.add(new VideoCourse("数据结构与算法","￥99.00",R.drawable.icon3,"本课程是离散数学，由王洪老师主讲",vsources4,asks4));
		home_LV_Datas.add(new VideoCourse("汇编语言","免费",R.drawable.icon4,"本课程是软件学院开的课程，由郑洪老师主讲",vsources5,asks5));
		home_LV_Datas.add(new VideoCourse("大学英语","免费",R.drawable.englishlesson,"本课程是英语",vsources6,asks6));


	}



	public void initUI(){

		//tv1=(TextView) getActivity().findViewById(R.id.tv1);
		//tv2=(TextView) getActivity().findViewById(R.id.tv2);
		//tv3=(TextView) getActivity().findViewById(R.id.tv3);
		//tv4=(TextView) getActivity().findViewById(R.id.tv4);
		listView=(ListView) getActivity().findViewById(R.id.home_fra1_lv);
	//	tv_audienceNumbers=(TextView) getActivity().findViewById(R.id.audienceNumbers_tv);
	}

	public void createAdapter(){

		//构建listView适配器对象
		ListView_Adapter lv_Adapter=new ListView_Adapter(getActivity(),home_LV_Datas,layout2);
		listView.setAdapter(lv_Adapter);
	}
	

}
