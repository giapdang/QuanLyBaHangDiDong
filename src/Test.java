import controller.DanhMucController;
import controller.SanPhamController;
import model.service.DanhMucService;
import model.service.SanPhamService;
import view.HomeView;

public class Test {

  public static void main(String[] args) {
    HomeView homeView = new HomeView();
    SanPhamService sanPhamService = new SanPhamService(homeView);
    DanhMucService danhMucService = new DanhMucService();
    SanPhamController sanPhamController = new SanPhamController(sanPhamService, homeView);
    DanhMucController danhMucController = new DanhMucController(homeView,danhMucService);
  }
}