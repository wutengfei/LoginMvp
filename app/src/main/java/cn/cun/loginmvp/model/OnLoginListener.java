package cn.cun.loginmvp.model;

import cn.cun.loginmvp.bean.User;

public interface OnLoginListener {
  void loginSuccess(User user);

  void loginFailed();
}
