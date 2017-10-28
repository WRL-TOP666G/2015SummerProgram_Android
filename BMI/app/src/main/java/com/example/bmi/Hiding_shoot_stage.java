package com.example.bmi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;


public class Hiding_shoot_stage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(new DrawBitmap(this));
    }


    public class AndroidUnit implements Runnable {

        private boolean flag = true;
        private int x, y;                     //???????
        private int direction;                //????? (0 ~ 7)
        private int speed;                    //?????(???????)
        private int step;                     //?????
        private int maxHp = 100;              //?????
        private int currentHp;                //??????
        private int unit_Width, unit_Height;  //????????
        private Bitmap unit_bmp = null;       //????????
        private Paint paint;                  //?? (??????????????)


        Rect unit_rect = new Rect();

        //==== ??? ==== (?? unit_bmp ?????)
        public AndroidUnit(Bitmap unit_bmp){

            //??????
            this.unit_bmp = unit_bmp;

            //??????????
            UnitInitial();

            //AndroidUnit ????? Runnable ??
            //??? Thread ??????????? :
            new Thread(this).start();


        }

        //==== ?????????? ====
        private void UnitInitial() {
            // TODO Auto-generated method stub

            //??????????
            unit_Height = unit_bmp.getHeight();
            unit_Width = unit_bmp.getWidth();

            //???
            currentHp = maxHp;

            //?????????????
            x = (int)(Math.random() * (Constant.monitor_Width - unit_Width));
            y = (int)((Math.random() * (Constant.monitor_Height - unit_Height - 5)) + 5);

            //???????????(speed)??????(direction)???(step)
            speed = (int)(Math.random() * 10 + 3);  //???? : 3 ~ 12

            //??????(step) ? ????(direction)
            StepAndDirection();

            //??????? (paint ?????????????)
            paint = new Paint();
            paint.setColor(Color.RED); //??????
            paint.setStrokeWidth(3);     //?????
        }

        //==== ??????(step) ? ????(direction) ====
        private void StepAndDirection() {

            //??????:???? : 5 ~ 15
            step = (int)(Math.random() * 11 + 5);

            //????????:???? : 0 ~ 7
            direction = (int)(Math.random() * 8);
        }

        //==== ?? PO ? canvas(??)? ====
        protected void PostUnit(Canvas canvas) {

            //? canvas ???????
            canvas.drawBitmap(this.unit_bmp, x, y, null);

            //???????????
            int hpWidth = (int)( ((float)currentHp/(float)maxHp) * (float)unit_Width );
            if (hpWidth <= 0) hpWidth = 0;

            //???? (???????????)
            canvas.drawLine(x, y - 5, x + hpWidth, y - 5, paint);
        }

        //==== ??????????? ====
        private void PositionChange() {

            //????????????? :
            // 1. ????
            // 2. ????

            //????????
            if (step <= 0) {
                //??????(step)? ????(direction)
                StepAndDirection();
            }

            //?????????????????
            if (direction == 3 || direction == 4 || direction == 5){
                // y ???
                y += speed;
            }
            if (direction == 0 || direction == 1 || direction == 7){
                // y ???
                y -= speed;
            }
            if (direction == 1 || direction == 2 || direction == 3){
                // x ???
                x += speed;
            }
            if (direction == 5 || direction == 6 || direction == 7){
                // x ???
                x -= speed;
            }

            //??????????(????)
            //????????????????????????????
            if (x <= 0) {
                x = 0;
                StepAndDirection();  //?????????
            }
            if (x >= Constant.monitor_Width - unit_Width) {
                x = Constant.monitor_Width - unit_Width;
                StepAndDirection();
            }
            if (y <= 6) {
                //?????????????
                //??????????????? y ????
                y = 6;
                StepAndDirection();
            }
            if (y >= Constant.monitor_Height - unit_Height) {
                y = Constant.monitor_Height - unit_Height;
                StepAndDirection();
            }

            //??????????????????????????
            unit_rect.set(x, y, x + unit_Width, y + unit_Height) ;
            step--;  //????????????????
        }

        //==== ???????? ====
        protected void IsTouch(int touch_x, int touch_y) {

            //??????? touch_x ? touch_y ???
            //??????? unit_rect ? contains(x, y) ??????
            //?????????????????contains(x, y)????? true
            //???? false

            if (unit_rect.contains(touch_x, touch_y)) {
                //????????
                currentHp -= 20;  //??????? 20
                //????????????
                if (currentHp <= 0) {  //???????????????
                    flag = false;           //flag ?? false????????
                }
            }
        }

        //==== ??????????(??) ====
        protected boolean IsAlive() {
            return flag;
        }

        //==== ???????? ====
        //??????????????????????????
        @Override
        public void run() {
            // TODO Auto-generated method stub

            while(flag) {
                PositionChange(); //???????????

                try {
                    //??0.15?????? 0.15 ???????????????
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    //??????? DrawBitmap
//??? SurfaceView ?? ? ??? SurfaceHolder.Callback ?
//Runnable ????
    public class DrawBitmap extends SurfaceView
            implements SurfaceHolder.Callback, Runnable {

        private Resources res;
        private Bitmap bmp;
        private Bitmap bmp_2;
        private boolean flag = true;
        private Canvas canvas = null;
        private SurfaceHolder holder;
        private ArrayList<AndroidUnit> Au;  //AndroidUnit ?????????
        private Thread db_thread;

        //==== ??? ==== (?????? MainActivity ??)
        public DrawBitmap(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            getHolder().addCallback(this);
            holder = getHolder();

            //??????
            res = getResources();
            bmp = BitmapFactory.decodeResource(res, R.drawable.trash);

            //????
            InitialSet();

            //?????
            db_thread = new Thread(this);
        }

        //==== ???? ====
        private void InitialSet() {
            //?? AndroidUnit ??????
            Au = new ArrayList<AndroidUnit>();
            Au.clear();  //??? Au ????

            //?? AndroidUnit ?? 10 ?
            for(int i=0; i<20; i++)
            {
                //?? AndroidUnit ?? au
                AndroidUnit au = new AndroidUnit(bmp);
                //??? au ?? Au ?????
                Au.add(au);
            }

        }

        //==== ???????? ====
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // TODO Auto-generated method stub
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                int x = (int)event.getX();
                int y = (int)event.getY();

                //?? Au ????????????????????
                for (AndroidUnit a: Au) {
                    a.IsTouch(x, y);
                }
            }
            return true;
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {
            // TODO Auto-generated method stub
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            // TODO Auto-generated method stub
            db_thread.start();  //?????
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            // TODO Auto-generated method stub
        }

        //==== ????????? ====
        //????????????? canvas ?????????
        //??? 0.05 ???????

        @Override
        public void run() {
            // TODO Auto-generated method stub

            while(flag){
                //? Au ?????????????????????
                if (Au.isEmpty()) {
                    flag = false;        //?????
                    Intent intent= new Intent(Hiding_shoot_stage.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                //?????????
                try {
                    //?? 0.05 ?(?? 0.05 ???????)
                    Thread.sleep(50);

                    //???????(canvas)
                    canvas = holder.lockCanvas();

                    //?????? (????)
                    canvas.drawColor(Color.BLACK);

                    //?? Au ??????????

                    for (AndroidUnit a: Au) {
                        //??????????? AndroidUnit ??? PostUnit() ??
                        //??????? canvas ?
                        if (a.IsAlive()) a.PostUnit(canvas);
                    }

                    //? Au ????????????????
                    for (AndroidUnit b: Au) {
                        if (!b.IsAlive()) Au.remove(b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    if (canvas != null) {
                        //????(canvas)???????
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            } //while
        }
    }


    //???????????
//????????????????????????
    public class Constant {
        final static int monitor_Width = 480;
        final static int monitor_Height = 800;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hiding_shoot_stage, menu);
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
