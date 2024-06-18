package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entity.KhachHang;
import model.response.Item;
import model.service.KhachHangService;
import view.HomeView;

public class KhachHangController {

  private final HomeView homeView;
  private final KhachHangService khachHangService;

  public KhachHangController(HomeView homeView, KhachHangService khachHangService) {
    this.homeView = homeView;
    this.khachHangService = khachHangService;
    allKhachHang();
    addKhachHang();
    updateKhachHang();
    delete();
    exit();
    clickMouse();
    refreshKhachHangList();
  }

  //method all thong tin khach hang
  public void allKhachHang() {
    List<KhachHang> khachHangList = khachHangService.findAll();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_khachhang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (KhachHang kh : khachHangList) {
      Object[] row = {
          kh.getIDKhachHang(),
          kh.getTenKhachHang(),
          kh.getDiaChi(),
          kh.getSoDienThoai(),
          kh.getEmail()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  //method add khach hang
  public void addKhachHang() {
    homeView.getBtnAddkh().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if (homeView.getTfTenKhachHang().getText().isEmpty() || homeView.getTfDiachiKhachHang()
              .getText().isEmpty() || homeView.getTfSodienthoaiKhachHang().getText().isEmpty()
              || homeView.getTfEmailKhachHang().getText().isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng nhập đầy đủ thông tin");
            return;
          }
          khachHangService.addKhachHang(homeView.getTfTenKhachHang().getText(),
              homeView.getTfDiachiKhachHang().getText(),
              homeView.getTfSodienthoaiKhachHang().getText(),
              homeView.getTfEmailKhachHang().getText());
          JOptionPane.showMessageDialog(homeView, "Thêm khách hàng thành công");
          homeView.clearKhachHang();
          refreshKhachHangList();
          allKhachHang();
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    });
  }

  //method delete
  public void delete() {
    homeView.getBtnDeletekh().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_khachhang().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn khách hàng cần xóa");
        } else {
          int IDDanhMuc = (int) homeView.getTable_khachhang().getValueAt(row, 0);
          khachHangService.deleteKhachHang(IDDanhMuc);
          JOptionPane.showMessageDialog(homeView, "Xóa khách hàng thành công");
          homeView.clearKhachHang();
          allKhachHang();
          refreshKhachHangList();
        }
      }
    });
  }

  //method sua thong tin khach hang
  public void updateKhachHang() {
    homeView.getBtnEditkh().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_khachhang().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn khách hàng cần sửa");
        } else {
          try {
            int IDKhachHang = (int) homeView.getTable_khachhang().getValueAt(row, 0);
            String tenKhachHang = homeView.getTfTenKhachHang().getText();
            String diaChi = homeView.getTfDiachiKhachHang().getText();
            String soDienThoai = homeView.getTfSodienthoaiKhachHang().getText();
            String email = homeView.getTfEmailKhachHang().getText();
            khachHangService.updateKhachHang(tenKhachHang, diaChi, soDienThoai, email, IDKhachHang);
            JOptionPane.showMessageDialog(homeView, "Sửa thông tin khách hàng thành công");
            homeView.clearKhachHang();
            homeView.clearKhachHang();
            refreshKhachHangList();
            allKhachHang();
          } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(homeView, "Sửa thông tin khách hàng thất bại");
          }
        }
      }
    });
  }

  //method exit
//  public void exit() {
//    homeView.getBtnExitkh().addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        System.exit(0);
//      }
//    });
//  }
  //method click mouse
  public void clickMouse() {
    homeView.getTable_khachhang().addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = homeView.getTable_khachhang().getSelectedRow();
        homeView.getTfTenKhachHang().setText(homeView.getTable_khachhang().getValueAt(row, 1).toString());
        homeView.getTfDiachiKhachHang().setText(homeView.getTable_khachhang().getValueAt(row, 2).toString());
        homeView.getTfSodienthoaiKhachHang().setText(homeView.getTable_khachhang().getValueAt(row, 3).toString());
        homeView.getTfEmailKhachHang().setText(homeView.getTable_khachhang().getValueAt(row, 4).toString());
      }
    });
  }
  //method refresh khach hang
  public void refreshKhachHangList() {
    // Clear the JComboBox
    JComboBox<Item> CbTenKhachHang = homeView.getCbtenKhachhangdonhang();
    CbTenKhachHang.removeAllItems();
    // Get the updated list of DanhMuc
    List<Item> updatedKhachHangNames = khachHangService.getIDTenKhachHang();
    // Repopulate the JComboBox
    for (Item item : updatedKhachHangNames) {
      CbTenKhachHang.addItem(item);
    }
  }

}
