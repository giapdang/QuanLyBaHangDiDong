package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.response.DonHangResponse;
import model.response.Item;
import model.service.DonHangService;
import view.HomeView;

public class DonHangController {

  private final HomeView homeView;
  private final DonHangService donHangService;

  private  final HoaDonController hoaDonController;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


  public DonHangController(HomeView homeView, DonHangService donHangService, HoaDonController hoaDonController) {
    this.homeView = homeView;
    this.donHangService = donHangService;
    this.hoaDonController = hoaDonController;
    findByAll();
    exit();
    addDonHangAndCtdhAndHoaDon();
  }

  //method hien thi don hang
  public void findByAll() {
    List<DonHangResponse> donHangList = donHangService.getAllDonHang();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_donhang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

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

//  //method exit
//  public void exit() {
//    homeView.getBtnExitdonhang().addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        System.exit(0);
//      }
//    });
//  }

  public void addDonHangAndCtdhAndHoaDon() {
    homeView.getBtnAdddonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String ngayTaoDonHang = dateFormat.format(new Date());
          String selectedTrangThai = (String) homeView.getCbTrangthaidonhang().getSelectedItem();
          Item selectKhangHang = (Item) homeView.getCbtenKhachhangdonhang().getSelectedItem();
          int idKhachHang = selectKhangHang.getId();
          Item selectSanPham = (Item) homeView.getCbTensanphamdonhang().getSelectedItem();
          int idSanPham = selectSanPham.getId();
          int soLuong = Integer.parseInt(homeView.getTfSoluongdonhang().getText());
          Item selectGiaBan = (Item) homeView.getCbGiaBandonhang().getSelectedItem();
          double giaBan = Double.parseDouble(selectGiaBan.getName());
          double tongTien = soLuong * giaBan;
          double tongtienHoaDon = tongTien; // Assuming the total invoice amount is the same as the total order amount
          String ngayTaoHoaDon = dateFormat.format(new Date());
          donHangService.addDonHangAndCtdhAndHoaDon(ngayTaoDonHang,selectedTrangThai, idKhachHang,
              idSanPham, soLuong, giaBan, tongTien, tongtienHoaDon, ngayTaoHoaDon);
          findByAll();
          hoaDonController.findByAllHoaDon();
          JOptionPane.showMessageDialog(homeView, "Thêm đơn hàng thành công");
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(homeView, "Lỗi khi thêm đơn hàng: " + ex.getMessage(),
              "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

}
