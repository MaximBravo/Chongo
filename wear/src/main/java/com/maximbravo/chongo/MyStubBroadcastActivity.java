package com.maximbravo.chongo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;

/**
 * Example shell activity which simply broadcasts to our receiver and exits.
 */
public class MyStubBroadcastActivity extends Activity {
    MyAlarmReceiver alarm = new MyAlarmReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.context = this;
        alarm.setAlarm(this);

        //scheduleNotification(getNotification(), 5000);

//        Intent i = new Intent();
//        i.setAction("com.maximbravo.chongo.SHOW_NOTIFICATION");
//        i.putExtra(MyPostNotificationReceiver.CONTENT_KEY, Utils.title);
//        sendBroadcast(i);
//        finish();
    }
    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this, NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }

    private Notification getNotification() {
        int randomInt = (int)(Math.random() * 600) / 10 * 10;
        Utils.updateVariables(randomInt);

        Intent displayIntent = new Intent(this, MyDisplayActivity.class);


        Bitmap bitmap = Bitmap.createBitmap(320,320, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Utils.context.getResources().getColor(R.color.colorPrimary));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.color.colorPrimary)
                .setContentTitle(Utils.title)
                .extend(new NotificationCompat.WearableExtender()
                        .setBackground(bitmap)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_FULL_SCREEN)
                        .setDisplayIntent(PendingIntent.getActivity(this, 0, displayIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT)));
        return builder.build();
    }


}
