package com.sci.kolorob.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sci.kolorob.R;
import com.sci.kolorob.utils.AppConstants;
import com.sci.kolorob.utils.AppUtils;

/**
 * Created by touhid on 10/29/15.
 *
 * @author touhid
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener {

    private HorizontalScrollView hsvCategory, hsvSubCategory;
    private ImageView ivHookCat;
    private Handler movHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        movHandler = new Handler();

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
        switch (view.getId()) {
            case R.id.ivHookCat:
                toggleSubCategoryView();
                break;
        }
    }

    private void toggleSubCategoryView() {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) ivHookCat.getLayoutParams();
        // -1 will decrease the top margin of the hook (hide sub-category), 1 will increase it
        int hookMovDir = lp.topMargin > 60 ? -1 : 1;
        runSlideAction(hookMovDir);
        if (hookMovDir > 0)
            populateSubCategory(AppConstants.CAT_EDU);
        else
            clearSubCategoryList();
    }

    private void clearSubCategoryList() {
        LinearLayout llSubCatHolder = (LinearLayout) findViewById(R.id.llSubCatHolderCat);
        llSubCatHolder.removeAllViews();
    }

    private void populateSubCategory(int categoryId) {
        LinearLayout llSubCatHolder = (LinearLayout) findViewById(R.id.llSubCatHolderCat);
        String[] subCats = AppConstants.SUB_CATEGORIES[categoryId - AppConstants.CAT_BASE];
        for (String s : subCats) {
            Button btn = new Button(CategoryActivity.this);
            btn.setText(AppUtils.getUnicodedFormat(getAssets(), s));
            btn.setBackgroundColor(getResources().getColor(R.color.sky_blue));
            llSubCatHolder.addView(btn);
        }
    }

    private void runSlideAction(final int hookMovDir) {
        movHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FrameLayout.LayoutParams lpIvHook = (FrameLayout.LayoutParams) ivHookCat.getLayoutParams();
                int hookTopMargin = lpIvHook.topMargin;
                lpIvHook.setMargins(0, hookTopMargin + hookMovDir, 0, 0);
                ivHookCat.setLayoutParams(lpIvHook);

                FrameLayout.LayoutParams lpSubCat = (FrameLayout.LayoutParams) hsvCategory.getLayoutParams();
                lpSubCat.setMargins(0, lpSubCat.topMargin + hookMovDir, 0, 0);
                hsvCategory.setLayoutParams(lpSubCat);

                FrameLayout.LayoutParams lpCat = (FrameLayout.LayoutParams) hsvCategory.getLayoutParams();
                lpCat.setMargins(0, lpCat.topMargin + hookMovDir * -1, 0, 0);
                hsvCategory.setLayoutParams(lpCat);

                if (hookTopMargin > 60 && hookTopMargin < 86)
                    runSlideAction(hookMovDir);
            }
        }, 100);
    }
}
