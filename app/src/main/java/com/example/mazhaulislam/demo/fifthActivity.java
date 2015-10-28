package com.example.mazhaulislam.demo;

/**
 * Created by Mazhaul Islam on 26/10/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class fifthActivity extends Activity {
    ImageView img7;
    int flag=0,f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);
        ImageView study = (ImageView) findViewById(R.id.imageView6);
        final ImageView hook = (ImageView) findViewById(R.id.imageView17);
        final Button b = (Button) findViewById(R.id.button);
        final ImageView pin1 = (ImageView) findViewById(R.id.imageView18);
        final ImageView pin2 = (ImageView) findViewById(R.id.imageView19);
        final ImageView pin3 = (ImageView) findViewById(R.id.imageView20);
        final ImageView pin4 = (ImageView) findViewById(R.id.imageView21);
        final ImageView hook1 = (ImageView) findViewById(R.id.imageView13);
        final ImageView info = (ImageView) findViewById(R.id.imageView22);
        pin1.setVisibility(View.INVISIBLE);
        pin2.setVisibility(View.INVISIBLE);
        pin3.setVisibility(View.INVISIBLE);
        pin4.setVisibility(View.INVISIBLE);
        hook.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);

        final RelativeLayout rv = (RelativeLayout) findViewById(R.id.rv);
        rv.setVisibility(View.INVISIBLE);
        img7=(ImageView)findViewById(R.id.img7);
        img7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(fifthActivity.this,fourth.class);
                        startActivity(i);
                    }
                }
        );
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    pin1.setVisibility(View.VISIBLE);
                    pin2.setVisibility(View.VISIBLE);
                    pin3.setVisibility(View.VISIBLE);
                    pin4.setVisibility(View.VISIBLE);
                    hook.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.VISIBLE);
                    b.setText("এলাকার পড়াশুনা");
                    flag=1;
                }
                else{
                    pin1.setVisibility(View.INVISIBLE);
                    pin2.setVisibility(View.INVISIBLE);
                    pin3.setVisibility(View.INVISIBLE);
                    pin4.setVisibility(View.INVISIBLE);
                    hook.setVisibility(View.INVISIBLE);
                    rv.setVisibility(View.INVISIBLE);
                    b.setText("বাউনিয়া বাঁধ");
                    flag=0;
                }
            }
        });
        hook1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    pin1.setVisibility(View.VISIBLE);
                    pin2.setVisibility(View.VISIBLE);
                    pin3.setVisibility(View.VISIBLE);
                    pin4.setVisibility(View.VISIBLE);
                    hook.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.VISIBLE);
                    b.setText("এলাকার পড়াশুনা");
                    flag=1;
                }
                else{
                    pin1.setVisibility(View.INVISIBLE);
                    pin2.setVisibility(View.INVISIBLE);
                    pin3.setVisibility(View.INVISIBLE);
                    pin4.setVisibility(View.INVISIBLE);
                    hook.setVisibility(View.INVISIBLE);
                    rv.setVisibility(View.INVISIBLE);
                    b.setText("বাউনিয়া বাঁধ");
                    flag=0;
                }
            }
        });
        pin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(f==0) {
                    info.setVisibility(View.VISIBLE);
                    f=1;
                }
                else{
                    info.setVisibility(View.INVISIBLE);
                    f=0;
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
