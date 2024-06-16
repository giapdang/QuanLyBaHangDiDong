package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.response.DonHangResponse;
import view.HomeView;

public class DonHangService {

  private HomeView homeView;

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public DonHangService(HomeView homeView) {
    this.homeView = homeView;
  }

  //method hien thi don hang
  public List<DonHangResponse> getAllDonHang() {
    List<DonHangResponse> donHangs = new ArrayList<>();
    String query =
        "SELECT dh.IDDonHang ,dh.NgayTaoDonHang ,dh.TongTienDonHang ,dh.TrangThaiDonHang ,kh.IDKhachHang ,kh.TenKhachHang "
            + "FROM donhang dh ,khachhang kh "
            + "WHERE dh.IDKhachHang = kh.IDKhachHang";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int IDDonHang = rs.getInt("IDDonHang");
        double TongTienDonHang = rs.getDouble("TongTienDonHang");
        String TrangThaiDonHang = rs.getString("TrangThaiDonHang");
        Date NgayTaoDonHang = dateFormat.parse(rs.getString("NgayTaoDonHang"));
        int IDKhachHang = rs.getInt("IDKhachHang");
        String TenKhachHang = rs.getString("TenKhachHang");
        DonHangResponse donHang = new DonHangResponse(IDDonHang, NgayTaoDonHang, TongTienDonHang,
            TrangThaiDonHang, IDKhachHang, TenKhachHang);
        donHangs.add(donHang);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return donHangs;
  }

  //method them don va chi tiet don hang va hoa don va cap nha lai so luong san pham trong kho
  public void addDonHangAndCtdhAndHoaDon(String ngayTaoDonHang, String trangThaiDonHang,
      int idKhachHang, int idSanPham, int soLuong, double giaBan, double tongTien,
      double tongtienHoaDon, String ngayTaoHoaDon) {
    Connection connection = null;
    PreparedStatement insertProductStatement = null;
    PreparedStatement insertProductStatement1 = null;
    PreparedStatement insertProductStatement2 = null;
    PreparedStatement insertProductStatement3 = null;
    PreparedStatement calculateTotalAmountStatement = null;
    try {
      connection = Jdbc.getJdbc();
      connection.setAutoCommit(false);
      // Calculate 'TongTienDonHang'
      double tongTienDonHang = soLuong * giaBan;

      insertProductStatement = connection.prepareStatement(
          "INSERT INTO donhang(ngaytaodonhang,trangthaidonhang,idkhachhang,tongtiendonhang) VALUES (?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      insertProductStatement.setString(1, dateFormat.format(new Date()));
      insertProductStatement.setString(2, trangThaiDonHang);
      insertProductStatement.setInt(3, idKhachHang);
      insertProductStatement.setDouble(4, tongTienDonHang); // Set 'TongTienDonHang'
      insertProductStatement.executeUpdate();

      // Lấy ID sản phẩm mới được tạo
      ResultSet rs = insertProductStatement.getGeneratedKeys();
      rs.next();
      int IDDonHang = rs.getInt(1);

      //insert chi tiet don hang
      insertProductStatement1 = connection.prepareStatement(
          "INSERT INTO chitietdonhang(iddonhang,idsanpham,soluong,GiaBan) VALUES (?,?,?,?)");
      insertProductStatement1.setInt(1, IDDonHang);
      insertProductStatement1.setInt(2, idSanPham);
      insertProductStatement1.setInt(3, soLuong);
      insertProductStatement1.setDouble(4, giaBan);
      insertProductStatement1.executeUpdate();

      //update tong tien don hang cong thuc tong tien = gia ban * so luong
      insertProductStatement2 = connection.prepareStatement(
          "UPDATE donhang SET tongtiendonhang = ? WHERE iddonhang = ?");
      insertProductStatement2.setDouble(1, tongTienDonHang);
      insertProductStatement2.setInt(2, IDDonHang);
      insertProductStatement2.executeUpdate();

      //insert hoa don
      insertProductStatement3 = connection.prepareStatement(
          "INSERT INTO hoadon(iddonhang, tongtienthanhtoan, ngaythanhtoan) VALUES (?,?,?)");
      insertProductStatement3.setInt(1, IDDonHang);

      // Calculate the sum of the total amount of the order for a specific customer
      calculateTotalAmountStatement = connection.prepareStatement(
          "SELECT SUM(tongtiendonhang) FROM donhang WHERE idkhachhang = ?");
      calculateTotalAmountStatement.setInt(1, idKhachHang);
      ResultSet rsTotalAmount = calculateTotalAmountStatement.executeQuery();
      double totalAmount = 0;
      if (rsTotalAmount.next()) {
        totalAmount = rsTotalAmount.getDouble(1);
      }

      // Update the total payment of the invoice
      insertProductStatement3.setDouble(2, totalAmount);
      insertProductStatement3.setString(3, dateFormat.format(new Date()));
      insertProductStatement3.executeUpdate();

      connection.commit();
    } catch (Exception e) {
      if (connection != null) {
        try {
          System.err.print("Transaction is being rolled back");
          connection.rollback();
        } catch(SQLException excep) {
          excep.printStackTrace();
        }
      }
      e.printStackTrace();
    }
  }
}
