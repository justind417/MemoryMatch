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

public class Memory4x4 extends Activity {

    TextView tv_p1, tv_cmp, tv_p1_score, tv_p2_score,winner_tv;
    private MediaPlayer mediaPlayerWin;
    private MediaPlayer mediaPlayerLose;
    private MediaPlayer mediaPlayerMatch;
    private MediaPlayer mediaPlayerMiss;

    int matchCount=0;

    ImageView a1, a2, a3,a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4, turn_img;

    Integer[] cards= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    int image0, image1, image2, image3, image4, image5, image6, image7, rightArrow, leftArrow;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory4x4);
        matchCount=0;
        mediaPlayerWin = MediaPlayer.create(this, R.raw.win);
        mediaPlayerLose = MediaPlayer.create(this, R.raw.lose);
        mediaPlayerMatch = MediaPlayer.create(this, R.raw.electrowinsound);
        mediaPlayerMiss = MediaPlayer.create(this, R.raw.youlosesfx);

        winner_tv=findViewById(R.id.winner_tv);
        winner_tv.setVisibility(View.INVISIBLE);
       // tv_p1 = findViewById(R.id.player_tv);
        //tv_p1_score = findViewById(R.id.p1_score_tv);
        //tv_cmp = findViewById(R.id.computer_tv);
        //tv_p2_score = findViewById(R.id.p2_score_tv);

        a1 = findViewById(R.id.A1_img_btn);
        a2 = findViewById(R.id.A2_img_btn);
        a3 = findViewById(R.id.A3_img_btn);
        a4 = findViewById(R.id.A4_img_btn);

        b1 = findViewById(R.id.B1_img_btn);
        b2 = findViewById(R.id.B2_img_btn);
        b3 = findViewById(R.id.B3_img_btn);
        b4 = findViewById(R.id.B4_img_btn);

        c1 = findViewById(R.id.C1_img_btn);
        c2 = findViewById(R.id.C2_img_btn);
        c3 = findViewById(R.id.C3_img_btn);
        c4 = findViewById(R.id.C4_img_btn);

        d1 = findViewById(R.id.D1_img_btn);
        d2 = findViewById(R.id.D2_img_btn);
        d3 = findViewById(R.id.D3_img_btn);
        d4 = findViewById(R.id.D4_img_btn);

        turn_img = findViewById(R.id.turn_iv);

        // tags used to check for match.
        a1.setTag("0");
        a2.setTag("1");
        a3.setTag("2");
        a4.setTag("3");

        b1.setTag("4");
        b2.setTag("5");
        b3.setTag("6");
        b4.setTag("7");

        c1.setTag("8");
        c2.setTag("9");
        c3.setTag("10");
        c4.setTag("11");

        d1.setTag("12");
        d2.setTag("13");
        d3.setTag("14");
        d4.setTag("15");


        //load images for the board.
        loadImages();
        //shuffle the array to simulate shuffling the cards.
        Collections.shuffle(Arrays.asList(cards));


//On Click Listener for each button, calls flip card when clicked & passes the tag number of the card that was clicked as an Integer for card comparison in CheckforMatch.

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


    }

    // flip card to show the image
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
            img.setImageResource(image0);
        }else if(cards[card] == 9){
            img.setImageResource(image1);
        }else if(cards[card] == 10){
            img.setImageResource(image2);
        }else if(cards[card]==11){
            img.setImageResource(image3);
        }else if(cards[card]==12){
            img.setImageResource(image4);
        }else if(cards[card]==13){
            img.setImageResource(image5);
        }else if(cards[card]==14){
            img.setImageResource(image6);
        }else if(cards[card]==15){
            img.setImageResource(image7);

        }
//set first and second card to 0-7 to prepare to check for a match
        if(cardNumber == 1){
            firstCard = cards[card];
            if(firstCard >= 8){
                firstCard = firstCard - 8;
            }
            cardNumber = 2;
            clickedFirst = card;
            img.setEnabled(false);
        }else if(cardNumber == 2){
            secondCard = cards[card];
            if(secondCard >= 8){
                secondCard = secondCard -8;
            }
            cardNumber = 1;
            clickedSecond = card;
//disable all buttons while check for match
            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);

            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);

            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            d1.setEnabled(false);
            d2.setEnabled(false);
            d3.setEnabled(false);
            d4.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    checkForMatch();
                }
            }, 1000);
        }

    }

    //compares first card against second card. If cards are equal, find the correct button and set it to invisible. Add point for match maker.
    private void checkForMatch(){

        if(firstCard == secondCard){
            matchCount++;
            if(clickedFirst == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 1) {
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 2) {
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 4) {
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 5) {
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 6) {
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 7){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 8) {
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 9) {
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 10) {
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 11){
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 12){
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 13){
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 14){
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedFirst == 15){
                d4.setVisibility(View.INVISIBLE);
            }
            if(clickedSecond == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 1) {
                a2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 2) {
                a3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 4) {
                b1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 5) {
                b2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 6) {
                b3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 7){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 8) {
                c1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 9) {
                c2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 10) {
                c3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 11){
                c4.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 12){
                d1.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 13){
                d2.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 14){
                d3.setVisibility(View.INVISIBLE);
            }else if(clickedSecond == 15){
                d4.setVisibility(View.INVISIBLE);
            }

            if(turn == 1){
                mediaPlayerMatch.start();
               // playerPoints++;
                //tv_p1_score.setText("P1 Score: " + playerPoints);
            }else if(turn == 2){
                mediaPlayerMatch.start();
                //cpuPoints++;
                //tv_p2_score.setText("P2 Score: " + cpuPoints);
            }
if(matchCount==8){
    winner_tv.setVisibility(View.VISIBLE);

}
            //if no matches occur, reset cards to face down.
        }else {
            mediaPlayerMiss.start();
            a1.setImageResource(R.drawable.square100);
            a2.setImageResource(R.drawable.square100);
            a3.setImageResource(R.drawable.square100);
            a4.setImageResource(R.drawable.square100);

            b1.setImageResource(R.drawable.square100);
            b2.setImageResource(R.drawable.square100);
            b3.setImageResource(R.drawable.square100);
            b4.setImageResource(R.drawable.square100);

            c1.setImageResource(R.drawable.square100);
            c2.setImageResource(R.drawable.square100);
            c3.setImageResource(R.drawable.square100);
            c4.setImageResource(R.drawable.square100);

            d1.setImageResource(R.drawable.square100);
            d2.setImageResource(R.drawable.square100);
            d3.setImageResource(R.drawable.square100);
            d4.setImageResource(R.drawable.square100);

        }
        //change turn animation with arrow.
        if(turn == 1){
            turn = 2;
            //turn_img.setImageResource(rightArrow);

        }else if(turn == 2){
            turn = 1;
            //turn_img.setImageResource(leftArrow);
        }
// re-enable all buttons after check for match is complete.
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);

        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);

        d1.setEnabled(true);
        d2.setEnabled(true);
        d3.setEnabled(true);
        d4.setEnabled(true);

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

        rightArrow = R.drawable.rightarrow;
        leftArrow = R.drawable.left_arrow;



    }
}
