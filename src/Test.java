import controller.DanhMucController;
import controller.NguoiNhapController;
import controller.NhaCungCapController;
import controller.SanPhamController;
import model.service.DanhMucService;
import model.service.NguoiNhapService;
import model.service.NhaCungCapService;
import model.service.SanPhamService;
import view.HomeView;

public class Test {

  public static void main(String[] args) {
    HomeView homeView = new HomeView();
    SanPhamService sanPhamService = new SanPhamService(homeView);
    DanhMucService danhMucService = new DanhMucService(homeView);
    NhaCungCapService nhaCungCapService = new NhaCungCapService(homeView);
    NguoiNhapService nguoiNhapService = new NguoiNhapService(homeView);
    SanPhamController sanPhamController = new SanPhamController(sanPhamService, homeView);
    DanhMucController danhMucController = new DanhMucController(homeView, danhMucService);
    NhaCungCapController nhaCungCapController = new NhaCungCapController(homeView,
        nhaCungCapService);
    NguoiNhapController nguoiNhapController = new NguoiNhapController(homeView, nguoiNhapService);
  }
}