package com.example.fuchanglin.Fragment.TongPaoActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fuchanglin.Adapter.DiscoverHotAdapter;
import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.Bean.data.MakeupData;
import com.example.fuchanglin.Bean.data.NavigationData;
import com.example.fuchanglin.Bean.data.News_1;
import com.example.fuchanglin.Fragment.Discoover.CosFragment;
import com.example.fuchanglin.Fragment.Discoover.HotSpotFragment;
import com.example.fuchanglin.Fragment.Discoover.MakeupFragment;
import com.example.fuchanglin.Fragment.Discoover.WikiFragment;
import com.example.fuchanglin.Presenter.DiscoverPresenter;
import com.example.fuchanglin.R;
import com.example.fuchanglin.base.BaseFragment;
import com.example.fuchanglin.interfac.Tongpao.IDiscover;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment<DiscoverPresenter> implements IDiscover.View {

    @BindView(R.id.discover)
    TextView discover;
    @BindView(R.id.hot_shaky)
    TextView hotShaky;
    @BindView(R.id.more_shaky)
    TextView moreShaky;
    @BindView(R.id.rlv_hot_shaky)
    RecyclerView rlvHotShaky;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.square_vp)
    ViewPager squareVp;
    @BindView(R.id.img_corporation)
    ImageView imgCorporation;
    @BindView(R.id.img_robe)
    ImageView imgRobe;
    @BindView(R.id.img_ranking)
    ImageView imgRanking;
    @BindView(R.id.discover_tab)
    TabLayout discoverTab;
    private List<DiscoverHotshakyData.DataBean> discoverHotList;
    private DiscoverHotAdapter discoverHotAdapter;
    private ArrayList<Fragment> fragments;
    private HotSpotFragment hotSpotFragment;
    private MakeupFragment makeupFragment;
    private CosFragment cosFragment;
    private WikiFragment wikiFragment;
    private ArrayList<NavigationData.DataBean> tabs;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        hotSpotFragment = new HotSpotFragment();
        makeupFragment = new MakeupFragment();
        cosFragment = new CosFragment();
        wikiFragment = new WikiFragment();
        fragments.add(hotSpotFragment);
        fragments.add(makeupFragment);
        fragments.add(cosFragment);
        fragments.add(wikiFragment);

        tabs = new ArrayList<>();

        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(this).load(R.drawable.pz).apply(options).into(imgCorporation);
        Glide.with(this).load(R.drawable.phb).apply(options).into(imgRobe);
        Glide.with(this).load(R.drawable.st).apply(options).into(imgRanking);


        //热门活动
        rlvHotShaky.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        discoverHotList = new ArrayList<>();
        discoverHotAdapter = new DiscoverHotAdapter(discoverHotList, getActivity());
        rlvHotShaky.setAdapter(discoverHotAdapter);
    }

    @Override
    protected void initData() {
        presenter.getDiscoverHot();
        presenter.getNavigationData();
    }

    @Override
    protected DiscoverPresenter createPresenter() {
        return new DiscoverPresenter(this);
    }

    @Override
    public void getDiscoverHotReturn(DiscoverHotshakyData result) {
        discoverHotList.clear();
        discoverHotList.addAll(result.getData());
        discoverHotAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDiscoverHotspotReturn(News_1 result) {

    }

    @Override
    public void getNavigationReturn(NavigationData result) {

        tabs.addAll(result.getData());
        squareVp.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs.get(position).getName();
            }
        });
        discoverTab.setupWithViewPager(squareVp);
    }

    @Override
    public void getMakeupDataReturn(MakeupData result) {

    }

    @Override
    public void tips(String tip) {

    }

    @Override
    public void loading(int visible) {

    }
}
