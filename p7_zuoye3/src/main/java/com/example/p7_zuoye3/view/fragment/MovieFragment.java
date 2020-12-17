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
import com.example.p7_zuoye3.model.adapter.MovieRecAdapter;
import com.example.p7_zuoye3.model.bean.MovieBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieFragment extends Fragment {

    private View view;
    private RecyclerView rv_mov;
    private ArrayList<MovieBean.DataBeanX.DataBean> list;
    private MovieRecAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(Activity.REC_Mov)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Activity.class)
                .getMovieBean(12,"video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        List<MovieBean.DataBeanX.DataBean> data = movieBean.getData().getData();
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
        rv_mov = view.findViewById(R.id.rv_mov);
        rv_mov.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new MovieRecAdapter(getActivity(), list);
        rv_mov.setAdapter(adapter);
    }
}