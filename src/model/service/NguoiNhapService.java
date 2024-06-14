package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.NguoiNhap;
import model.response.Item;
import view.HomeView;

public class NguoiNhapService {

  private HomeView homeView;

  public NguoiNhapService(HomeView homeView) {
    this.homeView = homeView;
  }

  //lay id va ten nguoi nhap
  public List<Item> getTenNhanVienList() {
    List<Item> nguoiNhapList = new ArrayList<>();
    String query = "SELECT IDNguoiNhap, TenNguoiNhap FROM nguoinhap";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        nguoiNhapList.add(
            new Item(resultSet.getInt("IDNguoiNhap"), resultSet.getString("TenNguoiNhap")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nguoiNhapList;
  }

  //method lay tat thong tin nguoi nhap
  public List<NguoiNhap> getAllNguoiNhap() {
    List<NguoiNhap> nguoiNhapList = new ArrayList<>();
    String query = "SELECT idnguoinhap, tennguoinhap, email, matkhau, sodienthoai FROM nguoinhap";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        nguoiNhapList.add(
            new NguoiNhap(resultSet.getInt("IDNguoiNhap"), resultSet.getString("TenNguoiNhap"),
                resultSet.getString("Email"), resultSet.getString("MatKhau"),
                resultSet.getString("SoDienThoai")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nguoiNhapList;
  }

  //method them nguoi nhap
  public void addNguoiNhap(String tenNguoiNhap, String email, String matKhau, String soDienThoai) {
    String query = "INSERT INTO nguoinhap(tennguoinhap, email, matkhau, sodienthoai) VALUES (?, ?, ?, ?)";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, homeView.getTfTenNhanVien().getText());
      preparedStatement.setString(2, homeView.getTfEmailNhanVien().getText());
      preparedStatement.setString(3, homeView.getTfmatkhauNhanVien().getText());
      preparedStatement.setString(4, homeView.getTfSodienthoaiNhanVien().getText());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
