package com.example.bmi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AsyncPlayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{

    public static int stage_in_backup ;
    public static int[] stage_pass_backup = new int[13];
    public static int stageclear_backup;

    private ImageView imageView;
    private MediaPlayer player;
    private MediaPlayer player_shoot;


    public static int stageclear;
    private int stage_in=0;
    private int[] stage_pass=new int[12];



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn3 = (Button) findViewById(R.id.btnYauMeTei);
        final Button btn4 = (Button) findViewById(R.id.btnCentral);
        final Button btn1 = (Button) findViewById(R.id.btnWangTaiSin);
        final Button btn6 = (Button) findViewById(R.id.btnDisneyland);
        final Button btn2 = (Button) findViewById(R.id.btnMangKok);
        final Button btn10 = (Button) findViewById(R.id.btnDimandHill);
        final Button btn9 = (Button) findViewById(R.id.btnTsuenWan);
        final Button btn11 = (Button) findViewById(R.id.btnRaceCourse);
        final Button btn7 = (Button) findViewById(R.id.btnYuenLong);
        final Button btn8 = (Button) findViewById(R.id.btnTungChung);
        final Button btn = (Button) findViewById(R.id.btnCausewayBay);
        final Button btn12 = (Button) findViewById(R.id.btnhidestage);

        player=MediaPlayer.create(this,R.raw.audio);
        player.setLooping(true);

        if(stage_in_backup!=12) {
            player.start();
        }




        Bundle bundle=getIntent().getExtras();

        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(50);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);


        btn1.startAnimation(animation);
        btn2.startAnimation(animation);
        btn3.startAnimation(animation);
        btn4.startAnimation(animation);
        btn.startAnimation(animation);
        btn6.startAnimation(animation);
        btn7.startAnimation(animation);
        btn8.startAnimation(animation);
        btn9.startAnimation(animation);
        btn10.startAnimation(animation);
        btn11.startAnimation(animation);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage_wts(view);
            }
        });

        if(stage_pass_backup[stage_in_backup]==1)
        {
            stageclear = stageclear + 1;
        }

        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn.setVisibility(View.GONE);
        btn6.setVisibility(View.GONE);
        btn7.setVisibility(View.GONE);
        btn8.setVisibility(View.GONE);
        btn9.setVisibility(View.GONE);
        btn10.setVisibility(View.GONE);
        btn11.setVisibility(View.GONE);
        btn12.setVisibility(View.GONE);


        if (stageclear>0)
        {
            btn1.clearAnimation();
            btn2.setVisibility(View.VISIBLE);
            btn2.startAnimation(animation);
        }
        if (stageclear>1)
        {
            btn2.clearAnimation();
            btn3.setVisibility(View.VISIBLE);
            btn3.startAnimation(animation);
            
        }
        if (stageclear>2)
        {
            btn3.clearAnimation();
            btn4.setVisibility(View.VISIBLE);
            btn4.startAnimation(animation);
        }
        if (stageclear>3)
        {
            btn4.clearAnimation();
            btn.setVisibility(View.VISIBLE);
            btn.startAnimation(animation);
        }
        if (stageclear>4)
        {
            btn.clearAnimation();
            btn6.setVisibility(View.VISIBLE);
            btn6.startAnimation(animation);
        }
        if (stageclear>5)
        {
            btn6.clearAnimation();
            btn7.setVisibility(View.VISIBLE);
            btn7.startAnimation(animation);
        }
        if (stageclear>6)
        {
            btn7.clearAnimation();
            btn8.setVisibility(View.VISIBLE);
            btn8.startAnimation(animation);
        }
        if (stageclear>7)
        {
            btn8.clearAnimation();
            btn9.setVisibility(View.VISIBLE);
            btn9.startAnimation(animation);
        }
        if (stageclear>8)
        {
            btn9.clearAnimation();
            btn10.setVisibility(View.VISIBLE);
            btn10.startAnimation(animation);
        }
        if (stageclear>9)
        {
            btn10.clearAnimation();
            btn11.setVisibility(View.VISIBLE);
            btn11.startAnimation(animation);
        }
        if (stageclear>10)
        {
            btn11.clearAnimation();
            btn12.setVisibility(View.VISIBLE);
        }
    }


    public void stage_wts(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",1);
        stage_pass_backup[1]=stage_pass_backup[1]+1;
        stage_in_backup=1;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_mkk(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",2);
        stage_pass_backup[2]=stage_pass_backup[2]+1;
        stage_in_backup=2;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_ymt(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",3);
        stage_pass_backup[3]=stage_pass_backup[3]+1;
        stage_in_backup=3;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_ct(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",4);
        stage_pass_backup[4]=stage_pass_backup[4]+1;
        stage_in_backup=4;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_cwb(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",5);
        stage_pass_backup[5]=stage_pass_backup[5]+1;
        stage_in_backup=5;
        player.stop();

        stage_in=5;

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_dl(View view)
    {
        Intent intent= new Intent(this, ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",6);
        stage_pass_backup[6]=stage_pass_backup[6]+1;
        stage_in_backup=6;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_yl(View view)
    {
        Intent intent= new Intent(this, ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",7);
        stage_pass_backup[7]=stage_pass_backup[7]+1;
        stage_in_backup=7;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_tc(View view)
    {
        Intent intent= new Intent(this, ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",8);
        stage_pass_backup[8]=stage_pass_backup[8]+1;
        stage_in_backup=8;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_tw(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",9);
        stage_pass_backup[9]=stage_pass_backup[9]+1;
        stage_in_backup=9;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_dh(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",10);
        stage_pass_backup[10]=stage_pass_backup[10]+1;
        stage_in_backup=10;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void stage_rc(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",11);
        stage_pass_backup[11]=stage_pass_backup[11]+1;
        stage_in_backup=11;
        player.stop();

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void tohidestage(View view)
    {
        Intent intent= new Intent(this,ChatView.class);
        Bundle bundle = new Bundle();

        bundle.putInt("stage_1",12);
        stage_pass_backup[12]=stage_pass_backup[12]+1;
        stage_in_backup=12;
        player.stop();

        player_shoot=MediaPlayer.create(this,R.raw.game_maoudamashii_1_battle34);

        player_shoot.start();


        intent.putExtras(bundle);
        startActivity(intent);
        finish();
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


}
