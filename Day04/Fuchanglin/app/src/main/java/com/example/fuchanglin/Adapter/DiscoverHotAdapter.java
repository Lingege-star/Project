package com.example.fuchanglin.Adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fuchanglin.Bean.data.DiscoverHotshakyData;
import com.example.fuchanglin.R;
import com.example.fuchanglin.Utils.TxtUtils;
import com.example.fuchanglin.base.BaseAdapter;

import java.util.List;

public class DiscoverHotAdapter extends BaseAdapter {

    private final List<DiscoverHotshakyData.DataBean> mData;
    private final Context context;

    public DiscoverHotAdapter(List<DiscoverHotshakyData.DataBean> mData, Context context) {

        this.mData = mData;
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.discoverhot_item;
    }

    @Override
    protected void bindData(Object o, VH vh) {
        DiscoverHotshakyData.DataBean dataBean = (DiscoverHotshakyData.DataBean) o;
        ImageView discover_img = (ImageView) vh.getViewById(R.id.discover_img);
        TextView discover_title = (TextView) vh.getViewById(R.id.discover_title);
        TextView discover_location = (TextView) vh.getViewById(R.id.discover_location);
        TextView discover_time = (TextView) vh.getViewById(R.id.discover_time);

        Glide.with(context).load(dataBean.getCover()).into(discover_img);
        TxtUtils.setTextView(discover_title,dataBean.getTitle());
        TxtUtils.setTextView(discover_location,dataBean.getLocation());
        TxtUtils.setTextView(discover_time,dataBean.getStartTime());
    }
}
