package com.zanydruid.shelfelf20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;


/**
 * Created by yizhu on 2/8/16.
 */
public class LiquorDetailFragment extends Fragment {

    private ImageView mImageView;
    private TextView nameTextView;
    private TextView abvTextView;
    private TextView descrTextView;
    private Liquor mLiquor;
    public static final String ARG_ID = "liquor_id";

    public static LiquorDetailFragment newInstance(UUID id){
        Bundle args = new Bundle();
        args.putSerializable(ARG_ID, id);
        LiquorDetailFragment fragment = new LiquorDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID mId = (UUID)getArguments().getSerializable(ARG_ID);
        mLiquor = LiquorBox.get(getActivity()).getLiquorById(mId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liquor_detail,container,false);
        mImageView = (ImageView) view.findViewById(R.id.detail_image_view);
        mImageView.setImageResource(mLiquor.getImageRes());
        nameTextView = (TextView)view.findViewById(R.id.detail_name_text_view);
        nameTextView.setText(mLiquor.getName());
        abvTextView = (TextView)view.findViewById(R.id.detail_abv_text_view);
        abvTextView.setText(mLiquor.getABV());
        descrTextView = (TextView) view.findViewById(R.id.detail_desc_text_view);
        descrTextView.setText(mLiquor.getDescription());
        return view;
    }
}
