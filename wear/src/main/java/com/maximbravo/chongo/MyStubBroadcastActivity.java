package com.maximbravo.chongo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Example shell activity which simply broadcasts to our receiver and exits.
 */
public class MyStubBroadcastActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent();
        i.setAction("com.maximbravo.chongo.SHOW_NOTIFICATION");
        i.putExtra(MyPostNotificationReceiver.CONTENT_KEY, Utils.title);
        sendBroadcast(i);
        finish();
    }
}
