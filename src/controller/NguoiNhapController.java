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
    update();
    clickMouse();
    delete();
    searchNguoiNhap();
    loadNguoiNhap();
  }

  //method load nguoi nhap
  public void loadNguoiNhap() {
    homeView.getBtnNhanVien().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showAllNguoiNhap();
      }
    });
  }

  //method hiem thi tat ca nguoi nhap
  public void showAllNguoiNhap() {
    List<NguoiNhap> nguoiNhapList = nguoiNhapService.getAllNguoiNhap();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_nhanvien().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (NguoiNhap nn : nguoiNhapList) {
      Object[] row = {
          nn.getIDNguoiNhap(),
          nn.getTenNguoiNhap(),
          nn.getEmail(),
          nn.getMatKhau(),
          nn.getSoDienThoai()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
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
          homeView.clearNhanVien();
          showAllNguoiNhap();
          refreshDanhMucList();
        } catch (Exception ex) {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(homeView, "Thêm người nhập thất bại");
        }
      }
    });
  }

  //method update nguoi nhap
  public void update() {
    homeView.getBtnEditnv().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_nhanvien().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn người nhập cần sửa");
        } else {
          try {
            int IDNguoiNhap = (int) homeView.getTable_nhanvien().getValueAt(row, 0);
            String TenNguoiNhap = homeView.getTfTenNhanVien().getText();
            String Email = homeView.getTfEmailNhanVien().getText();
            String MatKhau = homeView.getTfmatkhauNhanVien().getText();
            String SoDienThoai = homeView.getTfSodienthoaiNhanVien().getText();
            nguoiNhapService.updateNguoiNhap(IDNguoiNhap, TenNguoiNhap, Email, MatKhau, SoDienThoai);
            JOptionPane.showMessageDialog(homeView, "Sửa người nhập thành công");
            homeView.clearNhanVien();
            showAllNguoiNhap();
            refreshDanhMucList();
          } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(homeView, "Sửa người nhập thất bại");
          }
        }
      }
    });
  }

  //method delete nguoi nhap
  public void delete() {
    homeView.getBtnDeletenv().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_nhanvien().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn người nhập cần xóa");
        } else {
          try {
            int IDNguoiNhap = (int) homeView.getTable_nhanvien().getValueAt(row, 0);
            nguoiNhapService.deleteNguoiNhap(IDNguoiNhap);
            JOptionPane.showMessageDialog(homeView, "Xóa người nhập thành công");
            homeView.clearNhanVien();
            showAllNguoiNhap();
            refreshDanhMucList();
          } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(homeView, "Xóa người nhập thất bại");
          }
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
  //method click mouse
  public void clickMouse() {
    homeView.getTable_nhanvien().addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = homeView.getTable_nhanvien().getSelectedRow();
        homeView.getTfTenNhanVien().setText(homeView.getTable_nhanvien().getValueAt(row, 1).toString());
        homeView.getTfEmailNhanVien().setText(homeView.getTable_nhanvien().getValueAt(row, 2).toString());
        homeView.getTfmatkhauNhanVien().setText(homeView.getTable_nhanvien().getValueAt(row, 3).toString());
        homeView.getTfSodienthoaiNhanVien().setText(homeView.getTable_nhanvien().getValueAt(row, 4).toString());
      }
    });
  }
  //method tim kiem nguoi nhap theo ten hoac so dien thoai hoac email hoac id
  //method tim kiem nguoi nhap theo ten hoac so dien thoai hoac email hoac id
  public void searchNguoiNhap() {
    homeView.getBtnSearchnhanvien().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String search = homeView.getTfSearchnhanvien().getText();
        List<NguoiNhap> nguoiNhapList = nguoiNhapService.searchNguoiNhap(search);
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_nhanvien().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (NguoiNhap nn : nguoiNhapList) {
          Object[] row = {
              nn.getIDNguoiNhap(),
              nn.getTenNguoiNhap(),
              nn.getEmail(),
              nn.getMatKhau(),
              nn.getSoDienThoai()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
}
