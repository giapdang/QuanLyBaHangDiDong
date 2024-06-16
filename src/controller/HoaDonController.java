package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.response.HoaDonResponse;
import model.service.HoaDonService;
import view.HomeView;

public class HoaDonController {

  private final HomeView homeView;
  private final HoaDonService hoaDonService;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  public HoaDonController(HomeView homeView, HoaDonService hoaDonService) {
    this.homeView = homeView;
    this.hoaDonService = hoaDonService;
    findByAllHoaDon();
    exit();
  }

  //method to get all bill hoa don response
  public void findByAllHoaDon() {
    List<HoaDonResponse> hoaDonList = hoaDonService.getAllHoaDon();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_hoadon().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (HoaDonResponse hd : hoaDonList) {
      Object[] row = {
          hd.getIDHoaDon(),
          hd.getTenKhachHang(),
          hd.getDiaChi(),
          hd.getEmail(),
          hd.getSoDienThoai(),
          hd.getSanPhamChiTiet(),
          NumberFormat.getCurrencyInstance().format(hd.getTongTienDonHang()),
          dateFormat.format(hd.getNgayThanhToan())
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }
  //method exit
  public void exit() {
    homeView.getBtnExithoadon().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
