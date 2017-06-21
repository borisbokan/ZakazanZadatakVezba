package com.borcha.zakazivanjezadatakavezba;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;
/**
 * Created by borcha on 21.06.17..
 */

public class TestServis extends Service {

    private MySyncTimeTask mySyncTas;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    public TestServis(){
        super();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mySyncTas=new MySyncTimeTask(this,342,intent,10);
        mySyncTas.startRepeating();

        stopSelf();
        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mySyncTas.stopRepeating();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
