package com.coolapps.memorymatch;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Memory5x4 extends Activity {

    TextView tv_p1, tv_cmp, tv_p1_score, tv_p2_score, winner_tv;

    ImageView a1, a2, a3,a4,a5, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5, turn_img;

    boolean cardA1, cardA2, cardA3, cardA4, cardA5,
            cardB1, cardB2, cardB3, cardB4, cardB5,
            cardC1, cardC2, cardC3, cardC4, cardC5,
            cardD1, cardD2, cardD3, cardD4, cardD5;

    Integer[] cards= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

    int image0, image1, image2, image3, image4, image5, image6, image7, image8, image9, rightArrow, leftArrow;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    boolean playerTurn = true;
    boolean computerTurn = false;
    private MediaPlayer mediaPlayerWin;
    private MediaPlayer mediaPlayerLose;
    private MediaPlayer mediaPlayerMatch;
    private MediaPlayer mediaPlayerMiss;
    int matchcount = 0;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory5x4);

        tv_p1 = findViewById(R.id.player_tv);
        tv_p1_score = findViewById(R.id.p1_score_tv);
        tv_cmp = findViewById(R.id.computer_tv);
        tv_p2_score = findViewById(R.id.p2_score_tv);
        winner_tv=findViewById(R.id.winner_tv);
        winner_tv.setVisibility(View.INVISIBLE);

        mediaPlayerWin = MediaPlayer.create(this, R.raw.win);
        mediaPlayerLose = MediaPlayer.create(this, R.raw.lose);
        mediaPlayerMatch = MediaPlayer.create(this, R.raw.match);
        mediaPlayerMiss = MediaPlayer.create(this, R.raw.miss);

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
        turn_img = findViewById(R.id.turn_iv);

        // tags used to check for match.
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

        //load images for the board.
        loadImages();

        //shuffle the array to simulate shuffling the cards.
        Collections.shuffle(Arrays.asList(cards));



//On Click Listener for each button, calls flip card when clicked & passes the tag number of the card that was clicked as an Integer for card comparison in CheckforMatch.

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
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(a4, thisCard);
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(a5, thisCard);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(b1, thisCard);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(b2, thisCard);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(b3, thisCard);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(b4, thisCard);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(b5, thisCard);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(c1, thisCard);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());

                flipCard(c2, thisCard);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(c3, thisCard);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
                flipCard(c4, thisCard);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thisCard = Integer.parseInt((String) v.getTag());
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

// flip card to show the image
    private void flipCard(ImageView img, int card){
       if(cards[card] == 0 ){
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
//set first and second card to 0-9 to prepare to check for a match
       if(cardNumber == 1){
           firstCard = cards[card];

           if(firstCard >= 10){
               firstCard = firstCard - 10;
           }

           cardNumber = 2;
           clickedFirst = card;
           img.setEnabled(false);
       }else if(cardNumber == 2){
           secondCard = cards[card];
           if(secondCard >= 10){
               secondCard = secondCard -10;
           }
           cardNumber = 1;
           clickedSecond = card;
//disable all buttons while check for match
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

                   checkForMatch(firstCard, secondCard);

               }

           }, 2000);

       }

        computerTurn = true;
        playerTurn = false;


    }

