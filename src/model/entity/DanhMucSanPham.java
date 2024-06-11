package model.entity;

public class DanhMucSanPham {
  private int IDDanhMuc;
  private String TenDanhMuc;
  private String MoTaDanhMuc;

  // Constructor, getters, setters

  public DanhMucSanPham(int IDDanhMuc, String tenDanhMuc, String moTaDanhMuc) {
    this.IDDanhMuc = IDDanhMuc;
    TenDanhMuc = tenDanhMuc;
    MoTaDanhMuc = moTaDanhMuc;
  }

  public int getIDDanhMuc() {
    return IDDanhMuc;
  }

  public void setIDDanhMuc(int IDDanhMuc) {
    this.IDDanhMuc = IDDanhMuc;
  }

  public String getTenDanhMuc() {
    return TenDanhMuc;
  }

  public void setTenDanhMuc(String tenDanhMuc) {
    TenDanhMuc = tenDanhMuc;
  }

  public String getMoTaDanhMuc() {
    return MoTaDanhMuc;
  }

  public void setMoTaDanhMuc(String moTaDanhMuc) {
    MoTaDanhMuc = moTaDanhMuc;
  }
}

