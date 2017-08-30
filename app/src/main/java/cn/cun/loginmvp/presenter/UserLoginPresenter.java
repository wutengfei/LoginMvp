package cn.cun.loginmvp.presenter;

import android.os.Handler;
import cn.cun.loginmvp.bean.User;
import cn.cun.loginmvp.contract.LoginContract;
import cn.cun.loginmvp.model.LoginModel;
import cn.cun.loginmvp.model.OnLoginListener;

public class UserLoginPresenter {

  private LoginContract.ILoginActivity loginActivity;
  private LoginContract.ILoginModel loginModel;
  private Handler mHandler = new Handler();

  public UserLoginPresenter(LoginContract.ILoginActivity loginActivity) {
    this.loginActivity = loginActivity;
    this.loginModel = new LoginModel();
  }

  public void login() {
    loginActivity.showLoading();
    loginModel.login(loginActivity.getUserName(), loginActivity.getPassword(),
        new OnLoginListener() {
          @Override
          public void loginSuccess(final User user) {
            //需要在UI线程执行
            mHandler.post(new Runnable() {
              @Override
              public void run() {
                loginActivity.toMainActivity(user);
                loginActivity.hideLoading();
              }
            });

          }

          @Override
          public void loginFailed() {
            //需要在UI线程执行
            mHandler.post(new Runnable() {
              @Override
              public void run() {
                loginActivity.showFailedError();
                loginActivity.hideLoading();
              }
            });

          }
        });
  }

  public void clear() {
    loginActivity.clearUserName();
    loginActivity.clearPassword();
  }
}
