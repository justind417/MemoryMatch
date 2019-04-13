package com.coolapps.memorymatch;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Memory4x4 extends Activity {

    TextView tv_p1, tv_cmp;

    ImageView a1, a2, a3, b1, b2, b3, c1, c2, c3;

    Integer[] cards= {1,2,3,11,22,33,};

    int image1, image2, image3, image11, image22, image33;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory4x4);

        tv_p1 = findViewById(R.id.player_tv);
        tv_cmp = findViewById(R.id.computer_tv);

        a1 = findViewById(R.id.A1_img_btn);
        a2 = findViewById(R.id.A2_img_btn);
        a3 = findViewById(R.id.A3_img_btn);
        b1 = findViewById(R.id.B1_img_btn);
        b2 = findViewById(R.id.B2_img_btn);
        b3 = findViewById(R.id.B3_img_btn);
        c1 = findViewById(R.id.C1_img_btn);
        c2 = findViewById(R.id.C2_img_btn);
        c3 = findViewById(R.id.C3_img_btn);

        a1.setTag("1");
        a2.setTag("2");
        a3.setTag("3");
        b1.setTag("4");
        b2.setTag("5");
        b3.setTag("6");



        loadImages();
        Collections.shuffle(Arrays.asList(cards));


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(a1,thisCard);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(a2, thisCard);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(a3, thisCard);
            }
        });

    }


    private void flipCard(ImageView img, int card){
       if(card == 1){
            img.setImageResource(image1);
       }else if(card == 2){
           img.setImageResource(image2);
       }else if(card == 3){
           img.setImageResource(image3);
       }
    }


    private void loadImages(){
        image1 = R.drawable.dolphin;
        image2 = R.drawable.octopus;
        image3 = R.drawable.turtle;
        image11 = R.drawable.dolphin;
        image22 = R.drawable.octopus;
        image33 = R.drawable.turtle;
    }
}
