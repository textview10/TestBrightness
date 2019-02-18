package com.bignox.testbrightness.render;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.bignox.testbrightness.R;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * @author xu.wang
 * @date 2019/2/11 17:45
 * @desc
 */
public class BrightnessModeView extends FrameLayout {
    private static final String TAG = "BrightnessModeView";

    private ArrayList<Integer> mColorList = new ArrayList<>();

    public BrightnessModeView(@NonNull Context context) {
        this(context, null);
    }

    public BrightnessModeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BrightnessModeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeData();
    }

    private void initializeData() {
        mColorList.add(getResources().getColor(R.color.bg0));
        mColorList.add(getResources().getColor(R.color.bg1));
        mColorList.add(getResources().getColor(R.color.bg2));
        mColorList.add(getResources().getColor(R.color.bg3));
        mColorList.add(getResources().getColor(R.color.bg4));
        mColorList.add(getResources().getColor(R.color.bg5));
        mColorList.add(getResources().getColor(R.color.bg6));
        mColorList.add(getResources().getColor(R.color.bg7));
        mColorList.add(getResources().getColor(R.color.bg8));
        mColorList.add(getResources().getColor(R.color.bg9));
    }

    public void setBrightnessMode(float progress) {
        float percent = progress / 100f;
        int index = (int) (progress / 10);
        if (percent > 0.8f) {
            percent = 1f;
        }
        if (percent < 0.2f){
            percent = 0f;
        }
        percent = 1 - percent;
        if (index >= mColorList.size()) {
            return;
        }
        Log.e(TAG, "set bg color index = " + index + " percent = " + percent);
        setBackgroundColor(mColorList.get(index));
        setAlpha(percent);
    }

}
