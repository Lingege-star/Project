package com.example.fuchanglin.Fragment.Discoover;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fuchanglin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WikiFragment extends Fragment {

    public WikiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wiki, container, false);
    }
}
