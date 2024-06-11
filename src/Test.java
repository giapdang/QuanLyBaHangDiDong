import controller.SanPhamController;
import model.service.SanPhamService;
import view.HomeView;

public class Test {

  public static void main(String[] args) {
    HomeView homeView = new HomeView();
    SanPhamService sanPhamService = new SanPhamService();
    SanPhamController sanPhamController = new SanPhamController(sanPhamService, homeView);
  }
}