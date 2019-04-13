package com.coolapps.memorymatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Memory3x3 extends Activity {

    TextView tv_p1, tv_cmp;

    ImageView a1, a2, a3,a4,a5, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5;

    Integer[] cards= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

    int image0, image1, image2, image3, image4, image5, image6, image7, image8, image9;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory3x3);

        tv_p1 = findViewById(R.id.player_tv);
        tv_cmp = findViewById(R.id.computer_tv);

        a1 = findViewById(R.id.A1_img_btn);
        a2 = findViewById(R.id.A2_img_btn);
        a3 = findViewById(R.id.A3_img_btn);
        a4 = findViewById(R.id.a4_img_btn);
        a5 = findViewById(R.id.a5_img_btn);
        b1 = findViewById(R.id.B1_img_btn);
        b2 = findViewById(R.id.B2_img_btn);
        b3 = findViewById(R.id.B3_img_btn);
        b4 = findViewById(R.id.B4_img_btn);
        b5 = findViewById(R.id.B5_img_btn);
        c1 = findViewById(R.id.C1_img_btn);
        c2 = findViewById(R.id.C2_img_btn);
        c3 = findViewById(R.id.C3_img_btn);
        c4 = findViewById(R.id.C4_img_btn);
        c5 = findViewById(R.id.C5_img_btn);
        d1 = findViewById(R.id.D1_img_btn);
        d2 = findViewById(R.id.D2_img_btn);
        d3 = findViewById(R.id.D3_img_btn);
        d4 = findViewById(R.id.D4_img_btn);
        d5 = findViewById(R.id.D5_img_btn);


        a1.setTag("0");
        a2.setTag("1");
        a3.setTag("2");
        a4.setTag("3");
        a5.setTag("4");
        b1.setTag("5");
        b2.setTag("6");
        b3.setTag("7");
        b4.setTag("8");
        b5.setTag("9");
        c1.setTag("10");
        c2.setTag("11");
        c3.setTag("12");
        c4.setTag("13");
        c5.setTag("14");
        d1.setTag("15");
        d2.setTag("16");
        d3.setTag("17");
        d4.setTag("18");
        d5.setTag("19");


        loadImages();
        Log.i("--------", "----cards Array-----"+ (Arrays.asList(cards)) + " ");
        Collections.shuffle(Arrays.asList(cards));
        Log.i("--------", "----cards Array-----"+ (Arrays.asList(cards)) + " ");



        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(a1,thisCard);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(a2, thisCard);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(a3, thisCard);
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(a4, thisCard);
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(a5, thisCard);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(b1, thisCard);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(b2, thisCard);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(b3, thisCard);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(b4, thisCard);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(b5, thisCard);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(c1, thisCard);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(c2, thisCard);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(c3, thisCard);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(c4, thisCard);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                Log.i("--------", "----this card-----"+ thisCard + " ");
                flipCard(c5, thisCard);
            }
        });
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(d1, thisCard);
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(d2, thisCard);
            }
        });
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(d3, thisCard);
            }
        });
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(d4, thisCard);
            }
        });
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(d5, thisCard);
            }
        });

    }


    private void flipCard(ImageView img, int card){
       if(cards[card] == 0){
            img.setImageResource(image0);
       }else if(cards[card] == 1){
           img.setImageResource(image1);
       }else if(cards[card] == 2){
           img.setImageResource(image2);
       }else if(cards[card]==3){
           img.setImageResource(image3);
       }else if(cards[card]==4){
           img.setImageResource(image4);
       }else if(cards[card]==5){
           img.setImageResource(image5);
       }else if(cards[card]==6){
           img.setImageResource(image6);
       }else if(cards[card]==7){
           img.setImageResource(image7);
       }else if(cards[card] == 8){
           img.setImageResource(image8);
       }else if(cards[card] == 9){
           img.setImageResource(image9);
       }else if(cards[card] == 10){
            img.setImageResource(image0);
        }else if(cards[card] == 11){
            img.setImageResource(image1);
        }else if(cards[card] == 12){
            img.setImageResource(image2);
        }else if(cards[card]==13){
            img.setImageResource(image3);
        }else if(cards[card]==14){
            img.setImageResource(image4);
        }else if(cards[card]==15){
            img.setImageResource(image5);
        }else if(cards[card]==16){
            img.setImageResource(image6);
        }else if(cards[card]==17){
            img.setImageResource(image7);
        }else if(cards[card] == 18){
            img.setImageResource(image8);
        }else if(cards[card] == 19){
            img.setImageResource(image9);
        }

       if(cardNumber == 1){
           firstCard = cards[card];
           if(firstCard >= 10){
               firstCard = firstCard - 10;
           }
           cardNumber = 2;
           clickedFirst = card;
           Log.i("--------", "----clickedFirst-----"+ clickedFirst + " ");
           img.setEnabled(false);
       }else if(cardNumber == 2){
           secondCard = cards[card];
           if(secondCard >= 10){
               secondCard = secondCard -10;
           }
           cardNumber = 1;
           clickedSecond = card;
           Log.i("--------", "----clickedSecond-----"+ clickedSecond + " ");

           a1.setEnabled(false);
           a2.setEnabled(false);
           a3.setEnabled(false);
           a4.setEnabled(false);
           a5.setEnabled(false);
           b1.setEnabled(false);
           b2.setEnabled(false);
           b3.setEnabled(false);
           b4.setEnabled(false);
           b5.setEnabled(false);
           c1.setEnabled(false);
           c2.setEnabled(false);
           c3.setEnabled(false);
           c4.setEnabled(false);
           c5.setEnabled(false);
           d1.setEnabled(false);
           d2.setEnabled(false);
           d3.setEnabled(false);
           d4.setEnabled(false);
           d5.setEnabled(false);

           Handler handler = new Handler();
           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   calculate();
               }
           }, 1000);
       }

    }


    private void calculate(){


        Log.i("--------", "----firstCArd-----"+ firstCard + " ");
        Log.i("--------", "----secondCard-----"+ secondCard + " ");
        if(firstCard == secondCard){
            if(clickedFirst == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1) {
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 2) {
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 4){
                a5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 5) {
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 6) {
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 7) {
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 8){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 9){
                b5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 10) {
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 11) {
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 12) {
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 13){
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 14){
                c5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 15){
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 16){
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 17){
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 18){
                d4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 19){
                d5.setVisibility(View.INVISIBLE);
            }
            if(clickedSecond == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 1) {
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 2) {
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 4){
                a5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 5) {
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 6) {
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 7) {
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 8){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 9){
                b5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 10) {
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 11) {
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 12) {
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 13){
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 14){
                c5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 15){
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 16){
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 17){
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 18){
                d4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 19){
                d5.setVisibility(View.INVISIBLE);
            }

                if(turn == 1){
                playerPoints++;
                tv_p1.setText("P1: " + playerPoints);
                }else if(turn == 2){
                cpuPoints++;
                tv_cmp.setText("P2: " + cpuPoints);
                }
        }else{
            a1.setImageResource(R.drawable.square100);
            a2.setImageResource(R.drawable.square100);
            a3.setImageResource(R.drawable.square100);
            a4.setImageResource(R.drawable.square100);
            a5.setImageResource(R.drawable.square100);
            b1.setImageResource(R.drawable.square100);
            b2.setImageResource(R.drawable.square100);
            b3.setImageResource(R.drawable.square100);
            b4.setImageResource(R.drawable.square100);
            b5.setImageResource(R.drawable.square100);
            c1.setImageResource(R.drawable.square100);
            c2.setImageResource(R.drawable.square100);
            c3.setImageResource(R.drawable.square100);
            c4.setImageResource(R.drawable.square100);
            c5.setImageResource(R.drawable.square100);
            d1.setImageResource(R.drawable.square100);
            d2.setImageResource(R.drawable.square100);
            d3.setImageResource(R.drawable.square100);
            d4.setImageResource(R.drawable.square100);
            d5.setImageResource(R.drawable.square100);

            if(turn == 1){
                turn = 2;

            }else if(turn == 2){
                turn = 1;
            }
        }
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);
        a5.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        c5.setEnabled(true);
        d1.setEnabled(true);
        d2.setEnabled(true);
        d3.setEnabled(true);
        d4.setEnabled(true);
        d5.setEnabled(true);
    }

    private void loadImages(){
        image0 = R.drawable.dolphin80;
        image1 = R.drawable.octopus80;
        image2 = R.drawable.turtle80;
        image3 = R.drawable.whale80;
        image4 = R.drawable.smilingfish;
        image5 = R.drawable.fishingfish;
        image6 = R.drawable.purplefish;
        image7 = R.drawable.yellowfish;
        image8 = R.drawable.biglipfish80;
        image9 = R.drawable.littlewhale;

    }
}
