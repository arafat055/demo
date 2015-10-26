package com.example.mazhaulislam.demo;

import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mazhaulislam.demo.R;

public class secondActivity extends ActionBarActivity {
    TextView tv2,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tv2=(TextView)findViewById(R.id.tv2);
        Typeface font = Typeface.createFromAsset(getAssets(), "SolaimanLipi_Bold_10-03-12.ttf");
        tv2.setTypeface(font);
        tv2.setText("কোনহানে যাইবেন কন");
        tv4=(TextView)findViewById(R.id.tv4);
        tv4.setText("আমি রেডি");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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



