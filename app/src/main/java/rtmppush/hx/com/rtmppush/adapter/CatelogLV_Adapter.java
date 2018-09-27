package rtmppush.hx.com.rtmppush.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import rtmppush.hx.com.rtmppush.R;

/**
 * Created by biwei on 2018/6/5.
 */
public class CatelogLV_Adapter extends BaseAdapter {

    private ArrayList<String> texts ;
    private int layout;
    private Context context;
    public CatelogLV_Adapter(Context context , ArrayList<String> texts, int layout
    ) {
        super();
        this.texts = texts;
        this.layout = layout;
        this.context = context;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return texts.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return texts.get(position);
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

            vh.catelog=(TextView) convertView.findViewById(R.id.freevv_frag2tv);

            convertView.setTag(vh);
        }

        vh=(ViewHolder)convertView.getTag();
        String text=texts.get(position);
        vh.catelog.setText(text);
        //3.���ÿؼ���ʾ
        //4.�������յ�view
        return convertView;
    }
    class ViewHolder{

        TextView  catelog;
    }
}
