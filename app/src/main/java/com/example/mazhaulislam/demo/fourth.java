package com.example.mazhaulislam.demo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sci.kolorob.R;


public class fourth extends Activity {

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        ImageView img5 = (ImageView) findViewById(R.id.img5);
        ImageView img6 = (ImageView) findViewById(R.id.img6);
        ImageView study = (ImageView) findViewById(R.id.imageView6);
        final ImageView hook = (ImageView) findViewById(R.id.imageView17);
        final Button b = (Button) findViewById(R.id.button);
        final ImageView pin1 = (ImageView) findViewById(R.id.imageView18);
        final ImageView pin2 = (ImageView) findViewById(R.id.imageView19);
        final ImageView pin3 = (ImageView) findViewById(R.id.imageView20);
        final ImageView pin4 = (ImageView) findViewById(R.id.imageView21);
        final ImageView hook1 = (ImageView) findViewById(R.id.imageView13);
        pin1.setVisibility(View.INVISIBLE);
        pin2.setVisibility(View.INVISIBLE);
        pin3.setVisibility(View.INVISIBLE);
        pin4.setVisibility(View.INVISIBLE);
        hook.setVisibility(View.INVISIBLE);

        final RelativeLayout rv = (RelativeLayout) findViewById(R.id.rv);
        rv.setVisibility(View.INVISIBLE);

        img5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(fourth.this, third.class);
                        startActivity(i);
                    }
                }
        );
        img6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent k = new Intent(fourth.this, fifthActivity.class);
                        startActivity(k);
                    }
                }
        );

        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    pin1.setVisibility(View.VISIBLE);
                    pin2.setVisibility(View.VISIBLE);
                    pin3.setVisibility(View.VISIBLE);
                    pin4.setVisibility(View.VISIBLE);
                    hook.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.VISIBLE);
                    b.setText("এলাকার পড়াশুনা");
                    flag = 1;
                } else {
                    pin1.setVisibility(View.INVISIBLE);
                    pin2.setVisibility(View.INVISIBLE);
                    pin3.setVisibility(View.INVISIBLE);
                    pin4.setVisibility(View.INVISIBLE);
                    hook.setVisibility(View.INVISIBLE);
                    rv.setVisibility(View.INVISIBLE);
                    b.setText("বাউনিয়া বাঁধ");
                    flag = 0;
                }
            }
        });
        hook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    pin1.setVisibility(View.VISIBLE);
                    pin2.setVisibility(View.VISIBLE);
                    pin3.setVisibility(View.VISIBLE);
                    pin4.setVisibility(View.VISIBLE);
                    hook.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.VISIBLE);
                    b.setText("এলাকার পড়াশুনা");
                    flag = 1;
                } else {
                    pin1.setVisibility(View.INVISIBLE);
                    pin2.setVisibility(View.INVISIBLE);
                    pin3.setVisibility(View.INVISIBLE);
                    pin4.setVisibility(View.INVISIBLE);
                    hook.setVisibility(View.INVISIBLE);
                    rv.setVisibility(View.INVISIBLE);
                    b.setText("বাউনিয়া বাঁধ");
                    flag = 0;
                }
            }
        });

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

