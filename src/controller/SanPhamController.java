package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.response.Item;
import model.response.SanPhamResponse;
import model.service.SanPhamService;
import view.HomeView;

public class SanPhamController {

  private final SanPhamService sanPhamService;
  private final HomeView homeView;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  public SanPhamController(SanPhamService sanPhamService, HomeView homeView) {
    this.sanPhamService = sanPhamService;
    this.homeView = homeView;
    loadSanPham();
    deleteSanPham();
    addSanPham();
    exit();
    updateSanPham();
    clickMouse();
  }

  //method load san pham
  public void loadSanPham() {
      List<SanPhamResponse> sanPhamList = sanPhamService.findAllSanPham();
      DefaultTableModel model = (DefaultTableModel) homeView.getTable().getModel();
      model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

      for (SanPhamResponse sp : sanPhamList) {
        Object[] row = {
            sp.getIDSanPham(),
            sp.getMaSanPham(),
            sp.getTenSanPham(),
            NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sp.getGiaBanRa()),
            NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sp.getGiaNhap()),
            sp.getMoTa(),
            dateFormat.format(sp.getThoiGianNhap()),
            sp.getTenDanhMuc(),
            sp.getTenNhaCungCap()
        };
        model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
      }
    }

  public void deleteSanPham() {
    homeView.getBtnDelete().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn sản phẩm cần xóa");
        } else {
          int IDSanPham = (int) homeView.getTable().getValueAt(row, 0);
          int confirm = JOptionPane.showConfirmDialog(homeView,
              "Bạn có chắc chắn muốn xóa sản phẩm này không?");
          homeView.clearSanPham();
          if (confirm == JOptionPane.YES_OPTION) {
            sanPhamService.deleteById(IDSanPham);
            DefaultTableModel model = (DefaultTableModel) homeView.getTable().getModel();
            model.removeRow(row);
          }
        }
      }
    });
  }

  public void addSanPham() {
    homeView.getBtnAdd().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          if(homeView.getTfMasanpham().getText().isEmpty() || homeView.getTfTensanpham().getText().isEmpty()
              || homeView.getTfGiaBan().getText().isEmpty() || homeView.getTfGiaNhap().getText().isEmpty()
              || homeView.getTfMoTa().getText().isEmpty()){
            JOptionPane.showMessageDialog(homeView, "Vui lòng nhập đầy đủ thông tin");
            return;
          }
          String MaSanPham = homeView.getTfMasanpham().getText();
          String TenSanPham = homeView.getTfTensanpham().getText();
          double GiaBanRa = Double.parseDouble(homeView.getTfGiaBan().getText());
          double GiaNhap = Double.parseDouble(homeView.getTfGiaNhap().getText());
          String MoTa = homeView.getTfMoTa().getText();

          Item selectedDanhMuc = (Item) homeView.getCbTenDanhMuc().getSelectedItem();
          int IDDanhMuc = selectedDanhMuc.getId();

          Item selectedNhaCungCap = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
          int IDNhaCungCap = selectedNhaCungCap.getId();

          sanPhamService.them(MaSanPham, TenSanPham, GiaBanRa, GiaNhap, MoTa, IDDanhMuc,
              IDNhaCungCap);
          JOptionPane.showMessageDialog(homeView, "Thêm sản phẩm thành công");
          homeView.clearSanPham();
          loadSanPham(); // Load lại bảng sản phẩm sau khi thêm
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(homeView, "Giá bán và giá nhập phải là số");
        }
      }
    });
  }

  //method update
  public void updateSanPham() {
    homeView.getBtnEdit().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int row = homeView.getTable().getSelectedRow();
        if (row == -1) {
          JOptionPane.showMessageDialog(homeView, "Vui lòng chọn sản phẩm cần cập nhật");
        } else {
          int IDSanPham = (int) homeView.getTable().getValueAt(row, 0);
          String MaSanPham = homeView.getTfMasanpham().getText();
          String TenSanPham = homeView.getTfTensanpham().getText();
          double GiaBanRa = Double.parseDouble(homeView.getTfGiaBan().getText());
          double GiaNhap = Double.parseDouble(homeView.getTfGiaNhap().getText());
          String MoTa = homeView.getTfMoTa().getText();

          Item selectedDanhMuc = (Item) homeView.getCbTenDanhMuc().getSelectedItem();
          int IDDanhMuc = selectedDanhMuc.getId();

          Item selectedNhaCungCap = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
          int IDNhaCungCap = selectedNhaCungCap.getId();

          sanPhamService.update(IDSanPham, MaSanPham, TenSanPham, GiaBanRa, GiaNhap, MoTa,
              IDDanhMuc, IDNhaCungCap);
          JOptionPane.showMessageDialog(homeView, "Cập nhật sản phẩm thành công");
          homeView.clearSanPham();
          loadSanPham(); // Load lại bảng sản phẩm sau khi cập nhật
        }
      }
    });
  }

  //method click mouse
  public void clickMouse() {
    homeView.getTable().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = homeView.getTable().getSelectedRow();
        homeView.getTfMasanpham().setText(homeView.getTable().getValueAt(row, 1).toString());
        homeView.getTfTensanpham().setText(homeView.getTable().getValueAt(row, 2).toString());
        String giaBan = homeView.getTable().getValueAt(row, 3).toString().replace(".", "")
            .replace("₫", "").trim();
        homeView.getTfGiaBan().setText(giaBan);
        String giaNhap = homeView.getTable().getValueAt(row, 4).toString().replace(".", "")
            .replace("₫", "").trim();
        homeView.getTfGiaNhap().setText(giaNhap);
        homeView.getTfMoTa().setText(homeView.getTable().getValueAt(row, 5).toString());
        homeView.getTfThoiGianNhap().setText(homeView.getTable().getValueAt(row, 6).toString());

        String danhMuc = homeView.getTable().getValueAt(row, 7).toString();
        for (int i = 0; i < homeView.getCbTenDanhMuc().getItemCount(); i++) {
          if (homeView.getCbTenDanhMuc().getItemAt(i).toString().equals(danhMuc)) {
            homeView.getCbTenDanhMuc().setSelectedIndex(i);
            break;
          }
        }

        String nhaCungCap = homeView.getTable().getValueAt(row, 8).toString();
        for (int i = 0; i < homeView.getCbTenNhaCungCap().getItemCount(); i++) {
          if (homeView.getCbTenNhaCungCap().getItemAt(i).toString().equals(nhaCungCap)) {
            homeView.getCbTenNhaCungCap().setSelectedIndex(i);
            break;
          }
        }
      }
    });
  }

  //method thoat
  public void exit() {
    homeView.getBtnExit().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
