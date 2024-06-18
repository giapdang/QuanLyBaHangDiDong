package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entity.NhaCungCapSanPham;
import model.response.Item;
import model.service.NhaCungCapService;
import view.HomeView;

public class NhaCungCapController {

  private final HomeView homeView;
  private final NhaCungCapService nhaCungCapService;

  public NhaCungCapController(HomeView homeView, NhaCungCapService nhaCungCapService) {
    this.homeView = homeView;
    this.nhaCungCapService = nhaCungCapService;
    showAllNhaCungCap();
    refreshNhaCungCapList();
    updateNhaCungCap();
    clickMouse();
    addNhaCungCap();
    deleteNhaCungCap();
    timKiemNhaCungCap();
    loadNhaCungCap();
  }

  //method hien thi tat ca nha cung cap
  public void showAllNhaCungCap() {
    List<NhaCungCapSanPham> nhaCungCapList = nhaCungCapService.getAllNhaCungCap();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_nhacungcap().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (NhaCungCapSanPham ncc : nhaCungCapList) {
      Object[] row = {
          ncc.getIDNhaCungCap(),
          ncc.getTenNhaCungCap(),
          ncc.getDiaChi(),
          ncc.getSoDienThoai()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  //method refresh
  public void refreshNhaCungCapList() {
    // Clear the JComboBox
    JComboBox<Item> CbTenNhaCungCap = homeView.getCbTenNhaCungCap();
    CbTenNhaCungCap.removeAllItems();
    // Get the updated list of DanhMuc
    List<Item> updatedNhaCungCapNames = nhaCungCapService.getAllTenNhaCungCap();
    // Repopulate the JComboBox
    for (Item item : updatedNhaCungCapNames) {
      CbTenNhaCungCap.addItem(item);
    }
  }


  //method update nha cung cap
  public void updateNhaCungCap() {
    homeView.getBtnEditncc().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_nhacungcap().getSelectedRow();
        if(row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn nhà cung cấp cần sửa");
        } else {
          try {
            Item item = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
            int IDNhaCungCap = item.getId();
            String TenNhaCungCap = homeView.getTfTenNhaCungCap1().getText();
            String DiaChi = homeView.getTfDiachi().getText();
            String SoDienThoai = homeView.getTfSodienthoai().getText();
            nhaCungCapService.updateNhaCungCap(IDNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai);
            showAllNhaCungCap();
            refreshNhaCungCapList();
            homeView.clearNhaCungCap();
            JOptionPane.showMessageDialog(homeView, "Sửa nhà cung cấp thành công");
          } catch (Exception e2) {
            JOptionPane.showMessageDialog(homeView, "Sửa nhà cung cấp thất bại");
            e2.printStackTrace();
          }
        }
      }
    });
  }

  //method click chuot
  public void clickMouse() {
    homeView.getTable_nhacungcap().addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = homeView.getTable_nhacungcap().getSelectedRow();
        Item item = new Item((int) homeView.getTable_nhacungcap().getValueAt(row, 0),
            (String) homeView.getTable_nhacungcap().getValueAt(row, 1));
        homeView.getCbTenNhaCungCap().getModel().setSelectedItem(item);
        homeView.getTfTenNhaCungCap1()
            .setText((String) homeView.getTable_nhacungcap().getValueAt(row, 1));
        homeView.getTfDiachi().setText((String) homeView.getTable_nhacungcap().getValueAt(row, 2));
        homeView.getTfSodienthoai()
            .setText((String) homeView.getTable_nhacungcap().getValueAt(row, 3));
      }
    });
  }

  //method them nha cung cap
  public void addNhaCungCap() {
    homeView.getBtnAddncc().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if(homeView.getTfTenNhaCungCap1().getText().equals("") || homeView.getTfDiachi().getText().equals("") || homeView.getTfSodienthoai().getText().equals("")) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng nhập đầy đủ thông tin");
            return;
          }
          String TenNhaCungCap = homeView.getTfTenNhaCungCap1().getText();
          String DiaChi = homeView.getTfDiachi().getText();
          String SoDienThoai = homeView.getTfSodienthoai().getText();
          nhaCungCapService.addNhaCungCap(TenNhaCungCap, DiaChi, SoDienThoai);
          homeView.clearNhaCungCap();
          showAllNhaCungCap();
          refreshNhaCungCapList();
          JOptionPane.showMessageDialog(homeView, "Thêm nhà cung cấp thành công");
        } catch (Exception e2) {
          JOptionPane.showMessageDialog(homeView, "Thêm nhà cung cấp thất bại");
          e2.printStackTrace();
        }
      }
    });
  }

  //method xoa nha cung cap
  public void deleteNhaCungCap() {
    homeView.getBtnDeletencc().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable_nhacungcap().getSelectedRow();
        if(row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn nhà cung cấp cần xóa");
        } else {
          try {
            Item item = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
            int IDNhaCungCap = item.getId();
            nhaCungCapService.deleteNhaCungCap(IDNhaCungCap);
            showAllNhaCungCap();
            refreshNhaCungCapList();
            JOptionPane.showMessageDialog(homeView, "Xóa nhà cung cấp thành công");
            homeView.clearNhaCungCap();
          } catch (Exception e2) {
            JOptionPane.showMessageDialog(homeView, "Xóa nhà cung cấp thất bại");
            e2.printStackTrace();
          }
        }
      }
    });
  }
  //method tim kiem nha cung cap theo ten nha cung cap va so dien thoai va dia chi nha cung cap va id nha cung cap
  public void timKiemNhaCungCap() {
    homeView.getBtnSearchnhacungcap().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String search = homeView.getTfSearchnhacungcap().getText();
        List<NhaCungCapSanPham> nhaCungCapList = nhaCungCapService.searchNhaCungCap(search);
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_nhacungcap().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (NhaCungCapSanPham ncc : nhaCungCapList) {
          Object[] row = {
              ncc.getIDNhaCungCap(),
              ncc.getTenNhaCungCap(),
              ncc.getDiaChi(),
              ncc.getSoDienThoai()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }

  //method load danh sach nha cung cap
  public void loadNhaCungCap() {
    homeView.getBtnNhaCungCap().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        showAllNhaCungCap();
      }
    });
  }
}
