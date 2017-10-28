package com.example.bmi;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.bmi.R;

import java.util.Timer;
import java.util.TimerTask;


public class Racecource extends ActionBarActivity {

    Button btnRun;
    ProgressBar pgbCom, pgbPlayer;
    int playerNum = 0, comNumber = 0;
    Timer timer = new Timer(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racecource);

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);


        pgbCom = (ProgressBar)findViewById(R.id.progressBar_com);
        pgbPlayer = (ProgressBar)findViewById(R.id.progressBar_player);
        btnRun = (Button)findViewById(R.id.button);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playerNum < 1000) {
                    playerNum += 40;
                    pgbPlayer.setProgress(playerNum);
                } else if (playerNum >= 1000) {
                    timer.cancel();
                    new AlertDialog.Builder(Racecource.this)
                            .setTitle("Okay you win. It's a good game!!")
                            .setCancelable(false)
                            .setPositiveButton("Thank you,and you unlock the final stage", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Racecource.this,MainActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("result", "win");
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .show();
                }
            }
        });

        timer.schedule(new timerTask(), 0, 10);
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

    public class timerTask extends TimerTask
    {
        public void run()
        {
            if(comNumber < 1000){
                comNumber += 2;
                pgbCom.setProgress(comNumber);
            }
            else if(comNumber >= 1000) {
                timer.cancel();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new AlertDialog.Builder(Racecource.this)
                                .setTitle("Sorry you lose the game, I can't let you leave...")
                                .setMessage("Do you want to play again?")
                                .setCancelable(false)
                                .setNegativeButton("Sure!!", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        playerNum = 0;
                                        comNumber = 0;
                                        pgbPlayer.setProgress(playerNum);
                                        pgbCom.setProgress(comNumber);
                                        timer = new Timer(true);
                                        timer.schedule(new timerTask(), 0, 10);
                                    }
                                })
                                .show();
                    }
                });

            }

        }
    };
}
