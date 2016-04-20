package cn.edu.csuft.lkdapp.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import cn.edu.csuft.lkdapp.R;

/**
 * Created by Administrator on 2016/4/5 0005.
 */
public class InitActivity extends Activity{
    android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent i = new Intent(InitActivity.this,MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.initactivity_open, 0);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_layout);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
