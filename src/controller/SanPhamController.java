package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import model.response.SanPhamResponse;
import model.service.SanPhamService;
import view.HomeView;

public class SanPhamController {

  private final SanPhamService sanPhamService;
  private final HomeView homeView;

  public SanPhamController(SanPhamService sanPhamService, HomeView homeView) {
    this.sanPhamService = sanPhamService;
    this.homeView = homeView;
    loadSanPham();
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
              sp.getThoiGianNhap(),
              sp.getTenDanhMuc(),
              sp.getTenNhaCungCap()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
}
