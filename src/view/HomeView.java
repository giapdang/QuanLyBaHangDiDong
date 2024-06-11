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
    leftPanel.setLayout(new GridLayout(6,1));
    leftPanel.setPreferredSize(new Dimension(300,0));
    leftPanel.setBackground(Color.decode("#212121"));
    btnSanPham = new JButton("SẢN PHẨM");
    btnHoaDon = new JButton("HOÁ ĐƠN");
    btnDanhMuc = new JButton("DANH MỤC");
    btnNhaCungCap = new JButton("NHÀ CUNG CẤP");
    btnKhachHang = new JButton("KHÁCH HÀNG");
    btnNhanVien = new JButton("NHÂN VIÊN");
    
    btnSanPham.setFont(new Font("Arial",Font.BOLD,30));
    btnHoaDon.setFont(new Font("Arial",Font.BOLD,30));
    btnDanhMuc.setFont(new Font("Arial",Font.BOLD,30));
    btnNhaCungCap.setFont(new Font("Arial",Font.BOLD,30));
    btnKhachHang.setFont(new Font("Arial",Font.BOLD,30));
    btnNhanVien.setFont(new Font("Arial",Font.BOLD,30)); 
    
    btnSanPham.setBackground(Color.decode("#212121"));
    btnHoaDon.setBackground(Color.decode("#212121"));
    btnDanhMuc.setBackground(Color.decode("#212121"));
    btnNhaCungCap.setBackground(Color.decode("#212121"));
    btnKhachHang.setBackground(Color.decode("#212121"));
    btnNhanVien.setBackground(Color.decode("#212121"));
    
    btnSanPham.setForeground(Color.decode("#FBFBFB"));
    btnHoaDon.setForeground(Color.decode("#FBFBFB"));
    btnNhaCungCap.setForeground(Color.decode("#FBFBFB"));
    btnKhachHang.setForeground(Color.decode("#FBFBFB"));
    btnNhanVien.setForeground(Color.decode("#FBFBFB"));
    btnDanhMuc.setForeground(Color.decode("#FBFBFB"));
    leftPanel.add(btnSanPham);
    leftPanel.add(btnHoaDon);
    leftPanel.add(btnDanhMuc);
    leftPanel.add(btnNhaCungCap);
    leftPanel.add(btnKhachHang);
    leftPanel.add(btnNhanVien);
