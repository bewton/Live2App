package rtmppush.hx.com.rtmppush.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import datasource.Home_LV_Data;
import datasource.VideoCourse;
import datasource.VideoCourseDao;
import rtmppush.hx.com.rtmppush.R;

public class ListView_Adapter extends BaseAdapter{
	private List<VideoCourse>  home_LV_Datas=VideoCourseDao.getVCourses() ;
	private int layout;
	private Context context;
	public ListView_Adapter(Context context ,List<VideoCourse> home_LV_Datas, int layout
			) {
		super();
		this.home_LV_Datas = home_LV_Datas;
		this.layout = layout;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return home_LV_Datas.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return home_LV_Datas.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.i("TAG", "getView()");
		ViewHolder vh=null;
		//�ж�convertView�����Ƿ����
		if(convertView==null){
			//�൱�ڵ�һ�����ص�ʱ��
			//1.����item����
			convertView=
					View.inflate(
							context, layout, null);
			//����ViewHolder���󣬲�������
			vh=new ViewHolder();
			vh.image=(ImageView)convertView.findViewById(R.id.home1_lv_iv);
			vh.price=(TextView) convertView.findViewById(R.id.home1_lv_tv2);
			vh.name=(TextView)convertView.findViewById(R.id.home1_lv_tv1);
			//ViewHolder��convertView
			convertView.setTag(vh);
		}
		vh=(ViewHolder)convertView.getTag();
		
		VideoCourse home_LV_Data=home_LV_Datas.get(position);
		vh.image.setImageResource(home_LV_Data.getIcon());
		vh.price.setText(home_LV_Data.getVc_price());
		vh.name.setText(home_LV_Data.getVcourseName());
		//3.���ÿؼ���ʾ
		//4.�������յ�view
		return convertView;
	}
	class ViewHolder{
		ImageView  image;
		TextView   price;
		TextView  name;
	}
	
	
	
	
	

}
