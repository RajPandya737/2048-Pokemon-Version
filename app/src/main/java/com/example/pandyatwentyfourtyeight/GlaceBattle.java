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

public class GlaceBattle extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glace_battle);
        player = MediaPlayer.create(this, R.raw.battlemusic);
        player.start();
    }

    public void throwball(View view) {
        ImageView i = (ImageView) findViewById(R.id.ball);
        ImageView battle = (ImageView) findViewById(R.id.battle);
        TextView t = (TextView) findViewById(R.id.text);
        i.setImageResource(R.drawable.empty);
        int val = 6;
        SharedPreferences sp;
        sp = getSharedPreferences("BattleValue", Context.MODE_PRIVATE);
        int a = (int) (Math.random() * 100 + 1);
        Timer timer;
        if (a != 1) {
            t.setText("You have caught the Glaceon!");
            battle.setImageResource(R.drawable.s5after);

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(GlaceBattle.this, GameScreen.class);
                    SharedPreferences.Editor editor = sp.edit();
                    player.stop();
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
                    Intent i = new Intent(GlaceBattle.this, LoseScreen.class);
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        }
    }
}
