package rtmppush.hx.com.rtmppush.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import datasource.Home_LV_Data;
import rtmppush.hx.com.rtmppush.R;

public class Home_LV_DataListAdapter extends BaseAdapter{
    private  List<Home_LV_Data> home_lv_datas;
    private  Context context;
    private      int layout;
    
	public Home_LV_DataListAdapter(List<Home_LV_Data> home_lv_datas, Context context,
			int layout) {
		super();
		home_lv_datas = home_lv_datas;
		this.context = context;
		this.layout = layout;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return home_lv_datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return home_lv_datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
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
			//vh.image=(ImageView)convertView.findViewById(R.id.);
			//vh.price=(TextView) convertView.findViewById(R.id.);
			//vh.name=(TextView)convertView.findViewById(R.id.);
			//ViewHolder��convertView
			convertView.setTag(vh);
		}
		vh=(ViewHolder)convertView.getTag();

		Home_LV_Data  medicine=home_lv_datas.get(position);
		vh.image.setImageResource(medicine.getIcon());
		vh.price.setText(medicine.getPrice());
		vh.name.setText(medicine.getName());
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
