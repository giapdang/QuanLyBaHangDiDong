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

public class DanhMucService {

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
}
