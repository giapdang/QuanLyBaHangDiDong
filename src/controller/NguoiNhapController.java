package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entity.NguoiNhap;
import model.response.Item;
import model.service.NguoiNhapService;
import view.HomeView;

public class NguoiNhapController {

  private final HomeView homeView;
  private final NguoiNhapService nguoiNhapService;

  public NguoiNhapController(HomeView homeView, NguoiNhapService nguoiNhapService) {
    this.homeView = homeView;
    this.nguoiNhapService = nguoiNhapService;
    showAllNguoiNhap();
    themNguoiNhap();
  }

  //method hiem thi tat ca nguoi nhap
  public void showAllNguoiNhap() {
    homeView.getBtnNhanVien().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<NguoiNhap> nguoiNhapList = nguoiNhapService.getAllNguoiNhap();
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_nhanvien().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (NguoiNhap nguoiNhap : nguoiNhapList) {
          Object[] row = {
              nguoiNhap.getIDNguoiNhap(),
              nguoiNhap.getTenNguoiNhap(),
              nguoiNhap.getEmail(),
              nguoiNhap.getMatKhau(),
              nguoiNhap.getSoDienThoai()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }

  //method them nguoi nhap
  public void themNguoiNhap() {
    homeView.getBtnAddnv().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (homeView.getTfTenNhanVien().getText().isEmpty() || homeView.getTfEmailNhanVien()
              .getText().isEmpty()
              || homeView.getTfmatkhauNhanVien().getText().isEmpty()
              || homeView.getTfSodienthoaiNhanVien().getText().isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng nhập đầy đủ thông tin");
            return;
          }
          String tenNguoiNhap = homeView.getTfTenNhanVien().getText();
          String email = homeView.getTfEmailNhanVien().getText();
          String matKhau = homeView.getTfmatkhauNhanVien().getText();
          String soDienThoai = homeView.getTfSodienthoaiNhanVien().getText();
          nguoiNhapService.addNguoiNhap(tenNguoiNhap, email, matKhau, soDienThoai);
          JOptionPane.showMessageDialog(homeView, "Thêm người nhập thành công");
          showAllNguoiNhap();
          refreshDanhMucList();
        } catch (Exception ex) {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(homeView, "Thêm người nhập thất bại");
        }
      }
    });
  }

  //method refresh
  public void refreshDanhMucList() {
    // Clear the JComboBox
    JComboBox<Item> CbTenNhanVien = homeView.getCbNguoiNhap();
    CbTenNhanVien.removeAllItems();
    // Get the updated list of DanhMuc
    List<Item> updatedNhanVienNames = nguoiNhapService.getTenNhanVienList();
    // Repopulate the JComboBox
    for (Item item : updatedNhanVienNames) {
      CbTenNhanVien.addItem(item);
    }
  }
}
