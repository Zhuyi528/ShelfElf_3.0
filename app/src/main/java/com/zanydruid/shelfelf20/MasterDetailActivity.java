package com.zanydruid.shelfelf20;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MasterDetailActivity extends SkeletonActivity implements LiquorListFragment.Callbacks{

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_master_detail;
    }

    @Override
    protected Fragment createFragment() {
        return new LiquorListFragment();
    }

    @Override
    public void onLiquorSelected(Liquor liquor) {
        Fragment newDetail = LiquorDetailFragment.newInstance(liquor.getLiquorId());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_detail_container, newDetail)
                .commit();
    }
}
