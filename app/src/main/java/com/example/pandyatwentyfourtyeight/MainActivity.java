//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    //The media player variable plays the music

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play();
    }
//Just a bunch of button clicks

    public void play() {

        player = MediaPlayer.create(this, R.raw.pokemonsong);
        player.start();
    }

    public void Story(View view) {
        player.stop();
        Intent i = new Intent(this, MeeveeBattle.class);
        startActivity(i);
    }

    public void Instructions(View view) {
        player.stop();
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
    }

    public void Classic(View view) {
        player.stop();
        Intent i = new Intent(this, ClassicGame.class);
        startActivity(i);
    }

    public void Rate(View view) {
        player.stop();
        Intent i = new Intent(this, RateScreen.class);
        startActivity(i);
    }
}