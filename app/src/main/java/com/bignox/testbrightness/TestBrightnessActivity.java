package com.bignox.testbrightness;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import com.bignox.testbrightness.render.BrightnessModeView;

/**
 * @author xu.wang
 * @date 2019/2/11 15:18
 * @desc
 */
public class TestBrightnessActivity extends Activity {
    private static final String TAG = "TestBrightnessActivity";

    private AppCompatSeekBar seekbar;
    private BrightnessModeView bmv_test_bright_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bright);
        initializeData();
    }

    private void initializeData() {
        bmv_test_bright_content = findViewById(R.id.bmv_test_bright_content);
        seekbar = findViewById(R.id.sk_test_bright_content);
        
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float brightness = (float) progress / (float) 100;
                bmv_test_bright_content.setBrightnessMode(progress);

                Window window = TestBrightnessActivity.this.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.screenBrightness = brightness;
                window.setAttributes(lp);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
