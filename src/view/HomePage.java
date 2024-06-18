package view;

import controller.ChiTietDonHangController;
import controller.DanhMucController;
import controller.DonHangController;
import controller.HoaDonController;
import controller.KhachHangController;
import controller.KhoHangController;
import controller.NguoiNhapController;
import controller.NhaCungCapController;
import controller.SanPhamController;
import model.service.ChiTietDonHangService;
import model.service.DanhMucService;
import model.service.DonHangService;
import model.service.HoaDonService;
import model.service.KhachHangService;
import model.service.KhoHangService;
import model.service.NguoiNhapService;
import model.service.NhaCungCapService;
import model.service.SanPhamService;
import view.HomeView;

public class HomePage {

  public void run() {
    HomeView homeView = new HomeView();
    SanPhamService sanPhamService = new SanPhamService(homeView);
    DanhMucService danhMucService = new DanhMucService(homeView);
    NhaCungCapService nhaCungCapService = new NhaCungCapService(homeView);
    KhachHangService khachHangService = new KhachHangService(homeView);
    NguoiNhapService nguoiNhapService = new NguoiNhapService(homeView);
    KhoHangService khoHangService = new KhoHangService(homeView);
    DonHangService donHangService = new DonHangService(homeView);
    HoaDonService hoaDonService = new HoaDonService(homeView);
    HoaDonController hoaDonController = new HoaDonController(homeView, hoaDonService);
    ChiTietDonHangService chiTietDonHangService = new ChiTietDonHangService(homeView);
    ChiTietDonHangController chiTietDonHangController = new ChiTietDonHangController(homeView,
        chiTietDonHangService, new KhoHangController(homeView, khoHangService));
    DonHangController donHangController = new DonHangController(homeView, donHangService,
        hoaDonController, new KhoHangController(homeView, khoHangService),
        chiTietDonHangController);
    SanPhamController sanPhamController = new SanPhamController(sanPhamService, homeView,
        new KhoHangController(homeView, khoHangService));
    DanhMucController danhMucController = new DanhMucController(homeView, danhMucService);
    NhaCungCapController nhaCungCapController = new NhaCungCapController(homeView,
        nhaCungCapService);
    NguoiNhapController nguoiNhapController = new NguoiNhapController(homeView, nguoiNhapService);
    KhachHangController khachHangController = new KhachHangController(homeView, khachHangService);
    KhoHangController khoHangController = new KhoHangController(homeView, khoHangService);
  }
}