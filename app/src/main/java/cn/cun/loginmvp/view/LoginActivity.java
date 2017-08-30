package cn.cun.loginmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import cn.cun.loginmvp.R;
import cn.cun.loginmvp.bean.User;
import cn.cun.loginmvp.contract.LoginContract;
import cn.cun.loginmvp.presenter.UserLoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginActivity {

  private EditText et_username, et_password;
  private Button bt_login, bt_clear;
  private ProgressBar progressBar;
  private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    init();
  }

  private void init() {
    et_username = (EditText) findViewById(R.id.editText);
    et_password = (EditText) findViewById(R.id.editText2);
    bt_login = (Button) findViewById(R.id.login);
    bt_clear = (Button) findViewById(R.id.clear);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);

    bt_login.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        mUserLoginPresenter.login();
      }
    });
    bt_clear.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        mUserLoginPresenter.clear();
      }
    });
  }

  @Override
  public String getUserName() {
    return et_username.getText().toString();
  }

  @Override
  public String getPassword() {
    return et_password.getText().toString();
  }

  @Override
  public void clearUserName() {
    et_username.setText("");
  }

  @Override
  public void clearPassword() {
    et_password.setText("");
  }

  @Override
  public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override
  public void toMainActivity(User user) {
    Toast.makeText(this, user.getUsername() +
        " login success , to MainActivity", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void showFailedError() {
    Toast.makeText(this,
        "login failed", Toast.LENGTH_SHORT).show();
  }
}
