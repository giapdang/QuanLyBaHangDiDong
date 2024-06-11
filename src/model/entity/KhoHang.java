package model.entity;

import java.util.Date;

public class KhoHang {
  private int IDKho;
  private int IDSanPham;
  private int SoLuongTonKho;
  private Date NgayNhapKho;
  private int IDNhaCungCap;
  private int IDNguoiNhap;

  // Constructor, getters, setters

  public KhoHang(int IDKho, int IDSanPham, int soLuongTonKho, Date ngayNhapKho, int IDNhaCungCap,
      int IDNguoiNhap) {
    this.IDKho = IDKho;
    this.IDSanPham = IDSanPham;
    SoLuongTonKho = soLuongTonKho;
    NgayNhapKho = ngayNhapKho;
    this.IDNhaCungCap = IDNhaCungCap;
    this.IDNguoiNhap = IDNguoiNhap;
  }

  public int getIDKho() {
    return IDKho;
  }

  public void setIDKho(int IDKho) {
    this.IDKho = IDKho;
  }

  public int getIDSanPham() {
    return IDSanPham;
  }

  public void setIDSanPham(int IDSanPham) {
    this.IDSanPham = IDSanPham;
  }

  public int getSoLuongTonKho() {
    return SoLuongTonKho;
  }

  public void setSoLuongTonKho(int soLuongTonKho) {
    SoLuongTonKho = soLuongTonKho;
  }

  public Date getNgayNhapKho() {
    return NgayNhapKho;
  }

  public void setNgayNhapKho(Date ngayNhapKho) {
    NgayNhapKho = ngayNhapKho;
  }

  public int getIDNhaCungCap() {
    return IDNhaCungCap;
  }

  public void setIDNhaCungCap(int IDNhaCungCap) {
    this.IDNhaCungCap = IDNhaCungCap;
  }

  public int getIDNguoiNhap() {
    return IDNguoiNhap;
  }

  public void setIDNguoiNhap(int IDNguoiNhap) {
    this.IDNguoiNhap = IDNguoiNhap;
  }
}

