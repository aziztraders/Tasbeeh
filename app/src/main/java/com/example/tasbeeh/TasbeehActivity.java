package com.example.tasbeeh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TasbeehActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "clickCheck";
    private AdView mAdView;
    private TextView txvDisplay;
    private Button btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar, btnReset;
    private ImageButton ibVibrate;
    int counterSubhanAllah, counterAlhamdulillah, counterAllahuAkbar;
    boolean isVibrationEnabled = true;
    int vibrateNum = 0;
    // PlaySound playSoundd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeeh);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        //change status bar color
        Window window = this.getWindow();
// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.tasbeeh_statusbar_color));

//initialising layout
        initLayout();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
                Toast.makeText(TasbeehActivity.this,"Ad loaded",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked();
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });


    }

    private void initLayout() {
        txvDisplay = (TextView) findViewById(R.id.txv_counter);
        btnSubhanAllah = (Button) findViewById(R.id.btn_subhan_allah);
        btnAlhamdulillah = (Button) findViewById(R.id.btn_alhamdulillah);
        btnAllahuAkbar = (Button) findViewById(R.id.btn_allahu_akbar);
        btnReset = (Button) findViewById(R.id.btn_reset);
        ibVibrate = (ImageButton) findViewById(R.id.ib_vibrate);

        btnSubhanAllah.setOnClickListener(this);
        btnAlhamdulillah.setOnClickListener(this);
        btnAllahuAkbar.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        ibVibrate.setOnClickListener(this);

        counterSubhanAllah = counterAlhamdulillah = counterAllahuAkbar = 0;
        AppMethods.setText(counterSubhanAllah, txvDisplay);
        AppMethods.btnEnableDisable(counterSubhanAllah, counterAlhamdulillah,
                counterAllahuAkbar, btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar);
        checkVibration(vibrateNum);
    }

    @Override
    public void onClick(View v) {
        AppMethods appMethods = new AppMethods();
        switch (v.getId()) {
            case R.id.btn_subhan_allah:
                counterSubhanAllah++;
                // playSoundd.playSound(R.raw.beep);
                AppMethods.setText(counterSubhanAllah, txvDisplay);
                AppMethods.btnEnableDisable(counterSubhanAllah, counterAlhamdulillah, counterAllahuAkbar,
                        btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar);
                if (isVibrationEnabled) {
                    if (counterSubhanAllah == 33) {
                        appMethods.vibrate(this, 500);
                    } else {
                        appMethods.vibrate(this, 200);
                    }
                }
                Log.d(TAG, "onClick: Subhan Allah " + counterSubhanAllah);
                break;
            case R.id.btn_alhamdulillah:
                counterAlhamdulillah++;
                //playSoundd.playSound(R.raw.beep);
                AppMethods.setText(counterAlhamdulillah, txvDisplay);
                AppMethods.btnEnableDisable(counterSubhanAllah, counterAlhamdulillah, counterAllahuAkbar,
                        btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar);
                if (isVibrationEnabled) {
                    if (counterAlhamdulillah == 33) {
                        appMethods.vibrate(this, 500);
                    } else {
                        appMethods.vibrate(this, 200);
                    }
                }
                Log.d(TAG, "onClick: Alhamdulillah " + counterAlhamdulillah);
                break;
            case R.id.btn_allahu_akbar:
                counterAllahuAkbar++;
                // playSoundd.playSound(R.raw.beep);
                AppMethods.setText(counterAllahuAkbar, txvDisplay);
                AppMethods.btnEnableDisable(counterSubhanAllah, counterAlhamdulillah, counterAllahuAkbar,
                        btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar);
                if (isVibrationEnabled) {
                    if (counterAllahuAkbar == 34) {
                        appMethods.vibrate(this, 500);
                    } else {
                        appMethods.vibrate(this, 200);
                    }
                }
                Log.d(TAG, "onClick: Allahu Akbar " + counterAllahuAkbar);
                break;
            case R.id.btn_reset:
                counterSubhanAllah = counterAlhamdulillah = counterAllahuAkbar = 0;
                AppMethods.setText(counterSubhanAllah, txvDisplay);
                AppMethods.btnEnableDisable(counterSubhanAllah, counterAlhamdulillah, counterAllahuAkbar,
                        btnSubhanAllah, btnAlhamdulillah, btnAllahuAkbar);
                if (isVibrationEnabled) {
                    appMethods.vibrate(this, 500);
                }
                Log.d(TAG, "onClick: Subhan Allah = Alhamdulillah = Allahu Akbar " + counterSubhanAllah);
                break;

            case R.id.ib_vibrate:
                appMethods.vibrate(this, 500);
                checkVibration(vibrateNum);
                Log.d(TAG, "onClick: vibrateNum " + vibrateNum);
                break;
            default:
        }
    }

    public void checkVibration(int num) {
        if (num == 0) {
            isVibrationEnabled = true;
            vibrateNum = 1;
            ibVibrate.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner_normal));
        } else if (num == 1) {
            isVibrationEnabled = false;
            vibrateNum = 0;
            ibVibrate.setBackgroundDrawable(getResources().getDrawable(R.drawable.rounded_corner_reset));
        }
    }

}