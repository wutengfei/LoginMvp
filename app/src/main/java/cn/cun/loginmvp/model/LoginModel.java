package cn.cun.loginmvp.model;

import cn.cun.loginmvp.bean.User;
import cn.cun.loginmvp.contract.LoginContract;

/**
 * Created by 600263 on 2017/8/30.
 */

public class LoginModel implements LoginContract.ILoginModel {

  @Override
  public void login(final String username, final String password,
      final OnLoginListener loginListener) {
    //模拟子线程耗时操作
    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        //模拟登录成功
        if ("123".equals(username) && "123".equals(password)) {
          User user = new User();
          user.setUsername(username);
          user.setPassword(password);
          loginListener.loginSuccess(user);
        } else {
          loginListener.loginFailed();
        }
      }
    }.start();
  }
}
