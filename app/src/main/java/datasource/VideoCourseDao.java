package datasource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by biwei on 2018/5/3.
 */
public class VideoCourseDao implements Serializable {

  private static  List vCourses;

static {
    vCourses=new ArrayList();
}


    //获取所有英雄人物
    public static List getVCourses(){
        return vCourses;
    }
    //....
    public static void addVCourses( VideoCourse videoCourse){
        //
        vCourses.add(videoCourse);

    }
}
