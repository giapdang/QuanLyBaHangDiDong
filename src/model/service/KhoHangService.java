package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.response.KhoHangResponse;
import view.HomeView;

public class KhoHangService {

  private HomeView homeView;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public KhoHangService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method hien thi kho hang
  public List<KhoHangResponse> getAllKhoHang() {
    List<KhoHangResponse> khoHangs = new ArrayList<>();
    String query =
        "SELECT kh.IDKho ,sp.IDSanPham, sp.TenSanPham , kh.SoLuongTonKho , kh.NgayNhapKho,ncc.IDNhaCungCap ,ncc.TenNhaCungCap ,nv.IDNguoiNhap,nv.TenNguoiNhap "
            + "FROM khohang kh ,sanpham sp, nhacungcapsanpham ncc , nguoinhap nv "
            + "WHERE kh.IDSanPham = sp.IDSanPham and kh.IDNhaCungCap = ncc.IDNhaCungCap and kh.IDNguoiNhap = nv.IDNguoiNhap;";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDKho = rs.getInt("IDKho");
        int SoLuongTonKho = rs.getInt("SoLuongTonKho");
        String TenSanPham = rs.getString("TenSanPham");
        String TenNhaCungCap = rs.getString("TenNhaCungCap");
        String TenNguoiNhap = rs.getString("TenNguoiNhap");
        Date ngayNhapKho = dateFormat.parse(rs.getString("NgayNhapKho"));
        int IDSanPham = rs.getInt("IDSanPham");
        int IDNhaCungCap = rs.getInt("IDNhaCungCap");
        int IDNguoiNhap = rs.getInt("IDNguoiNhap");
        KhoHangResponse khoHang = new KhoHangResponse(IDKho, IDSanPham, SoLuongTonKho, ngayNhapKho,
            IDNhaCungCap, IDNguoiNhap, TenSanPham, TenNhaCungCap, TenNguoiNhap);
        khoHangs.add(khoHang);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
    return khoHangs;
  }
}
