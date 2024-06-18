package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.KhachHang;
import model.response.Item;
import view.HomeView;

public class KhachHangService {

  private HomeView homeView;

  public KhachHangService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method lay id va ten khach hang
  public List<Item> getIDTenKhachHang() {
    List<Item> khachHangList = new ArrayList<>();
    String query = "SELECT IDKhachHang, TenKhachHang FROM khachhang";
    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      while (resultSet.next()) {
        khachHangList.add(
            new Item(resultSet.getInt("IDKhachHang"), resultSet.getString("TenKhachHang")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return khachHangList;
  }

  //method findAll khach hang
  public List<KhachHang> findAll() {
    List<KhachHang> khachHangList = new ArrayList<>();
    String query = "SELECT * FROM khachhang";
    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      while (resultSet.next()) {
        int IDKhachHang = resultSet.getInt("IDKhachHang");
        String TenKhachHang = resultSet.getString("TenKhachHang");
        String DiaChi = resultSet.getString("DiaChi");
        String SoDienThoai = resultSet.getString("SoDienThoai");
        String Email = resultSet.getString("Email");
        KhachHang khachHang = new KhachHang(IDKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email);
        khachHangList.add(khachHang);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return khachHangList;
  }

  //method them khach hang
  public void addKhachHang(String tenKhachHang, String diaChi, String soDienThoai, String email) {
    String query = "INSERT INTO khachhang(tenkhachhang, diachi, sodienthoai, email) VALUES(?, ?, ?, ?)";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, homeView.getTfTenKhachHang().getText());
      preparedStatement.setString(2, homeView.getTfDiachiKhachHang().getText());
      preparedStatement.setString(3, homeView.getTfSodienthoaiKhachHang().getText());
      preparedStatement.setString(4, homeView.getTfEmailKhachHang().getText());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method sua thong tin khach hang
  public void updateKhachHang(String tenKhachHang, String diaChi, String soDienThoai, String email,
      int id) {
    String query = "UPDATE khachhang SET tenkhachhang = ?, diachi = ?, sodienthoai = ?, email = ? WHERE idkhachhang = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, tenKhachHang);
      preparedStatement.setString(2, diaChi);
      preparedStatement.setString(3, soDienThoai);
      preparedStatement.setString(4, email);
      preparedStatement.setInt(5, id);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method xoa khach hang
  public void deleteKhachHang(int id) {
    String query = "DELETE FROM khachhang WHERE idkhachhang = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //method tim kiem khach hang theo ten khach hang hoac so dien thoai khach hang hoac
  // email khach hang hoac dia chi khach hang hoac id khach hang
  public List<KhachHang> searchKhachHang(String search) {
    List<KhachHang> khachHangList = new ArrayList<>();
    String query = "SELECT * FROM khachhang WHERE tenkhachhang LIKE ? "
        + "OR sodienthoai LIKE ? OR email LIKE ? OR diachi LIKE ? OR idkhachhang = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, "%" + search + "%");
      preparedStatement.setString(3, "%" + search + "%");
      preparedStatement.setString(4, "%" + search + "%");
      preparedStatement.setString(5, search);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int IDKhachHang = resultSet.getInt("IDKhachHang");
        String TenKhachHang = resultSet.getString("TenKhachHang");
        String DiaChi = resultSet.getString("DiaChi");
        String SoDienThoai = resultSet.getString("SoDienThoai");
        String Email = resultSet.getString("Email");
        KhachHang khachHang = new KhachHang(IDKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email);
        khachHangList.add(khachHang);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return khachHangList;
  }

}
