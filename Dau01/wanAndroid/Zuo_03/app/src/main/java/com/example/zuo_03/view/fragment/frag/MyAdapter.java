package com.example.zuo_03.view.fragment.frag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.zuo_03.App;
import com.example.zuo_03.R;
import com.example.zuo_03.Student;
import com.example.zuo_03.modle.bean.TuBean;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TuBean.DataBeanX.DataBean> list;

    public MyAdapter(Context context, ArrayList<TuBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        TuBean.DataBeanX.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getIcon()).apply(new RequestOptions().transform(new RoundedCorners(20))).into(viewHolder.iv);
        viewHolder.name.setText(dataBean.getIntro());
        viewHolder.title.setText(dataBean.getTitle());
        viewHolder.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setImg(dataBean.getIcon());
                student.setName(dataBean.getIntro());
                student.setTitle(dataBean.getTitle());
                App.daoSession.getStudentDao().insert(student);
                viewHolder.ok.setText("已关注");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView name;
        public TextView title;
        public Button ok;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.ok = (Button) rootView.findViewById(R.id.ok);
        }

    }
}
