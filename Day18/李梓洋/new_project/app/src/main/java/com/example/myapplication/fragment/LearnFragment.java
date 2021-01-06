package com.example.myapplication.fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.myapplication.R;
import com.example.myapplication.StatusBarUtil;

import butterknife.BindView;

public class LearnFragment extends BaseFragment {

    @BindView(R.id.learn_toolbar)
    Toolbar learnToolbar;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        learnToolbar.setNavigationIcon(R.drawable.services);
        learnToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "services", Toast.LENGTH_SHORT).show();
            }
        });
        initMenu();
    }

    private void initMenu() {
        learnToolbar.inflateMenu(R.menu.fragment_home_menu);
        learnToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.home_search) {
                    Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "邮箱", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_learn;
    }
}
