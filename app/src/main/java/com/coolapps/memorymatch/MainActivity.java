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
    }

    public void play3x3(){
        Intent intent = new Intent(getApplicationContext(),
               Memory3x3.class );
        startActivity(intent);
    }
}
