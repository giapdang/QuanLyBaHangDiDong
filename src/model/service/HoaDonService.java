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

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

        HoaDonResponse hoaDon = new HoaDonResponse(TenKhachHang, DiaChi, Email, SoDienThoai, IDHoaDon, SanPhamChiTiet, TongTienDonHang, NgayThanhToan);
        hoaDonList.add(hoaDon);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return hoaDonList;
  }
}
