package model;

import java.util.Date;

public class SanPham {
  private int IDSanPham;
  private String TenSanPham;
  private String MaSanPham;
  private double GiaBanRa;
  private double GiaNhap;
  private String MoTa;
  private Date ThoiGianNhap;
  private int IDDanhMuc;
  private int IDNhaCungCap;

  // Constructor, getters, setters

  public SanPham(int IDSanPham, String tenSanPham, String maSanPham, double giaBanRa,
      double giaNhap,
      String moTa, Date thoiGianNhap, int IDDanhMuc, int IDNhaCungCap) {
    this.IDSanPham = IDSanPham;
    TenSanPham = tenSanPham;
    MaSanPham = maSanPham;
    GiaBanRa = giaBanRa;
    GiaNhap = giaNhap;
    MoTa = moTa;
    ThoiGianNhap = thoiGianNhap;
    this.IDDanhMuc = IDDanhMuc;
    this.IDNhaCungCap = IDNhaCungCap;
  }

  public int getIDSanPham() {
    return IDSanPham;
  }

  public void setIDSanPham(int IDSanPham) {
    this.IDSanPham = IDSanPham;
  }

  public String getTenSanPham() {
    return TenSanPham;
  }

  public void setTenSanPham(String tenSanPham) {
    TenSanPham = tenSanPham;
  }

  public String getMaSanPham() {
    return MaSanPham;
  }

  public void setMaSanPham(String maSanPham) {
    MaSanPham = maSanPham;
  }

  public double getGiaBanRa() {
    return GiaBanRa;
  }

  public void setGiaBanRa(double giaBanRa) {
    GiaBanRa = giaBanRa;
  }

  public double getGiaNhap() {
    return GiaNhap;
  }

  public void setGiaNhap(double giaNhap) {
    GiaNhap = giaNhap;
  }

  public String getMoTa() {
    return MoTa;
  }

  public void setMoTa(String moTa) {
    MoTa = moTa;
  }

  public Date getThoiGianNhap() {
    return ThoiGianNhap;
  }

  public void setThoiGianNhap(Date thoiGianNhap) {
    ThoiGianNhap = thoiGianNhap;
  }

  public int getIDDanhMuc() {
    return IDDanhMuc;
  }

  public void setIDDanhMuc(int IDDanhMuc) {
    this.IDDanhMuc = IDDanhMuc;
  }

  public int getIDNhaCungCap() {
    return IDNhaCungCap;
  }

  public void setIDNhaCungCap(int IDNhaCungCap) {
    this.IDNhaCungCap = IDNhaCungCap;
  }
}

