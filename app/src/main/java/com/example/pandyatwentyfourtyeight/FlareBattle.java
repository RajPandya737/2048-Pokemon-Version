//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class FlareBattle extends AppCompatActivity {
    Timer timer;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flare_battle);
        player = MediaPlayer.create(this, R.raw.battlemusic);
        player.start();
    }

    public void throwball(View view) {
        ImageView i = (ImageView) findViewById(R.id.ball);
        ImageView battle1 = (ImageView) findViewById(R.id.battle);
        TextView t = (TextView) findViewById(R.id.text);
        i.setImageResource(R.drawable.empty);
        int val = 5;
        SharedPreferences sp;
        sp = getSharedPreferences("BattleValue", Context.MODE_PRIVATE);
        int a = (int) (Math.random() * 100 + 1);
        if (a != 1) {
            t.setText("You have caught the flareon!");
            battle1.setImageResource(R.drawable.s2after);

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(FlareBattle.this, GameScreen.class);
                    player.stop();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("val", val);
                    editor.commit();
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
                    Intent i = new Intent(FlareBattle.this, LoseScreen.class);
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        }
    }
}