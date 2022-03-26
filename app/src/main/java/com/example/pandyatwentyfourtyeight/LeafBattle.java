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

public class LeafBattle extends AppCompatActivity {
    MediaPlayer player;

    //Music player global variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaf_battle);
        player = MediaPlayer.create(this, R.raw.battlemusic);
        player.start();

    }

    //All of the battles screens are esentially the same thing, they just have different images.
    public void throwball(View view) {
        //this method runs when you click the pokeball
        ImageView i = (ImageView) findViewById(R.id.ball);
        ImageView battle = (ImageView) findViewById(R.id.battle);
        TextView t = (TextView) findViewById(R.id.text);
        i.setImageResource(R.drawable.empty);
        //timer is used to create a window gap between catching the pokemon and going back to the game screen
        Timer timer;
//random int is used
        int a = (int) (Math.random() * 100 + 1);
        //if the int is not 1, you will catch the pokemon, there is only a 1% chance you lose. across 8 games, 0.99^8 = 92% chance you will win.
        if (a != 1) {
            int val = 2;
//Using shared preferences to send back if the battle was completed
            SharedPreferences sp;
            sp = getSharedPreferences("BattleValue", Context.MODE_PRIVATE);


            t.setText("You have caught the Leafeon!");
            battle.setImageResource(R.drawable.s1after);
            //once all the text and images have been changed, the timer begins, its 4 seconds and is just a bit more plesent then having the screen change immediately
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(LeafBattle.this, GameScreen.class);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("val", val);
                    editor.commit();
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        } else {
            //if you get 1, you will fail and the game will send you back to the home screen
            t.setText("You have failed to catch the pokemon");
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Intent i = new Intent(LeafBattle.this, LoseScreen.class);
                    player.stop();
                    startActivity(i);
                    finish();
                }
            }, 4000);
        }
    }
}
