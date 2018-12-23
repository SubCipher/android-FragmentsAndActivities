package com.stepwisedesigns.android_me00.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.stepwisedesigns.android_me00.R;
import com.stepwisedesigns.android_me00.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    public static String IMAGE_ID_LIST = "image_ids";
    public static String IMAGE_INDEX = "image_index";

    public static final String TAG = "BodyPartFragment";

    public  BodyPartFragment(){}

    private List<Integer> mImageIds;
    private int mImageIndex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if(savedInstanceState != null ){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mImageIndex = savedInstanceState.getInt(IMAGE_INDEX);
        }

        //create container for holding object (image view)
        View rootView = inflater.inflate(R.layout.fragment_body_part,container,false);

        //assign instance of image view to root view
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        //assign image to image view
        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mImageIndex));

            imageView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    if(mImageIndex < mImageIds.size()-1){
                        mImageIndex++;
                    } else {
                        mImageIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mImageIndex));
                }
            });
        } else {
            Log.v(TAG, "null list returned");
        }

        //return the compiled rootView
        return rootView;

    }

    public void setImageIds(List<Integer> imageIds) {

        mImageIds = imageIds;
    }
    public void setImageIndex(int index){

        mImageIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>) mImageIds);
        currentState.putInt(IMAGE_INDEX,mImageIndex);
    }
}
