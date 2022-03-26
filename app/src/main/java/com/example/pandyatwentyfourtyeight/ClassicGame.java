//Name; Raj Pandya
//Date: November 19 2021
//Purpose: To entertain grade 6 students in Ms. Mafteechers class that finish their work early
package com.example.pandyatwentyfourtyeight;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClassicGame extends AppCompatActivity {
    int bored[][] =
            {{1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1}};
    //^ This is the array for the bored
    int value[][] =
            {{1, 1, 1, 1},
                    {1, 2, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1}};
    //^ the array for the pieces that are present on the bored
    int old[][] =
            {{1, 1, 1, 1},
                    {1, 2, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1}};
    //^ used for the reset button
    int row = 4;
    int col = 4;
    ImageView pics[] = new ImageView[row * col];
    ImageView boredpics[] = new ImageView[row * col];
    int score = 0;

    //^ The score that is displayed on screen
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_game);
        GridLayout g = (GridLayout) findViewById(R.id.grid);
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boredpics[m] = new ImageView(this);
                setpicStart(boredpics[m], m);
                boredpics[m].setId(m);
                g.addView(boredpics[m]);
                m++;
            }
        }
        player = MediaPlayer.create(this, R.raw.rbbattlesong);
        player.start();
        //music player
        int l = 0;
        // this is the grid layout for placing the pokemon
        GridLayout g2 = (GridLayout) findViewById(R.id.grid2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pics[l] = new ImageView(this);
                setpicPoke(pics[l], l);
                pics[l].setId(l);
                g2.addView(pics[l]);
                l++;
            }
        }

    }

    public int add() {
        //In the real 2048 game, there is a 10% chance the new tile spawned is a 4 and 90% chance it is a 2
        //This code reflects that, rolls a number from 1-10, and if that number is 1, it return 4, if not, it returns 2
        int n = (int) (Math.random() * 10 + 1);
        if (n == 1) {
            return 4;
        } else
            return 2;
    }


    public boolean empty() {
        //method that checks if a space is empty or not so it can place a piece there
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (value[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    public void imp() {
        //method that implements a new piece into the bored when the user click on something
        int check = 0;
        if (empty())
            while (check == 0) {
                int i = (int) (Math.random() * 4);
                int j = (int) (Math.random() * 4);
                if (value[i][j] == 1) {
                    value[i][j] = add();
                    check = 1;
                }
            }
        else {
            player.stop();
            Intent i = new Intent(this, LoseScreen.class);
            startActivity(i);
        }

    }

    //the set pic method that changes the background of the grid
    public void setpicStart(ImageView i, int pos) {
        int x = pos / col;
        int y = pos % col;
        int picnum = bored[x][y];
        if (picnum == 1)
            i.setImageResource(R.drawable.bg1);
        else if (picnum == 2)
            i.setImageResource(R.drawable.bg2);
        else if (picnum == 3)
            i.setImageResource(R.drawable.bg3);
        else if (picnum == 4)
            i.setImageResource(R.drawable.bg4);
        else if (picnum == 5)
            i.setImageResource(R.drawable.bg5);
        else if (picnum == 6)
            i.setImageResource(R.drawable.bg6);
        else if (picnum == 7)
            i.setImageResource(R.drawable.bg7);
        else if (picnum == 8)
            i.setImageResource(R.drawable.bg8);
    }

    public void reset(View view) {
//reset method that uses the 'old' array to restore a new game
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                value[i][j] = old[i][j];
        imp();
        redraw();
        redrawBored();
    }

    public void redraw() {
        //redraws the pokemon onto the grid if the value has changed
        int m = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (value[i][j] == 1)
                    pics[m].setImageResource(R.drawable.empty);
                else if (value[i][j] == 2)
                    pics[m].setImageResource(R.drawable.eevee);
                else if (value[i][j] == 4)
                    pics[m].setImageResource(R.drawable.vap);
                else if (value[i][j] == 8)
                    pics[m].setImageResource(R.drawable.jolt);
                else if (value[i][j] == 16)
                    pics[m].setImageResource(R.drawable.leaf);
                else if (value[i][j] == 32)
                    pics[m].setImageResource(R.drawable.esp);
                else if (value[i][j] == 64)
                    pics[m].setImageResource(R.drawable.umb);
                else if (value[i][j] == 128)
                    pics[m].setImageResource(R.drawable.flare);
                else if (value[i][j] == 256)
                    pics[m].setImageResource(R.drawable.glace);
                else if (value[i][j] == 512)
                    pics[m].setImageResource(R.drawable.sylve);
                else if (value[i][j] == 1024)
                    pics[m].setImageResource(R.drawable.steel);
                else if (value[i][j] == 2048)
                    win();
                m++;
            }
        }
    }

    public void win() {
        //win method is activated when the 2048 piece happens on the bored, it switches screens
        player.stop();
        Intent i = new Intent(this, WinScreenClassic.class);
        startActivity(i);
    }

    public void redrawBored() {
        //redraws the pokemon onto the grid if the value has changed
        int m = 0;
        int max = backgroundValue();
        //the background value will always be proportional to the highest pokemon on the bored
        LinearLayout bg = findViewById(R.id.gamebackground);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (max == 1) {
                    boredpics[m].setImageResource(R.drawable.bg1);
                    bg.setBackgroundResource(R.drawable.leafbg);
                } else if (max == 2) {
                    boredpics[m].setImageResource(R.drawable.bg2);
                    bg.setBackgroundResource(R.drawable.espbg);
                } else if (max == 3) {
                    boredpics[m].setImageResource(R.drawable.bg3);
                    bg.setBackgroundResource(R.drawable.umbbg);
                } else if (max == 4) {
                    boredpics[m].setImageResource(R.drawable.bg4);
                    bg.setBackgroundResource(R.drawable.flarebg);
                } else if (max == 5) {
                    boredpics[m].setImageResource(R.drawable.bg5);
                    bg.setBackgroundResource(R.drawable.glacebg);
                } else if (max == 6) {
                    boredpics[m].setImageResource(R.drawable.bg6);
                    bg.setBackgroundResource(R.drawable.sylvbg);
                } else if (max == 7) {
                    boredpics[m].setImageResource(R.drawable.bg7);
                    bg.setBackgroundResource(R.drawable.steelbg);
                } else if (max == 8) {
                    boredpics[m].setImageResource(R.drawable.bg7);
                    bg.setBackgroundResource(R.drawable.meeveebg);
                }
                m++;
            }
        }
    }

    public void setpicPoke(ImageView i, int pos) {
        //sets the value of each array
        int x = pos / col;
        int y = pos % col;
        int picvalue = value[x][y];
        if (picvalue == 1)
            i.setImageResource(R.drawable.empty);
        else if (picvalue == 2)
            i.setImageResource(R.drawable.eevee);
        else if (picvalue == 4)
            i.setImageResource(R.drawable.vap);
        else if (picvalue == 8)
            i.setImageResource(R.drawable.jolt);
        else if (picvalue == 16)
            i.setImageResource(R.drawable.leaf);
        else if (picvalue == 32)
            i.setImageResource(R.drawable.esp);
        else if (picvalue == 64)
            i.setImageResource(R.drawable.umb);
        else if (picvalue == 128)
            i.setImageResource(R.drawable.flare);
        else if (picvalue == 256)
            i.setImageResource(R.drawable.glace);
        else if (picvalue == 512)
            i.setImageResource(R.drawable.sylve);
        else if (picvalue == 1024)
            i.setImageResource(R.drawable.steel);
        else if (picvalue == 2048)
            i.setImageResource(R.drawable.meevee);
    }

    public int merge(int a, int b) {
        //merges the 2 pokemon together
        a += b;
        return a;
    }


    public void leftclick(View view) {
        //moves all elements to the left, does this 1 less times then the length of the bored (4) so that all the elements can get as far left as possible
        boolean change = false;
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j != 0 && value[i][j - 1] == 1) {
                        value[i][j - 1] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        //once all are fully left, it merges them together, if something on the right has the same value, it will merge them together.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col - 1; j++) {
                if (value[i][j] == value[i][j + 1] && value[i][j] != 1) {
                    value[i][j] = merge(value[i][j], value[i][j + 1]);
                    value[i][j + 1] = 1;
                    score += value[i][j];
                    change = true;
                }
            }
        }
        //Once all the merging is complete, it shifts everything to the left again
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j != 0 && value[i][j - 1] == 1) {
                        value[i][j - 1] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        if (change) {
            //this method prints the score
            score();
            //adds a new piece
            imp();
            //redraws the bored to scan for changes
            redrawBored();
            //redraws the pieces
            redraw();
        } else if (!change) {
            if (empty())
                Toast.makeText(getApplicationContext(), "You cannot move that way", Toast.LENGTH_SHORT).show();
            else if (!empty()) {
                player.stop();
                Intent i = new Intent(this, LoseScreen.class);
                startActivity(i);
            }
        }
    }

    public void score() {
        //prints the score on the screen
        TextView t = (TextView) findViewById(R.id.score);
        t.setText("" + score);
    }

    public void rightclick(View view) {
        boolean change = false;
        //moves all elements to the right, does this 1 less times then the length of the bored (4) so that all the elements can get as far right as possible
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j != col - 1 && value[i][j + 1] == 1) {
                        value[i][j + 1] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        //once all are fully right, it merges them together, if something on the left has the same value, it will merge them together.
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if (j != 0 && value[i][j] == value[i][j - 1] && value[i][j] != 1) {
                    //the merge function just determines the number that will go into value [i][j]
                    value[i][j] = merge(value[i][j], value[i][j - 1]);
                    value[i][j - 1] = 1;
                    score += value[i][j];
                    change = true;
                }
            }
        }
        //Once all the merging is complete, it shifts everything to the right again
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j != col - 1 && value[i][j + 1] == 1) {
                        value[i][j + 1] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        if (change) {
            //this method prints the score
            score();
            //adds a new piece
            imp();
            //redraws the bored to scan for changes
            redrawBored();
            //redraws the pieces
            redraw();
        } else {
            if (empty())
                Toast.makeText(getApplicationContext(), "You cannot move that way", Toast.LENGTH_SHORT).show();
            else if (!empty()) {
                player.stop();
                Intent i = new Intent(this, LoseScreen.class);
                startActivity(i);
            }
        }
    }

    public int backgroundValue() {
        //finds the highest value pokemon on the bored, which will be proportional to the background value
        int highest = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (value[i][j] > highest) {
                    highest = value[i][j];
                }
            }

        }
        //return the bored value
        if (highest <= 16)
            return 1;
        else if (highest == 32)
            return 2;
        else if (highest == 64)
            return 3;
        else if (highest == 128)
            return 4;
        else if (highest == 256)
            return 5;
        else if (highest == 512)
            return 6;
        else if (highest == 1024)
            return 7;
        return 1;
    }

    public void downclick(View view) {
        boolean change = false;
        //same as right and left click
        for (int a = 0; a < row; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != row - 1 && value[i + 1][j] == 1) {
                        value[i + 1][j] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (i != 0 && value[i][j] == value[i - 1][j] && value[i][j] != 1) {
                    value[i][j] = merge(value[i][j], value[i - 1][j]);
                    value[i - 1][j] = 1;
                    score += value[i][j];
                    change = true;
                }
            }
        }
        for (int a = 0; a < row; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != row - 1 && value[i + 1][j] == 1) {
                        value[i + 1][j] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        if (change) {
            //this method prints the score
            score();
            //adds a new piece
            imp();
            //redraws the bored to scan for changes
            redrawBored();
            //redraws the pieces
            redraw();
        } else {
            if (empty())
                Toast.makeText(getApplicationContext(), "You cannot move that way", Toast.LENGTH_SHORT).show();
            else if (!empty()) {
                player.stop();
                Intent i = new Intent(this, LoseScreen.class);
                startActivity(i);
            }
        }
    }

    public void upclick(View view) {
        boolean change = false;
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != 0 && value[i - 1][j] == 1) {
                        value[i - 1][j] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        //same as right and left click
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col; j++) {
                if (i != row - 1 && value[i][j] == value[i + 1][j] && value[i][j] != 1) {
                    value[i][j] = merge(value[i][j], value[i + 1][j]);
                    value[i + 1][j] = 1;
                    score += value[i][j];
                    change = true;
                }
            }
        }
        //same as right and left click
        for (int a = 0; a < col; a++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i != 0 && value[i - 1][j] == 1) {
                        value[i - 1][j] = value[i][j];
                        value[i][j] = 1;
                        change = true;
                    }
                }
            }
        }
        if (change) {
            //this method prints the score
            score();
            //adds a new piece
            imp();
            //redraws the bored to scan for changes
            redrawBored();
            //redraws the pieces
            redraw();
        } else {
            if (empty())
                Toast.makeText(getApplicationContext(), "You cannot move that way", Toast.LENGTH_SHORT).show();
            else if (!empty()) {
                player.stop();
                Intent i = new Intent(this, LoseScreen.class);
                startActivity(i);
            }
        }
    }

    public void dbox(View view) {
        //Dialog box for game instructions
        new AlertDialog.Builder(this)
                .setTitle("Game Instructions")
                .setMessage("In the game 2048, you have to merge as " +
                        "\nYou can and try to get the Mega Eevee square" +
                        "\nYou can press the buttons at the bottom to" +
                        "\nMove the tiles, but it moves all of them. " +
                        "\nWhen 2 tiles of the same value hit each other," +
                        "\nThey merge and create a new value. Every round a " +
                        "\nNew block appears, its over when the bored fill up! " +
                        "\nGood luck and have fun!")
                .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
    }

    public void home(View view) {
        //if you click on the home button, it will take you to the home paage
        player.stop();
        Intent i = new Intent(this, LoadScreen.class);
        startActivity(i);
    }
}