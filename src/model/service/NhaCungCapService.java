package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.NhaCungCapSanPham;
import model.response.Item;
import view.HomeView;

public class NhaCungCapService {

  private HomeView homeView;

  private static final String SELECT_ALL_NHA_CUNG_CAP = "select IDNhaCungCap , TenNhaCungCap , SoDienThoai , DiaChi from nhacungcapsanpham";

  public NhaCungCapService(HomeView homeView) {
    this.homeView = homeView;
  }

  //lay id va ten nha cung cap
  public List<Item> getAllTenNhaCungCap() {
    List<Item> nhaCungCapList = new ArrayList<>();
    String query = "SELECT IDNhaCungCap, TenNhaCungCap FROM nhacungcapsanpham";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        nhaCungCapList.add(
            new Item(resultSet.getInt("IDNhaCungCap"), resultSet.getString("TenNhaCungCap")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nhaCungCapList;
  }

  //method lay tat ca nha cung cap
  public List<NhaCungCapSanPham> getAllNhaCungCap() {
    List<NhaCungCapSanPham> nhaCungCapSanPhams = new ArrayList<>();

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(
            SELECT_ALL_NHA_CUNG_CAP)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDNhaCungCap = rs.getInt("IDNhaCungCap");
        String TenNhaCungCap = rs.getString("TenNhaCungCap");
        String DiaChi = rs.getString("DiaChi");
        String SoDienThoai = rs.getString("SoDienThoai");

        NhaCungCapSanPham nhaCungCapSanPham = new NhaCungCapSanPham(IDNhaCungCap, TenNhaCungCap,
            DiaChi, SoDienThoai);
        nhaCungCapSanPhams.add(nhaCungCapSanPham);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return nhaCungCapSanPhams;
  }

  //method update nha cung cap
  public void updateNhaCungCap(int IDNhaCungCap, String TenNhaCungCap, String DiaChi,
      String SoDienThoai) {
    String query = "UPDATE nhacungcapsanpham SET TenNhaCungCap = ?, DiaChi = ?, SoDienThoai = ? WHERE IDNhaCungCap = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setString(1, TenNhaCungCap);
      preparedStatement.setString(2, DiaChi);
      preparedStatement.setString(3, SoDienThoai);
      preparedStatement.setInt(4, IDNhaCungCap);

      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method them nha cung cap
  public void addNhaCungCap(String TenNhaCungCap, String DiaChi, String SoDienThoai) {
    String query = "INSERT INTO nhacungcapsanpham(TenNhaCungCap, DiaChi, SoDienThoai) VALUES (?, ?, ?)";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setString(1, TenNhaCungCap);
      preparedStatement.setString(2, DiaChi);
      preparedStatement.setString(3, SoDienThoai);

      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method xoa nha cung cap
  public void deleteNhaCungCap(int IDNhaCungCap) {
    String query = "DELETE FROM nhacungcapsanpham WHERE IDNhaCungCap = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setInt(1, IDNhaCungCap);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //method tim kiem nha cung cap theo ten nha cung cap va so dien thoai va dia chi nha cung cap va id nha cung cap
  public List<NhaCungCapSanPham> searchNhaCungCap(String search) {
    List<NhaCungCapSanPham> nhaCungCapSanPhams = new ArrayList<>();
    String query = "SELECT IDNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai FROM nhacungcapsanpham "
        + "WHERE TenNhaCungCap LIKE ? OR SoDienThoai LIKE ? OR DiaChi LIKE ? OR IDNhaCungCap = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, "%" + search + "%");
      preparedStatement.setString(3, "%" + search + "%");
      preparedStatement.setString(4, search);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDNhaCungCap = rs.getInt("IDNhaCungCap");
        String TenNhaCungCap = rs.getString("TenNhaCungCap");
        String DiaChi = rs.getString("DiaChi");
        String SoDienThoai = rs.getString("SoDienThoai");

        NhaCungCapSanPham nhaCungCapSanPham = new NhaCungCapSanPham(IDNhaCungCap, TenNhaCungCap,
            DiaChi, SoDienThoai);
        nhaCungCapSanPhams.add(nhaCungCapSanPham);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return nhaCungCapSanPhams;
  }
}
