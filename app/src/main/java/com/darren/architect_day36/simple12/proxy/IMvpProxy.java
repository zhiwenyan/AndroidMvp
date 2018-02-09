package com.darren.architect_day36.simple12.proxy;

/**
 * Description:
 * Data：1/24/2018-11:39 AM
 *
 * @author: yanzhiwen
 */
public interface IMvpProxy {
    void bindAndCreatePresenter(); //创建绑定

    void unbindPresenter(); //解绑
}
