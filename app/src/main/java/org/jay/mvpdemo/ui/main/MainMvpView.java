package org.jay.mvpdemo.ui.main;


import org.jay.mvpdemo.model.UserInfoModel;
import org.jay.mvpdemo.ui.base.BaseView;

/**
 * Created by Administrator on 2016/12/23.
 */

public interface MainMvpView  extends BaseView {
    public  void showErrorMsg(String errorMsg);

    public void startHomePage();


    public void showProgressDialog();

    public void dimssProgressDialog();

    public void  setUserInfoView(UserInfoModel userInfo);
}
