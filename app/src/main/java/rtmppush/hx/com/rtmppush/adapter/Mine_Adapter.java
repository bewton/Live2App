package rtmppush.hx.com.rtmppush.adapter;

import datasource.Mine_Data;
import datasource.Mine_DataDao;
import rtmppush.hx.com.rtmppush.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Mine_Adapter extends BaseAdapter{
    Context context;
        int layout;
        Mine_Data[] mine_Datas;
        
	public Mine_Adapter(Context context, int layout, Mine_Data[] mine_Datas) {
			super();
			this.context = context;
			this.layout = layout;
			this.mine_Datas = mine_Datas;
		}
        
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mine_Datas.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mine_Datas[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//ViewHolder vh=null;
		//if(convertView==null){
		 //   vh=new ViewHolder();
			convertView=View.inflate(context, layout, null);
		 //   ImageView imageView=(ImageView) convertView.findViewById(R.id.my_lv_imagView);
		 //   TextView  textView= (TextView) convertView.findViewById(R.id.my_lv_textView);
		//vh.imageView= (ImageView) convertView.findViewById(R.id.imageView);
		//vh.textView= (TextView) convertView.findViewById(R.id.textView);
		//convertView.setTag(vh);
		//}
		//else
		 //   vh=(ViewHolder)convertView.getTag();
		    Mine_Data mine_Data=mine_Datas[position];
		//    imageView.setImageResource(mine_Data.getImage());
		 //   textView.setText(mine_Data.getText());
		 //  vh.imageView.setImageResource(mine_Data.getImage());
		 //  vh.textView.setText(mine_Data.getText());
		    return convertView;
	}
	//class ViewHolder{
	//	ImageView imageView;
	//	TextView  textView;
	//}

}
