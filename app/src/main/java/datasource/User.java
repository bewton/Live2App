package datasource;

import android.app.Application;

/**
 * Created by biwei on 2018/5/3.
 */
public class User extends Application{

    private User user;

    public static String USERNUM;
    public static String USERNAME;
    public static int USERICON;
    public static String PASSWORD;
    public static String EMAIL;
    //private String pay_account;

    public static void setUSERNUM(String usernum){USERNUM=usernum;}
    public static void setUSERNAME(String username){USERNAME=username;}
    public static void setUSERICON(int userIcon){USERICON=userIcon;}
    public static void setPASSWORD(String pwd){PASSWORD=pwd;}
    public static void setEMAIL(String email){EMAIL=email;}

    public User getAppuser(){return user;}
    @Override
    public void onCreate() {
        super.onCreate();
        this.user =this;
    }
}
