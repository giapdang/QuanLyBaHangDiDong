package model.response;

import java.util.Date;
import model.entity.SanPham;

public class SanPhamResponse extends SanPham {

  private String TenDanhMuc;
  private String TenNhaCungCap;

  public SanPhamResponse(int IDSanPham, String tenSanPham, String maSanPham, double giaBanRa,
      double giaNhap, String moTa, Date thoiGianNhap, int IDDanhMuc, int IDNhaCungCap,
      String tenDanhMuc, String tenNhaCungCap) {
    super(IDSanPham, tenSanPham, maSanPham, giaBanRa, giaNhap, moTa, thoiGianNhap, IDDanhMuc, IDNhaCungCap);
    this.TenDanhMuc = tenDanhMuc;
    this.TenNhaCungCap = tenNhaCungCap;
  }

  public String getTenDanhMuc() {
    return TenDanhMuc;
  }

  public void setTenDanhMuc(String tenDanhMuc) {
    TenDanhMuc = tenDanhMuc;
  }

  public String getTenNhaCungCap() {
    return TenNhaCungCap;
  }

  public void setTenNhaCungCap(String tenNhaCungCap) {
    TenNhaCungCap = tenNhaCungCap;
  }
}
