package model.response;

import java.util.Date;
import model.entity.KhoHang;

public class KhoHangResponse extends KhoHang {

  private String tenSanPham;
  private String tenNhaCungCap;
  private String tenNguoiNhap;

  public KhoHangResponse(int IDKho, int IDSanPham, int soLuongTonKho, Date ngayNhapKho,
      int IDNhaCungCap, int IDNguoiNhap, String tenSanPham, String tenNhaCungCap,
      String tenNguoiNhap) {
    super(IDKho, IDSanPham, soLuongTonKho, ngayNhapKho, IDNhaCungCap, IDNguoiNhap);
    this.tenSanPham = tenSanPham;
    this.tenNhaCungCap = tenNhaCungCap;
    this.tenNguoiNhap = tenNguoiNhap;
  }

  public String getTenSanPham() {
    return tenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    this.tenSanPham = tenSanPham;
  }

  public String getTenNhaCungCap() {
    return tenNhaCungCap;
  }

  public void setTenNhaCungCap(String tenNhaCungCap) {
    this.tenNhaCungCap = tenNhaCungCap;
  }

  public String getTenNguoiNhap() {
    return tenNguoiNhap;
  }

  public void setTenNguoiNhap(String tenNguoiNhap) {
    this.tenNguoiNhap = tenNguoiNhap;
  }
}
