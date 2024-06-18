package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.response.DonHangResponse;
import model.response.Item;
import model.service.DonHangService;
import view.HomeView;

public class DonHangController {

  private final HomeView homeView;
  private final DonHangService donHangService;

  private final HoaDonController hoaDonController;

  private final KhoHangController khoHangController;

  private final ChiTietDonHangController chiTietDonHangController;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


  public DonHangController(HomeView homeView, DonHangService donHangService,
      HoaDonController hoaDonController, KhoHangController khoHangController, ChiTietDonHangController chiTietDonHangController) {
    this.homeView = homeView;
    this.donHangService = donHangService;
    this.hoaDonController = hoaDonController;
    this.khoHangController = khoHangController;
    this.chiTietDonHangController = chiTietDonHangController;
    findByAll();
    addDonHangAndCtdhAndHoaDon();
    deleteDonHang();
    updateDonHang();
    timKiemDonHang();
    loadDonHang();
  }

  //method hien thi don hang
  public void findByAll() {
    List<DonHangResponse> donHangList = donHangService.getAllDonHang();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_donhang().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (DonHangResponse dh : donHangList) {
      Object[] row = {
          dh.getIDDonHang(),
          dateFormat.format(dh.getNgayTaoDonHang()),
          NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(dh.getTongTienDonHang()),
          dh.getTrangThaiDonHang(),
          dh.getTenNguoiMua()
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }

  public void addDonHangAndCtdhAndHoaDon() {
    homeView.getBtnAdddonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String ngayTaoDonHang = dateFormat.format(new Date());
          String selectedTrangThai = (String) homeView.getCbTrangthaidonhang().getSelectedItem();
          Item selectKhangHang = (Item) homeView.getCbtenKhachhangdonhang().getSelectedItem();
          int idKhachHang = selectKhangHang.getId();
          Item selectSanPham = (Item) homeView.getCbTensanphamdonhang().getSelectedItem();
          int idSanPham = selectSanPham.getId();
          int soLuong = Integer.parseInt(homeView.getTfSoluongdonhang().getText());
          Item selectGiaBan = (Item) homeView.getCbGiaBandonhang().getSelectedItem();
          double giaBan = Double.parseDouble(selectGiaBan.getName());
          double tongTien = soLuong * giaBan;
          double tongtienHoaDon = tongTien; // Assuming the total invoice amount is the same as the total order amount
          String ngayTaoHoaDon = dateFormat.format(new Date());
          donHangService.addDonHangAndCtdhAndHoaDon(ngayTaoDonHang, selectedTrangThai, idKhachHang,
              idSanPham, soLuong, giaBan, tongTien, tongtienHoaDon, ngayTaoHoaDon);
          findByAll();
          hoaDonController.findByAllHoaDon();
          khoHangController.loadKhoHang();
          chiTietDonHangController.findByAll();
          JOptionPane.showMessageDialog(homeView, "Thêm đơn hàng thành công");
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(homeView, "Lỗi khi thêm đơn hàng: " + ex.getMessage(),
              "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }
  //method xoa don hang
  public void deleteDonHang() {
    homeView.getBtnDeletedonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          int row = homeView.getTable_donhang().getSelectedRow();
          if(row == -1) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng chọn đơn hàng cần xóa");
            return;
          }
          int IDDonHang = (int) homeView.getTable_donhang().getValueAt(row, 0);
          donHangService.deleteDonHang(IDDonHang);
          findByAll();
          hoaDonController.findByAllHoaDon();
          khoHangController.loadKhoHang();
          chiTietDonHangController.findByAll();
          JOptionPane.showMessageDialog(homeView, "Xóa đơn hàng thành công");
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(homeView, "Lỗi khi xóa đơn hàng: " + ex.getMessage(),
              "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }
  //update don hang trang thai don hang , neu update cacs truong khac ngoai trang thai thi bao ko duoc cap nhat truong do
  public void updateDonHang() {
    homeView.getBtnEditdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          int row = homeView.getTable_donhang().getSelectedRow();
          if(row == -1) {
            JOptionPane.showMessageDialog(homeView, "Vui lòng chọn đơn hàng cần cập nhật");
            return;
          }
          int IDDonHang = (int) homeView.getTable_donhang().getValueAt(row, 0);
          String selectedTrangThai = (String) homeView.getCbTrangthaidonhang().getSelectedItem();
          donHangService.updateDonHang(selectedTrangThai, IDDonHang);
          findByAll();
          hoaDonController.findByAllHoaDon();
          khoHangController.loadKhoHang();
          chiTietDonHangController.findByAll();
          JOptionPane.showMessageDialog(homeView, "Cập nhật đơn hàng thành công");
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(homeView, "Lỗi khi cập nhật đơn hàng: " + ex.getMessage(),
              "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }
  //method tim kiem don hang
  public void timKiemDonHang() {
    homeView.getBtnSearchdonhang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String search = homeView.getTfSearchdonhang().getText();
          List<DonHangResponse> donHangList = donHangService.searchDonHang(search);
          DefaultTableModel model = (DefaultTableModel) homeView.getTable_donhang().getModel();
          model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

          for (DonHangResponse dh : donHangList) {
            Object[] row = {
                dh.getIDDonHang(),
                dateFormat.format(dh.getNgayTaoDonHang()),
                NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(dh.getTongTienDonHang()),
                dh.getTrangThaiDonHang(),
                dh.getTenNguoiMua()
            };
            model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
          }
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(homeView, "Lỗi khi tìm kiếm đơn hàng: " + ex.getMessage(),
              "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }
  //method load danh sach don hang
  public void loadDonHang() {
    homeView.getBtnDonHang().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        findByAll();
      }
    });
  }
}
