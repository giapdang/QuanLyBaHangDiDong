package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.response.ChiTietDonHangResponse;
import model.service.ChiTietDonHangService;
import view.HomeView;

public class ChiTietDonHangController {

  private final HomeView homeView;
  private final ChiTietDonHangService chiTietDonHangService;

  private final KhoHangController khoHangController;

  public ChiTietDonHangController(HomeView homeView, ChiTietDonHangService chiTietDonHangService,
      KhoHangController khoHangController) {
    this.homeView = homeView;
    this.chiTietDonHangService = chiTietDonHangService;
    this.khoHangController = khoHangController;
    findByAll();
    clickMouse();
    updateChiTietDonHang();
    searchChiTietDonHang();
    loadChiTietDonHang();
  }

  //method hien thi chi tiet don hang
  public void findByAll() {
    List<ChiTietDonHangResponse> chiTietDonHangList = chiTietDonHangService.getAllChiTietDonHang();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_chitietdonhang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (ChiTietDonHangResponse ctdh : chiTietDonHangList) {
      Object[] row = {
          ctdh.getIDChiTietDonHang(),
          ctdh.getIDDonHang(),
          ctdh.getTenSanPham(),
          ctdh.getTenKhachHang(),
          ctdh.getSoLuong(),
          NumberFormat.getCurrencyInstance().format(ctdh.getGiaBan())
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  //method update chi tiet don hang
  public void updateChiTietDonHang() {
    homeView.getBtnEditchitietdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_chitietdonhang().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn chi tiết đơn hàng cần cập nhật");
        } else {
          int IDChiTietDonHang = Integer.parseInt(
              homeView.getTable_chitietdonhang().getValueAt(row, 0).toString());
          int SoLuong = Integer.parseInt(homeView.getTfSoluongchitietdonhang().getText());
          chiTietDonHangService.updateSoLuongChiTietDonHang(IDChiTietDonHang, SoLuong);
          JOptionPane.showMessageDialog(homeView, "Cập nhật chi tiết đơn hàng thành công");
          findByAll();
          khoHangController.loadKhoHang();
        }
      }
    });
  }

  //method click mouse
  public void clickMouse() {
    homeView.getTable_chitietdonhang().addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = homeView.getTable_chitietdonhang().getSelectedRow();
        homeView.getTfiddonhang_chitietdonhang().setText(homeView.getTable_chitietdonhang().getValueAt(row, 1).toString());
        homeView.getTfTensanphamchitietdonhang().setText(homeView.getTable_chitietdonhang().getValueAt(row, 2).toString());
        homeView.getTfTenkhachhangchitietdonhang().setText(homeView.getTable_chitietdonhang().getValueAt(row, 3).toString());
        homeView.getTfSoluongchitietdonhang().setText(homeView.getTable_chitietdonhang().getValueAt(row, 4).toString());
        String giaBan = homeView.getTable_chitietdonhang().getValueAt(row, 5).toString().replace(".", "")
            .replace("₫", "").trim();
        homeView.getTfGiabanchitietdonhang().setText(giaBan);
      }
    });
  }
  //method tim kiem chi tiet don hang
  public void searchChiTietDonHang() {
    homeView.getBtnSearchchitietdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String search = homeView.getTfSearchchitietdonhang().getText();
        List<ChiTietDonHangResponse> chiTietDonHangList = chiTietDonHangService.searchChiTietDonHang(search);
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_chitietdonhang().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (ChiTietDonHangResponse ctdh : chiTietDonHangList) {
          Object[] row = {
              ctdh.getIDChiTietDonHang(),
              ctdh.getIDDonHang(),
              ctdh.getTenSanPham(),
              ctdh.getTenKhachHang(),
              ctdh.getSoLuong(),
              NumberFormat.getCurrencyInstance().format(ctdh.getGiaBan())
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
  //method load chi tiet don hang
  public void loadChiTietDonHang() {
    homeView.getBtnChitietdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        findByAll();
      }
    });
  }
}
