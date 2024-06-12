package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
  }

  public void loadSanPham() {
    homeView.getBtnSanPham().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<SanPhamResponse> sanPhams = sanPhamService.findAllSanPham();
        DefaultTableModel model = (DefaultTableModel) homeView.getTable().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        for (SanPhamResponse sp : sanPhams) {
          Object[] row = {
              sp.getIDSanPham(),
              sp.getMaSanPham(),
              sp.getTenSanPham(),
              currencyFormat.format(sp.getGiaBanRa()),
              currencyFormat.format(sp.getGiaNhap()),
              sp.getMoTa(),
              dateFormat.format(sp.getThoiGianNhap()),
              sp.getTenDanhMuc(),
              sp.getTenNhaCungCap()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
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
          String MaSanPham = homeView.getTfMasanpham().getText();
          String TenSanPham = homeView.getTfTensanpham().getText();
          double GiaBanRa = Double.parseDouble(homeView.getTfGiaBan().getText());
          double GiaNhap = Double.parseDouble(homeView.getTfGiaNhap().getText());
          String MoTa = homeView.getTfMoTa().getText();

          Item selectedDanhMuc = (Item) homeView.getCbTenDanhMuc().getSelectedItem();
          int IDDanhMuc = selectedDanhMuc.getId();

          Item selectedNhaCungCap = (Item) homeView.getCbTenNhaCungCap().getSelectedItem();
          int IDNhaCungCap = selectedNhaCungCap.getId();

          sanPhamService.them(MaSanPham, TenSanPham, GiaBanRa, GiaNhap, MoTa, IDDanhMuc, IDNhaCungCap);
          JOptionPane.showMessageDialog(homeView, "Thêm sản phẩm thành công");
          loadSanPham(); // Load lại bảng sản phẩm sau khi thêm
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(homeView, "Giá bán và giá nhập phải là số");
        }
      }
    });
  }
}
