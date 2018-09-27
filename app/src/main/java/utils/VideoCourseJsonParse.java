package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import datasource.LiveCourse;
import datasource.VideoCourse;

/**
 * Created by biwei on 2018/6/9.
 */
public class VideoCourseJsonParse {

    private  static List<VideoCourse> vcs;

    public static List<VideoCourse>  parse(String vcjson) {
        Gson gson = new Gson();
        List<VideoCourse> vcs=gson.fromJson(vcjson, new TypeToken<List<VideoCourse>>(){}.getType());
        return vcs;
    }
}
