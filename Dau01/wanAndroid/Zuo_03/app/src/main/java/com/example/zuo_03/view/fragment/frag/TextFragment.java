package com.example.zuo_03.view.fragment.frag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.zuo_03.R;
import com.example.zuo_03.modle.bean.TextBean;
import com.example.zuo_03.paresrcte.Parsetcay;
import com.example.zuo_03.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment implements IView {


    private RecyclerView rlv;
    private ArrayList<TextBean.DataBeanX.DataBean.AuthorBean> list;
    private TextAdapter textAdapter;
    private ArrayList<TextBean.DataBeanX.DataBean> beans;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        initView(view);
        Parsetcay parsetcay = new Parsetcay(this);
        parsetcay.start();
        return view;
    }

    private void initView(View view) {
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        beans = new ArrayList<>();
        textAdapter = new TextAdapter(getContext(),list, beans);
        rlv.setAdapter(textAdapter);
    }

    @Override
    public void ShowOK(Object obj) {
        if(obj instanceof TextBean){
            TextBean textBean= (TextBean) obj;
            List<TextBean.DataBeanX.DataBean> data = textBean.getData().getData();
            for (int i = 0; i <data.size() ; i++) {
                TextBean.DataBeanX.DataBean.AuthorBean author = data.get(i).getAuthor();
                list.add(author);
            }
            textAdapter.notifyDataSetChanged();
        }
        if(obj instanceof TextBean){
            TextBean textBean= (TextBean) obj;
            List<TextBean.DataBeanX.DataBean> data = textBean.getData().getData();
            beans.addAll(data);
            textAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void ShowNO(String no) {

    }
}
