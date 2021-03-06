package com.darren.architect_day36.simple8;

import android.widget.TextView;

import com.darren.architect_day36.R;
import com.darren.architect_day36.retrofit.UserInfo;
import com.darren.architect_day36.simple8.Base.BaseMvpActivity;

public class Main8Activity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {
    private TextView mTextView;

    //多个Presenter怎么处理 dagger处理，自己写dagger处理
    @Override
    protected UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initView() {
        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    protected void initData() {
        getPresenter().getUsers("5daefee2ce7f9208d465fab4ae6e40c2");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main6;
    }

    @Override
    public void onLoading() {
        //加载进度条
    }

    @Override
    public void onError() {
        //显示错误
    }

    @Override
    public void onSucceed(UserInfo userInfo) {
        //显示成功
        //成功 这个时候可能会关闭Activity，有可能会异常崩溃
        //1、判读界面还在不在  有么有被finish掉
        //2、采用解绑（通用）
        mTextView.setText(userInfo.toString());
    }
}
