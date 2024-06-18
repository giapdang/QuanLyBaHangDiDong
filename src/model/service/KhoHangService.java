package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import model.response.KhoHangResponse;
import view.HomeView;

public class KhoHangService {

  private HomeView homeView;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public KhoHangService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method hien thi kho hang
  public List<KhoHangResponse> getAllKhoHang() {
    List<KhoHangResponse> khoHangs = new ArrayList<>();
    String query =
        "SELECT kh.IDKho ,sp.IDSanPham, sp.TenSanPham , kh.SoLuongTonKho , kh.NgayNhapKho,"
            + "ncc.IDNhaCungCap ,ncc.TenNhaCungCap ,nv.IDNguoiNhap,nv.TenNguoiNhap "
            + "FROM khohang kh ,sanpham sp, nhacungcapsanpham ncc , nguoinhap nv "
            + "WHERE kh.IDSanPham = sp.IDSanPham "
            + "and kh.IDNhaCungCap = ncc.IDNhaCungCap and kh.IDNguoiNhap = nv.IDNguoiNhap;";
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

  //method tim kiem kho hang theo ten san pham va ten nha cung cap va ten nguoi nhap va ngay nhap kho
  public List<KhoHangResponse> searchKhoHang(String search) {
    List<KhoHangResponse> khoHangs = new ArrayList<>();
    String query =
        "SELECT kh.IDKho, sp.IDSanPham, sp.TenSanPham, kh.SoLuongTonKho, kh.NgayNhapKho, "
            + "ncc.IDNhaCungCap, ncc.TenNhaCungCap, nv.IDNguoiNhap, nv.TenNguoiNhap "
            + "FROM khohang kh "
            + "JOIN sanpham sp ON kh.IDSanPham = sp.IDSanPham "
            + "JOIN nhacungcapsanpham ncc ON kh.IDNhaCungCap = ncc.IDNhaCungCap "
            + "JOIN nguoinhap nv ON kh.IDNguoiNhap = nv.IDNguoiNhap "
            + "WHERE sp.TenSanPham LIKE ? "
            + "or ncc.TenNhaCungCap LIKE ? "
            + "or nv.TenNguoiNhap LIKE ? "
            + "or kh.IDKho = ? ";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, "%" + search + "%");
      preparedStatement.setString(3, "%" + search + "%");
      preparedStatement.setString(4, search);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDKho = rs.getInt("IDKho");
        int SoLuongTonKho = rs.getInt("SoLuongTonKho");
        String TenSanPham = rs.getString("TenSanPham");
        String TenNhaCungCap = rs.getString("TenNhaCungCap");
        String TenNguoiNhap = rs.getString("TenNguoiNhap");
        Date ngayNhapKho1 = dateFormat.parse(rs.getString("NgayNhapKho"));
        int IDSanPham = rs.getInt("IDSanPham");
        int IDNhaCungCap = rs.getInt("IDNhaCungCap");
        int IDNguoiNhap = rs.getInt("IDNguoiNhap");
        KhoHangResponse khoHang = new KhoHangResponse(IDKho, IDSanPham, SoLuongTonKho, ngayNhapKho1,
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
