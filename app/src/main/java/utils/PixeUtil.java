package utils;

import android.content.Context;

/**
 * Created by biwei on 2018/6/8.
 */


public class PixeUtil {

    private static Context pContext;

    public static void initContext(Context context){
        pContext=context;
    }

    public  static int dp2px(float value){
        final float scale=pContext.getResources().getDisplayMetrics().densityDpi;
        return (int)(value*(scale/160)+0.5f);

    }
}


