package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.response.FormHoadon;
import model.response.HoaDonResponse;
import model.service.HoaDonService;
import view.HomeView;

public class HoaDonController {

  private final HomeView homeView;
  private final HoaDonService hoaDonService;

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

  public HoaDonController(HomeView homeView, HoaDonService hoaDonService) {
    this.homeView = homeView;
    this.hoaDonService = hoaDonService;
    findByAllHoaDon();
    timKiemHoaDon();
    refresh();
    viewHoaDon();
  }

  //method to get all bill hoa don response
  public void findByAllHoaDon() {
    List<HoaDonResponse> hoaDonList = hoaDonService.getAllHoaDon();
    DefaultTableModel model = (DefaultTableModel) homeView.getTable_hoadon().getModel();
    model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

    for (HoaDonResponse hd : hoaDonList) {
      Object[] row = {
          hd.getIDHoaDon(),
          hd.getTenKhachHang(),
          hd.getDiaChi(),
          hd.getEmail(),
          hd.getSoDienThoai(),
          hd.getSanPhamChiTiet(),
          NumberFormat.getCurrencyInstance().format(hd.getTongTienDonHang()),
          dateFormat.format(hd.getNgayThanhToan())
      };
      model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
    }
  }
  //method tim kiem hoa don
  public void timKiemHoaDon() {
    homeView.getBtnSearchhoadon().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String search = homeView.getTfSearchhoadon().getText();
        List<HoaDonResponse> hoaDonList = hoaDonService.searchHoaDon(search);
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_hoadon().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (HoaDonResponse hd : hoaDonList) {
          Object[] row = {
              hd.getIDHoaDon(),
              hd.getTenKhachHang(),
              hd.getDiaChi(),
              hd.getEmail(),
              hd.getSoDienThoai(),
              hd.getSanPhamChiTiet(),
              NumberFormat.getCurrencyInstance().format(hd.getTongTienDonHang()),
              dateFormat.format(hd.getNgayThanhToan())
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
  //method refresh
  public void refresh() {
    homeView.getBtnHoaDon().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        homeView.getTfSearchhoadon().setText("");
        findByAllHoaDon();
      }
    });
  }

  //method view hoa don FormHoaDon
  public void viewHoaDon() {
    homeView.getTable_hoadon().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        String row = String.valueOf(homeView.getTable_hoadon().getSelectedRow());
        String name = (String) homeView.getTable_hoadon().getValueAt(Integer.parseInt(row), 1);

        //lay thong tin hoa don theo IDHoaDon
        HoaDonResponse hoaDon = hoaDonService.findById(name);

        //dat thong tin hoa don vao form hoa don
        FormHoadon formHoadon = new FormHoadon();
        formHoadon.getThongtin_sohoadon().setText(String.valueOf(hoaDon.getIDHoaDon()));
        formHoadon.getThongtin_hovatenkhachhang().setText(hoaDon.getTenKhachHang());
        formHoadon.getThongtin_diachikhachhang().setText(hoaDon.getDiaChi());
        formHoadon.getThongtin_ngaytao().setText(dateFormat.format(new Date()));
        formHoadon.getThongtin_sdtkhachhang().setText(hoaDon.getSoDienThoai());
        formHoadon.getThongtin_tongtien().setText(NumberFormat.getCurrencyInstance().format(hoaDon.getTongTienDonHang()));

        //phan tach SanPhamChiTiet va them vao bang
        String[] sanPhamChiTiets = hoaDon.getSanPhamChiTiet().split(";");
        DefaultTableModel model = (DefaultTableModel) formHoadon.getBang_chitietdonhang().getModel();
        model.setRowCount(0); //clear table
        for (String sanPhamChiTiet : sanPhamChiTiets) {
          String[] chiTiet = sanPhamChiTiet.split(", ");
          String tenSanPham = chiTiet[0].split(": ")[1];
          String maSanPham = chiTiet[1].split(": ")[1];
          String soLuong = chiTiet[2].split(": ")[1];
          String giaBan = chiTiet[3].split(": ")[1];
          String tongTienDonHang = chiTiet[4].split(": ")[1];
          model.addRow(new Object[]{tenSanPham, maSanPham, soLuong, giaBan, tongTienDonHang});
        }
        formHoadon.setVisible(true);
      }
    });
  }
}
