package rtmppush.hx.com.rtmppush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home2_Fragement2 extends Fragment{

	private Button livebtn;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home2_frag2, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		livebtn=(Button)getActivity().findViewById(R.id.home2_fra2_livebtn);

		livebtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent1=new Intent(getActivity(),StartActivity.class);
				startActivity(intent1);
				getActivity().finish();
			}
		});



	}

}
