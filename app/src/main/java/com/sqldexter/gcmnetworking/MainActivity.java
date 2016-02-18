package com.sqldexter.gcmnetworking;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG=MainActivity.class.getSimpleName();
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private ProgressBar mRegProgressBar;
    private BroadcastReceiver mRegBroadcastReceiver;
    private TextView mInfoTextView,mTokenTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mRegProgressBar=(ProgressBar)findViewById(R.id.registrationProgressBar);
        mRegProgressBar.setOnClickListener(this);
        Button btnNext=(Button)findViewById(R.id.nextBtn);
        btnNext.setOnClickListener(this);
        mInfoTextView=(TextView)findViewById(R.id.infoTextView);
        mTokenTextView=(TextView)findViewById(R.id.tokenTextView);
//        BroadcastReceiver Object for getting notified when registration completed
        mRegBroadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mRegProgressBar.setVisibility(ProgressBar.GONE);
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(LocalPreferences.TOKEN_SENT_TO_SERVER, false);
                if (sentToken) {
                    mInfoTextView.setText(getString(R.string.gcm_send_message));
                    mTokenTextView.setText(intent.getExtras().getString("token"));
                    Snackbar.make(mInfoTextView, "Copy: Long press on token text", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                } else {
                    mInfoTextView.setText(getString(R.string.token_error_message));
                }
            }
        };

        LocalBroadcastManager.getInstance(this).registerReceiver(mRegBroadcastReceiver,
                new IntentFilter(LocalPreferences.REGISTRATION_COMPLETE));
        Log.d(TAG,"Registered mRegBroadcastReceiver");
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, GCMRegIntentService.class);
            startService(intent);
        }

//        if(AlarmReceiver.getPendingIntent()==null) {
//            Intent alarmIntent = new Intent(this, AlarmReceiver.class);
//            alarmIntent.setAction("com.sqldexter.gcmnetworking.AlarmReceiver");
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//            startAlarm(pendingIntent);
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegBroadcastReceiver);
        super.onPause();
    }
    @Override
    public void onClick(View v) {
        int itemId=v.getId();
        if(itemId==R.id.nextBtn){
            Intent intent=new Intent(MainActivity.this,Bidding.class);
            startActivity(intent);
        }


    }
//    Check the device to make sure it has the Google Play Services APK
    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
    private void startAlarm(PendingIntent pendingIntent){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = 30000;

        manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();

    }
}
