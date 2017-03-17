package com.example.extra.dice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    ImageButton b_play1,b_instruct1,b_level;
    String levelVal;
    TextView txtLabel;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        b_play1 = (ImageButton) findViewById(R.id.b_play1);
        b_instruct1 = (ImageButton) findViewById(R.id.b_instruct1);
        b_level = (ImageButton) findViewById(R.id.b_level);
        level = 1;
        txtLabel = (TextView) findViewById(R.id.textViewMenuActivity);

        b_instruct1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),InstructActivity.class);
                startActivity(myIntent);
            }
        });

        b_level.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),LevelActivity.class);
                startActivityForResult(myIntent,2000);
            }
        });

        b_play1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(),GameActivity.class);
                myIntent.putExtra("levelType", level);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
        if (requestCode == 2000) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                levelVal = data.getExtras().getString("level");
                level = Integer.parseInt(levelVal);
                txtLabel.setText("The level is " + levelVal);
            }
        }
    }
}
