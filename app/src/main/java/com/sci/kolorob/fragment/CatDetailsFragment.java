package com.sci.kolorob.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sci.kolorob.R;
import com.sci.kolorob.model.CatDetails;
import com.sci.kolorob.utils.AppConstants;

/**
 * Created by touhid on 10/30/15.
 * @author touhid
 */
public class CatDetailsFragment extends Fragment{

    public static CatDetailsFragment newInstance(){
        return new CatDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cat_details_frag, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle catDetData = getArguments();
        if(catDetData==null)
            return;
        CatDetails catDetails = (CatDetails) catDetData.getSerializable(AppConstants.KEY_CAT_OBJ);
        if(catDetails==null)
            catDetails = new CatDetails("Default Category Name", "Some details on this category and its sub-categories");
        TextView tvName= (TextView) view.findViewById(R.id.tvCatNameDetFrag);
        tvName.setText(catDetails.getCatName());

        TextView tvDetails = (TextView) view.findViewById(R.id.tvCatDetailsDetFrag);
        tvDetails.setText(catDetails.getOtherDetails());
    }
}
