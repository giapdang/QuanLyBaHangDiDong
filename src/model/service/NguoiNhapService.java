package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.response.Item;

public class NguoiNhapService {

  //lay id va ten nguoi nhap
  public List<Item> getDanhMucList() {
    List<Item> nguoiNhapList = new ArrayList<>();
    String query = "SELECT IDNguoiNhap, TenNguoiNhap FROM nguoinhap";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        nguoiNhapList.add(new Item(resultSet.getInt("IDNguoiNhap"), resultSet.getString("TenNguoiNhap")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nguoiNhapList;
  }
}
