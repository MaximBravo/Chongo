package com.maximbravo.chongo;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Maxim Bravo on 6/28/2017.
 */

public class Utils {
    public static int frequency = 1;
    public static String title = "么";
    public static String pinyin = "me";
    public static String definition = "what; particle for questions; question particle";
    public static Context context;
    public static void print(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    private static String getPartOfCharacter(int i, int part){
        int counter = 0;
        InputStream is = context.getResources().openRawResource(R.raw.hsksmall);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if(counter == i) {
                    String[] rowData = line.split(",");
                    return rowData[part];
                } else {
                    counter ++;
                }
                // do something with "data" and "value"
            }
        }
        catch (IOException ex) {
            // handle exception
        }
        finally {
            try {
                is.close();
            }
            catch (IOException e) {
                // handle exception
            }
        }
        return "nope";
    }

    public static void updateVariables(int randomInt) {
        title = getPartOfCharacter(randomInt, 0);
        pinyin = getPartOfCharacter(randomInt, 1);
        definition = getPartOfCharacter(randomInt, 2);
    }
}
