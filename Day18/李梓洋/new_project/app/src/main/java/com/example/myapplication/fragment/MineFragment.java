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

public class MineFragment extends BaseFragment {

    @BindView(R.id.mine_toolbar)
    Toolbar mineToolbar;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        mineToolbar.setNavigationIcon(R.drawable.service_white_icon);
        mineToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "services", Toast.LENGTH_SHORT).show();
            }
        });
        initMenu();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            StatusBarUtil.setStatusBarColor(getActivity(),R.color.drak_primary);
        }
    }

    private void initMenu() {
        mineToolbar.inflateMenu(R.menu.fragment_mine_menu);
        mineToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.mine_search) {
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
        return R.layout.fragment_mine;
    }
}
