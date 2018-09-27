package datasource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by biwei on 2018/5/3.
 */
public class AppUserDao {

    Context context;
    DbHelper dbHelper;
    public AppUserDao(Context context) {
        this.context = context;
        dbHelper=new DbHelper(context,"user.db",null,1);
    }

    //获得App用户全局对象
    public User getAppUser(){
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select * from user where usernum=?";
        Cursor cursor= sqLiteDatabase.rawQuery(sql,null);
        if(cursor.moveToFirst()) {
            User.USERNAME = cursor.getString(cursor.getColumnIndex("username"));
            User.USERNUM = cursor.getString(cursor.getColumnIndex("usernum"));
            // User.USERICON=Integer.parseInt(cursor.getString(2));
            User.PASSWORD = cursor.getString(cursor.getColumnIndex("userpassword"));
            User.EMAIL = cursor.getString(cursor.getColumnIndex("useremail"));
        }
        return new User().getAppuser();
    }

    //     往student表中  插入数据方法
    public  void insert(String name,String num,String pwd,String email){
//        获取数据库写的权限 一般都是更新
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
        String sql="insert into user(username,usernum,userpassword,useremail)values(?,?,?,?)";
        sqLiteDatabase.execSQL(sql,new String[]{name,num,pwd,email});
//        ContentValues values=new ContentValues();
//        values.put("num",num);
//        values.put("name",name);
//        sqLiteDatabase.insert("student",null,values);
        sqLiteDatabase.close();
    }

    //    查询数据库方法,  使用数据库读数据库权限的时候，不能调用sqLiteDatabase.close();
    public Cursor query(String num){
        SQLiteDatabase sqLiteDatabase= dbHelper.getReadableDatabase();
        String sql="select usernum from usernum where usernum=?";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,new String[]{num});
        //Log.i("usernum",cursor.getString(0));
        return cursor;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String num){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String Query = "Select usernum from user where usernum =?";
        Cursor cursor = db.rawQuery(Query,new String[] { num });
        if (cursor.getCount()>0){
            if(cursor.moveToFirst())
            Log.i("usernum",cursor.getString(cursor.getColumnIndex("usernum")));
            cursor.close();
            return  true;
        }
        cursor.close();

        return false;
    }
}
