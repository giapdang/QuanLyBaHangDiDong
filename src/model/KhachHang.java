package model;
public class KhachHang {
  private int IDKhachHang;
  private String TenKhachHang;
  private String DiaChi;
  private String SoDienThoai;
  private String Email;

  // Constructor, getters, setters

  public KhachHang(int IDKhachHang, String tenKhachHang, String diaChi, String soDienThoai,
      String email) {
    this.IDKhachHang = IDKhachHang;
    TenKhachHang = tenKhachHang;
    DiaChi = diaChi;
    SoDienThoai = soDienThoai;
    Email = email;
  }

  public int getIDKhachHang() {
    return IDKhachHang;
  }

  public void setIDKhachHang(int IDKhachHang) {
    this.IDKhachHang = IDKhachHang;
  }

  public String getTenKhachHang() {
    return TenKhachHang;
  }

  public void setTenKhachHang(String tenKhachHang) {
    TenKhachHang = tenKhachHang;
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

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }
}

