package rtmppush.hx.com.rtmppush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import datasource.AppUserDao;

public class RegisterActivity extends Activity {
    private EditText regname_et;
    private EditText regnum_et;
    private EditText regpwd_et;
    private EditText regemail_et;
    private Button   reg_btn;
    private AppUserDao userdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_btn= (Button) findViewById(R.id.reg_button);
        regname_et= (EditText) findViewById(R.id.reg_name);
        regnum_et= (EditText) findViewById(R.id.reg_num);
        regpwd_et= (EditText) findViewById(R.id.reg_password);
        regemail_et= (EditText) findViewById(R.id.reg_email);
        userdao = new AppUserDao(this);


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1=regname_et.getText().toString();
                String str2= regnum_et.getText().toString();
                //int str3= -1;
                String str4=regpwd_et.getText().toString();
                String str5= regemail_et.getText().toString();

                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);

                if (userdao.CheckIsDataAlreadyInDBorNot(str2)) {
                    Toast.makeText(RegisterActivity.this,"该用户名已被注册，注册失败",Toast.LENGTH_SHORT).show();
                    Log.i("regmun",str2);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    userdao.insert(str1,str2,str4,str5);
                    startActivity(intent);

                    RegisterActivity.this.finish();
                }

            }
        });
    }

    public boolean CheckIsDataAlreadyInDBorNot(String num,String name) {

        if (userdao.query(num).getCount() > 0) {
            userdao.query(num).close();
            return true;
        }
        userdao.query(num).close();
        return false;
    }
}
