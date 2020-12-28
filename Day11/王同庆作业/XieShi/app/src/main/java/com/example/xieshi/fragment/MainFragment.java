package com.example.xieshi.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xieshi.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Banner banner;
    private ArrayList<Integer> integers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        banner = view.findViewById(R.id.banner);
        integers = new ArrayList<>();
        integers.add(R.drawable.image1);
        integers.add(R.drawable.image2);
        integers.add(R.drawable.image3);
        integers.add(R.drawable.image4);
        integers.add(R.drawable.image5);
        banner.setImages(integers)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(getContext()).load(path).into(imageView);
                    }
                }).start();
        return view;
    }
}
