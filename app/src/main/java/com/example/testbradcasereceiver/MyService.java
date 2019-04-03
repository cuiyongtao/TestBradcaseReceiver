package com.example.testbradcasereceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * @Author： Victory
 * @Time： 2019/4/3
 * @Explain：
 */
public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        handler.postDelayed(runnable, 10);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    int i = 0;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(runnable, 10000);
            i += 10;
            getServer(i);
        }
    };

    /**
     * 从服务端获取数据
     */
    private void getServer(int i) {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("test", i);
        sendBroadcast(intent);


//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        Intent intent = new Intent("com.example.testbradcasereceiver.myreceiver");
//        intent.putExtra("test", i);
//        localBroadcastManager.sendBroadcast(intent);
    }

}
