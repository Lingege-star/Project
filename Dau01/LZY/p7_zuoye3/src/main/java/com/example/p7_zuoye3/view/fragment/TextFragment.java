package com.example.p7_zuoye3.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p7_zuoye3.R;
import com.example.p7_zuoye3.model.Activity;
import com.example.p7_zuoye3.model.adapter.TextRecAdapter;
import com.example.p7_zuoye3.model.bean.TextBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TextFragment extends Fragment {

    private View view;
    private RecyclerView rv_text;
    private ArrayList<TextBean.DataBeanX.DataBean> list;
    private TextRecAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_text, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(Activity.REC_Text)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Activity.class)
                .getTextBean("http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=10&feedType=text&feedId=1578920275")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        List<TextBean.DataBeanX.DataBean> data = textBean.getData().getData();
                        list.addAll(data);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        rv_text = view.findViewById(R.id.rv_text);
        rv_text.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new TextRecAdapter(getActivity(), list);
        rv_text.setAdapter(adapter);
    }
}