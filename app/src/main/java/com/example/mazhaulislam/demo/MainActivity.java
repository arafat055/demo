package com.example.mazhaulislam.demo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
ImageView imageView;
    TextView tv;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
        tv=(TextView)findViewById(R.id.tv);
        Typeface font = Typeface.createFromAsset(getAssets(), "SolaimanLipi_Bold_10-03-12.ttf");
        tv.setTypeface(font);
        tv.setText("খারান!! একটু রেডি হইয়া লই। ");
        imageButton=(ImageButton)findViewById(R.id.imagebutton);
        rotate();
        imageButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent(MainActivity.this,secondActivity.class);
                        startActivity(i);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void rotate()
    {
        Animation animation= AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.rotate
        );
        imageView.startAnimation(animation);
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
