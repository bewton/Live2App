package utils;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import datasource.LiveCourse;
import datasource.VideoCourse;
import datasource.VideoSource;

/**
 * Created by biwei on 2018/6/9.
 */
public class VideoCourseToJson {
    private static JsonObject jobject;
    private static JsonArray  jsarry;

    public static String creatVCJsObject(VideoCourse vc ){
        jobject= new JsonObject();
       // String courseName;
       //  String url;
       //  String price;//教师名称
       //  int icon;
       //  String content;
       //  ArrayList<String> comments;
        JsonArray jsa= new JsonArray();
        for(int i=0;i<vc.getCatelog().size();i++) {
            VideoSource catelog=vc.getCatelog().get(i);
            JsonObject js=new JsonObject();
            js.addProperty("video_catelog",catelog.getVideo_catelog());
            js.addProperty("url",catelog.getUrl());
            jsa.add(js);
        }

        JsonArray jsa2= new JsonArray();
        for(int i=0;i<vc.getAskquestion().size();i++) {
            String comment=vc.getAskquestion().get(i);
            jsa2.add(comment);
        }

        jobject.addProperty("vcourseName",vc.getVcourseName());
        jobject.addProperty("content",vc.getContent());
        jobject.addProperty("vc_price",vc.getVc_price());
        jobject.addProperty("icon",vc.getIcon());
        jobject.add("catelog",jsa);
        jobject.add("askquestion",jsa2);

        Log.d("VideoCource",jobject.toString());

        return jobject.toString();
    }

    public static String creatVCJsObArray(List<VideoCourse> vcs ){

        jsarry= new JsonArray();

        for(int j=0;j<vcs.size();j++) {
            VideoCourse vc = vcs.get(j);

            jobject = new JsonObject();
            // String courseName;
            //  String url;
            //  String price;//教师名称
            //  int icon;
            //  String content;
            //  ArrayList<String> comments;
            JsonArray jsa = new JsonArray();
            for (int i = 0; i < vc.getCatelog().size(); i++) {
                VideoSource catelog = vc.getCatelog().get(i);
                JsonObject js = new JsonObject();
                js.addProperty("video_catelog", catelog.getVideo_catelog());
                js.addProperty("url", catelog.getUrl());
                jsa.add(js);
            }

            JsonArray jsa2 = new JsonArray();
            for (int i = 0; i < vc.getAskquestion().size(); i++) {
                String comment = vc.getAskquestion().get(i);
                jsa2.add(comment);
            }

            jobject.addProperty("vcourseName", vc.getVcourseName());
            jobject.addProperty("content", vc.getContent());
            jobject.addProperty("vc_price", vc.getVc_price());
            jobject.addProperty("icon", vc.getIcon());
            jobject.add("catelog", jsa);
            jobject.add("askquestion", jsa2);

            jsarry.add(jobject);
        }

        Log.d("VideoCources", jsarry.toString());
        return jsarry.toString();
    }


}
