package com.example.bmi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Lesson extends ActionBarActivity {

    //lessonNum >> this is which lesson  //ansNum >> the answer is in the which button
    //quesNum >> this is which question  //totalNum >> the total question of this lesson
    //extraPoint >> it means extra HP for the battle system
    int lessonNum = 0, quesNum = 1, ansNum = 0, totalNum = 0, extraPoint = 3;
    ImageView imvNPC, imvBackground;
    TextView tvQuest;

    MediaPlayer player;

    Button btnAns[] = new Button[3];
    Random number = new Random();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Bundle bundle=getIntent().getExtras();

        imvNPC = (ImageView)findViewById(R.id.imvNPC);
        imvBackground = (ImageView)findViewById(R.id.imvBackground);
        tvQuest = (TextView)findViewById(R.id.tvQuest);
        btnAns[0] = (Button)findViewById(R.id.btnAns1);
        btnAns[1] = (Button)findViewById(R.id.btnAns2);
        btnAns[2] = (Button)findViewById(R.id.btnAns3);

        player=MediaPlayer.create(this,R.raw.game_maoudamashii_5_village09);
        player.setLooping(true);
        player.start();

////////get lessonNum
        lessonNum = bundle.getInt("stage");
        updateUI(lessonNum, quesNum);
//        updateUI(lessonNum, quesNum);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateUI(int lessonNum, int quesNum){

        QuestionsDB db = new QuestionsDB(lessonNum, quesNum);
        imvNPC.setImageResource(db.getImvSrc());
        imvBackground.setImageResource(db.getImvBackground());
        tvQuest.setText(db.getQuestion());
        totalNum = db.getTotalNum();

        int randomInteger1 = number.nextInt(3);
        int randomInteger2 = number.nextInt(3);
        while(randomInteger1 == randomInteger2)
            randomInteger2 = number.nextInt(3);

        btnAns[randomInteger1].setText(db.getAns1());
        ansNum = randomInteger1;
        btnAns[randomInteger2].setText(db.getAns2());
        for(int i=0 ; i<3 ; i++){
            if(i != randomInteger1 && i != randomInteger2)
                btnAns[i].setText(db.getAns3());
        }
    }

    public void userChoose(View v){
        if(v.getId() == R.id.btnAns1){
            if( ansNum == 0){ //correct ans
                quesNum++;
                if(quesNum > totalNum){ //return to main
                    Intent intent= new Intent(this, MainActivity.class);

                    player.stop();
                    startActivity(intent);
                    finish();

                }
                else{ // next question
                    updateUI(lessonNum, quesNum);
                }
            }
            else{ //wrong ans
                Toast.makeText(this, "WRONG ANSWER !!", Toast.LENGTH_SHORT).show();
                if(extraPoint > 0)
                    extraPoint--;
            }
        }
        else if(v.getId() == R.id.btnAns2){
            if( ansNum == 1){ //correct ans
                quesNum++;
                if(quesNum > totalNum){ //return to main

                    Intent intent= new Intent(this, MainActivity.class);


                    player.stop();
                    startActivity(intent);
                    finish();
                }
                else{ // next question
                    updateUI(lessonNum, quesNum);
                    if(extraPoint > 0)
                        extraPoint--;
                }
            }
            else{ //wrong ans
                Toast.makeText(this, "WRONG ANSWER !!", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            if( ansNum == 2){ //correct ans
                quesNum++;
                if(quesNum > totalNum){ //return to main

                    Intent intent= new Intent(this, MainActivity.class);

                    player.stop();
                    startActivity(intent);
                    finish();


                }
                else{ // next question
                    updateUI(lessonNum, quesNum);
                    if(extraPoint > 0)
                        extraPoint--;
                }
            }
            else{ //wrong ans
                Toast.makeText(this, "WRONG ANSWER !!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}