// Create right panel 
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
    
    JPanel rightPanel_row1=new JPanel();
    rightPanel_row1.setBackground(Color.decode("#CDE8E5"));
    rightPanel_row1.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0, 1, 5, 5);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.insets.right = 1000;
    gbc.ipadx = 5; 
    gbc.ipady = 1; 
    lbMasanpham=new JLabel("Mã Sản Phẩm:");
    TfMasanpham=new JTextField(30);
    lbTensanpham=new JLabel("Tên Sản Phẩm:");
    TfTensanpham=new JTextField(30);
    lbGiaBan=new JLabel("Giá Bán:");
    TfGiaBan=new JTextField(30);
    lbGiaNhap=new JLabel("Giá Nhập:");
    TfGiaNhap=new JTextField(30);
    lbMoTa=new JLabel("Mô Tả:");
    TfMoTa=new JTextField(30);
    lbThoiGianNhap=new JLabel("Thời Gian Nhập:");
    TfThoiGianNhap=new JTextField(30);
    lbTenDanhMuc=new JLabel("Tên Danh Mục:");
    lbTenNhaCungCap=new JLabel("Tên Nhà Cung Cấp:");
    int dodai = lbTenNhaCungCap.getPreferredSize().width;
    lbMasanpham.setPreferredSize(new Dimension(dodai,lbMasanpham.getPreferredSize().height));
    lbTensanpham.setPreferredSize(new Dimension(dodai,lbTensanpham.getPreferredSize().height));
    lbGiaBan.setPreferredSize(new Dimension(dodai,lbGiaBan.getPreferredSize().height));
    lbGiaNhap.setPreferredSize(new Dimension(dodai,lbGiaNhap.getPreferredSize().height));
    lbMoTa.setPreferredSize(new Dimension(dodai,lbMoTa.getPreferredSize().height));
    lbThoiGianNhap.setPreferredSize(new Dimension(dodai,lbThoiGianNhap.getPreferredSize().height));
    lbTenDanhMuc.setPreferredSize(new Dimension(dodai,lbTenDanhMuc.getPreferredSize().height));  
    lbTenNhaCungCap.setPreferredSize(new Dimension(dodai,lbTenNhaCungCap.getPreferredSize().height));
    JPanel A=new JPanel();
    A.setBackground(Color.decode("#CDE8E5"));
    A.setLayout(new FlowLayout(FlowLayout.LEFT));
    A.add(lbMasanpham);
    A.add(TfMasanpham);
    rightPanel_row1.add(A,gbc);
    gbc.gridy++;
    
    JPanel B=new JPanel();
    B.setBackground(Color.decode("#CDE8E5"));
    B.setLayout(new FlowLayout(FlowLayout.LEFT));
    B.add(lbTensanpham);
    B.add(TfTensanpham);
    rightPanel_row1.add(B,gbc);
    gbc.gridy++;
    
    JPanel C=new JPanel();
    C.setBackground(Color.decode("#CDE8E5"));
    C.setLayout(new FlowLayout(FlowLayout.LEFT));
    C.add(lbGiaBan);
    C.add(TfGiaBan);
    rightPanel_row1.add(C,gbc);
    gbc.gridy++;
    
    JPanel D=new JPanel();
    D.setBackground(Color.decode("#CDE8E5"));
    D.setLayout(new FlowLayout(FlowLayout.LEFT));
    D.add(lbGiaNhap);
    D.add(TfGiaNhap);
    rightPanel_row1.add(D,gbc);
    gbc.gridy++;
    
    JPanel E=new JPanel();
    E.setBackground(Color.decode("#CDE8E5"));
    E.setLayout(new FlowLayout(FlowLayout.LEFT));
    E.add(lbMoTa);
    E.add(TfMoTa);
    rightPanel_row1.add(E,gbc);
    gbc.gridy++;
    
    JPanel F=new JPanel();
    F.setBackground(Color.decode("#CDE8E5"));
    F.setLayout(new FlowLayout(FlowLayout.LEFT));
    F.add(lbThoiGianNhap);
    F.add(TfThoiGianNhap);
    rightPanel_row1.add(F,gbc);
    gbc.gridy++;
    
    JPanel G = new JPanel();
    G.setBackground(Color.decode("#CDE8E5"));
    String[] items_danhmuc = {"Tự", "Thêm", "Tên", "Các","Danh","Mục","Nhé","!"};
    CbTenDanhMuc=new JComboBox<>(items_danhmuc);
    CbTenDanhMuc.setPreferredSize(new Dimension(100, CbTenDanhMuc.getPreferredSize().height));
    String[] items_nhacungcap = {"Tự", "Thêm", "Tên", "Các","Nhà","Cung","Cấp","Đi","Nhé","!"};
    CbTenNhaCungCap=new JComboBox<>(items_nhacungcap);
    CbTenNhaCungCap.setPreferredSize(new Dimension(121, CbTenDanhMuc.getPreferredSize().height));
    G.add(lbTenDanhMuc);
    G.add(CbTenDanhMuc);
    G.add(lbTenNhaCungCap);
    G.add(CbTenNhaCungCap);
    
    rightPanel_row1.add(G,gbc);
    rightPanel.add(rightPanel_row1);

// Create right panel with table and action buttons
    JPanel rightPanel_row2=new JPanel();
    rightPanel_row2.setBackground(Color.decode("#CDE8E5"));
    JPanel chuabang=new JPanel();
    chuabang.setLayout(new BorderLayout());
    table = new JTable(new DefaultTableModel(
        new Object[]{"ID Sản Phẩm", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán Ra", "Giá Nhập",
            "Mô Tả", "Thời Gian Nhập", "Tên Danh Mục", "Tên Nhà Cung Cấp"}, 0
    ));
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(1500, 600));
    chuabang.add(scrollPane,BorderLayout.NORTH);
    rightPanel_row2.add(chuabang);
    rightPanel.add(rightPanel_row2);
    JPanel actionPanel = new JPanel();
    actionPanel.setBackground(Color.decode("#CDE8E5"));
    actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));
    rightPanel.add(actionPanel);
    btnAdd = new JButton("Thêm");
    btnAdd.setPreferredSize(new Dimension(100,50));
    btnAdd.setFont(new Font("Arial",Font.BOLD,20));
    btnEdit = new JButton("Sửa");
    btnEdit.setPreferredSize(new Dimension(100,50));
    btnEdit.setFont(new Font("Arial",Font.BOLD,20));
    btnDelete = new JButton("Xóa");
    btnDelete.setPreferredSize(new Dimension(100,50));
    btnDelete.setFont(new Font("Arial",Font.BOLD,20));
    actionPanel.add(btnAdd);
    actionPanel.add(btnEdit);
    actionPanel.add(btnDelete);
    
    JSplitPane spmain=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPanel, rightPanel);
    this.setContentPane(spmain);
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
}
