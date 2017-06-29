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
    private RelativeLayout relativeLayout;
    private TextView pinyin;
    private TextView definition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Utils.context = getApplicationContext();
        character = (TextView) findViewById(R.id.character);
        character.setText(Utils.title);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        relativeLayout = (RelativeLayout) findViewById(R.id.container);
        pinyin = (TextView) findViewById(R.id.pinyin);
        definition = (TextView) findViewById(R.id.definition);
        //pinyin.setVisibility(View.INVISIBLE);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinyin.setVisibility(View.VISIBLE);
                pinyin.setText(Utils.pinyin);
                definition.setVisibility(View.VISIBLE);
                definition.setText(Utils.definition);
            }
        });

        LayoutTransition transition = linearLayout.getLayoutTransition();
        if(transition != null) {
            transition.enableTransitionType(LayoutTransition.CHANGING);
        }
        //Toast.makeText(this, "What up just got clicked", Toast.LENGTH_SHORT).show();
    }
}
