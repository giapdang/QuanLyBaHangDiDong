package model.entity;

public class NhaCungCapSanPham {
  private int IDNhaCungCap;
  private String TenNhaCungCap;
  private String DiaChi;
  private String SoDienThoai;

  // Constructor, getters, setters

  public NhaCungCapSanPham(int IDNhaCungCap, String tenNhaCungCap, String diaChi,
      String soDienThoai) {
    this.IDNhaCungCap = IDNhaCungCap;
    TenNhaCungCap = tenNhaCungCap;
    DiaChi = diaChi;
    SoDienThoai = soDienThoai;
  }

  public int getIDNhaCungCap() {
    return IDNhaCungCap;
  }

  public void setIDNhaCungCap(int IDNhaCungCap) {
    this.IDNhaCungCap = IDNhaCungCap;
  }

  public String getTenNhaCungCap() {
    return TenNhaCungCap;
  }

  public void setTenNhaCungCap(String tenNhaCungCap) {
    TenNhaCungCap = tenNhaCungCap;
  }

  public String getDiaChi() {
    return DiaChi;
  }

  public void setDiaChi(String diaChi) {
    DiaChi = diaChi;
  }

  public String getSoDienThoai() {
    return SoDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    SoDienThoai = soDienThoai;
  }
}

