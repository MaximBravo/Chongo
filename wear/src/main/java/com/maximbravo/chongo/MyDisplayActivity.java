package com.maximbravo.chongo;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyDisplayActivity extends Activity {

    private TextView character;
    private LinearLayout linearLayout;
    private TextView pinyin;
    private TextView definition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        character = (TextView) findViewById(R.id.character);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        pinyin = (TextView) findViewById(R.id.pinyin);
        definition = (TextView) findViewById(R.id.definition);
        //pinyin.setVisibility(View.INVISIBLE);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinyin.setVisibility(View.VISIBLE);
                definition.setVisibility(View.VISIBLE);
            }
        });

        LayoutTransition transition = linearLayout.getLayoutTransition();
        if(transition != null) {
            transition.enableTransitionType(LayoutTransition.CHANGING);
        }
        Toast.makeText(this, "What up just got clicked", Toast.LENGTH_SHORT).show();
    }
}
