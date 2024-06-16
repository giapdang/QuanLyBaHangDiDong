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
  //method thêm đơn hàng yêu cầu khi thêm 1 đơn hàng thì thêm cả chi tiết đơn hàng và hóa đơn


}
