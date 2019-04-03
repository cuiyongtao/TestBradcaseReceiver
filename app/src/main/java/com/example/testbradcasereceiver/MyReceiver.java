package com.example.testbradcasereceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @Author： Victory
 * @Time： 2019/4/3
 * @Explain：
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.e("testss", "getServers: " + intent.getIntExtra("test", -1));
        if (intent.getIntExtra("test", -1) == 20) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("我是Title");
            dialog.setMessage("我是测试的消息内容");
            dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "点击了确定", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(context, "点击了取消", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = dialog.create();
//            //google规定申请 TYPE_APPLICATION_OVERLAY
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
            alertDialog.show();
        }
    }
}

