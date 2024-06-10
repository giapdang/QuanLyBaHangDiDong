package model;

import java.util.Date;

public class HoaDon {

  private int IDHoaDon;
  private int IDDonHang;
  private double TongTienThanhToan;
  private Date NgayThanhToan;

  // Constructor, getters, setters

  public HoaDon(int IDHoaDon, int IDDonHang, double tongTienThanhToan, Date ngayThanhToan) {
    this.IDHoaDon = IDHoaDon;
    this.IDDonHang = IDDonHang;
    TongTienThanhToan = tongTienThanhToan;
    NgayThanhToan = ngayThanhToan;
  }

  public int getIDHoaDon() {
    return IDHoaDon;
  }

  public void setIDHoaDon(int IDHoaDon) {
    this.IDHoaDon = IDHoaDon;
  }

  public int getIDDonHang() {
    return IDDonHang;
  }

  public void setIDDonHang(int IDDonHang) {
    this.IDDonHang = IDDonHang;
  }

  public double getTongTienThanhToan() {
    return TongTienThanhToan;
  }

  public void setTongTienThanhToan(double tongTienThanhToan) {
    TongTienThanhToan = tongTienThanhToan;
  }

  public Date getNgayThanhToan() {
    return NgayThanhToan;
  }

  public void setNgayThanhToan(Date ngayThanhToan) {
    NgayThanhToan = ngayThanhToan;
  }
}
