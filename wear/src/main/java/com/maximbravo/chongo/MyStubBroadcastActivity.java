package com.maximbravo.chongo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Example shell activity which simply broadcasts to our receiver and exits.
 */
public class MyStubBroadcastActivity extends Activity {
    MyAlarmReceiver alarm = new MyAlarmReceiver();
    public boolean alarmOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.context = this;
        Utils.extractAll();
        loadSharedPrefrences();

        updatePrefrences();
        final Button startStop = (Button) findViewById(R.id.start_stop_button);
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!updatePrefrences()) {
                    if (alarmOn == false) {
                        alarm.setAlarm(getApplicationContext());
                        startStop.setText("Stop");
                        alarmOn = true;
                        updateSharedPrefrences();
                    } else {
                        alarm.cancelAlarm(getApplicationContext());
                        alarmOn = false;
                        Toast.makeText(getApplicationContext(), "Notifications stopped", Toast.LENGTH_SHORT).show();
                        startStop.setText("Start");
                        updateSharedPrefrences();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please choose prefrence", Toast.LENGTH_LONG).show();
                }
            }
        });


        //scheduleNotification(getNotification(), 5000);

//        Intent i = new Intent();
//        i.setAction("com.maximbravo.chongo.SHOW_NOTIFICATION");
//        i.putExtra(MyPostNotificationReceiver.CONTENT_KEY, Utils.title);
//        sendBroadcast(i);
//        finish();
    }

    private void loadSharedPrefrences(){
        SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
        if(settings != null) {
            Utils.selectedRadio = settings.getInt("radio", 0);
            Utils.hsk1pref = settings.getBoolean("hsk1", false);
            Utils.hsk2pref = settings.getBoolean("hsk2", false);
            Utils.hsk3pref = settings.getBoolean("hsk3", false);

            RadioGroup interval = (RadioGroup) findViewById(R.id.interval_prefrence);
            RadioButton prefrence = (RadioButton) interval.getChildAt(Utils.selectedRadio);
            prefrence.setChecked(true);


            CheckBox hsk1check = (CheckBox) findViewById(R.id.hsk1_checkbox);
            if(Utils.hsk1pref) {
                hsk1check.setChecked(true);
            } else {
                hsk1check.setChecked(false);
            }

            CheckBox hsk2check = (CheckBox) findViewById(R.id.hsk2_checkbox);
            if(Utils.hsk2pref) {
                hsk2check.setChecked(true);
            } else {
                hsk2check.setChecked(false);
            }


            CheckBox hsk3check = (CheckBox) findViewById(R.id.hsk3_checkbox);
            if(Utils.hsk3pref) {
                hsk3check.setChecked(true);
            } else {
                hsk3check.setChecked(false);
            }

        }

    }
    private void updateSharedPrefrences() {
        SharedPreferences settings = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("radio", Utils.selectedRadio);
        editor.putBoolean("hsk1", Utils.hsk1pref);
        editor.putBoolean("hsk2", Utils.hsk2pref);
        editor.putBoolean("hsk3", Utils.hsk3pref);
        editor.apply();
    }
    private boolean updatePrefrences() {
        boolean blank = true;
        RadioGroup interval = (RadioGroup) findViewById(R.id.interval_prefrence);
        RadioButton selected = (RadioButton) findViewById(interval.getCheckedRadioButtonId());
        if(selected != null) {
            if (selected.getText().equals(getString(R.string.five))) {
                Utils.frequency = 5;
                Utils.selectedRadio = 0;
            }
            if (selected.getText().equals(getString(R.string.ten))) {
                Utils.frequency = 10;
                Utils.selectedRadio = 1;
            }
            if (selected.getText().equals(getString(R.string.twenty))) {
                Utils.frequency = 20;
                Utils.selectedRadio = 2;
            }
            if (selected.getText().equals(getString(R.string.thirty))) {
                Utils.frequency = 30;
                Utils.selectedRadio = 3;
            }
            if (selected.getText().equals(getString(R.string.hour))) {
                Utils.frequency = 60;
                Utils.selectedRadio = 4;
            }
        }

        CheckBox hsk1check = (CheckBox) findViewById(R.id.hsk1_checkbox);

        if(hsk1check.isChecked()) {
            Utils.hsk1pref = true;
            blank = false;
        } else {
            Utils.hsk1pref = false;
        }

        CheckBox hsk2check = (CheckBox) findViewById(R.id.hsk2_checkbox);

        if(hsk2check.isEnabled()) {
            Utils.hsk2pref = true;
            blank = false;
        } else {
            Utils.hsk2pref = false;
        }

        CheckBox hsk3check = (CheckBox) findViewById(R.id.hsk3_checkbox);
        
        if(hsk3check.isEnabled()) {
            Utils.hsk3pref = true;
            blank = false;
        } else {
            Utils.hsk3pref = false;
        }

        return blank;
    }

}
