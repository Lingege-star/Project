package com.example.day12_17.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day12_17.Adapter.RecAdapter;
import com.example.day12_17.Bean.PicBean;
import com.example.day12_17.Presenter.SofaPresenter;
import com.example.day12_17.R;
import com.example.day12_17.View.SofaView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements SofaView {

    private SmartRefreshLayout smart;
    private RecyclerView rec;
    private ArrayList<PicBean.DataBeanX.DataBean> pic;
    private RecAdapter adapter;
    private SofaPresenter presenter;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_more, container, false);
        presenter = new SofaPresenter(this);

        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        presenter.getdata();
    }

    private void initView(View inflate) {
        smart = (SmartRefreshLayout) inflate.findViewById(R.id.smart);
        rec = (RecyclerView) inflate.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        pic = new ArrayList<>();
        adapter = new RecAdapter(getContext(),pic);
        rec.setAdapter(adapter);
    }

    @Override
    public void success(Object o) {
        adapter.AddList(pic);
    }
}
