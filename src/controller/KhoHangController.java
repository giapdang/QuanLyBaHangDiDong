package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    clickMouse();
    exit();
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

  //method click chuot
  public void clickMouse() {
    homeView.getTable_khohang().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int i = homeView.getTable_khohang().getSelectedRow();
        homeView.getTfTensanphamkhohang()
            .setText(homeView.getTable_khohang().getModel().getValueAt(i, 1).toString());
        homeView.getTfSoluongkhohang()
            .setText(homeView.getTable_khohang().getModel().getValueAt(i, 2).toString());
        homeView.getTfNgaynhapkhohang()
            .setText(homeView.getTable_khohang().getModel().getValueAt(i, 3).toString());

        for (int j = 0; j < homeView.getCbTenNhaCungCapkhohang().getItemCount(); j++) {
          if (homeView.getCbTenNhaCungCapkhohang().getItemAt(j).toString()
              .equals(homeView.getTable_khohang().getModel().getValueAt(i, 4).toString())) {
            homeView.getCbTenNhaCungCapkhohang().setSelectedIndex(j);
          }
        }

        for (int j = 0; j < homeView.getCbTenNguoiNhapkhohang().getItemCount(); j++) {
          if (homeView.getCbTenNguoiNhapkhohang().getItemAt(j).toString()
              .equals(homeView.getTable_khohang().getModel().getValueAt(i, 5).toString())) {
            homeView.getCbTenNguoiNhapkhohang().setSelectedIndex(j);
          }
        }
      }
    });
  }

  //method exit
  public void exit() {
    homeView.getBtnExitkhohang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
