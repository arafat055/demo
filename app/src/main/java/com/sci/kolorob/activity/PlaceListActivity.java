package com.sci.kolorob.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sci.kolorob.R;
import com.sci.kolorob.utils.AppConstants;

public class PlaceListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);

        findViewById(R.id.btnOption1PList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategoryActivity(AppConstants.PLACE_BAUNIABADH);
            }
        });
        findViewById(R.id.btnOption2PList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCategoryActivity(AppConstants.PLACE_PARIS_ROAD);
            }
        });
    }

    private void gotoCategoryActivity(int placeId) {
        Intent i = new Intent(PlaceListActivity.this, CategoryActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra(AppConstants.KEY_PLACE, placeId);
        startActivity(i);
    }
}