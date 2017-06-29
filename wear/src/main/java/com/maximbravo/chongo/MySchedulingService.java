package com.maximbravo.chongo;

/**
 * Created by Maxim Bravo on 6/28/2017.
 */


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * This {@code IntentService} does the app's actual work.
 * {@code SampleAlarmReceiver} (a {@code WakefulBroadcastReceiver}) holds a
 * partial wake lock for this service while the service does its work. When the
 * service is finished, it calls {@code completeWakefulIntent()} to release the
 * wake lock.
 */
public class MySchedulingService {//extends IntentService {
//    public MySchedulingService() {
//        super("SchedulingService");
//    }
//
//    public static final String TAG = "Scheduling Demo";
//    // An ID used to post the notification.
//    public static final int NOTIFICATION_ID = 1;
//    // The string the app searches for in the Google home page content. If the app finds
//    // the string, it indicates the presence of a doodle.
//    public static final String SEARCH_STRING = "doodle";
//    // The Google home page URL from which the app fetches content.
//    // You can find a list of other Google domains with possible doodles here:
//    // http://en.wikipedia.org/wiki/List_of_Google_domains
//    public static final String URL = "http://www.google.com";
//    private NotificationManager mNotificationManager;
//    NotificationCompat.Builder builder;
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        sendNotification();
//        Utils.print(getApplicationContext(), "Hello from onHandleIntent");
//        // Release the wake lock provided by the BroadcastReceiver.
//        MyAlarmReceiver.completeWakefulIntent(intent);
//        // END_INCLUDE(service_onhandle)
//    }
//
//    // Post a notification indicating whether a doodle was found.
//    private void sendNotification() {
//        int randomInt = (int)(Math.random() * 600) / 10 * 10;
//        Utils.updateVariables(randomInt);
//        mNotificationManager = (NotificationManager)
//                this.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, MyDisplayActivity.class), 0);
//
//        Bitmap bitmap = Bitmap.createBitmap(320,320, Bitmap.Config.ARGB_8888);
//        bitmap.eraseColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
//        Notification notification = new NotificationCompat.Builder(getApplicationContext())
//                .setSmallIcon(R.color.colorPrimary)
//                .setContentTitle(Utils.title)
//                .extend(new NotificationCompat.WearableExtender()
//                        .setBackground(bitmap)
//                        .setCustomSizePreset(NotificationCompat.WearableExtender.SIZE_FULL_SCREEN)
//                        .setDisplayIntent(contentIntent))
//                .build();
//
//        //notification.setContentIntent(contentIntent);
//        mNotificationManager.notify(NOTIFICATION_ID, notification);
//        Utils.print(getApplicationContext(), "notification sent");
//    }
}