//compares first card against second card. If cards are equal, find the correct button and set it to invisible. Add point for match maker.
    private void checkForMatch(int first, int second){

        if(first == second){
            matchcount++;
            if(clickedFirst == 0){
                cardA1 = true;
                a1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1) {
                cardA2 = true;
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 2) {
                cardA3 = true;
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 3){
                cardA4 = true;
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 4){
                cardA5 = true;
                a5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 5) {
                cardB1 = true;
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 6) {
                cardB2 = true;
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 7) {
                cardB3 = true;
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 8){
                cardB4 = true;
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 9){
                cardB5 = true;
                b5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 10) {
                cardC1 = true;
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 11) {
                cardC2 = true;
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 12) {
                cardC3 = true;
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 13){
                cardC4 = true;
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 14){
                cardC5 = true;
                c5.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 15){
                cardD1 = true;
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 16){
                cardD2 = true;
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 17){
                cardD3 = true;
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 18){
                cardD4 = true;
                d4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 19){
                cardD5 = true;
                d5.setVisibility(View.INVISIBLE);
            }
            if(clickedSecond == 0){
                a1.setVisibility(View.INVISIBLE);
                cardA1 = true;
            }else if(clickedSecond == 1) {
                cardA2 = true;
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 2) {
                cardA3 = true;
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 3){
                cardA4 = true;
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 4){
                cardA5 = true;
                a5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 5) {
                cardB1 = true;
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 6) {
                cardB2 = true;
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 7) {
                cardB3 = true;
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 8){
                cardB4 = true;
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 9){
                cardB5 = true;
                b5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 10) {
                cardC1 = true;
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 11) {
                cardC2 = true;
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 12) {
                cardC3 = true;
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 13){
                cardC4 = true;
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 14){
                cardC5 = true;
                c5.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 15){
                cardD1 = true;
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 16){
                cardD2 = true;
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 17){
                cardD3 = true;
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 18){
                cardD4 = true;
                d4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 19){
                cardD5 = true;
                d5.setVisibility(View.INVISIBLE);
            }

                if(computerTurn){
                mediaPlayerMatch.start();
                playerPoints++;
                tv_p1_score.setText("P1 Score: " + playerPoints);
                }else if(playerTurn){
                mediaPlayerMatch.start();
                cpuPoints++;
                tv_p2_score.setText("P2 Score: " + cpuPoints);
                }
              if(matchcount == 10){
                    if(playerPoints > cpuPoints){
                        tv_p1.setVisibility(View.INVISIBLE);
                        tv_cmp.setVisibility(View.INVISIBLE);
                        tv_p1_score.setVisibility(View.INVISIBLE);
                        tv_p2_score.setVisibility(View.INVISIBLE);
                        turn_img.setVisibility(View.INVISIBLE);
                        winner_tv.setVisibility(View.VISIBLE);
                        winner_tv.setText("You Win!");
                    }else if(cpuPoints > playerPoints)
                    {
                        tv_p1.setVisibility(View.INVISIBLE);
                        tv_cmp.setVisibility(View.INVISIBLE);
                        tv_p1_score.setVisibility(View.INVISIBLE);
                        tv_p2_score.setVisibility(View.INVISIBLE);
                        turn_img.setVisibility(View.INVISIBLE);
                        winner_tv.setVisibility(View.VISIBLE);
                        winner_tv.setText("You Lose!");
                    }
               }

                //if no matches occur, reset cards to face down.
        }else {
            mediaPlayerMiss.start();
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


        }
        //change turn animation with arrow.
        if(playerTurn){
            turn_img.setImageResource(leftArrow);

            //Enable all buttons
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


        }else if(computerTurn){
            turn_img.setImageResource(rightArrow);

            //Disable all buttons
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

            if(matchcount != 10) {

                cpuTurn();
            }
        }
    }

    private void cpuTurn(){

        Random rand = new Random();
        int ai_firstCard = rand.nextInt(19 );

        boolean firstCardTaken = cpuCheckCardAvailability(ai_firstCard);

        //check if card has already been matched

        while(firstCardTaken == true){

                ai_firstCard = rand.nextInt(19);
            firstCardTaken = cpuCheckCardAvailability(ai_firstCard);

            }





        if(ai_firstCard == 0){
            flipCard(a1, ai_firstCard);
        }else if(ai_firstCard == 1){
            flipCard(a2, ai_firstCard);
        }else if(ai_firstCard == 2){
            flipCard(a3, ai_firstCard);
        }else if(ai_firstCard == 3){
            flipCard(a4, ai_firstCard);
        }else if(ai_firstCard == 4){
            flipCard(a5, ai_firstCard);
        }else if(ai_firstCard == 5){
            flipCard(b1, ai_firstCard);
        }else if(ai_firstCard == 6){
            flipCard(b2, ai_firstCard);
        }else if(ai_firstCard == 7){
            flipCard(b3, ai_firstCard);
        }else if(ai_firstCard == 8){
            flipCard(b4, ai_firstCard);
        }else if(ai_firstCard == 9){
            flipCard(b5, ai_firstCard);
        }else if(ai_firstCard == 10){
            flipCard(c1, ai_firstCard);
        }else if(ai_firstCard == 11){
            flipCard(c2, ai_firstCard);
        }else if(ai_firstCard == 12){
            flipCard(c3, ai_firstCard);
        }else if(ai_firstCard == 13){
            flipCard(c4, ai_firstCard);
        }else if(ai_firstCard == 14){
            flipCard(c5, ai_firstCard);
        }else if(ai_firstCard == 15){
            flipCard(d1, ai_firstCard);
        }else if(ai_firstCard == 16){
            flipCard(d2, ai_firstCard);
        }else if(ai_firstCard == 17){
            flipCard(d3, ai_firstCard);
        }else if(ai_firstCard == 18){
            flipCard(d4, ai_firstCard);
        }else if(ai_firstCard == 19){
            flipCard(d5, ai_firstCard);
        }


        int ai_secondCard = rand.nextInt( 19);
        while(ai_secondCard == ai_firstCard){
            ai_secondCard = rand.nextInt(19);
        }
        boolean secondCardTaken = cpuCheckCardAvailability(ai_secondCard);
      while(secondCardTaken == true) {
                ai_secondCard = rand.nextInt(19);

                while(ai_secondCard == ai_firstCard){
                    ai_secondCard = rand.nextInt(19);

                }
            secondCardTaken = cpuCheckCardAvailability(ai_secondCard);
            }

        if(ai_secondCard == 0){
            flipCard(a1, ai_secondCard);
        }else if(ai_secondCard == 1){
            flipCard(a2, ai_secondCard);
        }else if(ai_secondCard == 2){
            flipCard(a3, ai_secondCard);
        }else if(ai_secondCard == 3){
            flipCard(a4, ai_secondCard);
        }else if(ai_secondCard == 4){
            flipCard(a5, ai_secondCard);
        }else if(ai_secondCard == 5){
            flipCard(b1, ai_secondCard);
        }else if(ai_secondCard == 6){
            flipCard(b2, ai_secondCard);
        }else if(ai_secondCard == 7){
            flipCard(b3, ai_secondCard);
        }else if(ai_secondCard == 8){
            flipCard(b4, ai_secondCard);
        }else if(ai_secondCard == 9){
            flipCard(b5, ai_secondCard);
        }else if(ai_secondCard == 10){
            flipCard(c1, ai_secondCard);
        }else if(ai_secondCard == 11){
            flipCard(c2, ai_secondCard);
        }else if(ai_secondCard == 12){
            flipCard(c3, ai_secondCard);
        }else if(ai_secondCard == 13){
            flipCard(c4, ai_secondCard);
        }else if(ai_secondCard == 14){
            flipCard(c5, ai_secondCard);
        }else if(ai_secondCard == 15){
            flipCard(d1, ai_secondCard);
        }else if(ai_secondCard == 16){
            flipCard(d2, ai_secondCard);
        }else if(ai_secondCard == 17){
            flipCard(d3, ai_secondCard);
        }else if(ai_secondCard == 18){
            flipCard(d4, ai_secondCard);
        }else if(ai_secondCard == 19){
            flipCard(d5, ai_secondCard);
        }

        computerTurn = false;
        playerTurn = true;



    }


    private boolean cpuCheckCardAvailability(int cpuCard){

        int ai_firstCard = cpuCard;

        if(ai_firstCard == 0 && cardA1 == true){
            return true;

        }else if(ai_firstCard == 1 && cardA2 == true){
            return true;
        }else if(ai_firstCard == 2 && cardA3 == true){
            return true;
        }else if(ai_firstCard == 3 && cardA4 == true){
            return true;
        }else if(ai_firstCard == 4 && cardA5 == true ){
            return true;
        }else if(ai_firstCard == 5 && cardB1 == true){
            return true;
        }else if(ai_firstCard == 6 && cardB2 == true){
            return true;
        }else if(ai_firstCard == 7 && cardB3 == true){
            return true;
        }else if(ai_firstCard == 8 && cardB4 == true){
            return true;
        }else if(ai_firstCard == 9 && cardB5 == true){
            return true;
        }else if(ai_firstCard == 10 && cardC1 == true){
            return true;
        }else if(ai_firstCard == 11 && cardC2 == true){
            return true;
        }else if(ai_firstCard == 12 && cardC3 == true){
            return true;
        }else if(ai_firstCard == 13 && cardC4 == true){
            return true;
        }else if(ai_firstCard == 14 && cardC5 == true){
            return true;
        }else if(ai_firstCard == 15 && cardD1 == true){
            return true;
        }else if(ai_firstCard == 16 && cardD2 == true){
            return true;
        }else if(ai_firstCard == 17 && cardD3 == true){
            return true;
        }else if(ai_firstCard == 18 && cardD4 == true){
            return true;
        }else if(ai_firstCard == 19 && cardD5 == true){
            return true;
        }else {
            return false;
        }
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
        rightArrow = R.drawable.rightarrow;
        leftArrow = R.drawable.left_arrow;



    }


    }

