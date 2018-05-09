package com.xiaopeng.jingleclock;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Date: 2018/5/8
 * Created by LiuJian
 */

public class DigitalTimeView extends AppCompatTextView {

    private AppCompatTextView mTextView;

    public DigitalTimeView(Context context) {
        super(context);
    }

    public DigitalTimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTextView = (AppCompatTextView) findViewById(R.id.time_view);
        mTextView.setText("");
        mHandler.sendEmptyMessage(0);

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            refreshTime();
            if (getVisibility() == View.VISIBLE) {
                mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };


    private void refreshTime() {
        Calendar calendar = Calendar.getInstance();
        mTextView.setText(String.format("%d:%d:%d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND)));
    }


}
