package com.example.extra.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class DiceActivity extends AppCompatActivity {

    Button b_roll;
    Button b_menu;
    ImageView iv_dice;
    Random r;
    int rolledNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        iv_dice = (ImageView) findViewById(R.id.iv_dice);
        r = new Random();

        rolledNumber = r.nextInt(6) + 1;

        if (rolledNumber == 1) {
            iv_dice.setImageResource(R.drawable.d1);
        } else if (rolledNumber == 2) {
            iv_dice.setImageResource(R.drawable.d2);
        } else if (rolledNumber == 3) {
            iv_dice.setImageResource(R.drawable.d3);
        } else if (rolledNumber == 4) {
            iv_dice.setImageResource(R.drawable.d4);
        } else if (rolledNumber == 5) {
            iv_dice.setImageResource(R.drawable.d5);
        } else if (rolledNumber == 6) {
            iv_dice.setImageResource(R.drawable.d6);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent data = new Intent();
                data.putExtra("diceVal", Integer.toString(rolledNumber));

                setResult(RESULT_OK, data);

                finish();
            }
        }, 3000);
    }
}
