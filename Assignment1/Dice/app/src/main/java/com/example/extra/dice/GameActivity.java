package com.example.extra.dice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    Button b_diceTurn;
    TextView t_diceValue;
    ImageView p1, p2, imageView;
    String result;
    int p1Total, p2Total;
    int turn, level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        level = getIntent().getExtras().getInt("levelType");
        Toast.makeText(getApplicationContext(), "LEVEL: " + level + "", Toast.LENGTH_LONG).show();

        b_diceTurn = (Button) findViewById(R.id.b_diceTurn);
        t_diceValue = (TextView) findViewById(R.id.diceVal);
        p1 = (ImageView) findViewById(R.id.p1);
        p2 = (ImageView) findViewById(R.id.p2);
        imageView = (ImageView) findViewById(R.id.imageView);
        p1Total = 0;
        p2Total = 0;
        turn = 0;

        String message = "Your Turn!";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

        b_diceTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (turn == 0) {
                    Intent myIntent = new Intent(getApplicationContext(), DiceActivity.class);
                    startActivityForResult(myIntent, 1000);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == 1000) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                result = data.getExtras().getString("diceVal");
                int diceRes = Integer.parseInt(result);
                int notPossible = 0;
                if (turn == 0) {
                    p1Total = p1Total + diceRes;
                    if (p1Total <= 100) {
                        changePosition(p1Total, turn, p1);
                    } else {
                        p1Total = p1Total - diceRes;
                        notPossible = 1;
                    }
                } else {
                    p2Total = p2Total + diceRes;
                    if (p1Total <= 100) {
                        changePosition(p2Total, turn, p2);
                    } else {
                        p2Total = p2Total - diceRes;
                        notPossible = 2;
                    }
                }
                t_diceValue.setText("" + p1Total + "");

                if (p1Total == 100) {
                    String message = "CONGRATULATIONS! YOU WON!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
                }
                if (p2Total == 100) {
                    String message = "YOU LOST!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    finish();
                }
                if (notPossible == 0) {
                    if (turn == 0)
                        turn = 1;
                    else turn = 0;

                    if (diceRes == 6) {
                        if (turn == 0) {
                            turn = 1;
                        } else turn = 0;
                    }

                    if (p1Total == 39 || p1Total == 12 || p1Total == 53 || p1Total == 84 || p1Total == 99 || p1Total == 90) {
                        turn = 0;
                    }

                    if (p2Total == 39 || p2Total == 12 || p2Total == 53 || p2Total == 84 || p2Total == 99 || p2Total == 90) {
                        turn = 1;
                    }

                    if (turn == 1) {
                        String message = "Computer's Turn!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {

                                Intent myIntent = new Intent(getApplicationContext(), DiceActivity.class);
                                startActivityForResult(myIntent, 1000);
                            }
                        }, 3000);
                    }

                    if (turn == 0) {
                        String message = "Your Turn!";
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                } else if (notPossible == 1) {
                    turn = 1;
                    String message = "Computer's Turn!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent myIntent = new Intent(getApplicationContext(), DiceActivity.class);
                            startActivityForResult(myIntent, 1000);
                        }
                    }, 3000);
                } else if (notPossible == 2) {
                    turn = 0;
                    String message = "Your Turn!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    protected void changePosition(int position, int turn, ImageView p1) {

        if (position == 1 || position == 20 || position == 21 || position == 40 || position == 41 || position == 60 || position == 61
                || position == 80 || position == 81 || position == 100) {
            p1.setX(75);
        }
        if (position == 2 || position == 19 || position == 22 || position == 39 || position == 42 || position == 59 || position == 62
                || position == 79 || position == 82 || position == 99) {
            p1.setX(175);
        }
        if (position == 3 || position == 18 || position == 23 || position == 38 || position == 43 || position == 58 || position == 63
                || position == 78 || position == 83 || position == 98) {
            p1.setX(275);
        }
        if (position == 4 || position == 17 || position == 24 || position == 37 || position == 44 || position == 57 || position == 64
                || position == 77 || position == 84 || position == 97) {
            p1.setX(375);
        }
        if (position == 5 || position == 16 || position == 25 || position == 36 || position == 45 || position == 56 || position == 65
                || position == 76 || position == 85 || position == 96) {
            p1.setX(475);
        }
        if (position == 6 || position == 15 || position == 26 || position == 35 || position == 46 || position == 55 || position == 66
                || position == 75 || position == 86 || position == 95) {
            p1.setX(575);
        }
        if (position == 7 || position == 14 || position == 27 || position == 34 || position == 47 || position == 54 || position == 67
                || position == 74 || position == 87 || position == 94) {
            p1.setX(675);
        }
        if (position == 8 || position == 13 || position == 28 || position == 33 || position == 48 || position == 53 || position == 68
                || position == 73 || position == 88 || position == 93) {
            p1.setX(775);
        }
        if (position == 9 || position == 12 || position == 29 || position == 32 || position == 49 || position == 52 || position == 69
                || position == 72 || position == 89 || position == 92) {
            p1.setX(875);
        }
        if (position == 10 || position == 11 || position == 30 || position == 31 || position == 50 || position == 51 || position == 70
                || position == 71 || position == 90 || position == 91) {
            p1.setX(975);
        }
        ///////////////////////////////FOR Y////////////////////////////////////
        if (position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6 || position == 7
                || position == 8 || position == 9 || position == 10) {
            p1.setY(1100);
        }
        if (position == 11 || position == 12 || position == 13 || position == 14 || position == 15 || position == 16 || position == 17
                || position == 18 || position == 19 || position == 20) {
            p1.setY(1000);
        }
        if (position == 21 || position == 22 || position == 23 || position == 24 || position == 25 || position == 26 || position == 27
                || position == 28 || position == 29 || position == 30) {
            p1.setY(900);
        }
        if (position == 31 || position == 32 || position == 33 || position == 34 || position == 35 || position == 36 || position == 37
                || position == 38 || position == 39 || position == 40) {
            p1.setY(800);
        }
        if (position == 41 || position == 42 || position == 43 || position == 44 || position == 45 || position == 46 || position == 47
                || position == 48 || position == 49 || position == 50) {
            p1.setY(700);
        }
        if (position == 51 || position == 52 || position == 53 || position == 54 || position == 55 || position == 56 || position == 57
                || position == 58 || position == 59 || position == 60) {
            p1.setY(600);
        }
        if (position == 61 || position == 62 || position == 63 || position == 64 || position == 65 || position == 66 || position == 67
                || position == 68 || position == 69 || position == 70) {
            p1.setY(500);
        }
        if (position == 71 || position == 72 || position == 73 || position == 74 || position == 75 || position == 76 || position == 77
                || position == 78 || position == 79 || position == 80) {
            p1.setY(400);
        }
        if (position == 81 || position == 82 || position == 83 || position == 84 || position == 85 || position == 86 || position == 87
                || position == 88 || position == 89 || position == 90) {
            p1.setY(300);
        }
        if (position == 91 || position == 92 || position == 93 || position == 94 || position == 95 || position == 96 || position == 97
                || position == 98 || position == 99 || position == 100) {
            p1.setY(200);
        }
        //////////////////////////////CHECKS SNAKES/////////////////////////
        if (position == 31) {
            position = 4;
            if (turn == 0)
                p1Total = 4;
            else p2Total = 4;
            changePosition(4, 1, p1);
        }
        if (position == 16) {
            position = 13;
            if (turn == 0)
                p1Total = 13;
            else p2Total = 13;
            changePosition(13, 1, p1);
        }
        if (position == 47) {
            position = 25;
            if (turn == 0)
                p1Total = 25;
            else p2Total = 25;
            changePosition(25, 1, p1);
        }
        if (position == 66) {
            position = 52;
            if (turn == 0)
                p1Total = 52;
            else p2Total = 52;
            changePosition(52, 1, p1);
        }
        if (position == 63) {
            position = 60;
            if (turn == 0)
                p1Total = 60;
            else p2Total = 60;
            changePosition(60, 1, p1);
        }
        if (position == 97) {
            position = 75;
            if (turn == 0)
                p1Total = 75;
            else p2Total = 75;
            changePosition(75, 1, p1);
        }
        //////////////////////////CHECK LADDERS/////////////////////////
        if (position == 3) {
            position = 39;
            if (turn == 0)
                p1Total = 39;
            else p2Total = 39;
            changePosition(39, 1, p1);
        }
        if (position == 10) {
            position = 12;
            if (turn == 0)
                p1Total = 12;
            else p2Total = 12;
            changePosition(12, 1, p1);
        }
        if (position == 27) {
            position = 53;
            if (turn == 0)
                p1Total = 53;
            else p2Total = 53;
            changePosition(53, 1, p1);
        }
        if (position == 56) {
            position = 84;
            if (turn == 0)
                p1Total = 84;
            else p2Total = 84;
            changePosition(84, 1, p1);
        }
        if (position == 72) {
            position = 90;
            if (turn == 0)
                p1Total = 90;
            else p2Total = 90;
            changePosition(90, 1, p1);
        }
        if (position == 61) {
            position = 99;
            if (turn == 0)
                p1Total = 99;
            else p2Total = 99;
            changePosition(99, 1, p1);
        }
        /////////////////CHECKS/////////////////////////////////
    }
}
