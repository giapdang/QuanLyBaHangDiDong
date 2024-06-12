package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomeView extends JFrame {

  private JButton btnSanPham;
  private JButton btnHoaDon;
  private JButton btnDanhMuc;
  private JButton btnNhaCungCap;
  private JButton btnKhachHang;
  private JButton btnNhanVien;
  private JTable table;
  private JButton btnAdd;
  private JButton btnEdit;
  private JButton btnDelete;
  private JLabel lbMasanpham;
  private JLabel lbTensanpham;
  private JLabel lbGiaBan;
  private JLabel lbGiaNhap;
  private JLabel lbMoTa;
  private JLabel lbThoiGianNhap;
  private JLabel lbTenDanhMuc;
  private JLabel lbTenNhaCungCap;
  private JTextField TfMasanpham;
  private JTextField TfTensanpham;
  private JTextField TfGiaBan;
  private JTextField TfGiaNhap;
  private JTextField TfMoTa;
  private JTextField TfThoiGianNhap;
  private JComboBox<String> CbTenDanhMuc;
  private JComboBox<String> CbTenNhaCungCap;

  public HomeView() {
    this.setTitle("Quản Lý Bán Hàng Thiết Bị Di Động");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    HomeUi();
    this.setVisible(true);
  }

  public void HomeUi() {
    // Create left panel with buttons
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(6, 1));
    leftPanel.setPreferredSize(new Dimension(300, 0));
    leftPanel.setBackground(Color.decode("#212121"));
    btnSanPham = createButton("SẢN PHẨM");
    btnHoaDon = createButton("HOÁ ĐƠN");
    btnDanhMuc = createButton("DANH MỤC");
    btnNhaCungCap = createButton("NHÀ CUNG CẤP");
    btnKhachHang = createButton("KHÁCH HÀNG");
    btnNhanVien = createButton("NHÂN VIÊN");

    leftPanel.add(btnSanPham);
    leftPanel.add(btnHoaDon);
    leftPanel.add(btnDanhMuc);
    leftPanel.add(btnNhaCungCap);
    leftPanel.add(btnKhachHang);
    leftPanel.add(btnNhanVien);

    // Create right panel
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BorderLayout());

    JPanel rightPanel_row1 = new JPanel();
    rightPanel_row1.setBackground(Color.decode("#CDE8E5"));
    rightPanel_row1.setLayout(new GridBagLayout());
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
    lbTenDanhMuc = new JLabel("Tên Danh Mục:");
    lbTenNhaCungCap = new JLabel("Tên Nhà Cung Cấp:");

    int dodai = lbTenNhaCungCap.getPreferredSize().width;
    Dimension labelSize = new Dimension(dodai, lbMasanpham.getPreferredSize().height);
    setLabelSize(lbMasanpham, labelSize);
    setLabelSize(lbTensanpham, labelSize);
    setLabelSize(lbGiaBan, labelSize);
    setLabelSize(lbGiaNhap, labelSize);
    setLabelSize(lbMoTa, labelSize);
    setLabelSize(lbThoiGianNhap, labelSize);
    setLabelSize(lbTenDanhMuc, labelSize);
    setLabelSize(lbTenNhaCungCap, labelSize);

    addComponent(rightPanel_row1, lbMasanpham, gbc, 0, 0);
    addComponent(rightPanel_row1, TfMasanpham, gbc, 1, 0);
    addComponent(rightPanel_row1, lbTensanpham, gbc, 0, 1);
    addComponent(rightPanel_row1, TfTensanpham, gbc, 1, 1);
    addComponent(rightPanel_row1, lbGiaBan, gbc, 0, 2);
    addComponent(rightPanel_row1, TfGiaBan, gbc, 1, 2);
    addComponent(rightPanel_row1, lbGiaNhap, gbc, 0, 3);
    addComponent(rightPanel_row1, TfGiaNhap, gbc, 1, 3);
    addComponent(rightPanel_row1, lbMoTa, gbc, 0, 4);
    addComponent(rightPanel_row1, TfMoTa, gbc, 1, 4);
    addComponent(rightPanel_row1, lbThoiGianNhap, gbc, 0, 5);
    addComponent(rightPanel_row1, TfThoiGianNhap, gbc, 1, 5);

    JPanel G = new JPanel();
    G.setBackground(Color.decode("#CDE8E5"));
    String[] items_danhmuc = {"Tự", "Thêm", "Tên", "Các", "Danh", "Mục", "Nhé", "!"};
    CbTenDanhMuc = new JComboBox<>(items_danhmuc);
    CbTenDanhMuc.setPreferredSize(new Dimension(100, CbTenDanhMuc.getPreferredSize().height));
    String[] items_nhacungcap = {"Tự", "Thêm", "Tên", "Các", "Nhà", "Cung", "Cấp", "Đi", "Nhé", "!"};
    CbTenNhaCungCap = new JComboBox<>(items_nhacungcap);
    CbTenNhaCungCap.setPreferredSize(new Dimension(121, CbTenDanhMuc.getPreferredSize().height));
    G.add(lbTenDanhMuc);
    G.add(CbTenDanhMuc);
    G.add(lbTenNhaCungCap);
    G.add(CbTenNhaCungCap);

    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    rightPanel_row1.add(G, gbc);

    rightPanel.add(rightPanel_row1, BorderLayout.NORTH);

    // Create right panel with table and action buttons
    JPanel rightPanel_row2 = new JPanel();
    rightPanel_row2.setBackground(Color.decode("#CDE8E5"));
    rightPanel_row2.setLayout(new BorderLayout());

    table = new JTable(new DefaultTableModel(
        new Object[]{"ID Sản Phẩm", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán Ra", "Giá Nhập",
            "Mô Tả", "Thời Gian Nhập", "Tên Danh Mục", "Tên Nhà Cung Cấp"}, 0
    ));
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(1500, 600));
    rightPanel_row2.add(scrollPane, BorderLayout.CENTER);
    rightPanel.add(rightPanel_row2, BorderLayout.CENTER);

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

    actionPanel.add(btnAdd);
    actionPanel.add(btnEdit);
    actionPanel.add(btnDelete);

    rightPanel.add(actionPanel, BorderLayout.SOUTH);

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

  private void setLabelSize(JLabel label, Dimension size) {
    label.setPreferredSize(size);
  }

  private void addComponent(JPanel panel, Component component, GridBagConstraints gbc, int x, int y) {
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
}
