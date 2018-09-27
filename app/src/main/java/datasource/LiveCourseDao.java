package datasource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by biwei on 2018/5/3.
 */
public class LiveCourseDao implements Serializable {


    private static List liveCourses;

    static {
        liveCourses=new ArrayList();
    }


    //获取所有英雄人物
    public static List getVCourses(){
        return liveCourses;
    }
    //....
    public static void addVCourses( VideoCourse videoCourse){
        //
        liveCourses.add(videoCourse);

    }
      
}
