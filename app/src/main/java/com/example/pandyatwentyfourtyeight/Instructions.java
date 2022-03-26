//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Instructions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    MediaPlayer player;

    //Music PLayer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        addItemsOnSpinner();

        play();
    }

    public void play() {

        player = MediaPlayer.create(this, R.raw.pokemonsong);
        player.start();
    }

    public void Home(View view) {
        player.stop();
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }

    public void addItemsOnSpinner() {
        //Find your spinner
        Spinner theSpinner = (Spinner) findViewById(R.id.theSpinner);
        List<String> list = new ArrayList<String>();
        //Put in the values that you want
        list.add("Choose");
        list.add("Classic");
        list.add("Story");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Call these two methods on your spinner
        theSpinner.setAdapter(dataAdapter);
        theSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //This is where you put th ecode that you want the spinner to run
        // when the user selects it.
        Spinner theSpinner = (Spinner) findViewById(R.id.theSpinner);
        TextView T1 = (TextView) findViewById(R.id.T1);
        ImageView I1 = (ImageView) findViewById(R.id.I1);
        TextView T2 = (TextView) findViewById(R.id.T2);
        ImageView I2 = (ImageView) findViewById(R.id.I2);
        TextView T3 = (TextView) findViewById(R.id.T3);
        ImageView I3 = (ImageView) findViewById(R.id.I3);
        TextView T4 = (TextView) findViewById(R.id.T4);
        ImageView I4 = (ImageView) findViewById(R.id.I4);
        //Pulls out the selected item. You probably want to store this in a global variable
        String item = theSpinner.getSelectedItem().toString();

        //depending on the option you choose, it will change what is shown

        if (item.equalsIgnoreCase("Classic")) {
            T1.setText("Welcome to the normal game of 2048! Here we have you explore the lands to find " +
                    "the various creatures that roam around the world. You may have seen some of them, " +
                    "but regardless, you can not deny their beauty. ");
            I1.setImageResource(R.drawable.glace);
            T2.setText("You will be given a bored where you must use the buttons at the bottom to" +
                    "move around. When you click a button, the pieces will move in that direction and" +
                    "if the same 2 pieces go in the same direction and hit, they merge");
            I2.setImageResource(R.drawable.ssbored);
            T3.setText("Everytime you merge 2 blocks, there combined value is added to your score. " +
                    "The higher the score the better. your goal is to merge pokemon until you reach the Mega Eevee" +
                    "Do your best, and Good Luck!!");
            I3.setImageResource(R.drawable.scoress);
        } else if (item.equalsIgnoreCase("Story")) {
            T1.setText("Welcome to the Story Mode of 2048! Here, you are given the task of finding, catching, and " +
                    "researching pokemon to find new species for Professor Oak. These new speices will not behave the same " +
                    "and are found in different habitats, be careful on your travels");
            I1.setImageResource(R.drawable.flare);
            T2.setText("In the wilderness creatures will do anything to run away, you can move around by using the arrow keys " +
                    "at the bottom of the bored to find your way around the map. If the map has no pokemon on it, move around to" +
                    " spot some. The pokemon merge together to become stronger, and it is your job to get the strongest of them all");
            I2.setImageResource(R.drawable.ssbored2);
            T3.setText("The lower level species are quite timid and docile, but higher level the species is, the more likely " +
                    "they will put up a fight. When you go to the fight, you need to catch the pokemon without attacking it. Once enough " +
                    "pokemon have been merged, you will be taken to a battle screen");
            I3.setImageResource(R.drawable.s1);
            T4.setText("On the battle screen, click on the pokeball to throw the ball. there is a chance the pokemon will not be caught " +
                    "and you will then have to restart your entire journey. There is a legend amoung the Celestial Dragon locals that a " +
                    "Mega Eevee has been spotted amoung the clouds, see if you can find it.");
            I4.setImageResource(R.drawable.ball);
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // Just put this in. You need it.
    }
}