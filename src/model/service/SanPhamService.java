package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.response.SanPhamResponse;

public class SanPhamService {

  public static final String SELECT_SAN_PHAM =
      "select sp.IDSanPham, sp.MaSanPham, sp.TenSanPham, sp.GiaBanRa, sp.GiaNhap, sp.MoTa, sp.ThoiGianNhap, "
          + "sp.IDDanhMuc, dm.TenDanhMuc, sp.IDNhaCungCap, ncc.TenNhaCungCap "
          + "from sanpham sp, danhmucsanpham dm, nhacungcapsanpham ncc "
          + "where sp.IDDanhMuc = dm.IDDanhMuc and sp.IDNhaCungCap = ncc.IDNhaCungCap";

  public List<SanPhamResponse> findAllSanPham() {
    List<SanPhamResponse> sanPhams = new ArrayList<>();

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SAN_PHAM)) {
      ResultSet rs = preparedStatement.executeQuery();
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      while (rs.next()) {
        int IDSanPham = rs.getInt("IDSanPham");
        String MaSanPham = rs.getString("MaSanPham");
        String TenSanPham = rs.getString("TenSanPham");
        double GiaBanRa = rs.getDouble("GiaBanRa");
        double GiaNhap = rs.getDouble("GiaNhap");
        String MoTa = rs.getString("MoTa");
        Date ThoiGianNhap = dateFormat.parse(rs.getString("ThoiGianNhap"));
        int IDDanhMuc = rs.getInt("IDDanhMuc");
        int IDNhaCungCap = rs.getInt("IDNhaCungCap");
        String TenDanhMuc = rs.getString("TenDanhMuc");
        String TenNhaCungCap = rs.getString("TenNhaCungCap");

        SanPhamResponse sanPham = new SanPhamResponse(IDSanPham, TenSanPham, MaSanPham, GiaBanRa,
            GiaNhap, MoTa, ThoiGianNhap, IDDanhMuc, IDNhaCungCap, TenDanhMuc, TenNhaCungCap);
        sanPhams.add(sanPham);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sanPhams;
  }
}
