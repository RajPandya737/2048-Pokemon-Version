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
import android.widget.TextView;

public class StoryS1 extends AppCompatActivity {
    int value = 0;
    //Used to cycle through the text
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_s1);
        player = MediaPlayer.create(this, R.raw.oaktheme);
        player.start();
    }

    //Mainly just dialogue between the player and Oak.
    public void text(View view) {
        int val = 1;
        //Use shared preferences here to reset any previous values
        SharedPreferences sp;
        sp = getSharedPreferences("BattleValue", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("val", val);
        editor.commit();
        if (value == 0) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Great, I have been researching Eevees for over a decade now, I have done the math and there should be a new species");
            value++;
        } else if (value == 1) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Can you go acorss the land to find the new species? I will give you everything you need");
            value++;
        } else if (value == 2) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Great, Here are a few merge crystals, you only have a limited number of spots in your party so these will come in handy");
            value++;
        } else if (value == 3) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("When 2 eevees of the same type get close, they form and evolve into a new species, keep doing this until you have found the final eevee");
            value++;
        } else if (value == 4) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Remember, eevees are wild pokemon, so they will put up a fight, be prepared to face off against them, anyways, good luck on your journey!");
            value++;
        } else if (value == 5) {
            Intent i = new Intent(this, GameScreen.class);
            player.stop();
            startActivity(i);
        }
    }
}