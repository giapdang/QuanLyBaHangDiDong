package model.response;

import java.util.Date;
import model.entity.DonHang;

public class DonHangResponse extends DonHang {

  private String tenNguoiMua;

  public DonHangResponse(int IDDonHang, Date ngayTaoDonHang, double tongTienDonHang,
      String trangThaiDonHang, int IDKhachHang, String tenNguoiMua) {
    super(IDDonHang, ngayTaoDonHang, tongTienDonHang, trangThaiDonHang, IDKhachHang);
    this.tenNguoiMua = tenNguoiMua;
  }

  public String getTenNguoiMua() {
    return tenNguoiMua;
  }

  public void setTenNguoiMua(String tenNguoiMua) {
    this.tenNguoiMua = tenNguoiMua;
  }
}
