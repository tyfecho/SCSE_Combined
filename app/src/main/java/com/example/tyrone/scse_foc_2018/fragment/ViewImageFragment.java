package com.example.tyrone.scse_foc_2018.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tyrone.scse_foc_2018.R;

public class ViewImageFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String image;
    private View.OnClickListener EmptyOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //do nothing
            ViewImageFragment.super.getActivity().onBackPressed();
        }
    };


    public ViewImageFragment() {
        // Required empty public constructor
    }

    public static ViewImageFragment newInstance(String image) {
        ViewImageFragment fragment = new ViewImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            image = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_image, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Log.i("as", "creating another new view for a new image");

        getActivity().findViewById(R.id.whitebackground).setOnClickListener(EmptyOnClickListener);

        byte[] PicByteArr = Base64.decode(image, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(PicByteArr, 0, PicByteArr.length);

        ImageView imageView = getActivity().findViewById(R.id.PictureImageView);
        imageView.setImageBitmap(bitmap);
    }
}
