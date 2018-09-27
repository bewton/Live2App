package datasource;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biwei on 2018/5/3.
 */
public class DongTaiDao {
    private static List<DongTai> twitters ;
    static {
        twitters=new ArrayList<>() ;
    }



    public List<DongTai> add(User user , ImageView iv, String text) {
        DongTai newDongTai = new DongTai(user.getAppuser().USERNUM, iv, text);
        twitters.add(newDongTai);
        return  twitters;
    }
}
