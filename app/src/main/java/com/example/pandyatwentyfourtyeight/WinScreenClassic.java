//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class WinScreenClassic extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen_classic);

        player = MediaPlayer.create(this, R.raw.champmusic);
        player.start();
    }

    public void home(View view) {
        player.stop();
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}