package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.entity.DanhMucSanPham;
import model.service.DanhMucService;
import view.HomeView;

public class DanhMucController {

  private final HomeView homeView;

  private final DanhMucService danhMucService;

  public DanhMucController(HomeView homeView, DanhMucService danhMucService) {
    this.homeView = homeView;
    this.danhMucService = danhMucService;
    findAllDanhMuc();
  }

  //method all danh muc
  public void findAllDanhMuc() {
    homeView.getBtnDanhMuc().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List<DanhMucSanPham> danhMucSanPhamList = danhMucService.getAllDanhMuc();
        DefaultTableModel model = (DefaultTableModel) homeView.getTable_danhmuc().getModel();
        model.setRowCount(0); // Xóa tất cả các hàng hiện có trong bảng

        for (DanhMucSanPham dm : danhMucSanPhamList) {
          Object[] row = {
              dm.getIDDanhMuc(),
              dm.getTenDanhMuc(),
              dm.getMoTaDanhMuc()
          };
          model.addRow(row); // Thêm một hàng mới vào bảng với dữ liệu tương ứng
        }
      }
    });
  }
  //method xoa
  public void deleteDanhMucById() {

  }
}
