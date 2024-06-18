package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.response.ChiTietDonHangResponse;
import view.HomeView;

public class ChiTietDonHangService {

  private HomeView homeView;

  public ChiTietDonHangService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method hien thi chi tiet don hang response
  public List<ChiTietDonHangResponse> getAllChiTietDonHang() {
    List<ChiTietDonHangResponse> chiTietDonHangs = new ArrayList<>();

    String query = "SELECT \n"
        + "    ctdh.IDChiTietDonHang, \n"
        + "    dh.IDDonHang, \n"
        + "    sp.IDSanPham,\n"
        + "    sp.TenSanPham,  \n"
        + "    kh.IDKhachHang,\n"
        + "    kh.TenKhachHang, \n"
        + "    ctdh.SoLuong, \n"
        + "    ctdh.GiaBan\n"
        + "FROM \n"
        + "    chitietdonhang ctdh \n"
        + "    JOIN donhang dh ON ctdh.IDDonHang = dh.IDDonHang\n"
        + "    JOIN khachhang kh ON dh.IDKhachHang = kh.IDKhachHang\n"
        + "    JOIN sanpham sp ON ctdh.IDSanPham = sp.IDSanPham";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDChiTietDonHang = rs.getInt("IDChiTietDonHang");
        int IDDonHang = rs.getInt("IDDonHang");
        int IDSanPham = rs.getInt("IDSanPham");
        String TenSanPham = rs.getString("TenSanPham");
        String TenKhachHang = rs.getString("TenKhachHang");
        int SoLuong = rs.getInt("SoLuong");
        double GiaBan = rs.getDouble("GiaBan");
        ChiTietDonHangResponse chiTietDonHang = new ChiTietDonHangResponse(IDChiTietDonHang,
            IDDonHang, IDSanPham, SoLuong, GiaBan, TenSanPham, TenKhachHang);
        chiTietDonHangs.add(chiTietDonHang);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return chiTietDonHangs;
  }

  //method update so luong chi tiet don hang va cap nhat lai so luong san pham trong kho
  public void updateSoLuongChiTietDonHang(int IDChiTietDonHang, int SoLuongMoi) {
    String query = "SELECT SoLuong, IDSanPham FROM ChiTietDonHang WHERE IDChiTietDonHang = ?";
    String queryUpdateChiTietDonHang = "UPDATE ChiTietDonHang SET SoLuong = ? WHERE IDChiTietDonHang = ?";
    String queryGetKhoHangQuantity = "SELECT SoLuongTonKho FROM KhoHang WHERE IDSanPham = ?";
    String queryUpdateKhoHang = "UPDATE KhoHang SET SoLuongTonKho = ? WHERE IDSanPham = ?";

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatementGetOldQuantity = connection.prepareStatement(query);
        PreparedStatement preparedStatementUpdateChiTietDonHang = connection.prepareStatement(
            queryUpdateChiTietDonHang);
        PreparedStatement preparedStatementGetKhoHangQuantity = connection.prepareStatement(
            queryGetKhoHangQuantity);
        PreparedStatement preparedStatementUpdateKhoHang = connection.prepareStatement(
            queryUpdateKhoHang)) {

      // lay SoLuong from ChiTietDonHang
      preparedStatementGetOldQuantity.setInt(1, IDChiTietDonHang);
      ResultSet resultSet = preparedStatementGetOldQuantity.executeQuery();
      resultSet.next();
      int SoLuongCu = resultSet.getInt("SoLuong");
      int IDSanPham = resultSet.getInt("IDSanPham");

      // update SoLuong from ChiTietDonHang
      preparedStatementUpdateChiTietDonHang.setInt(1, SoLuongMoi);
      preparedStatementUpdateChiTietDonHang.setInt(2, IDChiTietDonHang);
      preparedStatementUpdateChiTietDonHang.executeUpdate();

      // lay SoLuongTonKho from KhoHang
      preparedStatementGetKhoHangQuantity.setInt(1, IDSanPham);
      ResultSet resultSetKhoHang = preparedStatementGetKhoHangQuantity.executeQuery();
      resultSetKhoHang.next();
      int SoLuongKhoHang = resultSetKhoHang.getInt("SoLuongTonKho");

      // update so luong san pham trong kho
      int SoLuongKhoHangMoi = SoLuongKhoHang + SoLuongCu - SoLuongMoi;
      preparedStatementUpdateKhoHang.setInt(1, SoLuongKhoHangMoi);
      preparedStatementUpdateKhoHang.setInt(2, IDSanPham);
      preparedStatementUpdateKhoHang.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //method tim kiem chi tiet don hang theo ten san pham hoac ten khach hang hoac id don hang
  public List<ChiTietDonHangResponse> searchChiTietDonHang(String search) {
    List<ChiTietDonHangResponse> chiTietDonHangs = new ArrayList<>();
    String query = "SELECT \n"
        + "    ctdh.IDChiTietDonHang, \n"
        + "    dh.IDDonHang, \n"
        + "    sp.IDSanPham,\n"
        + "    sp.TenSanPham,  \n"
        + "    kh.IDKhachHang,\n"
        + "    kh.TenKhachHang, \n"
        + "    ctdh.SoLuong, \n"
        + "    ctdh.GiaBan\n"
        + "FROM \n"
        + "    chitietdonhang ctdh \n"
        + "    JOIN donhang dh ON ctdh.IDDonHang = dh.IDDonHang\n"
        + "    JOIN khachhang kh ON dh.IDKhachHang = kh.IDKhachHang\n"
        + "    JOIN sanpham sp ON ctdh.IDSanPham = sp.IDSanPham\n"
        + "WHERE sp.TenSanPham LIKE ? OR kh.TenKhachHang LIKE ? OR dh.IDDonHang = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setString(1, "%" + search + "%");
      preparedStatement.setString(2, "%" + search + "%");
      preparedStatement.setString(3, search);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        int IDChiTietDonHang = rs.getInt("IDChiTietDonHang");
        int IDDonHang = rs.getInt("IDDonHang");
        int IDSanPham = rs.getInt("IDSanPham");
        String TenSanPham = rs.getString("TenSanPham");
        String TenKhachHang = rs.getString("TenKhachHang");
        int SoLuong = rs.getInt("SoLuong");
        double GiaBan = rs.getDouble("GiaBan");
        ChiTietDonHangResponse chiTietDonHang = new ChiTietDonHangResponse(IDChiTietDonHang,
            IDDonHang, IDSanPham, SoLuong, GiaBan, TenSanPham, TenKhachHang);
        chiTietDonHangs.add(chiTietDonHang);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return chiTietDonHangs;
  }
}
