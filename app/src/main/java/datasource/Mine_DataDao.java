package datasource;

import rtmppush.hx.com.rtmppush.R;

//MineActivity�������Դ
public class Mine_DataDao {
	private static Mine_Data[]  mine_Datas;
	static {
		mine_Datas=new Mine_Data[3];
		mine_Datas[0]=new Mine_Data(R.drawable.mylistview_2,"我的优惠券");
		mine_Datas[1]=new Mine_Data(R.drawable.mylistview_3,"我的常用联系人");
		mine_Datas[2]=new Mine_Data(R.drawable.mylistview_5,"设置");
		
	}
	public  Mine_Data[] getMine_Datas() {
		return mine_Datas;
	}
	public  void setMine_Datas(Mine_Data[] mine_Datas) {
		Mine_DataDao.mine_Datas = mine_Datas;
	}
	

}
