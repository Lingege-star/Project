package com.example.Day02.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.Day02.Aciserect;
import com.example.Day02.R;
import com.example.Day02.bean.ReBean;
import com.example.Day02.fragment.frag.FourFragment;
import com.example.Day02.fragment.frag.OneFragment;
import com.example.Day02.fragment.frag.ThreeFragment;
import com.example.Day02.fragment.frag.TowFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<View> list;
    private ArrayList<ReBean.DataBean> beans;
    private ReAdapter reAdapter;

    public MyAdapter(Context context, ArrayList<View> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_faxian, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_remeng, parent, false);
            return new ViewHolder2(view2);
        } else {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item_vip, parent, false);
            return new ViewHolder3(view3);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            Glide.with(context).load(R.drawable.c).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv1);
            Glide.with(context).load(R.drawable.a).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv2);
            Glide.with(context).load(R.drawable.b).apply(new RequestOptions().circleCrop()).into(viewHolder1.iv3);
            viewHolder1.iv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是袍子", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder1.iv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是社团", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder1.iv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "这是排行榜", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (type == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            viewHolder2.rlv.setLayoutManager(linearLayoutManager);
            beans = new ArrayList<>();
            reAdapter = new ReAdapter(context, beans);
            new Retrofit.Builder()
                    .baseUrl(Aciserect.RE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Aciserect.class)
                    .getRe()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ReBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ReBean reBean) {
                            List<ReBean.DataBean> data = reBean.getData();
                            beans.addAll(data);
                            reAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "加载数据失败");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            viewHolder2.rlv.setAdapter(reAdapter);

        } else {
           
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv1;
        public ImageView iv2;
        public ImageView iv3;
        public TextView title1;
        public TextView title2;
        public TextView title3;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv1 = (ImageView) rootView.findViewById(R.id.iv1);
            this.iv2 = (ImageView) rootView.findViewById(R.id.iv2);
            this.iv3 = (ImageView) rootView.findViewById(R.id.iv3);
            this.title1 = (TextView) rootView.findViewById(R.id.title1);
            this.title2 = (TextView) rootView.findViewById(R.id.title2);
            this.title3 = (TextView) rootView.findViewById(R.id.title3);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rlv;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rlv = (RecyclerView) rootView.findViewById(R.id.rlv);
        }

    }

    public static
    class ViewHolder3 extends ReAdapter.ViewHolder {
        public View rootView;
        public TabLayout tab;
        public ViewPager vp;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab = (TabLayout) rootView.findViewById(R.id.tab);
            this.vp = (ViewPager) rootView.findViewById(R.id.vp);
        }

    }
}
