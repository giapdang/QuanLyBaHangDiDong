package model.entity;

public class ChiTietDonHang {
  private int IDChiTietDonHang;
  private int IDDonHang;
  private int IDSanPham;
  private int SoLuong;
  private double GiaBan;

  // Constructor, getters, setters

  public ChiTietDonHang(int IDChiTietDonHang, int IDDonHang, int IDSanPham, int soLuong,
      double giaBan) {
    this.IDChiTietDonHang = IDChiTietDonHang;
    this.IDDonHang = IDDonHang;
    this.IDSanPham = IDSanPham;
    SoLuong = soLuong;
    GiaBan = giaBan;
  }

  public int getIDChiTietDonHang() {
    return IDChiTietDonHang;
  }

  public void setIDChiTietDonHang(int IDChiTietDonHang) {
    this.IDChiTietDonHang = IDChiTietDonHang;
  }

  public int getIDDonHang() {
    return IDDonHang;
  }

  public void setIDDonHang(int IDDonHang) {
    this.IDDonHang = IDDonHang;
  }

  public int getIDSanPham() {
    return IDSanPham;
  }

  public void setIDSanPham(int IDSanPham) {
    this.IDSanPham = IDSanPham;
  }

  public int getSoLuong() {
    return SoLuong;
  }

  public void setSoLuong(int soLuong) {
    SoLuong = soLuong;
  }

  public double getGiaBan() {
    return GiaBan;
  }

  public void setGiaBan(double giaBan) {
    GiaBan = giaBan;
  }
}

