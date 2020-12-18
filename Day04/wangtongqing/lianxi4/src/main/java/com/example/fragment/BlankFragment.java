package com.example.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyInterface;
import com.example.adapter.NewsAdapter;
import com.example.base.BaseFragment;
import com.example.bean.HotInfo;
import com.example.bean.NewsInfo;
import com.example.bean.TabInfo;
import com.example.lianxi4.R;
import com.example.presenter.MyPersenter;

import java.util.ArrayList;


public class BlankFragment extends BaseFragment<MyPersenter> implements MyInterface.view {
    private int page;
    private RecyclerView rcy;
    private ArrayList<NewsInfo.DataBean.ListBean> listBeans;

    public BlankFragment(int page) {
        this.page = page;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_blank;
    }

    @Override
    protected void initView() {
        rcy = getActivity().findViewById(R.id.recy);
        listBeans = new ArrayList<>();
    }

    @Override
    protected void initData() {
        pPresenter.getnews(page);
    }

    @Override
    protected MyPersenter createPresenter() {
        return new MyPersenter(this);
    }

    @Override
    public void gethot(HotInfo hotInfo) {

    }

    @Override
    public void gettab(TabInfo tabInfo) {

    }

    @Override
    public void getnews(NewsInfo newsInfo) {
            if (newsInfo!=null){
                listBeans.addAll(newsInfo.getData().getList());
            }
        NewsAdapter newsAdapter = new NewsAdapter(getContext(), listBeans);
            rcy.setLayoutManager(new LinearLayoutManager(getContext()));
            rcy.setAdapter(newsAdapter);
            newsAdapter.notifyDataSetChanged();
    }
}
