package com.example.day03_test01.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day03_test01.R;
import com.example.day03_test01.adapter.PicRcyAdapter;
import com.example.day03_test01.bean.PicBean;
import com.example.day03_test01.net.ApiService;
import com.example.day03_test01.presenter.PicPresenter;
import com.example.day03_test01.view.PIcView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PicFragment extends Fragment implements PIcView {

    private static final String TAG = "PicFragment";
    private RecyclerView rv_recycler_pic;
    private ArrayList<PicBean.DataBeanX.DataBean> list;
    private PicRcyAdapter rcyAdapter;
    private PicPresenter picPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pic, container, false);
        picPresenter = new PicPresenter(this);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
//        picPresenter.getData();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://123.56.232.18:8080/serverdemo/feeds/queryHotFeedsList?pageCount=12&feedType=pics")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: "+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                PicBean picBean = new Gson().fromJson(response.body().string(), PicBean.class);
                List<PicBean.DataBeanX.DataBean> data = picBean.getData().getData();
                list.addAll(data);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        rcyAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }


    private void initView(View view) {
        rv_recycler_pic = view.findViewById(R.id.rv_recycler_pic);
        rv_recycler_pic.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        rcyAdapter = new PicRcyAdapter(getContext(), list);
        rv_recycler_pic.setAdapter(rcyAdapter);
    }


    @Override
    public void picOnSuccess(PicBean picBean) {
        Log.d(TAG, "picOnSuccess: "+picBean.getData().getData().toString());
        rcyAdapter.addPic(picBean.getData().getData());
    }

    @Override
    public void picOnFail(String msg) {
        Log.d(TAG, "picOnFail: "+msg);
        showToast(msg);
    }

    private void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}