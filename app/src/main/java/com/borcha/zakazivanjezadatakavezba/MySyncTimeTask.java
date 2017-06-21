package com.borcha.zakazivanjezadatakavezba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by borcha on 21.06.17..
 */

public class MySyncTimeTask {

    private int sekOdla;
    private Context cont;
    private AlarmManager manager;
    private PendingIntent pendingIntent;

    /**
     *
     * @param _context
     * @param req_code
     * @param _intent
     * @param _sekOdlaganja   minuti odlaganja tj period nakon pokretanja Intenta
     */
    public MySyncTimeTask(Context _context,int req_code,Intent _intent,int _sekOdlaganja){
        cont=_context;
        sekOdla=_sekOdlaganja;
        pendingIntent = PendingIntent.getService(_context, req_code, _intent, 0);
        manager = (AlarmManager)_context.getSystemService(Context.ALARM_SERVICE);
    }

    //Zaustavlja proces ponavljanja
    public void startRepeating(){
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),  calculateTimeTillNextSyncSec(this.sekOdla), pendingIntent);
        Toast.makeText(cont,"Start zakazan zadatak",Toast.LENGTH_LONG).show();
    }

    //Postavlja vrednsot null na referencu manager
    public void stopRepeating(){
        if(manager!=null){
            manager=null;
            Toast.makeText(cont,"Zakazan zadatak zaustavljen..",Toast.LENGTH_LONG).show();
        }
    }
    private int calculateTimeTillNextSyncMin(int minutes){
        return 1000 * 60 * minutes;
    }

    private int calculateTimeTillNextSyncSec(int sek){
        return 1000 * sek;
    }



}
