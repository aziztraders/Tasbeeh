package com.aziztraders.tasbeeh;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class PlaySound {

    MediaPlayer mp;
    Context context;

    public PlaySound(Context context) {
        this.context = context;
    }

    public void playSound(int sound) {
        mp = MediaPlayer.create(context, sound);
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
                 mp = MediaPlayer.create(context, sound);
            }
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
