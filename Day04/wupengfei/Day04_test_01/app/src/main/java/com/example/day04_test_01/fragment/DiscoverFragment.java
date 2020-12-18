package com.example.day04_test_01.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04_test_01.R;
import com.example.day04_test_01.adapter.RcyAdapter;
import com.example.day04_test_01.bean.EventsBean;
import com.example.day04_test_01.bean.TabBean;
import com.example.day04_test_01.net.ApiService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscoverFragment extends Fragment {

    private RecyclerView rv_recycler_discover;
    private RcyAdapter rcyAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getTab()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TabBean>() {
                    @Override
                    public void onNext(TabBean tabBean) {
                        rcyAdapter.addData(tabBean.getData());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rv_recycler_discover = view.findViewById(R.id.rv_recycler_discover);
        rv_recycler_discover.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<TabBean.DataBean> dataBeans = new ArrayList<>();
        ArrayList<EventsBean.DataBean> beans = new ArrayList<>();
        rcyAdapter = new RcyAdapter(getContext(),dataBeans,beans);
        rv_recycler_discover.setAdapter(rcyAdapter);

        rv_recycler_discover.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));






    }
}