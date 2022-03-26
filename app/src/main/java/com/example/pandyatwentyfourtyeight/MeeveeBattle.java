//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MeeveeBattle extends AppCompatActivity {
    MediaPlayer player;

    //player variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meevee_battle);
        player = MediaPlayer.create(this, R.raw.battlemusic);
        player.start();
    }

    public void throwball(View view) {
        ImageView i = (ImageView) findViewById(R.id.ball);
        ImageView battle = (ImageView) findViewById(R.id.battle);
        TextView t = (TextView) findViewById(R.id.text);
        i.setImageResource(R.drawable.empty);
        int a = (int) (Math.random() * 100 + 1);
        Timer timer;
        if (a != 1) {
            t.setText("You have caught the Mega Eevee and completed your jouney!");
            battle.setImageResource(R.drawable.s8after);

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    //This time, instead of going back to the game, it goes to the story
                    Intent i = new Intent(MeeveeBattle.this, StoryS2.class);
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        } else {
            t.setText("You have failed to catch the pokemon");
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(MeeveeBattle.this, LoseScreen.class);
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        }
    }
}