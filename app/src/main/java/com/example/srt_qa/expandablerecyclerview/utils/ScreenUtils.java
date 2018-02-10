package com.example.srt_qa.expandablerecyclerview.utils;

import android.content.Context;

/**
 * Created by sunpeng on 2018/2/10.
 */

public class ScreenUtils {
    public static int dpToPxInt(Context context, float dp) {
        return (int) (dpToPx(context, dp) + 0.5f);
    }

    public static float dpToPx(Context context, float dp) {
        if (context == null) {
            return -1;
        }
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
