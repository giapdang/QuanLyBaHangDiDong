package model.response;

import model.entity.ChiTietDonHang;

public class ChiTietDonHangResponse extends ChiTietDonHang {

  private String tenSanPham;
  private String tenKhachHang;

  public ChiTietDonHangResponse(int IDChiTietDonHang, int IDDonHang, int IDSanPham, int soLuong,
      double giaBan, String tenSanPham, String tenKhachHang) {
    super(IDChiTietDonHang, IDDonHang, IDSanPham, soLuong, giaBan);
    this.tenSanPham = tenSanPham;
    this.tenKhachHang = tenKhachHang;
  }

  public String getTenSanPham() {
    return tenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }

  public String getTenKhachHang() {
    return tenKhachHang;
  }

  public void setTenKhachHang(String tenKhachHang) {
    this.tenKhachHang = tenKhachHang;
  }
}
