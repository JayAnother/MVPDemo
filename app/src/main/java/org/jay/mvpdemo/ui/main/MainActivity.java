package org.jay.mvpdemo.ui.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jay.mvpdemo.R;
import org.jay.mvpdemo.model.UserInfoModel;
import org.jay.mvpdemo.ui.base.BaseActivity;
import org.jay.mvpdemo.ui.product.ProductActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainMvpView {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.tv_curr_info)
    TextView tvCurrInfo;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        getPresenter().getUserInfo();
    }



    public void setUserInfoView(UserInfoModel userInfo){
        if(userInfo==null){
            tvCurrInfo.setVisibility(View.GONE);
        }else{
            tvCurrInfo.setVisibility(View.VISIBLE);
            tvCurrInfo.setText("current User:\n name:"+userInfo.getFirstName()+" "+userInfo.getLastName()+"\n Email:"+userInfo.getEmail());
        }
    }

    @Override
    public void showProgressDialog() {
        mDialog = ProgressDialog.show(this, "", "loading");
    }

    @Override
    protected MainPresenter getPresenter() {
        return  new MainPresenter(this);
    }

    @Override
    public void dimssProgressDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    //    @Override
    public void startHomePage() {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    public void showErrorMsg(String errorMsg) {
        Toast.makeText(MainActivity.this, "" + errorMsg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_save)
    public void onClick() {
        String username = etName.getText().toString();
        String pwd = etPwd.getText().toString();
        showProgressDialog();
        getPresenter().login(username, pwd);
    }
}
