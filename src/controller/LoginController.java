package controller;

import model.service.LoginService;
import view.login;

public class LoginController {

  private final login loginView;

  private final LoginService loginService;

  public LoginController(login loginView, LoginService loginService) {
    this.loginView = loginView;
    this.loginService = loginService;
    Login();
  }

  //method dang nhap nguoi dung
  public void Login() {
    loginView.getLogBT().addActionListener(e -> {
      try {
        String username = loginView.getJTF1().getText();
        String MatKhau = loginView.getJPF1().getText();
        loginService.Login(username, MatKhau);
      } catch (Exception a) {
        a.printStackTrace();
      }
    });
  }
}
