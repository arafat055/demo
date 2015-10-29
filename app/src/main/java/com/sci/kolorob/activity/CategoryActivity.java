package com.sci.kolorob.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.sci.kolorob.R;

/**
 * Created by touhid on 10/29/15.
 *
 * @author touhid
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener{

    private HorizontalScrollView hsvCategory, hsvSubCategory;
    private ImageView ivHookCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        hsvCategory = (HorizontalScrollView) findViewById(R.id.hsvCat);
        hsvSubCategory = (HorizontalScrollView) findViewById(R.id.hsvSubCat);
        ivHookCat = (ImageView) findViewById(R.id.ivHookCat);
        ivHookCat.setOnClickListener(this);

        setCategoryClickers();

    }

    private void setCategoryClickers() {
        // TODO set 7 category clicks with slide-anim & sub-category population
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivHookCat:
                break;
        }
    }
}
