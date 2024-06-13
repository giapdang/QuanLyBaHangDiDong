package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.response.Item;
import model.service.DanhMucService;
import java.util.List;
import javax.swing.table.JTableHeader;
//import model.service.NguoiNhapService;
import model.service.NhaCungCapService;

public class HomeView extends JFrame {

  private JPanel rightPanel;
  private JPanel sanPhamPanel;
  private JPanel hoaDonPanel;
  private JPanel danhmucPanel;
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

  private JLabel lbTenDanhmuc;
  private JTextField TfTenDanhmuc;
  private JLabel lbMotadanhmuc;
  private JTextField TfMotadanhmuc;
  private JTable table_danhmuc;
  private JButton btnAdd1,btnEdit1,btnDelete1,btnExit1;
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
    leftPanel.setPreferredSize(new Dimension(300, 0));
    leftPanel.setBackground(Color.decode("#212121"));
    btnSanPham = createButton("SẢN PHẨM");
    btnHoaDon = createButton("HOÁ ĐƠN");
    btnDanhMuc = createButton("DANH MỤC");
    btnNhaCungCap = createButton("NHÀ CUNG CẤP");
    btnKhachHang = createButton("KHÁCH HÀNG");
    btnNhanVien = createButton("NHÂN VIÊN");
    btnDonHang= createButton("ĐƠN HÀNG");
    btnKhoHang= createButton("KHO HÀNG");
    btnBaocao=createButton("BÁO CÁO");
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
    danhmucPanel=createDanhMucPanel();
    rightPanel.add(sanPhamPanel, "SanPham");
    rightPanel.add(hoaDonPanel, "HoaDon");
    rightPanel.add(danhmucPanel,"DanhMuc");
    cardLayout.show(rightPanel, "SanPham");
    btnSanPham.addActionListener(e -> {
      cardLayout.show(rightPanel, "SanPham");
    });
    btnHoaDon.addActionListener(e -> {
      cardLayout.show(rightPanel, "HoaDon");
    });
    btnDanhMuc.addActionListener(e->{
      cardLayout.show(rightPanel, "DanhMuc");
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
    lbSoluong=new JLabel("Số lượng:");
    TfSoluong=new JTextField(20);
    lbTenDanhMuc = new JLabel("Tên Danh Mục:");
    lbTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp:");
    lbNguoiNhap=new JLabel("Tên Người Nhập:");

    int dodai = lbTenNhaCungCap.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbMasanpham.getPreferredSize().height);
    setLabelSize(lbMasanpham, labelSize);
    setLabelSize(lbTensanpham, labelSize);
    setLabelSize(lbGiaBan, labelSize);
    setLabelSize(lbGiaNhap, labelSize);
    setLabelSize(lbMoTa, labelSize);
    setLabelSize(lbThoiGianNhap, labelSize);
    setLabelSize(lbSoluong,labelSize);
    setLabelSize(lbTenDanhMuc, labelSize);
    setLabelSize(lbTenNhaCungCap, labelSize);
    setLabelSize(lbNguoiNhap,labelSize);
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
    DanhMucService danhMucService = new DanhMucService();
    List<Item> danhMucNames = danhMucService.getDanhMucList();
    CbTenDanhMuc = new JComboBox<>(danhMucNames.toArray(new Item[0]));
    CbTenDanhMuc.setPreferredSize(new Dimension(200, CbTenDanhMuc.getPreferredSize().height));
    G.add(lbTenDanhMuc);
    G.add(CbTenDanhMuc);
    JPanel H = new JPanel();
    H.setBackground(Color.decode("#CDE8E5"));
    NhaCungCapService nhaCungCapService = new NhaCungCapService();
    List<Item> nhaCungCapNames = nhaCungCapService.getAllTenNhaCungCap();
    CbTenNhaCungCap = new JComboBox<>(nhaCungCapNames.toArray(new Item[0]));
    CbTenNhaCungCap.setPreferredSize(new Dimension(200, CbTenNhaCungCap.getPreferredSize().height));
    H.add(lbTenNhaCungCap);
    H.add(CbTenNhaCungCap);
    JPanel I=new JPanel();
    I.setBackground(Color.decode("#CDE8E5"));
//      NguoiNhapService nguoiNhapService = new NguoiNhapService();
//      List<Item> nguoiNhapNames = nguoiNhapService.getDanhMucList();
//      CbNguoiNhap = new JComboBox<>(nguoiNhapNames.toArray(new Item[0]));
//      CbNguoiNhap.setPreferredSize(new Dimension(200, CbNguoiNhap.getPreferredSize().height));
//    I.add(lbNguoiNhap);
//    I.add(CbNguoiNhap);
    panel_row2.add(taokhoangcach2);
    panel_row2.add(G);
    panel_row2.add(H);
    panel_row2.add(I);
    panel.add(panel_row2);

    JPanel panel_row3 = new JPanel();
    panel_row3.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 20));
    panel_row3.setBackground(Color.decode("#CDE8E5"));
    table = new JTable(new DefaultTableModel(
        new Object[]{"ID Sản Phẩm", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán Ra", "Giá Nhập","Mô Tả", "Thời Gian Nhập","Số Lượng", "Tên Danh Mục", "Tên Nhà Cung Cấp"}, 0));
    JTableHeader header=table.getTableHeader();

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(1500, 600));
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

  private JPanel createHoaDonPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel row_0=new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT,1,10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0=new JPanel();
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1=new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT,23,1));
    JPanel subrow1_1=new JPanel();
    row_1.add(subrow1_1);
    JPanel subrow1_2=new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);

    lbIdhoadon=new JLabel("ID Hoá Đơn:");
    TfIdhoadon=new JTextField(20);
    lbTongTienThanhToan=new JLabel("Tổng Tiền Thanh Toán:");
    TfTongTienThanhToan=new JTextField(20);
    lbNgayThanhToan=new JLabel("Ngày Thanh Toán:");
    TfNgayThanhToan=new JTextField(20);
    int dodai=lbTongTienThanhToan.getPreferredSize().width;
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
    JPanel row_2=new JPanel();

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(1500, 300));
    panel.setBackground(Color.decode("#CDE8E5"));
    return panel;
  }
  private JPanel createDanhMucPanel() {
    JPanel panel=new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
    JPanel row_0=new JPanel();
    row_0.setLayout(new FlowLayout(FlowLayout.LEFT,1,10));
    row_0.setBackground(Color.decode("#CDE8E5"));
    JPanel padding_0=new JPanel();
    padding_0.setBackground(Color.decode("#CDE8E5"));
    row_0.add(padding_0);
    panel.add(row_0);
    JPanel row_1=new JPanel();
    row_1.setLayout(new FlowLayout(FlowLayout.LEFT,23,1));
    row_1.setBackground(Color.decode("#CDE8E5"));
    JPanel subrow1_1=new JPanel();
    subrow1_1.setBackground(Color.decode("#CDE8E5"));
    row_1.add(subrow1_1);
    JPanel subrow1_2=new JPanel();
    subrow1_2.setLayout(new GridBagLayout());
    subrow1_2.setBackground(Color.decode("#CDE8E5"));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);
    lbTenDanhmuc=new JLabel("Tên Danh Mục:");
    TfTenDanhmuc=new JTextField(20);
    lbMotadanhmuc=new JLabel("Mô Tả Danh Mục:");
    TfMotadanhmuc=new JTextField(20);
    int dodai=lbMotadanhmuc.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbTenDanhmuc.getPreferredSize().height);
    setLabelSize(lbTenDanhmuc, labelSize);
    setLabelSize(lbMotadanhmuc, labelSize);
    addComponent(subrow1_2, lbTenDanhmuc, gbc, 0, 0);
    addComponent(subrow1_2, TfTenDanhmuc, gbc, 1, 0);
    addComponent(subrow1_2, lbMotadanhmuc, gbc, 0, 1);
    addComponent(subrow1_2, TfMotadanhmuc, gbc, 1, 1);
    row_1.add(subrow1_2);
    panel.add(row_1);
    JPanel row_2=new JPanel();
    row_2.setLayout(new FlowLayout(FlowLayout.CENTER,20,1));
    JPanel row2_sub1=new JPanel();
    row2_sub1.setBackground(Color.decode("#CDE8E5"));
    JPanel row2_sub2=new JPanel();
    row2_sub2.setBackground(Color.decode("#CDE8E5"));
    table_danhmuc=new JTable(new DefaultTableModel(
        new Object[]{"ID Danh Mục", "Tên Danh Mục", "Mô Tả Danh Mục" }, 0
    ));
    JTableHeader header=table_danhmuc.getTableHeader();
    header.setFont(new Font("Tamoha",Font.BOLD,18));
    JScrollPane scrollPane = new JScrollPane(table_danhmuc);
    scrollPane.setPreferredSize(new Dimension(1500, 600));
    row_2.add(row2_sub1);
    row_2.add(scrollPane);
    row_2.add(row2_sub2);
    row_2.setBackground(Color.decode("#CDE8E5"));
    panel.add(row_2);
    JPanel row_3=new JPanel();
    row_3.setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
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
  private void setLabelSize(JLabel label, Dimension size) {
    label.setPreferredSize(size);
  }

  private void addComponent(JPanel panel, Component component, GridBagConstraints gbc, int x,int y) {
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
}
