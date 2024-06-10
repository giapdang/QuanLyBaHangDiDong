package model;

public class NguoiNhap {
  private int IDNguoiNhap;
  private String TenNguoiNhap;
  private String Email;
  private String MatKhau;
  private String SoDienThoai;

  // Constructor, getters, setters

  public NguoiNhap(int IDNguoiNhap, String tenNguoiNhap, String email, String matKhau,
      String soDienThoai) {
    this.IDNguoiNhap = IDNguoiNhap;
    TenNguoiNhap = tenNguoiNhap;
    Email = email;
    MatKhau = matKhau;
    SoDienThoai = soDienThoai;
  }

  public int getIDNguoiNhap() {
    return IDNguoiNhap;
  }

  public void setIDNguoiNhap(int IDNguoiNhap) {
    this.IDNguoiNhap = IDNguoiNhap;
  }

  public String getTenNguoiNhap() {
    return TenNguoiNhap;
  }

  public void setTenNguoiNhap(String tenNguoiNhap) {
    TenNguoiNhap = tenNguoiNhap;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getMatKhau() {
    return MatKhau;
  }

  public void setMatKhau(String matKhau) {
    MatKhau = matKhau;
  }

  public String getSoDienThoai() {
    return SoDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    SoDienThoai = soDienThoai;
  }
}

