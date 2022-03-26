//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class LoadScreen extends AppCompatActivity {
    ProgressBar pb;
    //used to give value to the porgress bar view
    int counter = 0;
    //the percent on the progress bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        prog();

    }

    //Not gonna lie, this screen only for extra feature marks, but it contatins a timer that increases a progress bar, only works when you want to go back to the homescreen
    public void prog() {
        pb = (ProgressBar) findViewById(R.id.progress_bar);
        Timer timer = new Timer();
        TimerTask timer2 = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter == 100) {
                    Intent i = new Intent(LoadScreen.this, MainActivity.class);
                    startActivity(i);
                }

            }
        };
        timer.schedule(timer2, 0, 10);
    }
}