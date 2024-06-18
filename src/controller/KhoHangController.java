package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.response.KhoHangResponse;
import model.service.KhoHangService;
import view.HomeView;

public class KhoHangController {

  private final HomeView homeView;

  private final KhoHangService khoHangService;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  public KhoHangController(HomeView homeView, KhoHangService khoHangService) {
    this.homeView = homeView;
    this.khoHangService = khoHangService;
    loadKhoHang();
    timKiemKhoHang();
    refresh();
  }

  //method hiem thi kho hang
  public void loadKhoHang() {
    List<KhoHangResponse> khoHangList = khoHangService.getAllKhoHang();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_khohang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (KhoHangResponse kh : khoHangList) {
      Object[] row = {
          kh.getIDKho(),
          kh.getTenSanPham(),
          kh.getSoLuongTonKho(),
          dateFormat.format(kh.getNgayNhapKho()),
          kh.getTenNhaCungCap(),
          kh.getTenNguoiNhap()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  //method tim kiem kho hang
public void timKiemKhoHang() {
    homeView.getBtnSearchkhohang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String search = homeView.getTfSearchkhohang().getText();
        List<KhoHangResponse> khoHangList = khoHangService.searchKhoHang(search);
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_khohang().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (KhoHangResponse kh : khoHangList) {
          Object[] row = {
              kh.getIDKho(),
              kh.getTenSanPham(),
              kh.getSoLuongTonKho(),
              dateFormat.format(kh.getNgayNhapKho()),
              kh.getTenNhaCungCap(),
              kh.getTenNguoiNhap()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
  //method refresh
  public void refresh() {
    homeView.getBtnKhoHang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        loadKhoHang();
      }
    });
  }
}
