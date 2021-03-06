package com.sci.kolorob.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sci.kolorob.R;
import com.sci.kolorob.fragment.CatDetailsFragment;
import com.sci.kolorob.helpers.OnSwipeTouchListener;
import com.sci.kolorob.model.CatDetails;
import com.sci.kolorob.utils.AppConstants;
import com.sci.kolorob.utils.AppUtils;
import com.sci.kolorob.utils.Lg;

/**
 * Created by touhid on 10/29/15.
 *
 * @author touhid
 */
public class CategoryActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = CategoryActivity.class.getSimpleName();

    private FrameLayout flDetailsHolder;
    private LinearLayout llFlowingDetails;
    private HorizontalScrollView hsvCategory, hsvSubCategory;
    private ImageView ivHookCat;
    private Handler movHandler;
    private TextView subcat_below_tv,subcat_tv;
    private static final int HOOK_TOP_MARGIN = 160;
    private static final int TOP_SLIDE_DELTA = 26;
    private static final int SLIDE_INTERVAL_MS = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        movHandler = new Handler();

        setupSwipyDetails();

        hsvCategory = (HorizontalScrollView) findViewById(R.id.hsvCat);
        hsvSubCategory = (HorizontalScrollView) findViewById(R.id.hsvSubCat);
        ivHookCat = (ImageView) findViewById(R.id.ivHookCat);
        ivHookCat.setOnClickListener(this);
        subcat_below_tv= (TextView) findViewById(R.id.belowSubCat);
        subcat_tv = (TextView) findViewById(R.id.textView);
        subcat_tv.setVisibility(View.INVISIBLE);

        setCategoryClickers();

    }

    private void setupSwipyDetails() {
        flDetailsHolder = (FrameLayout) findViewById(R.id.flDetailsHolderCat);
        llFlowingDetails = (LinearLayout) findViewById(R.id.llFlowingDetailsCat);

        flDetailsHolder.setOnTouchListener(new OnSwipeTouchListener(CategoryActivity.this) {
            @Override
            public void onSwipeLeft() {
                hideFlowingDetails();
            }

            @Override
            public void onSwipeRight() {
                showFlowingDetails();
            }
        });
        findViewById(R.id.ivOpenerCat).setOnClickListener(this);
    }

    private void hideFlowingDetails() {
        if (llFlowingDetails.getWidth() < 1)
            return;
        movHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                                llFlowingDetails.getLayoutParams();
                        lp.width -= 4;
                        llFlowingDetails.setLayoutParams(lp);
                        if (lp.width > 0)
                            hideFlowingDetails();
                    }
                });
            }
        }, SLIDE_INTERVAL_MS / 2);
    }

    private void showFlowingDetails() {
        if (llFlowingDetails.getWidth() > 120)
            return;
        movHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                                llFlowingDetails.getLayoutParams();
                        lp.width += 4;
                        llFlowingDetails.setLayoutParams(lp);
                        if (lp.width < 120)
                            showFlowingDetails();
                    }
                });
            }
        }, SLIDE_INTERVAL_MS / 2);
    }

    private void setCategoryClickers() {
        findViewById(R.id.btnEduCat).setOnClickListener(this);
        findViewById(R.id.btnFunCat).setOnClickListener(this);
        findViewById(R.id.btnGovtCat).setOnClickListener(this);
        findViewById(R.id.btnHealthCat).setOnClickListener(this);
        findViewById(R.id.btnJobCat).setOnClickListener(this);
        findViewById(R.id.btnLawCat).setOnClickListener(this);
        findViewById(R.id.btnMoneyCat).setOnClickListener(this);
    }

    /**
     * Sets the sub-category list as per the category-id & toggles the sub-category list view
     */
    private void toggleSubCategoryView() {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) ivHookCat.getLayoutParams();
        // -1 will decrease the top margin of the hook (hide sub-category), 1 will increase it
        int hookMovDir = lp.topMargin == HOOK_TOP_MARGIN ? 1 : -1;
        toggleSubCategoryView(hookMovDir, AppConstants.CAT_BASE);
    }

    /**
     * Sets the sub-category list as per the category-id & toggles the sub-category list view
     *
     * @param hookMovDir -1: Hides the sub-category view, 1: Shows the sub-category view,
     *                   0: identifies whether to show the sub-category view or not on the
     *                   basis of the current hook position.
     * @param categoryId @see{AppConstants} class to find specific category IDs to populate the respective sub-category list.
     *                   This integer is not checked when hookMovDir<=0.
     */
    private void toggleSubCategoryView(int hookMovDir, int categoryId) {
        runSlideAction(hookMovDir);
        if (hookMovDir > -1)
            populateSubCategory(categoryId);
        else
            clearSubCategoryList();
    }

    private void clearSubCategoryList() {
        final LinearLayout llSubCatHolder = (LinearLayout) findViewById(R.id.llSubCatHolderCat);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        llSubCatHolder.removeAllViews();
                        unselectAllCategories();
                    }
                });
            }
        }, SLIDE_INTERVAL_MS * TOP_SLIDE_DELTA);
    }

    private void unselectAllCategories() {
        findViewById(R.id.btnEduCat).setSelected(false);
        findViewById(R.id.btnFunCat).setSelected(false);
        findViewById(R.id.btnGovtCat).setSelected(false);
        findViewById(R.id.btnHealthCat).setSelected(false);
        findViewById(R.id.btnJobCat).setSelected(false);
        findViewById(R.id.btnLawCat).setSelected(false);
        findViewById(R.id.btnMoneyCat).setSelected(false);
    }

    private void populateSubCategory(int categoryId) {
        LinearLayout llSubCatHolder = (LinearLayout) findViewById(R.id.llSubCatHolderCat);
        llSubCatHolder.removeAllViews();
        String[] subCats = AppConstants.SUB_CATEGORIES[categoryId - AppConstants.CAT_BASE];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        for (String s : subCats) {
            Lg.e(TAG, "Setting sub-category: " + s);
            Button btn = new Button(CategoryActivity.this);
            btn.setText(AppUtils.getUnicodedFormat(getAssets(), s));
            btn.setBackgroundColor(getResources().getColor(R.color.sky_blue));
            lp.setMargins(5, 3, 3, 3);
            btn.setLayoutParams(lp);
            llSubCatHolder.addView(btn);

        }
        // TO_DO Attach a fragment with the respective category data
        CatDetailsFragment catDetailsFrag = CatDetailsFragment.newInstance();
        Bundle catDetailsData = new Bundle();
        catDetailsData.putSerializable(AppConstants.KEY_CAT_OBJ, getCategoryDetailsFull(categoryId));
        catDetailsFrag.setArguments(catDetailsData);
        getSupportFragmentManager().beginTransaction().replace(R.id.flDetailsHolderCat, catDetailsFrag).commit();
    }

    private CatDetails getCategoryDetailsFull(int categoryId) {
        int catPos = categoryId - AppConstants.CAT_BASE;
        String catName = AppConstants.ALL_CAT_BN[(catPos)];
        String catDetails = AppConstants.ALL_CAT_DETAIL_BN[catPos];

        return new CatDetails(catName, catDetails);
    }

    /**
     * @param hookMovDir -1: Hides the sub-category view, 1: Shows the sub-category view,
     *                   0: identifies whether to show the sub-category view or not on the
     *                   basis of the current hook position.
     */
    private void runSlideAction(final int hookMovDir) {
        Lg.e(TAG, "runSlideAction : Hook move-direction = " + hookMovDir);

        movHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        FrameLayout.LayoutParams lpIvHook = (FrameLayout.LayoutParams) ivHookCat.getLayoutParams();
                        int hookTopMargin = lpIvHook.topMargin;
                        int newHookTopMargin = hookTopMargin + hookMovDir;
                        if (newHookTopMargin < HOOK_TOP_MARGIN)
                            newHookTopMargin = HOOK_TOP_MARGIN;
                        else if (newHookTopMargin > (HOOK_TOP_MARGIN + TOP_SLIDE_DELTA))
                            newHookTopMargin = HOOK_TOP_MARGIN + TOP_SLIDE_DELTA;
                        lpIvHook.setMargins(0, newHookTopMargin, 0, 0);
                        ivHookCat.setLayoutParams(lpIvHook);

                        FrameLayout.LayoutParams lpSubCat = (FrameLayout.LayoutParams) hsvSubCategory.getLayoutParams();
                        lpSubCat.setMargins(17, lpSubCat.topMargin + hookMovDir, 17, 0);
                        hsvSubCategory.setLayoutParams(lpSubCat);

                        FrameLayout.LayoutParams lpCat = (FrameLayout.LayoutParams) hsvCategory.getLayoutParams();
                        lpCat.setMargins(0, lpCat.topMargin + hookMovDir * -1, 0, 0);
                        hsvCategory.setLayoutParams(lpCat);
                        if( newHookTopMargin==160)
                        {
                            subcat_below_tv.setVisibility(View.VISIBLE);
                            subcat_tv.setVisibility(View.INVISIBLE);
                        }
                        else
                        {
                            subcat_below_tv.setVisibility(View.INVISIBLE);
                            subcat_tv.setVisibility(View.VISIBLE);
                        }
                        Lg.d(TAG, "Hook top margin inside runSlideAction: " + hookTopMargin);
                        if ((hookMovDir > 0 && hookTopMargin < (HOOK_TOP_MARGIN + TOP_SLIDE_DELTA))
                                || (hookMovDir < 0 && hookTopMargin > HOOK_TOP_MARGIN))
                            runSlideAction(hookMovDir);
                        else if (hookMovDir == 0 && hookTopMargin < (HOOK_TOP_MARGIN + TOP_SLIDE_DELTA))
                            runSlideAction(1);
                    }
                });
            }
        }, SLIDE_INTERVAL_MS);
    }

    /**
     * Interface method implementations goes at the end of each class
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ivHookCat:
                unselectAllCategories();
                findViewById(R.id.btnEduCat).setSelected(true);
                toggleSubCategoryView();
                break;

            case R.id.btnEduCat:
                unselectAllCategories();
                findViewById(R.id.btnEduCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_EDU);
                break;

            case R.id.btnFunCat:
                unselectAllCategories();
                findViewById(R.id.btnFunCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_FUN);
                break;

            case R.id.btnGovtCat:
                unselectAllCategories();
                findViewById(R.id.btnGovtCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_GOVT);
                break;

            case R.id.btnHealthCat:
                unselectAllCategories();
                findViewById(R.id.btnHealthCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_HEALTH);
                break;

            case R.id.btnJobCat:
                unselectAllCategories();
                findViewById(R.id.btnJobCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_JOB);
                break;

            case R.id.btnLawCat:
                unselectAllCategories();
                findViewById(R.id.btnLawCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_LAW);
                break;

            case R.id.btnMoneyCat:
                unselectAllCategories();
                findViewById(R.id.btnMoneyCat).setSelected(true);
                toggleSubCategoryView(0, AppConstants.CAT_MONEY);
                break;

            case R.id.ivOpenerCat:
                if (llFlowingDetails.getWidth() < 1)
                    showFlowingDetails();
                else
                    hideFlowingDetails();
                break;

            default:
                break;

        }
    }
}
