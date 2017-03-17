package com.example.extra.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LevelActivity extends AppCompatActivity {

    Button level1,level2,level3,level4,level5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        level1 = (Button) findViewById(R.id.level1);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        level4 = (Button) findViewById(R.id.level4);
        level5 = (Button) findViewById(R.id.level5);

        level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("level", "1");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("level", "2");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        level3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("level", "3");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        level4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("level", "4");
                setResult(RESULT_OK, data);
                finish();
            }
        });

        level5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("level", "5");
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
