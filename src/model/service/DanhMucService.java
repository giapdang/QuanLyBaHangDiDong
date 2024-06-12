package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.entity.DanhMucSanPham;

public class DanhMucService {

  private static final String SELECT_ALL_DANH_MUC = "select * from danhmucsanpham";

  public List<DanhMucSanPham> getAllDanhMuc() {
    List<DanhMucSanPham> danhMucSanPhams = new ArrayList<>();

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DANH_MUC)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDDanhMuc = rs.getInt("IDDanhMuc");
        String TenDanhMuc = rs.getString("TenDanhMuc");
        String MoTa = rs.getString("MoTa");

        DanhMucSanPham danhMucSanPham = new DanhMucSanPham(IDDanhMuc, TenDanhMuc, MoTa);
        danhMucSanPhams.add(danhMucSanPham);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return danhMucSanPhams;
  }
}
