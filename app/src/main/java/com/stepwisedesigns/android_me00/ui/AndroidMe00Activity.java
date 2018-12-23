package com.stepwisedesigns.android_me00.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.stepwisedesigns.android_me00.R;
import com.stepwisedesigns.android_me00.data.AndroidImageAssets;

import java.util.List;

public class AndroidMe00Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me00);
        if (savedInstanceState == null) {


            //compile body part instance
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());

            int headIndex = getIntent().getIntExtra("headIndex", 5);
            headFragment.setImageIndex(headIndex);

            FragmentManager headFragmentManager = getSupportFragmentManager();
            headFragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();


            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setImageIndex(bodyIndex);

            FragmentManager bodyFragmentManager = getSupportFragmentManager();
            bodyFragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setImageIndex(legIndex);

            FragmentManager legFragmentManager = getSupportFragmentManager();
            legFragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}