package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entity.DanhMucSanPham;
import model.response.Item;
import model.service.DanhMucService;
import view.HomeView;

public class DanhMucController {

  private final HomeView homeView;
  private final DanhMucService danhMucService;

  public DanhMucController(HomeView homeView, DanhMucService danhMucService) {
    this.homeView = homeView;
    this.danhMucService = danhMucService;
    findAllDanhMuc();
    addDanhMuc();
    deleteDanhMuc();
    updateDanhMuc();
    clickMouse();
    exit();
    refreshDanhMucList();
  }

  //method all danh muc
  public void findAllDanhMuc() {
    List<DanhMucSanPham> danhMucSanPhams = danhMucService.getAllDanhMuc();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_danhmuc().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (DanhMucSanPham dm : danhMucSanPhams) {
      Object[] row = {
          dm.getIDDanhMuc(),
          dm.getTenDanhMuc(),
          dm.getMoTaDanhMuc()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  //method them
  public void addDanhMuc() {
    homeView.getBtnAdd1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (homeView.getTfTenDanhmuc().getText().isEmpty() || homeView.getTfMotadanhmuc()
              .getText().isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng nhập đầy đủ thông tin");
            return;
          }
          String TenDanhMuc = homeView.getTfTenDanhmuc().getText();
          String MoTaDanhMuc = homeView.getTfMotadanhmuc().getText();
          danhMucService.addDanhMuc(TenDanhMuc, MoTaDanhMuc);
          JOptionPane.showMessageDialog(homeView, "Thêm sản phẩm thành công");
          homeView.clearDanhMuc();
          findAllDanhMuc();
          refreshDanhMucList();
        } catch (Exception e2) {
          JOptionPane.showMessageDialog(homeView, "Thêm sản phẩm thất bại");
        }
      }
    });
  }

  //method xoa
  public void deleteDanhMuc() {
    homeView.getBtnDelete1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_danhmuc().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn danh mục cần xóa");
        } else {
          int IDDanhMuc = (int) homeView.getTable_danhmuc().getValueAt(row, 0);
          danhMucService.deleteDanhMuc(IDDanhMuc);
          JOptionPane.showMessageDialog(homeView, "Xóa danh mục thành công");
          homeView.clearDanhMuc();
          findAllDanhMuc();
          refreshDanhMucList();
        }
      }
    });
  }

  //method update
  public void updateDanhMuc() {
    homeView.getBtnEdit1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_danhmuc().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn danh mục cần cập nhật");
        } else {
          int IDDanhMuc = (int) homeView.getTable_danhmuc().getValueAt(row, 0);
          String TenDanhMuc = homeView.getTfTenDanhmuc().getText();
          String MoTaDanhMuc = homeView.getTfMotadanhmuc().getText();
          danhMucService.updateDanhMuc(IDDanhMuc, TenDanhMuc, MoTaDanhMuc);
          JOptionPane.showMessageDialog(homeView, "Cập nhật danh mục thành công");
          homeView.clearDanhMuc();
          findAllDanhMuc();
          refreshDanhMucList();
        }
      }
    });
  }

  //method click mouse
  public void clickMouse() {
    homeView.getTable_danhmuc().addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = homeView.getTable_danhmuc().getSelectedRow();
        homeView.getTfTenDanhmuc()
            .setText(homeView.getTable_danhmuc().getValueAt(row, 1).toString());
        homeView.getTfMotadanhmuc()
            .setText(homeView.getTable_danhmuc().getValueAt(row, 2).toString());
      }
    });
  }

  //method thoat
  public void exit() {
    homeView.getBtnExit1().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  public void refreshDanhMucList() {
    // Clear the JComboBox
    JComboBox<Item> CbTenDanhMuc = homeView.getCbTenDanhMuc();
    CbTenDanhMuc.removeAllItems();
    // Get the updated list of DanhMuc
    List<Item> updatedDanhMucNames = danhMucService.getDanhMucList();
    // Repopulate the JComboBox
    for (Item item : updatedDanhMucNames) {
      CbTenDanhMuc.addItem(item);
    }
  }
}
