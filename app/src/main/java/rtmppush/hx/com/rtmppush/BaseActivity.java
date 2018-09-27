package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initLayout();
		initView();
		initData();
		createAdapter();
		initListener();

	}
	public abstract void initLayout();
	public abstract void initView();
	public abstract void initData();
	public abstract void createAdapter();
	public abstract void initListener();

}
