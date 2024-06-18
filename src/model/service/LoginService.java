package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.login;

public class LoginService {

  private login loginView;

  public LoginService(login loginView) {
    this.loginView = loginView;
  }

  //method dang nhap nguoi dung
  public boolean Login(String username, String MatKhau) {
    String query = "SELECT * FROM nguoinhap WHERE tennguoinhap = ? AND matkhau = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, MatKhau);
      ResultSet resultSet = preparedStatement.executeQuery();
      // Check if the query returned a result
      if (!resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Tên người dùng hoặc mật khẩu không đúng");
        return false;
      } else {
        // Proceed with the login process
        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
        return true;
      }

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
