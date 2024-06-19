package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.response.HoaDonResponse;
import view.HomeView;

public class HoaDonService {

  private HomeView homeView;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public HoaDonService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method to get all bill hoa don response
  public List<HoaDonResponse> getAllHoaDon() {
    List<HoaDonResponse> hoaDonList = new ArrayList<>();
    String query = "SELECT hd.IDHoaDon, kh.TenKhachHang, kh.DiaChi, kh.Email, kh.SoDienThoai, "
        + "GROUP_CONCAT(CONCAT('TenSanPham: ', sp.TenSanPham, ', MaSanPham: ', sp.MaSanPham, ', SoLuong: ', ctdh.SoLuong, ', GiaBan: ', ctdh.GiaBan, ', TongTienDonHang: ', dh.TongTienDonHang) SEPARATOR '; ') AS SanPhamChiTiet, "
        + "SUM(dh.TongTienDonHang) AS TongTienDonHang, "
        + "MAX(hd.NgayThanhToan) AS NgayThanhToan "
        + "FROM DonHang dh "
        + "JOIN KhachHang kh ON dh.IDKhachHang = kh.IDKhachHang "
        + "JOIN ChiTietDonHang ctdh ON ctdh.IDDonHang = dh.IDDonHang "
        + "JOIN SanPham sp ON sp.IDSanPham = ctdh.IDSanPham "
        + "JOIN HoaDon hd ON hd.IDDonHang = dh.IDDonHang "
        + "GROUP BY kh.IDKhachHang";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDHoaDon = rs.getInt("IDHoaDon");
        String TenKhachHang = rs.getString("TenKhachHang");
        String DiaChi = rs.getString("DiaChi");
        String Email = rs.getString("Email");
        String SoDienThoai = rs.getString("SoDienThoai");
        String SanPhamChiTiet = rs.getString("SanPhamChiTiet");
        double TongTienDonHang = rs.getDouble("TongTienDonHang");
        Date NgayThanhToan = dateFormat.parse(rs.getString("NgayThanhToan"));

        HoaDonResponse hoaDon = new HoaDonResponse(TenKhachHang, DiaChi, Email, SoDienThoai,
            IDHoaDon, SanPhamChiTiet, TongTienDonHang, NgayThanhToan);
        hoaDonList.add(hoaDon);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return hoaDonList;
  }

  //method tim kiem hoa don theo ten khach hang hoac so dien thoai khach hang hoac email khach hang hoac dia chi khach hang hoac id hoa don
  public List<HoaDonResponse> searchHoaDon(String search) {
    List<HoaDonResponse> hoaDonList = new ArrayList<>();
    String query = "SELECT hd.IDHoaDon, kh.TenKhachHang, kh.DiaChi, kh.Email, kh.SoDienThoai, "
        + "GROUP_CONCAT(CONCAT('TenSanPham: ', sp.TenSanPham, ', MaSanPham: ', sp.MaSanPham, ', SoLuong: ', ctdh.SoLuong, ', GiaBan: ', ctdh.GiaBan, ', TongTienDonHang: ', dh.TongTienDonHang) SEPARATOR '; ') AS SanPhamChiTiet, "
        + "SUM(dh.TongTienDonHang) AS TongTienDonHang, "
        + "MAX(hd.NgayThanhToan) AS NgayThanhToan "
        + "FROM DonHang dh "
        + "JOIN KhachHang kh ON dh.IDKhachHang = kh.IDKhachHang "
        + "JOIN ChiTietDonHang ctdh ON ctdh.IDDonHang = dh.IDDonHang "
        + "JOIN SanPham sp ON sp.IDSanPham = ctdh.IDSanPham "
        + "JOIN HoaDon hd ON hd.IDDonHang = dh.IDDonHang "
        + "WHERE kh.TenKhachHang LIKE ? "
        + "OR kh.SoDienThoai LIKE ? "
        + "OR kh.Email LIKE ? "
        + "OR kh.DiaChi LIKE ? "
        + "OR hd.IDHoaDon = ? "
        + "GROUP BY kh.IDKhachHang";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, "%" + search + "%");
      preparedStatement.setString(3, "%" + search + "%");
      preparedStatement.setString(4, "%" + search + "%");
      preparedStatement.setString(5, search);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDHoaDon = rs.getInt("IDHoaDon");
        String TenKhachHang = rs.getString("TenKhachHang");
        String DiaChi = rs.getString("DiaChi");
        String Email = rs.getString("Email");
        String SoDienThoai = rs.getString("SoDienThoai");
        String SanPhamChiTiet = rs.getString("SanPhamChiTiet");
        double TongTienDonHang = rs.getDouble("TongTienDonHang");
        Date NgayThanhToan = dateFormat.parse(rs.getString("NgayThanhToan"));

        HoaDonResponse hoaDon = new HoaDonResponse(TenKhachHang, DiaChi, Email, SoDienThoai,
            IDHoaDon, SanPhamChiTiet, TongTienDonHang, NgayThanhToan);
        hoaDonList.add(hoaDon);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hoaDonList;
  }

  //method findById hoa don
  public HoaDonResponse findById(String name) {
    HoaDonResponse hoaDon = null;
    String query = "SELECT hd.IDHoaDon, kh.TenKhachHang, kh.DiaChi, kh.Email, kh.SoDienThoai, "
        + "GROUP_CONCAT(CONCAT('TenSanPham: ', sp.TenSanPham, ', MaSanPham: ', sp.MaSanPham, ', SoLuong: ', ctdh.SoLuong, ', GiaBan: ', ctdh.GiaBan, ', TongTienDonHang: ', dh.TongTienDonHang) SEPARATOR '; ') AS SanPhamChiTiet, "
        + "SUM(dh.TongTienDonHang) AS TongTienDonHang, "
        + "MAX(hd.NgayThanhToan) AS NgayThanhToan "
        + "FROM DonHang dh "
        + "JOIN KhachHang kh ON dh.IDKhachHang = kh.IDKhachHang "
        + "JOIN ChiTietDonHang ctdh ON ctdh.IDDonHang = dh.IDDonHang "
        + "JOIN SanPham sp ON sp.IDSanPham = ctdh.IDSanPham "
        + "JOIN HoaDon hd ON hd.IDDonHang = dh.IDDonHang "
        + "WHERE kh.TenKhachHang LIKE ? "
        + "GROUP BY kh.IDKhachHang";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + name + "%");
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDHoaDon = rs.getInt("IDHoaDon");
        String TenKhachHang = rs.getString("TenKhachHang");
        String DiaChi = rs.getString("DiaChi");
        String Email = rs.getString("Email");
        String SoDienThoai = rs.getString("SoDienThoai");
        String SanPhamChiTiet = rs.getString("SanPhamChiTiet");
        double TongTienDonHang = rs.getDouble("TongTienDonHang");
        Date NgayThanhToan = dateFormat.parse(rs.getString("NgayThanhToan"));

        hoaDon = new HoaDonResponse(TenKhachHang, DiaChi, Email, SoDienThoai,
            IDHoaDon, SanPhamChiTiet, TongTienDonHang, NgayThanhToan);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hoaDon;
  }
}

