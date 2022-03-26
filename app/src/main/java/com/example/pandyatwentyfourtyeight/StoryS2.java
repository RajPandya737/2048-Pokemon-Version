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

public class StoryS2 extends AppCompatActivity {
    int value = 0;
    //used to cycle through the texts
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_s2);
        player = MediaPlayer.create(this, R.raw.oaktheme);
        player.start();
    }

    public void text(View view) {

        if (value == 0) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Your expertise on the field of Eeveelution make you an important scientist, your discoveries will go down in history");
            value++;
        } else if (value == 1) {
            TextView txt = (TextView) findViewById(R.id.words);
            txt.setText("Let's get you into the hall of fame, in the meantime, you can go to the Champions room to collect your trophy'");
            value++;
        } else if (value == 2) {
            Intent i = new Intent(this, WinScreenStory.class);
            player.stop();
            startActivity(i);
        }
    }
}