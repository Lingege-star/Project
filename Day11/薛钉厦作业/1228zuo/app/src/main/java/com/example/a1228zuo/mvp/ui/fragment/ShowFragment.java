package com.example.a1228zuo.mvp.ui.fragment;

import android.content.Context;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a1228zuo.R;
import com.example.a1228zuo.base.BaseFragment;
import com.example.a1228zuo.base.BasePresenter;
import com.example.a1228zuo.mvp.ui.adapter.ShowGuoRecyAdapter;
import com.example.a1228zuo.mvp.ui.adapter.ShowHaiRecyAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;


public class ShowFragment extends BaseFragment {

    @BindView(R.id.show_ban)
    Banner showBan;
    @BindView(R.id.show_hai_recy)
    RecyclerView showHaiRecy;
    @BindView(R.id.show_guo_recy)
    RecyclerView showGuoRecy;

    @Override
    protected void init() {
        ArrayList<Integer> banner = new ArrayList<>();
        banner.add(R.drawable.show_01);
        banner.add(R.drawable.show_01);
        banner.add(R.drawable.show_01);
        showBan.setImages(banner)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(getActivity()).load(path).into(imageView);
                    }
                }).start();
        ArrayList<Integer> recy1 = new ArrayList<>();
        recy1.add(R.drawable.show_recy_1);
        recy1.add(R.drawable.show_recy_2);
        recy1.add(R.drawable.show_recy_1);
        recy1.add(R.drawable.show_recy_2);
        showHaiRecy.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        ShowHaiRecyAdapter showHaiRecyAdapter = new ShowHaiRecyAdapter(getActivity(), recy1);
        showHaiRecy.setAdapter(showHaiRecyAdapter);
        showHaiRecyAdapter.notifyDataSetChanged();

        ArrayList<Integer> recy2 = new ArrayList<>();
        recy2.add(R.drawable.show_recy_03);
        recy2.add(R.drawable.show_recy_04);
        recy2.add(R.drawable.show_recy_05);
        recy2.add(R.drawable.show_recy_03);
        recy2.add(R.drawable.show_recy_04);
        recy2.add(R.drawable.show_recy_05);
        ArrayList<String> re_str = new ArrayList<>();
        re_str.add("大理");
        re_str.add("成都");
        re_str.add("杭州");
        re_str.add("大理");
        re_str.add("成都");
        re_str.add("杭州");
        showGuoRecy.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        ShowGuoRecyAdapter showGuoRecyAdapter = new ShowGuoRecyAdapter(getActivity(),recy2,re_str);
        showGuoRecy.setAdapter(showGuoRecyAdapter);
        showGuoRecyAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show;
    }

    @Override
    public void getData(Object o) {

    }
}
