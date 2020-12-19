package com.example.pingmu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private final ArrayList<Bean> list;
    private final Context context;

    public RlvAdapter(ArrayList<Bean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LList(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LList llist = (LList) holder;
        llist.name.setText(list.get(position).getName());
        llist.sex.setText(list.get(position).getSex());
        llist.age.setText(list.get(position).getAge()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class LList extends RecyclerView.ViewHolder{

        private final TextView name;
        private final TextView sex;
        private final TextView age;

        public LList(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            sex = itemView.findViewById(R.id.sex);
            age = itemView.findViewById(R.id.age);
        }
    }
}
