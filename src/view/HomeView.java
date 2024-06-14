package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.response.Item;
import model.service.DanhMucService;
import java.util.List;
import javax.swing.table.JTableHeader;
import model.service.NguoiNhapService;
import model.service.NhaCungCapService;


public class HomeView extends JFrame {

  private JPanel rightPanel;
  private JPanel sanPhamPanel;
  private JPanel hoaDonPanel;
  private JPanel danhmucPanel;
  private JPanel nhaCungCapPanel;
  private JPanel khachhangPanel;
  private JPanel nhanvienPanel;
  private CardLayout cardLayout;
  private JButton btnSanPham;
  private JButton btnHoaDon;
  private JButton btnDanhMuc;
  private JButton btnNhaCungCap;
  private JButton btnKhachHang;
  private JButton btnNhanVien;
  private JButton btnDonHang;
  private JButton btnKhoHang;
  private JButton btnBaocao;
  private JTable table;
  private JButton btnAdd;
  private JButton btnEdit;
  private JButton btnDelete;
  private JButton btnExit;
  private JLabel lbMasanpham;
  private JLabel lbTensanpham;
  private JLabel lbGiaBan;
  private JLabel lbGiaNhap;
  private JLabel lbMoTa;
  private JLabel lbThoiGianNhap;
  private JLabel lbSoluong;
  private JLabel lbTenDanhMuc;
  private JLabel lbTenNhaCungCap;
  private JLabel lbNguoiNhap;
  private JTextField TfMasanpham;
  private JTextField TfTensanpham;
  private JTextField TfGiaBan;
  private JTextField TfGiaNhap;
  private JTextField TfMoTa;
  private JTextField TfThoiGianNhap;
  private JTextField TfSoluong;
  private JComboBox<Item> CbTenDanhMuc;
  private JComboBox<Item> CbTenNhaCungCap;
  private JComboBox<Item> CbNguoiNhap;

  private JLabel lbIdhoadon;
  private JTextField TfIdhoadon;
  private JLabel lbTongTienThanhToan;
  private JTextField TfTongTienThanhToan;
  private JLabel lbNgayThanhToan;
  private JTextField TfNgayThanhToan;
  private JTable table_hoadon;
  private JLabel lbTenDanhmuc;
  private JTextField TfTenDanhmuc;
  private JLabel lbMotadanhmuc;
  private JTextField TfMotadanhmuc;
  private JTable table_danhmuc;
  private JButton btnAdd1, btnEdit1, btnDelete1, btnExit1;

  private JLabel lbTenNhaCungCap1;
  private JTextField TfTenNhaCungCap1;
  private JLabel lbDiachi;
  private JTextField TfDiachi;
  private JLabel lbSodienthoai;
  private JTextField TfSodienthoai;
  private JTable table_nhacungcap;
  private JButton btnAddncc, btnEditncc, btnDeletencc, btnExitncc;

  private JLabel lbTenKhachHang;
  private JTextField TfTenKhachHang;
  private JLabel lbDiachiKhachHang;
  private JTextField TfDiachiKhachHang;
  private JLabel lbSodienthoaiKhachHang;
  private JTextField TfSodienthoaiKhachHang;
  private JLabel lbEmailKhachHang;
  private JTextField TfEmailKhachHang;
  private JTable table_khachhang;
  private JButton btnAddkh, btnEditkh, btnDeletekh, btnExitkh;

  private JLabel lbTenNhanVien;
  private JTextField TfTenNhanVien;
  private JLabel lbEmailNhanVien;
  private JTextField TfEmailNhanVien;
  private JLabel lbmatkhauNhanVien;
  private JTextField TfmatkhauNhanVien;
  private JLabel lbSodienthoaiNhanVien;
  private JTextField TfSodienthoaiNhanVien;
  private JTable table_nhanvien;
  private JButton btnAddnv, btnEditnv, btnDeletenv, btnExitnv;

  public HomeView() {
    this.setTitle("Quản Lý Bán Hàng Thiết Bị Di Động");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    HomeUi();
    this.setVisible(true);
  }

