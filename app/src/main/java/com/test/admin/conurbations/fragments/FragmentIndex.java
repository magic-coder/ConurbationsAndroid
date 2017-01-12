package com.test.admin.conurbations.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.admin.conurbations.R;
import com.test.admin.conurbations.adapter.IndexFragmentPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FragmentIndex extends BaseFragment {
    private Context mContext;
    @Bind(R.id.tabLayout_index)
    TabLayout tabLayoutIndex;
    @Bind(R.id.viewpager_index)
    ViewPager viewpagerIndex;
    @Bind(R.id.appbar)
    AppBarLayout mAppBarLayout;
    IndexFragmentPagerAdapter indexFragmentPagerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public BaseFragment newInstance() {
        return new FragmentIndex();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.index_fragment, container, false);
        int content = getArguments().getInt("content");
        ButterKnife.bind(this, viewRoot);
        mContext.getResources();
        indexFragmentPagerAdapter = new IndexFragmentPagerAdapter(mContext, getChildFragmentManager());
        tabLayoutIndex.setTabsFromPagerAdapter(indexFragmentPagerAdapter);
        viewpagerIndex.setAdapter(indexFragmentPagerAdapter);
        viewpagerIndex.setOffscreenPageLimit(5);
        tabLayoutIndex.setupWithViewPager(viewpagerIndex);
        tabLayoutIndex.setBackgroundColor(content);
        return viewRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
