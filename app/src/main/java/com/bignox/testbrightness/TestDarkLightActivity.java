package com.bignox.testbrightness;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.bignox.testbrightness.theme.util.ColorUiUtil;

/**
 * @author xu.wang
 * @date 2019/2/12 16:50
 * @desc
 */
public class TestDarkLightActivity extends Activity {
    private static final String TAG = "TestDarkLightActivity";

    private Button btn_test_darklight, btn_test_tosecond;
    private int theme1, theme2;
    private int mTheme;
    private RelativeLayout rl_bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theme1 = R.style.theme_1;
        theme2 = R.style.theme_2;
        mTheme = theme1;
        setTheme(mTheme);
        setContentView(R.layout.activity_test_darklight);
        initializeData();
    }


    private void initializeData() {

        rl_bg = findViewById(R.id.rl_main_bg);
        btn_test_darklight = findViewById(R.id.btn_test_darklight);
        btn_test_tosecond = findViewById(R.id.btn_test_tosecond);
        btn_test_darklight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTheme == theme1) {
                    mTheme = theme2;
                    Log.e(TAG, "change theme to 2 ");
                } else if (mTheme == theme2) {
                    mTheme = theme1;
                    Log.e(TAG, "change theme to 1 ");
                }
                setTheme(mTheme);
                ColorUiUtil.changeTheme(getWindow().getDecorView(), getTheme());
            }
        });
        btn_test_tosecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestDarkLightActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    public void setTheme(int resId) {
        super.setTheme(resId);
    }
}
