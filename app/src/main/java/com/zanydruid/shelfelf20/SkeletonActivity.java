package com.zanydruid.shelfelf20;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yizhu on 2/8/16.
 */
public abstract class SkeletonActivity extends AppCompatActivity{

    /**
     * Set up layout for subclass activity.
     *
     * Override in subclass to return custom layout res.
     *
     * @author Yi Zhu
     * @Version 1.0
     * @Created 2015.02.08
     *
     */
    @LayoutRes
    protected abstract int getLayoutResId();

    /**
     * Get a custom fragment for subclass activity
     *
     * Override in subclass, return a fragment in need
     *
     * @return Fragment
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        //Set up fragment container with FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_list_container);
        if(fragment==null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_list_container,fragment).commit();
        }
    }

}
