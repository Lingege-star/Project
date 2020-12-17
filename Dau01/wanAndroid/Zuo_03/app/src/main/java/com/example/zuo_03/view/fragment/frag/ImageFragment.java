package com.example.zuo_03.view.fragment.frag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuo_03.R;
import com.example.zuo_03.modle.bean.ImageBean;
import com.example.zuo_03.paresrcte.Parsetcay;
import com.example.zuo_03.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements IView {


    private RecyclerView rlv;
    private ArrayList<ImageBean.DataBeanX.DataBean.AuthorBean> list;
    private ImgAdapter imgAdapter;
    private ArrayList<ImageBean.DataBeanX.DataBean> image;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        Parsetcay parsetcay = new Parsetcay(this);
        parsetcay.start();
        return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        image = new ArrayList<>();
        imgAdapter = new ImgAdapter(getActivity(),list,image);
        rlv.setAdapter(imgAdapter);
    }

    @Override
    public void ShowOK(Object obj) {
    if(obj instanceof ImageBean){
        ImageBean imageBean= (ImageBean) obj;
        List<ImageBean.DataBeanX.DataBean> data = imageBean.getData().getData();
        for (int i = 0; i <data.size() ; i++) {
            ImageBean.DataBeanX.DataBean.AuthorBean author = data.get(i).getAuthor();
            list.add(author);
        }
        imgAdapter.notifyDataSetChanged();
    }
    if(obj instanceof ImageBean){
        ImageBean imageBean= (ImageBean) obj;
        List<ImageBean.DataBeanX.DataBean> data = imageBean.getData().getData();
        image.addAll(data);
        imgAdapter.notifyDataSetChanged();
    }
    }

    @Override
    public void ShowNO(String no) {

    }
}
