package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import datasource.LiveCourse;
import datasource.VideoCourse;

/**
 * Created by biwei on 2018/6/9.
 */
public class LiveCourseJsonParse {
    private  static List<LiveCourse> lcs;

    public static List<LiveCourse>  parse(String lcjson) {
        Gson gson = new Gson();
        List<LiveCourse> lcs=gson.fromJson(lcjson, new TypeToken<List<LiveCourse>>(){}.getType());
        return lcs;
    }
}