  //Test thu
  public void HomeUi() {
    // Create left panel with buttons
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(9, 1));
    leftPanel.setPreferredSize(new Dimension(200, 0));
    leftPanel.setBackground(Color.decode("#212121"));
    btnSanPham = createButton("SẢN PHẨM");
    btnHoaDon = createButton("HOÁ ĐƠN");
    btnDanhMuc = createButton("DANH MỤC");
    btnNhaCungCap = createButton("NHÀ CUNG CẤP");
    btnKhachHang = createButton("KHÁCH HÀNG");
    btnNhanVien = createButton("NHÂN VIÊN");
    btnDonHang = createButton("ĐƠN HÀNG");
    btnKhoHang = createButton("KHO HÀNG");
    btnBaocao = createButton("BÁO CÁO");
    leftPanel.add(btnSanPham);
    leftPanel.add(btnHoaDon);
    leftPanel.add(btnDanhMuc);
    leftPanel.add(btnNhaCungCap);
    leftPanel.add(btnKhachHang);
    leftPanel.add(btnNhanVien);
    leftPanel.add(btnDonHang);
    leftPanel.add(btnKhoHang);
    leftPanel.add(btnBaocao);
    cardLayout = new CardLayout();
    rightPanel = new JPanel(cardLayout);
    sanPhamPanel = createSanPhamPanel();
    hoaDonPanel = createHoaDonPanel();
    danhmucPanel = createDanhMucPanel();
    nhaCungCapPanel = createNhaCungCapPanel();
    khachhangPanel = createKhachHangPanel();
    nhanvienPanel = createNhanVienPanel();
    rightPanel.add(sanPhamPanel, "SanPham");
    rightPanel.add(hoaDonPanel, "HoaDon");
    rightPanel.add(danhmucPanel, "DanhMuc");
    rightPanel.add(nhaCungCapPanel, "NhaCungCap");
    rightPanel.add(khachhangPanel, "KhachHang");
    rightPanel.add(nhanvienPanel, "NhanVien");
    cardLayout.show(rightPanel, "SanPham");
    btnSanPham.addActionListener(e -> {
      cardLayout.show(rightPanel, "SanPham");
    });
    btnHoaDon.addActionListener(e -> {
      cardLayout.show(rightPanel, "HoaDon");
    });
    btnDanhMuc.addActionListener(e -> {
      cardLayout.show(rightPanel, "DanhMuc");
    });
    btnNhaCungCap.addActionListener(e -> {
      cardLayout.show(rightPanel, "NhaCungCap");
    });
    btnKhachHang.addActionListener(e -> {
      cardLayout.show(rightPanel, "KhachHang");
    });
    btnNhanVien.addActionListener(e -> {
      cardLayout.show(rightPanel, "NhanVien");
    });
    JSplitPane spmain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
    this.setContentPane(spmain);
  }

  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setFont(new Font("Arial", Font.BOLD, 30));
    button.setBackground(Color.decode("#212121"));
    button.setForeground(Color.decode("#FBFBFB"));
    return button;
  }

  //San Pham
  private JPanel createSanPhamPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel panel_row0 = new JPanel();
    panel_row0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 20));
    panel_row0.setBackground(Color.decode("#CDE8E5"));
    JPanel taokhoangcach = new JPanel();
    taokhoangcach.setBackground(Color.decode("#CDE8E5"));
    panel_row0.add(taokhoangcach);
    panel.add(panel_row0);
    JPanel chua_panel_row1 = new JPanel();
    chua_panel_row1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    chua_panel_row1.setBackground(Color.decode("#CDE8E5"));
    JPanel panel_row1 = new JPanel();
    panel_row1.setBackground(Color.decode("#CDE8E5"));
    panel_row1.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);

    lbMasanpham = new JLabel("Mã Sản Phẩm:");
    TfMasanpham = new JTextField(20);
    lbTensanpham = new JLabel("Tên Sản Phẩm:");
    TfTensanpham = new JTextField(20);
    lbGiaBan = new JLabel("Giá Bán:");
    TfGiaBan = new JTextField(20);
    lbGiaNhap = new JLabel("Giá Nhập:");
    TfGiaNhap = new JTextField(20);
    lbMoTa = new JLabel("Mô Tả:");
    TfMoTa = new JTextField(20);
    lbThoiGianNhap = new JLabel("Thời Gian Nhập:");
    TfThoiGianNhap = new JTextField(20);
    lbSoluong = new JLabel("Số lượng:");
    TfSoluong = new JTextField(20);
    lbTenDanhMuc = new JLabel("Tên Danh Mục:");
    lbTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp:");
    lbNguoiNhap = new JLabel("Tên Người Nhập:");

    int dodai = lbTenNhaCungCap.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenNhaCungCap.getPreferredSize().height);
    setLabelSize(lbMasanpham, labelSize);
    setLabelSize(lbTensanpham, labelSize);
    setLabelSize(lbGiaBan, labelSize);
    setLabelSize(lbGiaNhap, labelSize);
    setLabelSize(lbMoTa, labelSize);
    setLabelSize(lbThoiGianNhap, labelSize);
    setLabelSize(lbSoluong, labelSize);
    setLabelSize(lbTenDanhMuc, labelSize);
    setLabelSize(lbTenNhaCungCap, labelSize);
    setLabelSize(lbNguoiNhap, labelSize);
    addComponent(panel_row1, lbMasanpham, gbc, 0, 0);
    addComponent(panel_row1, TfMasanpham, gbc, 1, 0);
    addComponent(panel_row1, lbTensanpham, gbc, 0, 1);
    addComponent(panel_row1, TfTensanpham, gbc, 1, 1);
    addComponent(panel_row1, lbGiaBan, gbc, 0, 2);
    addComponent(panel_row1, TfGiaBan, gbc, 1, 2);
    addComponent(panel_row1, lbGiaNhap, gbc, 0, 3);
    addComponent(panel_row1, TfGiaNhap, gbc, 1, 3);
    addComponent(panel_row1, lbMoTa, gbc, 0, 4);
    addComponent(panel_row1, TfMoTa, gbc, 1, 4);
    addComponent(panel_row1, lbThoiGianNhap, gbc, 0, 5);
    addComponent(panel_row1, TfThoiGianNhap, gbc, 1, 5);
    addComponent(panel_row1, lbSoluong, gbc, 0, 6);
    addComponent(panel_row1, TfSoluong, gbc, 1, 6);

    JPanel taokhoangcach1 = new JPanel();
    taokhoangcach1.setBackground(Color.decode("#CDE8E5"));
    chua_panel_row1.add(taokhoangcach1);
    chua_panel_row1.add(panel_row1);
    panel.add(chua_panel_row1);

    JPanel panel_row2 = new JPanel();
    panel_row2.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    panel_row2.setBackground(Color.decode("#CDE8E5"));
    JPanel taokhoangcach2 = new JPanel();
    taokhoangcach2.setBackground(Color.decode("#CDE8E5"));
    JPanel G = new JPanel();
    G.setBackground(Color.decode("#CDE8E5"));
    DanhMucService danhMucService = new DanhMucService(null);
    List<Item> danhMucNames = danhMucService.getDanhMucList();
    CbTenDanhMuc = new JComboBox<>(danhMucNames.toArray(new Item[0]));
    CbTenDanhMuc.setPreferredSize(new Dimension(200, CbTenDanhMuc.getPreferredSize().height));
    G.add(lbTenDanhMuc);
    G.add(CbTenDanhMuc);
    JPanel H = new JPanel();
    H.setBackground(Color.decode("#CDE8E5"));
    NhaCungCapService nhaCungCapService = new NhaCungCapService(null);
    List<Item> nhaCungCapNames = nhaCungCapService.getAllTenNhaCungCap();
    CbTenNhaCungCap = new JComboBox<>(nhaCungCapNames.toArray(new Item[0]));
    CbTenNhaCungCap.setPreferredSize(new Dimension(200, CbTenNhaCungCap.getPreferredSize().height));
    H.add(lbTenNhaCungCap);
    H.add(CbTenNhaCungCap);
    JPanel I = new JPanel();
    I.setBackground(Color.decode("#CDE8E5"));
    NguoiNhapService nguoiNhapService = new NguoiNhapService(null);
    List<Item> nguoiNhapNames = nguoiNhapService.getTenNhanVienList();
    CbNguoiNhap = new JComboBox<>(nguoiNhapNames.toArray(new Item[0]));
    CbNguoiNhap.setPreferredSize(new Dimension(200, CbNguoiNhap.getPreferredSize().height));
    I.add(lbNguoiNhap);
    I.add(CbNguoiNhap);

    panel_row2.add(taokhoangcach2);
    panel_row2.add(G);
    panel_row2.add(H);
    panel_row2.add(I);
    panel.add(panel_row2);

    JPanel panel_row3 = new JPanel();
    panel_row3.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 20));
    panel_row3.setBackground(Color.decode("#CDE8E5"));
    table = new JTable(new DefaultTableModel(
        new Object[]{"ID Sản Phẩm", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán Ra", "Giá Nhập",
            "Mô Tả", "Thời Gian Nhập", "Số Lượng", "Tên Danh Mục", "Tên Nhà Cung Cấp"}, 0));
    JTableHeader header = table.getTableHeader();
    header.setFont(new Font("Tamoha", Font.BOLD, 14));
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(1200, 600));
    panel_row3.add(scrollPane);
    panel.add(panel_row3);
    JPanel actionPanel = new JPanel();
    actionPanel.setBackground(Color.decode("#CDE8E5"));
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
    btnAdd = new JButton("Thêm");
    btnAdd.setPreferredSize(new Dimension(100, 50));
    btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
    btnEdit = new JButton("Sửa");
    btnEdit.setPreferredSize(new Dimension(100, 50));
    btnEdit.setFont(new Font("Arial", Font.BOLD, 20));
    btnDelete = new JButton("Xóa");
    btnDelete.setPreferredSize(new Dimension(100, 50));
    btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
    btnExit = new JButton("Thoát");
    btnExit.setPreferredSize(new Dimension(100, 50));
    btnExit.setFont(new Font("Arial", Font.BOLD, 20));
    actionPanel.add(btnAdd);
    actionPanel.add(btnEdit);
    actionPanel.add(btnDelete);
    actionPanel.add(btnExit);
    panel.add(actionPanel);
    return panel;
  }

  //Hoa Don
  private JPanel createHoaDonPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0 = new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0 = new JPanel();
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    JPanel subrow1_1 = new JPanel();
    row_1.add(subrow1_1);
    JPanel subrow1_2 = new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbIdhoadon = new JLabel("ID Hoá Đơn:");
    TfIdhoadon = new JTextField(20);
    lbTongTienThanhToan = new JLabel("Tổng Tiền Thanh Toán:");
    TfTongTienThanhToan = new JTextField(20);
    lbNgayThanhToan = new JLabel("Ngày Thanh Toán:");
    TfNgayThanhToan = new JTextField(20);
    int dodai = lbTongTienThanhToan.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTongTienThanhToan.getPreferredSize().height);
    setLabelSize(lbIdhoadon, labelSize);
    setLabelSize(lbTongTienThanhToan, labelSize);
    setLabelSize(lbNgayThanhToan, labelSize);

    addComponent(subrow1_2, lbIdhoadon, gbc, 0, 0);
    addComponent(subrow1_2, TfIdhoadon, gbc, 1, 0);
    addComponent(subrow1_2, lbTongTienThanhToan, gbc, 0, 1);
    addComponent(subrow1_2, TfTongTienThanhToan, gbc, 1, 1);
    addComponent(subrow1_2, lbNgayThanhToan, gbc, 0, 2);
    addComponent(subrow1_2, TfNgayThanhToan, gbc, 1, 2);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2 = new JPanel();
    table_hoadon = new JTable(new DefaultTableModel(
        new Object[]{"ID Hoá Đơn", "Tổng Tiền Thanh Toán", "Ngày Thanh Toán"}, 0
    ));
    JScrollPane scrollPane = new JScrollPane(table_hoadon);
    scrollPane.setPreferredSize(new Dimension(1200, 300));
    row_2.add(scrollPane);
    panel.add(row_2);
    panel.setBackground(Color.decode("#CDE8E5"));
    return panel;
  }

  //Danh Muc
  private JPanel createDanhMucPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0 = new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0 = new JPanel();
    padding_0.setBackground(Color.decode("#CDE8E5"));
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    row_1.setBackground(Color.decode("#CDE8E5"));
    JPanel subrow1_1 = new JPanel();
    subrow1_1.setBackground(Color.decode("#CDE8E5"));
    row_1.add(subrow1_1);
    JPanel subrow1_2 = new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    subrow1_2.setBackground(Color.decode("#CDE8E5"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbTenDanhmuc = new JLabel("Tên Danh Mục:");
    TfTenDanhmuc = new JTextField(20);
    lbMotadanhmuc = new JLabel("Mô Tả Danh Mục:");
    TfMotadanhmuc = new JTextField(20);
    int dodai = lbMotadanhmuc.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenDanhmuc.getPreferredSize().height);
    setLabelSize(lbTenDanhmuc, labelSize);
    setLabelSize(lbMotadanhmuc, labelSize);
    addComponent(subrow1_2, lbTenDanhmuc, gbc, 0, 0);
    addComponent(subrow1_2, TfTenDanhmuc, gbc, 1, 0);
    addComponent(subrow1_2, lbMotadanhmuc, gbc, 0, 1);
    addComponent(subrow1_2, TfMotadanhmuc, gbc, 1, 1);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2 = new JPanel();
    row_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 1));
    table_danhmuc = new JTable(new DefaultTableModel(
        new Object[]{"ID Danh Mục", "Tên Danh Mục", "Mô Tả Danh Mục"}, 0
    ));
    JTableHeader header = table_danhmuc.getTableHeader();
    header.setFont(new Font("Tamoha", Font.BOLD, 14));
    JScrollPane scrollPane = new JScrollPane(table_danhmuc);
    scrollPane.setPreferredSize(new Dimension(1200, 600));
    row_2.add(scrollPane);
    row_2.add(scrollPane);
    row_2.setBackground(Color.decode("#CDE8E5"));
    panel.add(row_2);
    JPanel row_3 = new JPanel();
    row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
    row_3.setBackground(Color.decode("#CDE8E5"));
    btnAdd1 = new JButton("Thêm");
    btnAdd1.setPreferredSize(new Dimension(100, 50));
    btnAdd1.setFont(new Font("Arial", Font.BOLD, 20));
    btnEdit1 = new JButton("Sửa");
    btnEdit1.setPreferredSize(new Dimension(100, 50));
    btnEdit1.setFont(new Font("Arial", Font.BOLD, 20));
    btnDelete1 = new JButton("Xóa");
    btnDelete1.setPreferredSize(new Dimension(100, 50));
    btnDelete1.setFont(new Font("Arial", Font.BOLD, 20));
    btnExit1 = new JButton("Thoát");
    btnExit1.setPreferredSize(new Dimension(100, 50));
    btnExit1.setFont(new Font("Arial", Font.BOLD, 20));
    row_3.add(btnAdd1);
    row_3.add(btnEdit1);
    row_3.add(btnDelete1);
    row_3.add(btnExit1);
    panel.add(row_3);
    return panel;
  }

  //Nha Cung Cap
  private JPanel createNhaCungCapPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0 = new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0 = new JPanel();
    padding_0.setBackground(Color.decode("#CDE8E5"));
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    row_1.setBackground(Color.decode("#CDE8E5"));
    JPanel subrow1_1 = new JPanel();
    subrow1_1.setBackground(Color.decode("#CDE8E5"));
    row_1.add(subrow1_1);
    JPanel subrow1_2 = new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    subrow1_2.setBackground(Color.decode("#CDE8E5"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbTenNhaCungCap1 = new JLabel("Tên Nhà Cung Cấp:");
    TfTenNhaCungCap1 = new JTextField(20);
    lbDiachi = new JLabel("Địa Chỉ:");
    TfDiachi = new JTextField(20);
    lbSodienthoai = new JLabel("Số Điện Thoại:");
    TfSodienthoai = new JTextField(20);
    int dodai = lbTenNhaCungCap1.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenNhaCungCap1.getPreferredSize().height);
    setLabelSize(lbTenNhaCungCap1, labelSize);
    setLabelSize(lbDiachi, labelSize);
    setLabelSize(lbSodienthoai, labelSize);
    addComponent(subrow1_2, lbTenNhaCungCap1, gbc, 0, 0);
    addComponent(subrow1_2, TfTenNhaCungCap1, gbc, 1, 0);
    addComponent(subrow1_2, lbDiachi, gbc, 0, 1);
    addComponent(subrow1_2, TfDiachi, gbc, 1, 1);
    addComponent(subrow1_2, lbSodienthoai, gbc, 0, 2);
    addComponent(subrow1_2, TfSodienthoai, gbc, 1, 2);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2 = new JPanel();
    row_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
    table_nhacungcap = new JTable(new DefaultTableModel(
        new Object[]{"ID Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"}, 0
    ));
    JTableHeader header = table_nhacungcap.getTableHeader();
    header.setFont(new Font("Tamoha", Font.BOLD, 14));
    JScrollPane scrollPane = new JScrollPane(table_nhacungcap);
    scrollPane.setPreferredSize(new Dimension(1200, 600));
    row_2.add(scrollPane);
    row_2.add(scrollPane);
    row_2.setBackground(Color.decode("#CDE8E5"));
    panel.add(row_2);
    JPanel row_3 = new JPanel();
    row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
    row_3.setBackground(Color.decode("#CDE8E5"));
    btnAddncc = new JButton("Thêm");
    btnAddncc.setPreferredSize(new Dimension(100, 50));
    btnAddncc.setFont(new Font("Arial", Font.BOLD, 20));
    btnEditncc = new JButton("Sửa");
    btnEditncc.setPreferredSize(new Dimension(100, 50));
    btnEditncc.setFont(new Font("Arial", Font.BOLD, 20));
    btnDeletencc = new JButton("Xóa");
    btnDeletencc.setPreferredSize(new Dimension(100, 50));
    btnDeletencc.setFont(new Font("Arial", Font.BOLD, 20));
    btnExitncc = new JButton("Thoát");
    btnExitncc.setPreferredSize(new Dimension(100, 50));
    btnExitncc.setFont(new Font("Arial", Font.BOLD, 20));
    row_3.add(btnAddncc);
    row_3.add(btnEditncc);
    row_3.add(btnDeletencc);
    row_3.add(btnExitncc);
    panel.add(row_3);
    return panel;
  }

  //Khach Hang
  private JPanel createKhachHangPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0 = new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0 = new JPanel();
    padding_0.setBackground(Color.decode("#CDE8E5"));
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    row_1.setBackground(Color.decode("#CDE8E5"));
    JPanel subrow1_1 = new JPanel();
    subrow1_1.setBackground(Color.decode("#CDE8E5"));
    row_1.add(subrow1_1);
    JPanel subrow1_2 = new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    subrow1_2.setBackground(Color.decode("#CDE8E5"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbTenKhachHang = new JLabel("Tên Khách Hàng:");
    TfTenKhachHang = new JTextField(20);
    lbDiachiKhachHang = new JLabel("Địa Chỉ:");
    TfDiachiKhachHang = new JTextField(20);
    lbSodienthoaiKhachHang = new JLabel("Số Điện Thoại:");
    TfSodienthoaiKhachHang = new JTextField(20);
    lbEmailKhachHang = new JLabel("Email:");
    TfEmailKhachHang = new JTextField(20);
    int dodai = lbTenKhachHang.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenKhachHang.getPreferredSize().height);
    setLabelSize(lbTenKhachHang, labelSize);
    setLabelSize(lbDiachiKhachHang, labelSize);
    setLabelSize(lbSodienthoaiKhachHang, labelSize);
    setLabelSize(lbEmailKhachHang, labelSize);
    addComponent(subrow1_2, lbTenKhachHang, gbc, 0, 0);
    addComponent(subrow1_2, TfTenKhachHang, gbc, 1, 0);
    addComponent(subrow1_2, lbDiachiKhachHang, gbc, 0, 1);
    addComponent(subrow1_2, TfDiachiKhachHang, gbc, 1, 1);
    addComponent(subrow1_2, lbSodienthoaiKhachHang, gbc, 0, 2);
    addComponent(subrow1_2, TfSodienthoaiKhachHang, gbc, 1, 2);
    addComponent(subrow1_2, lbEmailKhachHang, gbc, 0, 3);
    addComponent(subrow1_2, TfEmailKhachHang, gbc, 1, 3);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2 = new JPanel();
    row_2.setBackground(Color.decode("#CDE8E5"));
    row_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
    table_khachhang = new JTable(new DefaultTableModel(
        new Object[]{"ID Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Email"}, 0
    ));
    JTableHeader header = table_khachhang.getTableHeader();
    header.setFont(new Font("Tamoha", Font.BOLD, 14));
    JScrollPane scrollPane = new JScrollPane(table_khachhang);
    scrollPane.setPreferredSize(new Dimension(1200, 600));
    row_2.add(scrollPane);
    panel.add(row_2);
    JPanel row_3 = new JPanel();
    row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
    row_3.setBackground(Color.decode("#CDE8E5"));
    btnAddkh = new JButton("Thêm");
    btnAddkh.setPreferredSize(new Dimension(100, 50));
    btnAddkh.setFont(new Font("Arial", Font.BOLD, 20));
    btnEditkh = new JButton("Sửa");
    btnEditkh.setPreferredSize(new Dimension(100, 50));
    btnEditkh.setFont(new Font("Arial", Font.BOLD, 20));
    btnDeletekh = new JButton("Xóa");
    btnDeletekh.setPreferredSize(new Dimension(100, 50));
    btnDeletekh.setFont(new Font("Arial", Font.BOLD, 20));
    btnExitkh = new JButton("Thoát");
    btnExitkh.setPreferredSize(new Dimension(100, 50));
    btnExitkh.setFont(new Font("Arial", Font.BOLD, 20));
    row_3.add(btnAddkh);
    row_3.add(btnEditkh);
    row_3.add(btnDeletekh);
    row_3.add(btnExitkh);
    panel.add(row_3);
    return panel;
  }

  private JPanel createNhanVienPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0 = new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0 = new JPanel();
    padding_0.setBackground(Color.decode("#CDE8E5"));
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1 = new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
    row_1.setBackground(Color.decode("#CDE8E5"));
    JPanel subrow1_1 = new JPanel();
    subrow1_1.setBackground(Color.decode("#CDE8E5"));
    row_1.add(subrow1_1);
    JPanel subrow1_2 = new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    subrow1_2.setBackground(Color.decode("#CDE8E5"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbTenNhanVien = new JLabel("Tên Nhân Viên:");
    TfTenNhanVien = new JTextField(20);
    lbSodienthoaiNhanVien = new JLabel("Số Điện Thoại:");
    TfSodienthoaiNhanVien = new JTextField(20);
    lbEmailNhanVien = new JLabel("Email:");
    TfEmailNhanVien = new JTextField(20);
    lbmatkhauNhanVien = new JLabel("Mật Khẩu:");
    TfmatkhauNhanVien = new JTextField(20);
    int dodai = lbTenNhanVien.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenNhanVien.getPreferredSize().height);
    setLabelSize(lbTenNhanVien, labelSize);
    setLabelSize(lbEmailNhanVien, labelSize);
    setLabelSize(lbmatkhauNhanVien, labelSize);
    setLabelSize(lbSodienthoaiNhanVien, labelSize);

    addComponent(subrow1_2, lbTenNhanVien, gbc, 0, 0);
    addComponent(subrow1_2, TfTenNhanVien, gbc, 1, 0);
    addComponent(subrow1_2, lbEmailNhanVien, gbc, 0, 1);
    addComponent(subrow1_2, TfEmailNhanVien, gbc, 1, 1);
    addComponent(subrow1_2, lbmatkhauNhanVien, gbc, 0, 2);
    addComponent(subrow1_2, TfmatkhauNhanVien, gbc, 1, 2);
    addComponent(subrow1_2, lbSodienthoaiNhanVien, gbc, 0, 3);
    addComponent(subrow1_2, TfSodienthoaiNhanVien, gbc, 1, 3);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2 = new JPanel();
    row_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
    row_2.setBackground(Color.decode("#CDE8E5"));
    table_nhanvien = new JTable(new DefaultTableModel(
        new Object[]{"ID Nhân Viên", "Tên Nhân Viên", "Email", "Mật Khẩu", "Số Điện Thoại"}, 0
    ));
    JTableHeader header = table_nhanvien.getTableHeader();
    header.setFont(new Font("Tamoha", Font.BOLD, 14));
    JScrollPane scrollPane = new JScrollPane(table_nhanvien);
    scrollPane.setPreferredSize(new Dimension(1200, 600));
    row_2.add(scrollPane);
    panel.add(row_2);
    JPanel row_3 = new JPanel();
    row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
    row_3.setBackground(Color.decode("#CDE8E5"));
    btnAddnv = new JButton("Thêm");
    btnAddnv.setPreferredSize(new Dimension(100, 50));
    btnAddnv.setFont(new Font("Arial", Font.BOLD, 20));
    btnEditnv = new JButton("Sửa");
    btnEditnv.setPreferredSize(new Dimension(100, 50));
    btnEditnv.setFont(new Font("Arial", Font.BOLD, 20));
    btnDeletenv = new JButton("Xóa");
    btnDeletenv.setPreferredSize(new Dimension(100, 50));
    btnDeletenv.setFont(new Font("Arial", Font.BOLD, 20));
    btnExitnv = new JButton("Thoát");
    btnExitnv.setPreferredSize(new Dimension(100, 50));
    btnExitnv.setFont(new Font("Arial", Font.BOLD, 20));
    row_3.add(btnAddnv);
    row_3.add(btnEditnv);
    row_3.add(btnDeletenv);
    row_3.add(btnExitnv);
    panel.add(row_3);
    return panel;
  }


  private void setLabelSize(JLabel label, Dimension size) {
    label.setPreferredSize(size);
  }

  private void addComponent(JPanel panel, Component component, GridBagConstraints gbc, int x,
      int y) {
    gbc.gridx = x;
    gbc.gridy = y;
    panel.add(component, gbc);
  }

  public JButton getBtnSanPham() {
    return btnSanPham;
  }

  public void setBtnSanPham(JButton btnSanPham) {
    this.btnSanPham = btnSanPham;
  }

  public JButton getBtnHoaDon() {
    return btnHoaDon;
  }

  public void setBtnHoaDon(JButton btnHoaDon) {
    this.btnHoaDon = btnHoaDon;
  }

  public JButton getBtnDanhMuc() {
    return btnDanhMuc;
  }

  public void setBtnDanhMuc(JButton btnDanhMuc) {
    this.btnDanhMuc = btnDanhMuc;
  }

  public JButton getBtnNhaCungCap() {
    return btnNhaCungCap;
  }

  public void setBtnNhaCungCap(JButton btnNhaCungCap) {
    this.btnNhaCungCap = btnNhaCungCap;
  }

  public JButton getBtnKhachHang() {
    return btnKhachHang;
  }

  public void setBtnKhachHang(JButton btnKhachHang) {
    this.btnKhachHang = btnKhachHang;
  }

  public JButton getBtnNhanVien() {
    return btnNhanVien;
  }

  public void setBtnNhanVien(JButton btnNhanVien) {
    this.btnNhanVien = btnNhanVien;
  }

  public JTable getTable() {
    return table;
  }

  public void setTable(JTable table) {
    this.table = table;
  }

  public JButton getBtnAdd() {
    return btnAdd;
  }

  public void setBtnAdd(JButton btnAdd) {
    this.btnAdd = btnAdd;
  }

  public JButton getBtnEdit() {
    return btnEdit;
  }

  public void setBtnEdit(JButton btnEdit) {
    this.btnEdit = btnEdit;
  }

  public JButton getBtnDelete() {
    return btnDelete;
  }

  public void setBtnDelete(JButton btnDelete) {
    this.btnDelete = btnDelete;
  }

  // tets thu git thoi ma
  public JButton getBtnExit() {
    return btnExit;
  }

  public void setBtnExit(JButton btnExit) {
    this.btnExit = btnExit;
  }

  public JLabel getLbMasanpham() {
    return lbMasanpham;
  }

  public void setLbMasanpham(JLabel lbMasanpham) {
    this.lbMasanpham = lbMasanpham;
  }

  public JLabel getLbTensanpham() {
    return lbTensanpham;
  }

  public void setLbTensanpham(JLabel lbTensanpham) {
    this.lbTensanpham = lbTensanpham;
  }

  public JLabel getLbGiaBan() {
    return lbGiaBan;
  }

  public void setLbGiaBan(JLabel lbGiaBan) {
    this.lbGiaBan = lbGiaBan;
  }

  public JLabel getLbGiaNhap() {
    return lbGiaNhap;
  }

  public void setLbGiaNhap(JLabel lbGiaNhap) {
    this.lbGiaNhap = lbGiaNhap;
  }

  public JLabel getLbMoTa() {
    return lbMoTa;
  }

  public void setLbMoTa(JLabel lbMoTa) {
    this.lbMoTa = lbMoTa;
  }

  public JLabel getLbThoiGianNhap() {
    return lbThoiGianNhap;
  }

  public void setLbThoiGianNhap(JLabel lbThoiGianNhap) {
    this.lbThoiGianNhap = lbThoiGianNhap;
  }

  public JLabel getLbTenDanhMuc() {
    return lbTenDanhMuc;
  }

  public void setLbTenDanhMuc(JLabel lbTenDanhMuc) {
    this.lbTenDanhMuc = lbTenDanhMuc;
  }

  public JLabel getLbTenNhaCungCap() {
    return lbTenNhaCungCap;
  }

  public void setLbTenNhaCungCap(JLabel lbTenNhaCungCap) {
    this.lbTenNhaCungCap = lbTenNhaCungCap;
  }

  public JTextField getTfMasanpham() {
    return TfMasanpham;
  }

  public void setTfMasanpham(JTextField tfMasanpham) {
    TfMasanpham = tfMasanpham;
  }

  public JTextField getTfTensanpham() {
    return TfTensanpham;
  }

  public void setTfTensanpham(JTextField tfTensanpham) {
    TfTensanpham = tfTensanpham;
  }

  public JTextField getTfGiaBan() {
    return TfGiaBan;
  }

  public void setTfGiaBan(JTextField tfGiaBan) {
    TfGiaBan = tfGiaBan;
  }

  public JTextField getTfGiaNhap() {
    return TfGiaNhap;
  }

  public void setTfGiaNhap(JTextField tfGiaNhap) {
    TfGiaNhap = tfGiaNhap;
  }

  public JTextField getTfMoTa() {
    return TfMoTa;
  }

  public void setTfMoTa(JTextField tfMoTa) {
    TfMoTa = tfMoTa;
  }

  public JTextField getTfThoiGianNhap() {
    return TfThoiGianNhap;
  }

  public void setTfThoiGianNhap(JTextField tfThoiGianNhap) {
    TfThoiGianNhap = tfThoiGianNhap;
  }

  public JComboBox<Item> getCbTenDanhMuc() {
    return CbTenDanhMuc;
  }

  public void setCbTenDanhMuc(JComboBox<Item> cbTenDanhMuc) {
    CbTenDanhMuc = cbTenDanhMuc;
  }

  public JComboBox<Item> getCbTenNhaCungCap() {
    return CbTenNhaCungCap;
  }

  public void setCbTenNhaCungCap(JComboBox<Item> cbTenNhaCungCap) {
    CbTenNhaCungCap = cbTenNhaCungCap;
  }

  public JComboBox<Item> getCbNguoiNhap() {
    return CbNguoiNhap;
  }

  public void setCbNguoiNhap(JComboBox<Item> CbNguoiNhap) {
    this.CbNguoiNhap = CbNguoiNhap;
  }

  public JPanel getRightPanel() {
    return rightPanel;
  }

  public void setRightPanel(JPanel rightPanel) {
    this.rightPanel = rightPanel;
  }

  public JPanel getSanPhamPanel() {
    return sanPhamPanel;
  }

  public void setSanPhamPanel(JPanel sanPhamPanel) {
    this.sanPhamPanel = sanPhamPanel;
  }

  public JPanel getHoaDonPanel() {
    return hoaDonPanel;
  }

  public void setHoaDonPanel(JPanel hoaDonPanel) {
    this.hoaDonPanel = hoaDonPanel;
  }

  public JPanel getDanhmucPanel() {
    return danhmucPanel;
  }

  public void setDanhmucPanel(JPanel danhmucPanel) {
    this.danhmucPanel = danhmucPanel;
  }

  public CardLayout getCardLayout() {
    return cardLayout;
  }

  public void setCardLayout(CardLayout cardLayout) {
    this.cardLayout = cardLayout;
  }

  public JButton getBtnDonHang() {
    return btnDonHang;
  }

  public void setBtnDonHang(JButton btnDonHang) {
    this.btnDonHang = btnDonHang;
  }

  public JButton getBtnKhoHang() {
    return btnKhoHang;
  }

  public void setBtnKhoHang(JButton btnKhoHang) {
    this.btnKhoHang = btnKhoHang;
  }

  public JButton getBtnBaocao() {
    return btnBaocao;
  }

  public void setBtnBaocao(JButton btnBaocao) {
    this.btnBaocao = btnBaocao;
  }

  public JLabel getLbSoluong() {
    return lbSoluong;
  }

  public void setLbSoluong(JLabel lbSoluong) {
    this.lbSoluong = lbSoluong;
  }

  public JLabel getLbNguoiNhap() {
    return lbNguoiNhap;
  }

  public void setLbNguoiNhap(JLabel lbNguoiNhap) {
    this.lbNguoiNhap = lbNguoiNhap;
  }

  public JTextField getTfSoluong() {
    return TfSoluong;
  }

  public void setTfSoluong(JTextField tfSoluong) {
    TfSoluong = tfSoluong;
  }

  public JLabel getLbIdhoadon() {
    return lbIdhoadon;
  }

  public void setLbIdhoadon(JLabel lbIdhoadon) {
    this.lbIdhoadon = lbIdhoadon;
  }

  public JTextField getTfIdhoadon() {
    return TfIdhoadon;
  }

  public void setTfIdhoadon(JTextField tfIdhoadon) {
    TfIdhoadon = tfIdhoadon;
  }

  public JLabel getLbTongTienThanhToan() {
    return lbTongTienThanhToan;
  }

  public void setLbTongTienThanhToan(JLabel lbTongTienThanhToan) {
    this.lbTongTienThanhToan = lbTongTienThanhToan;
  }

  public JTextField getTfTongTienThanhToan() {
    return TfTongTienThanhToan;
  }

  public void setTfTongTienThanhToan(JTextField tfTongTienThanhToan) {
    TfTongTienThanhToan = tfTongTienThanhToan;
  }

  public JLabel getLbNgayThanhToan() {
    return lbNgayThanhToan;
  }

  public void setLbNgayThanhToan(JLabel lbNgayThanhToan) {
    this.lbNgayThanhToan = lbNgayThanhToan;
  }

  public JTextField getTfNgayThanhToan() {
    return TfNgayThanhToan;
  }

  public void setTfNgayThanhToan(JTextField tfNgayThanhToan) {
    TfNgayThanhToan = tfNgayThanhToan;
  }

  public JLabel getLbTenDanhmuc() {
    return lbTenDanhmuc;
  }

  public void setLbTenDanhmuc(JLabel lbTenDanhmuc) {
    this.lbTenDanhmuc = lbTenDanhmuc;
  }

  public JTextField getTfTenDanhmuc() {
    return TfTenDanhmuc;
  }

  public void setTfTenDanhmuc(JTextField tfTenDanhmuc) {
    TfTenDanhmuc = tfTenDanhmuc;
  }

  public JLabel getLbMotadanhmuc() {
    return lbMotadanhmuc;
  }

  public void setLbMotadanhmuc(JLabel lbMotadanhmuc) {
    this.lbMotadanhmuc = lbMotadanhmuc;
  }

  public JTextField getTfMotadanhmuc() {
    return TfMotadanhmuc;
  }

  public void setTfMotadanhmuc(JTextField tfMotadanhmuc) {
    TfMotadanhmuc = tfMotadanhmuc;
  }

  public JTable getTable_danhmuc() {
    return table_danhmuc;
  }

  public void setTable_danhmuc(JTable table_danhmuc) {
    this.table_danhmuc = table_danhmuc;
  }

  public JButton getBtnAdd1() {
    return btnAdd1;
  }

  public void setBtnAdd1(JButton btnAdd1) {
    this.btnAdd1 = btnAdd1;
  }

  public JButton getBtnEdit1() {
    return btnEdit1;
  }

  public void setBtnEdit1(JButton btnEdit1) {
    this.btnEdit1 = btnEdit1;
  }

  public JButton getBtnDelete1() {
    return btnDelete1;
  }

  public void setBtnDelete1(JButton btnDelete1) {
    this.btnDelete1 = btnDelete1;
  }

  public JButton getBtnExit1() {
    return btnExit1;
  }

  public void setBtnExit1(JButton btnExit1) {
    this.btnExit1 = btnExit1;
  }

  public JTable getTable_hoadon() {
    return table_hoadon;
  }

  public void setTable_hoadon(JTable table_hoadon) {
    this.table_hoadon = table_hoadon;
  }

  public JPanel getNhaCungCapPanel() {
    return nhaCungCapPanel;
  }

  public void setNhaCungCapPanel(JPanel nhaCungCapPanel) {
    this.nhaCungCapPanel = nhaCungCapPanel;
  }

  public JPanel getKhachhangPanel() {
    return khachhangPanel;
  }

  public void setKhachhangPanel(JPanel khachhangPanel) {
    this.khachhangPanel = khachhangPanel;
  }

  public JPanel getNhanvienPanel() {
    return nhanvienPanel;
  }

  public void setNhanvienPanel(JPanel nhanvienPanel) {
    this.nhanvienPanel = nhanvienPanel;
  }

  public JLabel getLbTenNhaCungCap1() {
    return lbTenNhaCungCap1;
  }

  public void setLbTenNhaCungCap1(JLabel lbTenNhaCungCap1) {
    this.lbTenNhaCungCap1 = lbTenNhaCungCap1;
  }

  public JTextField getTfTenNhaCungCap1() {
    return TfTenNhaCungCap1;
  }

  public void setTfTenNhaCungCap1(JTextField tfTenNhaCungCap1) {
    TfTenNhaCungCap1 = tfTenNhaCungCap1;
  }

  public JLabel getLbDiachi() {
    return lbDiachi;
  }

  public void setLbDiachi(JLabel lbDiachi) {
    this.lbDiachi = lbDiachi;
  }

  public JTextField getTfDiachi() {
    return TfDiachi;
  }

  public void setTfDiachi(JTextField tfDiachi) {
    TfDiachi = tfDiachi;
  }

  public JLabel getLbSodienthoai() {
    return lbSodienthoai;
  }

  public void setLbSodienthoai(JLabel lbSodienthoai) {
    this.lbSodienthoai = lbSodienthoai;
  }

  public JTextField getTfSodienthoai() {
    return TfSodienthoai;
  }

  public void setTfSodienthoai(JTextField tfSodienthoai) {
    TfSodienthoai = tfSodienthoai;
  }

  public JTable getTable_nhacungcap() {
    return table_nhacungcap;
  }

  public void setTable_nhacungcap(JTable table_nhacungcap) {
    this.table_nhacungcap = table_nhacungcap;
  }

  public JButton getBtnAddncc() {
    return btnAddncc;
  }

  public void setBtnAddncc(JButton btnAddncc) {
    this.btnAddncc = btnAddncc;
  }

  public JButton getBtnEditncc() {
    return btnEditncc;
  }

  public void setBtnEditncc(JButton btnEditncc) {
    this.btnEditncc = btnEditncc;
  }

  public JButton getBtnDeletencc() {
    return btnDeletencc;
  }

  public void setBtnDeletencc(JButton btnDeletencc) {
    this.btnDeletencc = btnDeletencc;
  }

  public JButton getBtnExitncc() {
    return btnExitncc;
  }

  public void setBtnExitncc(JButton btnExitncc) {
    this.btnExitncc = btnExitncc;
  }

  public JLabel getLbTenKhachHang() {
    return lbTenKhachHang;
  }

  public void setLbTenKhachHang(JLabel lbTenKhachHang) {
    this.lbTenKhachHang = lbTenKhachHang;
  }

  public JTextField getTfTenKhachHang() {
    return TfTenKhachHang;
  }

  public void setTfTenKhachHang(JTextField tfTenKhachHang) {
    TfTenKhachHang = tfTenKhachHang;
  }

  public JLabel getLbDiachiKhachHang() {
    return lbDiachiKhachHang;
  }

  public void setLbDiachiKhachHang(JLabel lbDiachiKhachHang) {
    this.lbDiachiKhachHang = lbDiachiKhachHang;
  }

  public JTextField getTfDiachiKhachHang() {
    return TfDiachiKhachHang;
  }

  public void setTfDiachiKhachHang(JTextField tfDiachiKhachHang) {
    TfDiachiKhachHang = tfDiachiKhachHang;
  }

  public JLabel getLbSodienthoaiKhachHang() {
    return lbSodienthoaiKhachHang;
  }

  public void setLbSodienthoaiKhachHang(JLabel lbSodienthoaiKhachHang) {
    this.lbSodienthoaiKhachHang = lbSodienthoaiKhachHang;
  }

  public JTextField getTfSodienthoaiKhachHang() {
    return TfSodienthoaiKhachHang;
  }

  public void setTfSodienthoaiKhachHang(JTextField tfSodienthoaiKhachHang) {
    TfSodienthoaiKhachHang = tfSodienthoaiKhachHang;
  }

  public JLabel getLbEmailKhachHang() {
    return lbEmailKhachHang;
  }

  public void setLbEmailKhachHang(JLabel lbEmailKhachHang) {
    this.lbEmailKhachHang = lbEmailKhachHang;
  }

  public JTextField getTfEmailKhachHang() {
    return TfEmailKhachHang;
  }

  public void setTfEmailKhachHang(JTextField tfEmailKhachHang) {
    TfEmailKhachHang = tfEmailKhachHang;
  }

  public JTable getTable_khachhang() {
    return table_khachhang;
  }

  public void setTable_khachhang(JTable table_khachhang) {
    this.table_khachhang = table_khachhang;
  }

  public JButton getBtnAddkh() {
    return btnAddkh;
  }

  public void setBtnAddkh(JButton btnAddkh) {
    this.btnAddkh = btnAddkh;
  }

  public JButton getBtnEditkh() {
    return btnEditkh;
  }

  public void setBtnEditkh(JButton btnEditkh) {
    this.btnEditkh = btnEditkh;
  }

  public JButton getBtnDeletekh() {
    return btnDeletekh;
  }

  public void setBtnDeletekh(JButton btnDeletekh) {
    this.btnDeletekh = btnDeletekh;
  }

  public JButton getBtnExitkh() {
    return btnExitkh;
  }

  public void setBtnExitkh(JButton btnExitkh) {
    this.btnExitkh = btnExitkh;
  }

  public JLabel getLbTenNhanVien() {
    return lbTenNhanVien;
  }

  public void setLbTenNhanVien(JLabel lbTenNhanVien) {
    this.lbTenNhanVien = lbTenNhanVien;
  }

  public JTextField getTfTenNhanVien() {
    return TfTenNhanVien;
  }

  public void setTfTenNhanVien(JTextField tfTenNhanVien) {
    TfTenNhanVien = tfTenNhanVien;
  }

  public JLabel getLbEmailNhanVien() {
    return lbEmailNhanVien;
  }

  public void setLbEmailNhanVien(JLabel lbEmailNhanVien) {
    this.lbEmailNhanVien = lbEmailNhanVien;
  }

  public JTextField getTfEmailNhanVien() {
    return TfEmailNhanVien;
  }

  public void setTfEmailNhanVien(JTextField tfEmailNhanVien) {
    TfEmailNhanVien = tfEmailNhanVien;
  }

  public JLabel getLbmatkhauNhanVien() {
    return lbmatkhauNhanVien;
  }

  public void setLbmatkhauNhanVien(JLabel lbmatkhauNhanVien) {
    this.lbmatkhauNhanVien = lbmatkhauNhanVien;
  }

  public JTextField getTfmatkhauNhanVien() {
    return TfmatkhauNhanVien;
  }

  public void setTfmatkhauNhanVien(JTextField tfmatkhauNhanVien) {
    TfmatkhauNhanVien = tfmatkhauNhanVien;
  }

  public JLabel getLbSodienthoaiNhanVien() {
    return lbSodienthoaiNhanVien;
  }

  public void setLbSodienthoaiNhanVien(JLabel lbSodienthoaiNhanVien) {
    this.lbSodienthoaiNhanVien = lbSodienthoaiNhanVien;
  }

  public JTextField getTfSodienthoaiNhanVien() {
    return TfSodienthoaiNhanVien;
  }

  public void setTfSodienthoaiNhanVien(JTextField tfSodienthoaiNhanVien) {
    TfSodienthoaiNhanVien = tfSodienthoaiNhanVien;
  }

  public JTable getTable_nhanvien() {
    return table_nhanvien;
  }

  public void setTable_nhanvien(JTable table_nhanvien) {
    this.table_nhanvien = table_nhanvien;
  }

  public JButton getBtnAddnv() {
    return btnAddnv;
  }

  public void setBtnAddnv(JButton btnAddnv) {
    this.btnAddnv = btnAddnv;
  }

  public JButton getBtnEditnv() {
    return btnEditnv;
  }

  public void setBtnEditnv(JButton btnEditnv) {
    this.btnEditnv = btnEditnv;
  }

  public JButton getBtnDeletenv() {
    return btnDeletenv;
  }

  public void setBtnDeletenv(JButton btnDeletenv) {
    this.btnDeletenv = btnDeletenv;
  }

  public JButton getBtnExitnv() {
    return btnExitnv;
  }

  public void setBtnExitnv(JButton btnExitnv) {
    this.btnExitnv = btnExitnv;
  }
}
