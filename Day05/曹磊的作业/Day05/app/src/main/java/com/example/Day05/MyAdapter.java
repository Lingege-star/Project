package com.example.Day05;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Day05.bean.BannerBean;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

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
    private ArrayList<BannerBean.DataBean.ListBean> listBeans;

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
        } else if (position % 3 == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == 1) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_tab, parent, false);
            return new ViewHolder2(view2);
        }
//        else if(viewType==1){
//
//        }
//        else if(viewType==2){
//
//        }
        else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int type = getItemViewType(position);
        if (type == 0) {
            listBeans = new ArrayList<>();
            new Retrofit.Builder()
                    .baseUrl(Aciserict.Banner_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(Aciserict.class)
                    .getBanner()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BannerBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BannerBean bannerBean) {
                            List<BannerBean.DataBean.ListBean> list = bannerBean.getData().getList();
                            listBeans.addAll(list);
                            Log.e("TAG", "加载成功");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("TAG", "加载失败");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
            final ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.banner.setImages(listBeans).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.DataBean.ListBean bean = (BannerBean.DataBean.ListBean) path;
                    Glide.with(context).load(bean.getBanner()).into(imageView);
                }
            }).start();
        } else if (type == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.tab.addTab(viewHolder2.tab.newTab().setText("每日推荐").setIcon(R.drawable.a1));
            viewHolder2.tab.addTab(viewHolder2.tab.newTab().setText("飞花令").setIcon(R.drawable.a2));
            viewHolder2.tab.addTab(viewHolder2.tab.newTab().setText("诗歌社群").setIcon(R.drawable.a3));
            viewHolder2.tab.addTab(viewHolder2.tab.newTab().setText("排行帮").setIcon(R.drawable.a4));
            viewHolder2.tab.addTab(viewHolder2.tab.newTab().setText("会员专区").setIcon(R.drawable.a5));
            viewHolder2.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            Toast.makeText(context, "每日推荐", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(context, "飞花令", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
                            Toast.makeText(context, "诗歌社群", Toast.LENGTH_SHORT).show();
                            break;
                        case 3:
                            Toast.makeText(context, "排行榜", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(context, "会员专区", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TabLayout tab;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tab = (TabLayout) rootView.findViewById(R.id.tab);
        }

    }


}
