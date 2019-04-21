package com.coolapps.memorymatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_3x3 = findViewById(R.id.Memory_btn);
        play_3x3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                play3x3();
            }
        });

        Button about = findViewById(R.id.about_btn);
        about.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                about();
            }
        });

        Button play_4x4 = findViewById(R.id.mem_4x4btn);
        play_4x4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                play4x4();
            }
        });

    }

    public void play3x3(){
        Intent intent = new Intent(getApplicationContext(),
               Memory5x4.class );
        startActivity(intent);
    }
    public void play4x4(){
        Intent intent = new Intent(getApplicationContext(),
                Memory4x4.class );
        startActivity(intent);
    }
    public void about()
    {
        Intent i = new Intent(getApplicationContext(),AboutActivity.class);
        startActivity(i);
    }
}
