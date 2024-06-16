package model.service;

import database.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.response.Item;
import model.response.SanPhamResponse;
import view.HomeView;

public class SanPhamService {

  private HomeView homeView;

  public SanPhamService(HomeView homeView) {
    this.homeView = homeView;
  }

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static final String SELECT_SAN_PHAM =
      "select sp.IDSanPham, sp.MaSanPham, sp.TenSanPham, sp.GiaBanRa, sp.GiaNhap, sp.MoTa, sp.ThoiGianNhap, "
          + "sp.IDDanhMuc, dm.TenDanhMuc, sp.IDNhaCungCap, ncc.TenNhaCungCap "
          + "from sanpham sp, danhmucsanpham dm, nhacungcapsanpham ncc "
          + "where sp.IDDanhMuc = dm.IDDanhMuc and sp.IDNhaCungCap = ncc.IDNhaCungCap";

  //method hien thi ta ca san pham
  public List<SanPhamResponse> findAllSanPham() {
    List<SanPhamResponse> sanPhams = new ArrayList<>();

    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SAN_PHAM)) {
      ResultSet rs = preparedStatement.executeQuery();

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

  //method xoa
  public void deleteById(int IDSanPham) {
    Connection connection = null;
    PreparedStatement deleteDetailsStatement = null;
    PreparedStatement deleteStockStatement = null;
    PreparedStatement deleteProductStatement = null;

    try {
      connection = Jdbc.getJdbc();
      connection.setAutoCommit(false); // Bắt đầu giao dịch

      // Đầu tiên, xóa các hàng tham chiếu trong bảng chitietdonhang
      deleteDetailsStatement = connection.prepareStatement(
          "DELETE FROM chitietdonhang WHERE IDSanPham = ?");
      deleteDetailsStatement.setInt(1, IDSanPham);
      deleteDetailsStatement.executeUpdate();

      // Sau đó, xóa các hàng tham chiếu trong bảng khohang
      deleteStockStatement = connection.prepareStatement("DELETE FROM khohang WHERE IDSanPham = ?");
      deleteStockStatement.setInt(1, IDSanPham);
      deleteStockStatement.executeUpdate();

      // Cuối cùng, xóa hàng trong bảng sanpham
      deleteProductStatement = connection.prepareStatement(
          "DELETE FROM sanpham WHERE IDSanPham = ?");
      deleteProductStatement.setInt(1, IDSanPham);
      deleteProductStatement.executeUpdate();

      connection.commit(); // Commit giao dịch
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void them(String MaSanPham, String TenSanPham, double GiaBanRa, double GiaNhap,
      String MoTa, int IDDanhMuc, int IDNhaCungCap) {
    Connection connection = null;
    PreparedStatement insertProductStatement = null;
    PreparedStatement insertStockStatement = null;

    try {
      connection = Jdbc.getJdbc();
      connection.setAutoCommit(false); // Bắt đầu giao dịch

      // Thêm hàng vào bảng sanpham
      insertProductStatement = connection.prepareStatement(
          "INSERT INTO sanpham (MaSanPham, TenSanPham, GiaBanRa, GiaNhap, MoTa, ThoiGianNhap, IDDanhMuc, IDNhaCungCap) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
      insertProductStatement.setString(1, homeView.getTfMasanpham().getText());
      insertProductStatement.setString(2, homeView.getTfTensanpham().getText());
      insertProductStatement.setDouble(3, Double.parseDouble(homeView.getTfGiaBan().getText()));
      insertProductStatement.setDouble(4, Double.parseDouble(homeView.getTfGiaNhap().getText()));
      insertProductStatement.setString(5, homeView.getTfMoTa().getText());

      Date ThoiGianNhap = dateFormat.parse(homeView.getTfThoiGianNhap().getText());
      insertProductStatement.setString(6, dateFormat.format(ThoiGianNhap));

      Item selectedDanhMuc = (Item) homeView.getCbTenDanhMuc().getSelectedItem();
      insertProductStatement.setInt(7, selectedDanhMuc.getId());

      Item selectedNhaCungCap = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
      insertProductStatement.setInt(8, selectedNhaCungCap.getId());

      insertProductStatement.executeUpdate();

      // Lấy ID sản phẩm mới được tạo
      ResultSet rs = insertProductStatement.getGeneratedKeys();
      rs.next();
      int IDSanPham = rs.getInt(1);

      // Thêm hàng vào bảng khohang
      insertStockStatement = connection.prepareStatement(
          "INSERT INTO khohang (IDSanPham,SoLuongTonKho, NgayNhapKho,IDNhaCungCap,IDNguoiNhap) VALUES (?,?,?,?,?)");
      insertStockStatement.setInt(1, IDSanPham);
      insertStockStatement.setInt(2, Integer.parseInt(homeView.getTfSoluong().getText()));
      insertStockStatement.setString(3, dateFormat.format(ThoiGianNhap));
      insertStockStatement.setInt(4, selectedNhaCungCap.getId());

      // Lấy ID người nhập hàng
      Item selectedNguoiNhap = (Item) homeView.getCbNguoiNhap().getSelectedItem();
      insertStockStatement.setInt(5, selectedNguoiNhap.getId());

      insertStockStatement.executeUpdate();

      connection.commit(); // Commit giao dịch
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update(int IDSanPham, String MaSanPham, String TenSanPham, double GiaBanRa,
      double GiaNhap, String MoTa, int IDDanhMuc, int IDNhaCungCap) {
    Connection connection = null;
    PreparedStatement updateProductStatement = null;
    PreparedStatement updateStockStatement = null;

    try {
      connection = Jdbc.getJdbc();
      connection.setAutoCommit(false); // Start transaction

      // Update product in sanpham table
      updateProductStatement = connection.prepareStatement(
          "UPDATE sanpham SET MaSanPham = ?, TenSanPham = ?, GiaBanRa = ?, GiaNhap = ?, MoTa = ?, ThoiGianNhap = ?, IDDanhMuc = ?, IDNhaCungCap = ? WHERE IDSanPham = ?");
      updateProductStatement.setString(1, homeView.getTfMasanpham().getText().trim());
      updateProductStatement.setString(2, homeView.getTfTensanpham().getText().trim());
      updateProductStatement.setDouble(3,
          Double.parseDouble(homeView.getTfGiaBan().getText().trim()));
      updateProductStatement.setDouble(4,
          Double.parseDouble(homeView.getTfGiaNhap().getText().trim()));
      updateProductStatement.setString(5, homeView.getTfMoTa().getText().trim());

      Date ThoiGianNhap = dateFormat.parse(homeView.getTfThoiGianNhap().getText().trim());
      updateProductStatement.setString(6, dateFormat.format(ThoiGianNhap));

      Item selectedDanhMuc = (Item) homeView.getCbTenDanhMuc().getSelectedItem();
      updateProductStatement.setInt(7, selectedDanhMuc.getId());

      Item selectedNhaCungCap = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
      updateProductStatement.setInt(8, selectedNhaCungCap.getId());
      updateProductStatement.setInt(9, IDSanPham);

      updateProductStatement.executeUpdate();

      // Update stock in khohang table
      updateStockStatement = connection.prepareStatement(
          "UPDATE khohang SET SoLuongTonKho = ?, NgayNhapKho = ?, IDNhaCungCap = ?, IDNguoiNhap = ? WHERE IDSanPham = ?");
      updateStockStatement.setInt(1, Integer.parseInt(homeView.getTfSoluong().getText().trim()));
      updateStockStatement.setString(2, dateFormat.format(ThoiGianNhap));
      updateStockStatement.setInt(3, selectedNhaCungCap.getId());

      //lay id nguoi nhap
      Item selectedNguoiNhap = (Item) homeView.getCbNguoiNhap().getSelectedItem();
      updateStockStatement.setInt(4, selectedNguoiNhap.getId());
      updateStockStatement.setInt(5, IDSanPham);

      updateStockStatement.executeUpdate();

      connection.commit();
    } catch (Exception e) {
      e.printStackTrace();
      if (connection != null) {
        try {
          connection.rollback();
        } catch (SQLException rollbackException) {
          rollbackException.printStackTrace();
        }
      }
    }
  }

  //method tim kiem san pham theo id
  public SanPhamResponse findSanPhamById(int IDSanPham) {
    SanPhamResponse sanPham = null;
    String query =
        "select sp.IDSanPham, sp.MaSanPham, sp.TenSanPham, sp.GiaBanRa, sp.GiaNhap, sp.MoTa, sp.ThoiGianNhap, "
            + "sp.IDDanhMuc, dm.TenDanhMuc, sp.IDNhaCungCap, ncc.TenNhaCungCap "
            + "from sanpham sp "
            + "join danhmucsanpham dm on sp.IDDanhMuc = dm.IDDanhMuc "
            + "join nhacungcapsanpham ncc on sp.IDNhaCungCap = ncc.IDNhaCungCap "
            + "where sp.IDSanPham = ?";
    try (Connection connection = Jdbc.getJdbc();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, IDSanPham);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        sanPham = new SanPhamResponse(
            rs.getInt("IDSanPham"),
            rs.getString("TenSanPham"),
            rs.getString("MaSanPham"),
            rs.getDouble("GiaBanRa"),
            rs.getDouble("GiaNhap"),
            rs.getString("MoTa"),
            dateFormat.parse(rs.getString("ThoiGianNhap")),
            rs.getInt("IDDanhMuc"),
            rs.getInt("IDNhaCungCap"),
            rs.getString("TenDanhMuc"),
            rs.getString("TenNhaCungCap")

        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sanPham;
  }
  //method hien thi ten vaf id san pham
  public List<Item> getAllName() {
    List<Item> SanPhamNames = new ArrayList<>();
    String query = "SELECT IDSanPham,TenSanPham FROM sanpham";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        SanPhamNames.add(new Item(resultSet.getInt("IDSanPham"), resultSet.getString("TenSanPham")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return SanPhamNames;
  }
  //method lay id va gia ban ra
  public List<Item> getIDGiaBanRa() {
    List<Item> SanPhamList = new ArrayList<>();
    String query = "SELECT IDSanPham, GiaBanRa FROM sanpham";

    try (Connection connection = Jdbc.getJdbc();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        SanPhamList.add(new Item(resultSet.getInt("IDSanPham"), resultSet.getString("GiaBanRa")));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return SanPhamList;
  }
}
