package model;

import java.util.Date;

public class DonHang {
  private int IDDonHang;
  private Date NgayTaoDonHang;
  private double TongTienDonHang;
  private String TrangThaiDonHang;
  private int IDKhachHang;

  // Constructor, getters, setters

  public DonHang(int IDDonHang, Date ngayTaoDonHang, double tongTienDonHang,
      String trangThaiDonHang,
      int IDKhachHang) {
    this.IDDonHang = IDDonHang;
    NgayTaoDonHang = ngayTaoDonHang;
    TongTienDonHang = tongTienDonHang;
    TrangThaiDonHang = trangThaiDonHang;
    this.IDKhachHang = IDKhachHang;
  }

  public int getIDDonHang() {
    return IDDonHang;
  }

  public void setIDDonHang(int IDDonHang) {
    this.IDDonHang = IDDonHang;
  }

  public Date getNgayTaoDonHang() {
    return NgayTaoDonHang;
  }

  public void setNgayTaoDonHang(Date ngayTaoDonHang) {
    NgayTaoDonHang = ngayTaoDonHang;
  }

  public double getTongTienDonHang() {
    return TongTienDonHang;
  }

  public void setTongTienDonHang(double tongTienDonHang) {
    TongTienDonHang = tongTienDonHang;
  }

  public String getTrangThaiDonHang() {
    return TrangThaiDonHang;
  }

  public void setTrangThaiDonHang(String trangThaiDonHang) {
    TrangThaiDonHang = trangThaiDonHang;
  }

  public int getIDKhachHang() {
    return IDKhachHang;
  }

  public void setIDKhachHang(int IDKhachHang) {
    this.IDKhachHang = IDKhachHang;
  }
}

