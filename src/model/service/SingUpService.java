package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import view.signup;

public class SingUpService {

  private signup singUpView;

  public SingUpService(signup singUpView) {
    this.singUpView = singUpView;
  }

  //method them user
  public void CreateUser(String TenNguoiNhap, String Email, String MatKhau, String SoDienThoai) {
    String query = "INSERT INTO nguoinhap(TenNguoiNhap, Email, MatKhau, SoDienThoai) VALUES(?,?,?,?)";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, TenNguoiNhap);
      preparedStatement.setString(2, Email);
      preparedStatement.setString(3, MatKhau);
      preparedStatement.setString(4, SoDienThoai);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
