package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.response.DonHangResponse;
import model.service.DonHangService;
import view.HomeView;

public class DonHangController {

  private final HomeView homeView;
  private final DonHangService donHangService;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


  public DonHangController(HomeView homeView, DonHangService donHangService) {
    this.homeView = homeView;
    this.donHangService = donHangService;
    getAllDonHang();
    exit();
  }

  //method hien thi don hang
  public void getAllDonHang() {
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_donhang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng
    List<DonHangResponse> donHangList = donHangService.getAllDonHang();
    for (DonHangResponse dh : donHangList) {
      Object[] row = {
          dh.getIDDonHang(),
          dateFormat.format(dh.getNgayTaoDonHang()),
          NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(dh.getTongTienDonHang()),
          dh.getTrangThaiDonHang(),
          dh.getTenNguoiMua()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }
  //method exit
  public void exit() {
    homeView.getBtnExitdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
