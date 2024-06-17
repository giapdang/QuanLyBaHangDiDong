package model.response;

import java.util.Date;

public class HoaDonResponse {

  private String tenKhachHang;
  private String diaChi;
  private String email;
  private String soDienThoai;
  private int IDHoaDon;
  private String sanPhamChiTiet;
  private double tongTienDonHang;
  private Date ngayThanhToan;

  public HoaDonResponse(String tenKhachHang, String diaChi, String email, String soDienThoai,
      int IDHoaDon, String sanPhamChiTiet, double tongTienDonHang, Date ngayThanhToan) {
    this.tenKhachHang = tenKhachHang;
    this.diaChi = diaChi;
    this.email = email;
    this.soDienThoai = soDienThoai;
    this.IDHoaDon = IDHoaDon;
    this.sanPhamChiTiet = sanPhamChiTiet;
    this.tongTienDonHang = tongTienDonHang;
    this.ngayThanhToan = ngayThanhToan;
  }

  public String getTenKhachHang() {
    return tenKhachHang;
  }

  public void setTenKhachHang(String tenKhachHang) {
    this.tenKhachHang = tenKhachHang;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diaChi) {
    this.diaChi = diaChi;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSoDienThoai() {
    return soDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    this.soDienThoai = soDienThoai;
  }

  public int getIDHoaDon() {
    return IDHoaDon;
  }

  public void setIDHoaDon(int IDHoaDon) {
    this.IDHoaDon = IDHoaDon;
  }

  public String getSanPhamChiTiet() {
    return sanPhamChiTiet;
  }

  public void setSanPhamChiTiet(String sanPhamChiTiet) {
    this.sanPhamChiTiet = sanPhamChiTiet;
  }

  public double getTongTienDonHang() {
    return tongTienDonHang;
  }

  public void setTongTienDonHang(double tongTienDonHang) {
    this.tongTienDonHang = tongTienDonHang;
  }

  public Date getNgayThanhToan() {
    return ngayThanhToan;
  }

  public void setNgayThanhToan(Date ngayThanhToan) {
    this.ngayThanhToan = ngayThanhToan;
  }
}