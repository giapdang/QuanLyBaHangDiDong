package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.response.Item;

public class NhaCungCapService {

  public List<Item> getAllTenNhaCungCap() {
    List<Item> nhaCungCapList = new ArrayList<>();
    String query = "SELECT IDNhaCungCap, TenNhaCungCap FROM nhacungcapsanpham";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        nhaCungCapList.add(new Item(resultSet.getInt("IDNhaCungCap"), resultSet.getString("TenNhaCungCap")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nhaCungCapList;
  }

}
