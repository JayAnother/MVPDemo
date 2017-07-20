package org.jay.mvpdemo.data;

import org.jay.mvpdemo.data.preferces.PreferHelper;
import org.jay.mvpdemo.data.retrofit.RetrofitHelper;
import org.jay.mvpdemo.data.retrofit.service.AccountApi;
import org.jay.mvpdemo.data.retrofit.service.CheckoutApi;
import org.jay.mvpdemo.data.retrofit.service.OthersApi;
import org.jay.mvpdemo.data.retrofit.service.ProductApi;
import org.jay.mvpdemo.data.retrofit.service.ShoppingCartApi;


public class DataManager {
    private static DataManager mHttpManage;
    private AccountApi mAccountApi;
    private CheckoutApi mCheckoutApi;
    private OthersApi mOtherApi;
    private ProductApi mProductApi;
    private ShoppingCartApi mShoppingCartApi;
    private PreferHelper preferHelper;
    private Object monitor = new Object();



    private DataManager(){

    }
    public static DataManager getInstance(){
        if (mHttpManage == null) {
            synchronized (DataManager.class) {
                if (mHttpManage == null) {
                    mHttpManage = new DataManager();
                }
            }
        }
        return mHttpManage;
    }

    public PreferHelper getPreferHelper(){
        if(preferHelper==null){
            preferHelper=new PreferHelper();
        }
        return preferHelper;

    }




    public AccountApi getAccountApi(){
        if (mAccountApi==null){
            synchronized (monitor){
                if (mAccountApi==null){
                    mAccountApi= RetrofitHelper.getDefaultRetrofit().create(AccountApi.class);
                }
            }
        }
        return mAccountApi;
    }
    public CheckoutApi getCheckoutApi(){
        if (mCheckoutApi==null){
            synchronized (monitor){
                if (mCheckoutApi==null){
                    mCheckoutApi= RetrofitHelper.getDefaultRetrofit().create(CheckoutApi.class);
                }
            }
        }
        return mCheckoutApi;
    }

    public OthersApi getOtherApi(){
        if (mOtherApi==null){
            synchronized (monitor){
                if (mOtherApi==null){
                    mOtherApi= RetrofitHelper.getDefaultRetrofit().create(OthersApi.class);
                }
            }
        }
        return mOtherApi;
    }

    public ProductApi getProductApi(){
        if (mProductApi==null){
            synchronized (monitor){
                if (mProductApi==null){
                    mProductApi= RetrofitHelper.getDefaultRetrofit().create(ProductApi.class);
                }
            }
        }
        return mProductApi;
    }
    public ShoppingCartApi getShoppingCartApi(){
        if (mShoppingCartApi==null){
            synchronized (monitor){
                if (mShoppingCartApi==null){
                    mShoppingCartApi= RetrofitHelper.getDefaultRetrofit().create(ShoppingCartApi.class);
                }
            }
        }
        return mShoppingCartApi;
    }

}
