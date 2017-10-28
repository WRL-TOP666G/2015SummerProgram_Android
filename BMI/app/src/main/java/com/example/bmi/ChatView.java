package com.example.bmi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ChatView extends ActionBarActivity implements View.OnTouchListener {

    int lessonNum = 0, counter_talker = 0;
    public MediaPlayer stageplayer;
    RelativeLayout relativeLayout ;
    ImageView imvPlayer, imvNPC, imvBackground;
    TextView textView;
    ChatDB db ;


    protected void onDestroy()
    {
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);

        imvPlayer = (ImageView)findViewById(R.id.imvPlayer);
        imvNPC = (ImageView)findViewById(R.id.imvNPC);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        imvBackground = (ImageView)findViewById(R.id.imvBackground);
        textView = (TextView)findViewById(R.id.textView);
        relativeLayout.setOnTouchListener(this);

        stageplayer=MediaPlayer.create(this,R.raw.game_maoudamashii_5_village09);
        stageplayer.setLooping(true);
        stageplayer.start();

////////get which lesson and store it in lessonNum
        Bundle bundle=getIntent().getExtras();
        lessonNum=bundle.getInt("stage_1");

        db = new ChatDB(lessonNum);
        imvBackground.setImageResource(db.getImvBackground());
        imvPlayer.setImageResource(R.drawable.android);
        imvNPC.setImageResource(db.getImvNPC());
        if(db.getTalker()[counter_talker] == true){
            imvNPC.setVisibility(View.INVISIBLE);
            imvPlayer.setVisibility(View.VISIBLE);
        }
        else{
            imvNPC.setVisibility(View.VISIBLE);
            imvPlayer.setVisibility(View.INVISIBLE);
        }
        textView.setText(db.getTalkContent()[counter_talker]);

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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        counter_talker++;
        if(db.getTalker().length <= counter_talker)
        {

            if(lessonNum==11) {

                Intent intent= new Intent(ChatView.this,Racecource.class);
                stageplayer.stop();
                startActivity(intent);
                finish();
            }
            else if(lessonNum==12)
            {

                Intent intent= new Intent(this, Hiding_shoot_stage.class);
                Toast.makeText(this, "HIT THE GARBAGE TO CLEAN THEM", Toast.LENGTH_LONG).show();
                stageplayer.stop();
                startActivity(intent);

                finish();
            }
            else {

                Intent intent = new Intent(this, Lesson.class);
                Bundle bundle = new Bundle();
                bundle.putInt("stage", lessonNum);
                intent.putExtras(bundle);
                stageplayer.stop();
                startActivity(intent);
                finish();
            }

        }
        else if(db.getTalker()[counter_talker] == true){
            imvNPC.setVisibility(View.INVISIBLE);
            imvPlayer.setVisibility(View.VISIBLE);
            textView.setText(db.getTalkContent()[counter_talker]);
        }
        else{
            imvNPC.setVisibility(View.VISIBLE);
            imvPlayer.setVisibility(View.INVISIBLE);
            textView.setText(db.getTalkContent()[counter_talker]);
        }



        return false;
    }
}
