package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.entity.DanhMucSanPham;
import model.response.Item;
import view.HomeView;

public class DanhMucService {

  private HomeView homeView;

  public DanhMucService(HomeView homeView) {
    this.homeView = homeView;
  }
  private static final String SELECT_ALL_DANH_MUC = "select * from danhmucsanpham";


  //lay tat ca danh muc
  public List<DanhMucSanPham> getAllDanhMuc() {
    List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DANH_MUC)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDDanhMuc = rs.getInt("IDDanhMuc");
        String TenDanhMuc = rs.getString("TenDanhMuc");
        String MoTa = rs.getString("MoTaDanhMuc");

        DanhMucSanPham danhMucSanPham = new DanhMucSanPham(IDDanhMuc, TenDanhMuc, MoTa);
        danhMucSanPhams.add(danhMucSanPham);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return danhMucSanPhams;
  }

  //lay id va ten danh muc
  public List<Item> getDanhMucList() {
    List<Item> danhMucList = new ArrayList<>();
    String query = "SELECT IDDanhMuc, TenDanhMuc FROM danhmucsanpham";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        danhMucList.add(new Item(resultSet.getInt("IDDanhMuc"), resultSet.getString("TenDanhMuc")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return danhMucList;
  }

  //xoa danh muc
  public void deleteDanhMuc(int IDDanhMuc) {
    String query = "DELETE FROM danhmucsanpham WHERE IDDanhMuc = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, IDDanhMuc);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method them danh muc
  public void addDanhMuc(String TenDanhMuc, String MoTaDanhMuc) {
    String query = "INSERT INTO danhmucsanpham(TenDanhMuc, MoTaDanhMuc) VALUES (?, ?)";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, homeView.getTfTenDanhmuc().getText());
      preparedStatement.setString(2, homeView.getTfMotadanhmuc().getText());
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //method update danh muc
  public void updateDanhMuc(int IDDanhMuc, String TenDanhMuc, String MoTaDanhMuc) {
    String query = "UPDATE danhmucsanpham SET TenDanhMuc = ?, MoTaDanhMuc = ? WHERE IDDanhMuc = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, TenDanhMuc);
      preparedStatement.setString(2, MoTaDanhMuc);
      preparedStatement.setInt(3, IDDanhMuc);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //method tim kiem danh muc theo ten danh muc va id danh muc
  public List<DanhMucSanPham> searchDanhMuc(String search) {
    List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();
    String query = "SELECT IDDanhMuc, TenDanhMuc, MoTaDanhMuc FROM danhmucsanpham WHERE TenDanhMuc LIKE ? OR IDDanhMuc = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, search);

      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          danhMucSanPhams.add(
              new DanhMucSanPham(resultSet.getInt("IDDanhMuc"), resultSet.getString("TenDanhMuc"),
                  resultSet.getString("MoTaDanhMuc")));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return danhMucSanPhams;
  }
}
