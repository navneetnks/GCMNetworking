package com.sqldexter.gcmnetworking;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

/**
 * Created by HOME on 15-02-2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    private static PendingIntent pendingIntent;

    public static synchronized PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public static synchronized void setPendingIntent(PendingIntent pendingIntent) {
        AlarmReceiver.pendingIntent = pendingIntent;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "woke up at " + new Date(System.currentTimeMillis()));
    }
}
