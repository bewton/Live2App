package utils;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import datasource.LiveCourse;
import datasource.VideoCourse;

/**
 * Created by biwei on 2018/6/9.
 */
public class LiveCourseToJson {
    private static JsonObject jobject;
    private static JsonArray  jsarray;

    public static String creatLCJsObject(LiveCourse lc ){
        jobject= new JsonObject();
       // String courseName;
       //  String url;
       //  String price;//教师名称
       //  int icon;
       //  String content;
       //  ArrayList<String> comments;
        JsonArray jsa= new JsonArray();
        for(int i=0;i<lc.getComments().size();i++) {
            String comment=lc.getComments().get(i);
            jsa.add(comment);
        }
        jobject.addProperty("courseName",lc.getCourseName());
        jobject.addProperty("url",lc.getUrl());
        jobject.addProperty("price",lc.getPrice());
        jobject.addProperty("icon",lc.getIcon());
        jobject.addProperty("content",lc.getContent());
        jobject.add("comments",jsa);

        Log.d("LiveCource",jobject.toString());

        return jobject.toString();
    }

    public static String creatLCJsOArray(List<LiveCourse> lcs ){

        jsarray= new JsonArray();

        for(int j=0;j<lcs.size();j++) {
            LiveCourse lc = lcs.get(j);

            jobject = new JsonObject();
            // String courseName;
            //  String url;
            //  String price;//教师名称
            //  int icon;
            //  String content;
            //  ArrayList<String> comments;
            JsonArray jsa = new JsonArray();
            for (int i = 0; i < lc.getComments().size(); i++) {
                String comment = lc.getComments().get(i);
                jsa.add(comment);
            }
            jobject.addProperty("courseName", lc.getCourseName());
            jobject.addProperty("url", lc.getUrl());
            jobject.addProperty("price", lc.getPrice());
            jobject.addProperty("icon", lc.getIcon());
            jobject.addProperty("content", lc.getContent());
            jobject.add("comments", jsa);
            jsarray.add(jobject);
        }

        Log.d("LiveCources", jsarray.toString());
        return jsarray.toString();
    }
}
