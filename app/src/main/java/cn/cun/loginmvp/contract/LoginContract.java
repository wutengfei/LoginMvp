package cn.cun.loginmvp.contract;

import cn.cun.loginmvp.bean.User;
import cn.cun.loginmvp.model.OnLoginListener;

/**
 * Created by 600263 on 2017/8/30.
 */

public interface LoginContract {

  interface ILoginModel {

    void login(String username, String password, OnLoginListener loginListener);
  }

  interface ILoginActivity {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

  }
}
