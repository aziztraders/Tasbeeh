package com.example.tasbeeh;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.widget.Button;
import android.widget.TextView;
import android.os.Vibrator;

import androidx.appcompat.app.AppCompatActivity;

public class AppMethods extends AppCompatActivity {
    public static void setText(int counter, TextView tv) {
        tv.setText(String.valueOf(counter));
    }

    public static void btnEnableDisable(int counterSubhanAllah, int counterAlhamdulillah, int counterAllahuAkbar, Button
            btnSubhanAllah, Button btnAlhamdulillah, Button btnAllahuAkbar) {
        if (counterSubhanAllah < 33) {
            btnSubhanAllah.setEnabled(true);
            btnAlhamdulillah.setEnabled(false);
            btnAllahuAkbar.setEnabled(false);

            btnAlhamdulillah.setAlpha(0.5f);
            btnSubhanAllah.setAlpha(1);
            btnAllahuAkbar.setAlpha(0.5f);
        } else if (counterSubhanAllah == 33 && counterAlhamdulillah < 33) {
            btnSubhanAllah.setEnabled(false);
            btnAlhamdulillah.setEnabled(true);
            btnAllahuAkbar.setEnabled(false);

            btnSubhanAllah.setAlpha(0.5f);
            btnAlhamdulillah.setAlpha(1);
            btnAllahuAkbar.setAlpha(0.5f);
        } else if (counterSubhanAllah == 33 && counterAlhamdulillah == 33 && counterAllahuAkbar < 34) {
            btnSubhanAllah.setEnabled(false);
            btnAlhamdulillah.setEnabled(false);
            btnAllahuAkbar.setEnabled(true);

            btnSubhanAllah.setAlpha(0.5f);
            btnAlhamdulillah.setAlpha(0.5f);
            btnAllahuAkbar.setAlpha(1);
        } else if (counterSubhanAllah == 33 && counterAlhamdulillah == 33 && counterAllahuAkbar == 34) {
            btnSubhanAllah.setEnabled(false);
            btnAlhamdulillah.setEnabled(false);
            btnAllahuAkbar.setEnabled(false);

            btnSubhanAllah.setAlpha(0.5f);
            btnAlhamdulillah.setAlpha(0.5f);
            btnAllahuAkbar.setAlpha(0.5f);
        }
    }

    public void vibrate(Context context,int ml) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(ml, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(ml);
        }
    }

}
