package com.example.p7_zuoye4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhuangZaoFragment extends Fragment {

    private View view;
    private RecyclerView rv_zz;
    private ArrayList<ZhuangZaoBean.DataBean.ListBean> list;
    private ZhuangZaoRecAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_zhuang_zao, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(Activity.Rec_ZZ)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Activity.class)
                .getZhuangZaoBean("http://cdwan.cn:7000/tongpao/discover/news_2.json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuangZaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuangZaoBean zhuangZaoBean) {
                        List<ZhuangZaoBean.DataBean.ListBean> beanList = zhuangZaoBean.getData().getList();
                        list.addAll(beanList);
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
        rv_zz = view.findViewById(R.id.rv_zz);
        rv_zz.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_zz.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new ZhuangZaoRecAdapter(getActivity(), list);
        rv_zz.setAdapter(adapter);
    }
}