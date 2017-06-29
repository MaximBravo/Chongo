package com.maximbravo.chongo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyPostNotificationReceiver extends BroadcastReceiver {
    public static final String CONTENT_KEY = "contentText";

    @Override
    public void onReceive(Context context, Intent intent) {

        Utils.updateVariables();

        Intent displayIntent = new Intent(context, MyDisplayActivity.class);


        Bitmap bitmap = Bitmap.createBitmap(320,320, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Utils.context.getResources().getColor(R.color.colorPrimary));
        Notification notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.color.colorPrimary)
                .setContentTitle(Utils.title)
                .extend(new NotificationCompat.WearableExtender()
                        .setBackground(bitmap)
                        .setCustomSizePreset(Notification.WearableExtender.SIZE_FULL_SCREEN)
                        .setDisplayIntent(PendingIntent.getActivity(context, 0, displayIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT)))

                .build();
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, notification);

//        Notification myFullScreenNotification = new Notification.Builder(context)
//                //.setSmallIcon(R.drawable.ic_launcher)
//                .setContentText(text)
//                .extend(new Notification.WearableExtender()
//                        .setCustomSizePreset(Notification.WearableExtender.SIZE_FULL_SCREEN)
//                        .setDisplayIntent(PendingIntent.getActivity(context, 0, new Intent(context, MyActivity.class), 0)))
//                .build();

        //Toast.makeText(context, context.getString(R.string.notification_posted), Toast.LENGTH_SHORT).show();
    }
}
