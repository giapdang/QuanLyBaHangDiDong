package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.response.Item;
import model.service.DanhMucService;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import model.service.DonHangService;
import model.service.KhachHangService;

//import model.service.NguoiNhapService;
import model.service.NguoiNhapService;

import model.service.NguoiNhapService;

import model.service.NhaCungCapService;
import model.service.SanPhamService;

public class HomeView extends JFrame {

    //Cac thuoc tinh dung de lam trang chinh
    private JPanel rightPanel;
    private JPanel sanPhamPanel;
    private JPanel hoaDonPanel;
    private JPanel danhmucPanel;
    private JPanel nhaCungCapPanel;
    private JPanel khachhangPanel;
    private JPanel nhanvienPanel;
    private JPanel donhangPanel;
    private JPanel khodangPanel;
    private JPanel chitietdonhangPanel;
    private CardLayout cardLayout;
    private JButton btnSanPham;
    private JButton btnHoaDon;
    private JButton btnDanhMuc;
    private JButton btnNhaCungCap;
    private JButton btnKhachHang;
    private JButton btnNhanVien;
    private JButton btnDonHang;
    private JButton btnChitietdonhang;
    private JButton btnKhoHang;
    private JButton btnBaocao;
    private JButton btnLogout;
    private JButton btnShutdown;
    private JButton previousButton;

    //Cac thuoc tinh dung trong muc San Pham
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
    private JButton btnSearchsanpham;
    private JTextField TfSearchsanpham;

    //Cac thuoc tinh dung trong muc Hoa Don
    private JTable table_hoadon;
    private JButton btnSearchhoadon;
    private JTextField TfSearchhoadon;
    private JButton btnViewhoadon;

    //Cac thuoc tinh dung trong muc Danh Muc
    private JLabel lbTenDanhmuc;
    private JTextField TfTenDanhmuc;
    private JLabel lbMotadanhmuc;
    private JTextField TfMotadanhmuc;
    private JTable table_danhmuc;
    private JButton btnAdd1, btnEdit1, btnDelete1;
    private JButton btnSearchdanhmuc;
    private JTextField TfSearchdanhmuc;

    //Cac thuoc tinh dung trong muc Nha Cung Cap
    private JLabel lbTenNhaCungCap1;
    private JTextField TfTenNhaCungCap1;
    private JLabel lbDiachi;
    private JTextField TfDiachi;
    private JLabel lbSodienthoai;
    private JTextField TfSodienthoai;
    private JTable table_nhacungcap;
    private JButton btnAddncc, btnEditncc, btnDeletencc;
    private JButton btnSearchnhacungcap;
    private JTextField TfSearchnhacungcap;

    //Cac thuoc tinh dung trong muc Khach Hang
    private JLabel lbTenKhachHang;
    private JTextField TfTenKhachHang;
    private JLabel lbDiachiKhachHang;
    private JTextField TfDiachiKhachHang;
    private JLabel lbSodienthoaiKhachHang;
    private JTextField TfSodienthoaiKhachHang;
    private JLabel lbEmailKhachHang;
    private JTextField TfEmailKhachHang;
    private JTable table_khachhang;
    private JButton btnAddkh, btnEditkh, btnDeletekh;
    private JButton btnSearchkhachhang;
    private JTextField TfSearchkhachhang;

    //Cac thuoc tinh dung trong muc Nhan Vien
    private JLabel lbTenNhanVien;
    private JTextField TfTenNhanVien;
    private JLabel lbEmailNhanVien;
    private JTextField TfEmailNhanVien;
    private JLabel lbmatkhauNhanVien;
    private JTextField TfmatkhauNhanVien;
    private JLabel lbSodienthoaiNhanVien;
    private JTextField TfSodienthoaiNhanVien;
    private JTable table_nhanvien;
    private JButton btnAddnv, btnEditnv, btnDeletenv;
    private JButton btnSearchnhanvien;
    private JTextField TfSearchnhanvien;

    //Cac thuoc tinh dung trong muc Don Hang
    private JLabel lbTrangthaidonhang;
    private JComboBox<Item> CbTrangthaidonhang;
    private JLabel lbTensanphamdonhang;
    private JComboBox<Item> CbTensanphamdonhang;
    private JLabel lbSoluongdonhang;
    private JTextField TfSoluongdonhang;
    private JLabel lbGiaBandonhang;
    private JComboBox<Item> CbGiaBandonhang;
    private JLabel lbtenKhachhangdonhang;
    private JComboBox<Item> CbtenKhachhangdonhang;
    private JTable table_donhang;
    private JButton btnAdddonhang, btnEditdonhang, btnDeletedonhang;
    private JButton btnSearchdonhang;
    private JTextField TfSearchdonhang;

    //Cac thuoc tinh dung trong muc Kho Hang
    private JTable table_khohang;
    private JButton btnViewkhohang;
    private JButton btnSearchkhohang;
    private JTextField TfSearchkhohang;

    //Cac thuoc tinh dung trong muc Chi Tiet Don Hang
    // ID Chi tiet don hang
    private JLabel lbidchitietdonhang;
    // ID Don Hang
    private JLabel lbiddonhang_chitietdonhang;
    private JTextField Tfiddonhang_chitietdonhang;
    private JLabel lbTensanphamchitietdonhang;
    private JTextField TfTensanphamchitietdonhang;
    private JLabel lbTenkhachhangchitietdonhang;
    private JTextField TfTenkhachhangchitietdonhang;
    private JLabel lbSoluongchitietdonhang;
    private JTextField TfSoluongchitietdonhang;
    private JLabel lbGiabanchitietdonhang;
    private JTextField TfGiabanchitietdonhang;
    private JTable table_chitietdonhang;
//    private JButton btnAddchitietdonhang, btnEditchitietdonhang, btnDeletechitietdonhang, btnExitchitietdonhang;
    private JButton btnUpdatechithietdonhang, btnEditchitietdonhang, btnViewchitietdonhang;
    private JButton btnSearchchitietdonhang;
    private JTextField TfSearchchitietdonhang;

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
        leftPanel.setLayout(new BorderLayout());
        Dimension fixedWidth = new Dimension(300, 0);
        leftPanel.setPreferredSize(fixedWidth);
        leftPanel.setMinimumSize(fixedWidth);
        leftPanel.setMaximumSize(fixedWidth);
        leftPanel.setBackground(Color.decode("#E5E5E5"));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        row_0.setBackground(Color.decode("#FBFBFB"));
        row_0.setPreferredSize(new Dimension(250, 100));
        LineBorder lineBorder = new LineBorder(Color.BLACK, 3);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(lineBorder, "Tác Vụ");
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        ImageIcon icon = new ImageIcon(getClass().getResource("logout.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(25, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnLogout = new JButton(resizedicon);
        btnLogout.setActionCommand("Đăng Xuất");
        btnLogout.setBackground(Color.decode("#3F4952"));
        btnLogout.setPreferredSize(new Dimension(50, 50));
        btnLogout.addActionListener((e) -> {
            login ui = new login("Đăng Nhập");
            ui.showWindow();
            this.dispose();
        });
        ImageIcon icon1 = new ImageIcon(getClass().getResource("shutdown.png"));
        Image original1 = icon1.getImage();
        Image resizedImage1 = original1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedicon1 = new ImageIcon(resizedImage1);
        btnShutdown = new JButton(resizedicon1);
        btnShutdown.setActionCommand("Thoát");
        btnShutdown.setBackground(Color.decode("#3F4952"));
        btnShutdown.setPreferredSize(new Dimension(50, 50));
        btnShutdown.addActionListener((e) -> {
            System.exit(0);
        });
        row_0.setBorder(titledBorder);
        row_0.add(btnLogout);
        row_0.add(btnShutdown);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new GridLayout(10, 1));
        TitledBorder titledBorder1 = BorderFactory.createTitledBorder(lineBorder, "Danh Mục");
        titledBorder1.setTitleColor(Color.BLACK);
        titledBorder1.setTitleFont(new Font("Arial", Font.BOLD, 15));
        titledBorder1.setTitleJustification(TitledBorder.LEFT);
        titledBorder1.setTitlePosition(TitledBorder.TOP);
        row_1.setBorder(titledBorder1);
        btnSanPham = createButton("SẢN PHẨM");
        btnSanPham.setBackground(Color.decode("#638787"));
        btnSanPham.setForeground(Color.decode("#FBFBFB"));
        previousButton = btnSanPham;
        btnHoaDon = createButton("HOÁ ĐƠN");
        btnDanhMuc = createButton("DANH MỤC");
        btnNhaCungCap = createButton("NHÀ CUNG CẤP");
        btnKhachHang = createButton("KHÁCH HÀNG");
        btnNhanVien = createButton("NHÂN VIÊN");
        btnDonHang = createButton("ĐƠN HÀNG");
        btnChitietdonhang = createButton("CHI TIẾT ĐƠN HÀNG");
        btnKhoHang = createButton("KHO HÀNG");
        btnBaocao = createButton("BÁO CÁO");
        row_1.add(btnSanPham);
        row_1.add(btnHoaDon);
        row_1.add(btnDanhMuc);
        row_1.add(btnNhaCungCap);
        row_1.add(btnKhachHang);
        row_1.add(btnNhanVien);
        row_1.add(btnDonHang);
        row_1.add(btnChitietdonhang);
        row_1.add(btnKhoHang);
        row_1.add(btnBaocao);
        leftPanel.add(row_0, BorderLayout.NORTH);
        leftPanel.add(row_1, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        rightPanel = new JPanel(cardLayout);
        sanPhamPanel = createSanPhamPanel();
        hoaDonPanel = createHoaDonPanel();
        danhmucPanel = createDanhMucPanel();
        nhaCungCapPanel = createNhaCungCapPanel();
        khachhangPanel = createKhachHangPanel();
        nhanvienPanel = createNhanVienPanel();
        donhangPanel = createDonHangPanel();
        chitietdonhangPanel = creatchitietdonhangPanel();
        khodangPanel = createKhoHangPanel();
        rightPanel.add(sanPhamPanel, "SanPham");
        rightPanel.add(hoaDonPanel, "HoaDon");
        rightPanel.add(danhmucPanel, "DanhMuc");
        rightPanel.add(nhaCungCapPanel, "NhaCungCap");
        rightPanel.add(khachhangPanel, "KhachHang");
        rightPanel.add(nhanvienPanel, "NhanVien");
        rightPanel.add(donhangPanel, "DonHang");
        rightPanel.add(khodangPanel, "KhoHang");
        rightPanel.add(chitietdonhangPanel, "ChiTietDonHang");
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
        btnDonHang.addActionListener(e -> {
            cardLayout.show(rightPanel, "DonHang");
        });
        btnChitietdonhang.addActionListener(e -> {
            cardLayout.show(rightPanel, "ChiTietDonHang");
        });
        btnKhoHang.addActionListener(e -> {
            cardLayout.show(rightPanel, "KhoHang");
        });
        JSplitPane spmain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        this.setContentPane(spmain);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.setBackground(Color.decode("#252A2D"));
        button.setForeground(Color.decode("#FBFBFB"));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if (previousButton != null) {
                    previousButton.setBackground(Color.decode("#252A2D"));
                    previousButton.setForeground(Color.decode("#FBFBFB"));
                }

                clickedButton.setBackground(Color.decode("#638787"));
                clickedButton.setForeground(Color.decode("#FBFBFB"));
                previousButton = clickedButton;
            }
        });
        return button;
    }

    //San Pham
    private JPanel createSanPhamPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel panel_row0 = new JPanel();
        panel_row0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 20));
        panel_row0.setBackground(Color.decode("#D1E8D8"));
        JPanel taokhoangcach = new JPanel();
        taokhoangcach.setBackground(Color.decode("#D1E8D8"));
        panel_row0.add(taokhoangcach);
        panel.add(panel_row0);
        JPanel chua_panel_row1 = new JPanel();
        chua_panel_row1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        chua_panel_row1.setBackground(Color.decode("#D1E8D8"));
        JPanel panel_row1 = new JPanel();
        panel_row1.setBackground(Color.decode("#D1E8D8"));
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
        taokhoangcach1.setBackground(Color.decode("#D1E8D8"));
        chua_panel_row1.add(taokhoangcach1);
        chua_panel_row1.add(panel_row1);
        panel.add(chua_panel_row1);

        JPanel panel_row2 = new JPanel();
        panel_row2.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        panel_row2.setBackground(Color.decode("#D1E8D8"));
        JPanel taokhoangcach2 = new JPanel();
        taokhoangcach2.setBackground(Color.decode("#D1E8D8"));
        JPanel G = new JPanel();
        G.setBackground(Color.decode("#D1E8D8"));

        DanhMucService danhMucService = new DanhMucService(null);
        List<Item> danhMucNames = danhMucService.getDanhMucList();
        CbTenDanhMuc = new JComboBox<>(danhMucNames.toArray(new Item[0]));
        CbTenDanhMuc.setPreferredSize(new Dimension(170, CbTenDanhMuc.getPreferredSize().height));

        G.add(lbTenDanhMuc);
        G.add(CbTenDanhMuc);
        JPanel H = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 1));
        H.setBackground(Color.decode("#D1E8D8"));

        NhaCungCapService nhaCungCapService = new NhaCungCapService(null);
        List<Item> nhaCungCapNames = nhaCungCapService.getAllTenNhaCungCap();
        CbTenNhaCungCap = new JComboBox<>(nhaCungCapNames.toArray(new Item[0]));
        CbTenNhaCungCap.setPreferredSize(new Dimension(170, CbTenNhaCungCap.getPreferredSize().height));

        H.add(lbTenNhaCungCap);
        H.add(CbTenNhaCungCap);
        JPanel I = new JPanel();
        I.setBackground(Color.decode("#D1E8D8"));
        NguoiNhapService nguoiNhapService = new NguoiNhapService(null);

        List<Item> nguoiNhapNames = nguoiNhapService.getTenNhanVienList();
        CbNguoiNhap = new JComboBox<>(nguoiNhapNames.toArray(new Item[0]));
        CbNguoiNhap.setPreferredSize(new Dimension(170, CbNguoiNhap.getPreferredSize().height));
        I.add(lbNguoiNhap);
        I.add(CbNguoiNhap);

        JPanel padding0 = new JPanel();
        padding0.setBackground(Color.decode("#D1E8D8"));
        padding0.setPreferredSize(new Dimension(45, padding0.getPreferredSize().height));

        JPanel J = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        J.setBackground(Color.decode("#D1E8D8"));
        TfSearchsanpham = new JTextField(20);
        TfSearchsanpham.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchsanpham = new JButton(resizedicon);
        btnSearchsanpham.setActionCommand("Tìm Kiếm");
        btnSearchsanpham.setBackground(Color.decode("#3F4952"));
        J.add(TfSearchsanpham);
        J.add(btnSearchsanpham);
        panel_row2.add(taokhoangcach2);
        panel_row2.add(G);
        panel_row2.add(H);
        panel_row2.add(I);
        panel_row2.add(padding0);
        panel_row2.add(J);
        panel.add(panel_row2);

        JPanel panel_row3 = new JPanel();
        panel_row3.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 20));
        panel_row3.setBackground(Color.decode("#D1E8D8"));
        table = new JTable(new DefaultTableModel(
                new Object[]{"ID Sản Phẩm", "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán Ra", "Giá Nhập",
                    "Mô Tả", "Thời Gian Nhập", "Tên Danh Mục", "Tên Nhà Cung Cấp"}, 0));
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        panel_row3.add(scrollPane);
        panel.add(panel_row3);
        JPanel actionPanel = new JPanel();
        actionPanel.setBackground(Color.decode("#D1E8D8"));
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnAdd = new JButton("Thêm");
        btnAdd.setPreferredSize(new Dimension(100, 50));
        btnAdd.setBackground(Color.decode("#3F4952"));
        btnAdd.setForeground(Color.decode("#FFFFFF"));
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnEdit = new JButton("Sửa");
        btnEdit.setPreferredSize(new Dimension(100, 50));
        btnEdit.setFont(new Font("Arial", Font.BOLD, 20));
        btnEdit.setBackground(Color.decode("#3F4952"));
        btnEdit.setForeground(Color.decode("#FFFFFF"));
        btnDelete = new JButton("Xóa");
        btnDelete.setPreferredSize(new Dimension(100, 50));
        btnDelete.setBackground(Color.decode("#3F4952"));
        btnDelete.setForeground(Color.decode("#FFFFFF"));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        actionPanel.add(btnAdd);
        actionPanel.add(btnEdit);
        actionPanel.add(btnDelete);
        panel.add(actionPanel);
        return panel;
    }

    //Hoa Don
    private JPanel createHoaDonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 10));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 45));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JLabel hoadonthanhtoan = new JLabel("Hoá Đơn Thanh Toán");
        hoadonthanhtoan.setFont(new Font("Arial", Font.BOLD, 40));
        row_1.add(hoadonthanhtoan);
        panel.add(row_1);
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchhoadon = new JTextField(20);
        TfSearchhoadon.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchhoadon = new JButton(resizedicon);
        btnSearchhoadon.setActionCommand("Tìm Kiếm1");
        btnSearchhoadon.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchhoadon);
        row_2.add(btnSearchhoadon);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setBackground(Color.decode("#D1E8D8"));
        table_hoadon = new JTable(new DefaultTableModel(
                new Object[]{"ID Hoá Đơn", "Tên Khách Hàng", "Địa Chỉ", "Email", "Số Điện Thoại",
                    "Sản Phẩm Chi Tiết", "Tổng Tiền Hóa Đơn", "Ngày Thành Toán"}, 0
        ));
        JTableHeader header = table_hoadon.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_hoadon);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 700));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnViewhoadon = new JButton("Xem");
        btnViewhoadon.setPreferredSize(new Dimension(100, 50));
        btnViewhoadon.setBackground(Color.decode("#3F4952"));
        btnViewhoadon.setForeground(Color.decode("#FFFFFF"));
        btnViewhoadon.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnViewhoadon);
        panel.add(row_4);
        panel.setBackground(Color.decode("#D1E8D8"));
        return panel;
    }

    //Danh Muc
    private JPanel createDanhMucPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 30));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
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
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchdanhmuc = new JTextField(20);
        TfSearchdanhmuc.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchdanhmuc = new JButton(resizedicon);
        btnSearchdanhmuc.setActionCommand("Tìm Kiếm2");
        btnSearchdanhmuc.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchdanhmuc);
        row_2.add(btnSearchdanhmuc);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 1));
        table_danhmuc = new JTable(new DefaultTableModel(
                new Object[]{"ID Danh Mục", "Tên Danh Mục", "Mô Tả Danh Mục"}, 0
        ));
        JTableHeader header = table_danhmuc.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_danhmuc);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 700));
        row_3.add(scrollPane);
        row_3.setBackground(Color.decode("#D1E8D8"));
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnAdd1 = new JButton("Thêm");
        btnAdd1.setPreferredSize(new Dimension(100, 50));
        btnAdd1.setBackground(Color.decode("#3F4952"));
        btnAdd1.setForeground(Color.decode("#FFFFFF"));
        btnAdd1.setFont(new Font("Arial", Font.BOLD, 20));
        btnEdit1 = new JButton("Sửa");
        btnEdit1.setPreferredSize(new Dimension(100, 50));
        btnEdit1.setBackground(Color.decode("#3F4952"));
        btnEdit1.setForeground(Color.decode("#FFFFFF"));
        btnEdit1.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete1 = new JButton("Xóa");
        btnDelete1.setPreferredSize(new Dimension(100, 50));
        btnDelete1.setBackground(Color.decode("#3F4952"));
        btnDelete1.setForeground(Color.decode("#FFFFFF"));
        btnDelete1.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnAdd1);
        row_4.add(btnEdit1);
        row_4.add(btnDelete1);
        panel.add(row_4);
        return panel;
    }

    //Nha Cung Cap
    private JPanel createNhaCungCapPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 50));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 40));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
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
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchnhacungcap = new JTextField(20);
        TfSearchnhacungcap.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchnhacungcap = new JButton(resizedicon);
        btnSearchnhacungcap.setActionCommand("Tìm Kiếm3");
        btnSearchnhacungcap.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchnhacungcap);
        row_2.add(btnSearchnhacungcap);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        table_nhacungcap = new JTable(new DefaultTableModel(
                new Object[]{"ID Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"}, 0
        ));
        JTableHeader header = table_nhacungcap.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_nhacungcap);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        row_3.add(scrollPane);
        row_3.add(scrollPane);
        row_3.setBackground(Color.decode("#D1E8D8"));
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnAddncc = new JButton("Thêm");
        btnAddncc.setPreferredSize(new Dimension(100, 50));
        btnAddncc.setBackground(Color.decode("#3F4952"));
        btnAddncc.setForeground(Color.decode("#FFFFFF"));
        btnAddncc.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditncc = new JButton("Sửa");
        btnEditncc.setPreferredSize(new Dimension(100, 50));
        btnEditncc.setBackground(Color.decode("#3F4952"));
        btnEditncc.setForeground(Color.decode("#FFFFFF"));
        btnEditncc.setFont(new Font("Arial", Font.BOLD, 20));
        btnDeletencc = new JButton("Xóa");
        btnDeletencc.setPreferredSize(new Dimension(100, 50));
        btnDeletencc.setBackground(Color.decode("#3F4952"));
        btnDeletencc.setForeground(Color.decode("#FFFFFF"));
        btnDeletencc.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnAddncc);
        row_4.add(btnEditncc);
        row_4.add(btnDeletencc);
        panel.add(row_4);
        return panel;
    }

    //Khach Hang
    private JPanel createKhachHangPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 50));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
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
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchkhachhang = new JTextField(20);
        TfSearchkhachhang.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchkhachhang = new JButton(resizedicon);
        btnSearchkhachhang.setActionCommand("Tìm Kiếm4");
        btnSearchkhachhang.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchkhachhang);
        row_2.add(btnSearchkhachhang);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setBackground(Color.decode("#D1E8D8"));
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        table_khachhang = new JTable(new DefaultTableModel(
                new Object[]{"ID Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Email"}, 0
        ));
        JTableHeader header = table_khachhang.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_khachhang);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnAddkh = new JButton("Thêm");
        btnAddkh.setPreferredSize(new Dimension(100, 50));
        btnAddkh.setBackground(Color.decode("#3F4952"));
        btnAddkh.setForeground(Color.decode("#FFFFFF"));
        btnAddkh.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditkh = new JButton("Sửa");
        btnEditkh.setPreferredSize(new Dimension(100, 50));
        btnEditkh.setBackground(Color.decode("#3F4952"));
        btnEditkh.setForeground(Color.decode("#FFFFFF"));
        btnEditkh.setFont(new Font("Arial", Font.BOLD, 20));
        btnDeletekh = new JButton("Xóa");
        btnDeletekh.setPreferredSize(new Dimension(100, 50));
        btnDeletekh.setBackground(Color.decode("#3F4952"));
        btnDeletekh.setForeground(Color.decode("#FFFFFF"));
        btnDeletekh.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnAddkh);
        row_4.add(btnEditkh);
        row_4.add(btnDeletekh);
        panel.add(row_4);
        return panel;
    }

    //Nhan Vien
    private JPanel createNhanVienPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 55));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
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
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchnhanvien = new JTextField(20);
        TfSearchnhanvien.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchnhanvien = new JButton(resizedicon);
        btnSearchnhanvien.setActionCommand("Tìm Kiếm5");
        btnSearchnhanvien.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchnhanvien);
        row_2.add(btnSearchnhanvien);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        row_3.setBackground(Color.decode("#D1E8D8"));
        table_nhanvien = new JTable(new DefaultTableModel(
                new Object[]{"ID Nhân Viên", "Tên Nhân Viên", "Email", "Mật Khẩu", "Số Điện Thoại"}, 0
        ));
        JTableHeader header = table_nhanvien.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_nhanvien);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnAddnv = new JButton("Thêm");
        btnAddnv.setPreferredSize(new Dimension(100, 50));
        btnAddnv.setBackground(Color.decode("#3F4952"));
        btnAddnv.setForeground(Color.decode("#FFFFFF"));
        btnAddnv.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditnv = new JButton("Sửa");
        btnEditnv.setPreferredSize(new Dimension(100, 50));
        btnEditnv.setBackground(Color.decode("#3F4952"));
        btnEditnv.setForeground(Color.decode("#FFFFFF"));
        btnEditnv.setFont(new Font("Arial", Font.BOLD, 20));
        btnDeletenv = new JButton("Xóa");
        btnDeletenv.setPreferredSize(new Dimension(100, 50));
        btnDeletenv.setBackground(Color.decode("#3F4952"));
        btnDeletenv.setForeground(Color.decode("#FFFFFF"));
        btnDeletenv.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnAddnv);
        row_4.add(btnEditnv);
        row_4.add(btnDeletenv);
        panel.add(row_4);
        return panel;
    }

    //Don Hang
    private JPanel createDonHangPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#D1E8D8"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 55));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        lbTrangthaidonhang = new JLabel("Trạng Thái Đơn Hàng:");
        lbTensanphamdonhang = new JLabel("Sản Phẩm:");
        lbtenKhachhangdonhang = new JLabel("Tên Khách Hàng:");
        lbSoluongdonhang = new JLabel("Số Lượng:");
        TfSoluongdonhang = new JTextField(20);
        lbGiaBandonhang = new JLabel("Giá Bán:");

        lbTrangthaidonhang = new JLabel("Trạng Thái Đơn Hàng:");
        lbTensanphamdonhang = new JLabel("Sản Phẩm:");
        lbtenKhachhangdonhang = new JLabel("Tên Khách Hàng:");
        lbSoluongdonhang = new JLabel("Số Lượng:");
        TfSoluongdonhang = new JTextField(20);
        lbGiaBandonhang = new JLabel("Giá Bán:");

        String trangthai[] = {"Chưa Thanh Toán", "Đã Thanh Toán"};
        CbTrangthaidonhang = new JComboBox(trangthai);
        CbTrangthaidonhang.setPreferredSize(
                new Dimension(200, CbTrangthaidonhang.getPreferredSize().height));

        SanPhamService sanPhamService = new SanPhamService(null);
        List<Item> sanPhamNames = sanPhamService.getAllName();
        CbTensanphamdonhang = new JComboBox<>(sanPhamNames.toArray(new Item[1]));
        CbTensanphamdonhang.setPreferredSize(
                new Dimension(200, CbTensanphamdonhang.getPreferredSize().height));
        KhachHangService khachhangService = new KhachHangService(null);
        List<Item> khachhangNames = khachhangService.getIDTenKhachHang();
        CbtenKhachhangdonhang = new JComboBox<>(khachhangNames.toArray(new Item[0]));
        CbtenKhachhangdonhang.setPreferredSize(new Dimension(200, CbtenKhachhangdonhang.getPreferredSize().height));

        SanPhamService sanPhamService1 = new SanPhamService(null);
        List<Item> sanPhamNames1 = sanPhamService1.getIDGiaBanRa();
        CbGiaBandonhang = new JComboBox<>(sanPhamNames1.toArray(new Item[3]));
        CbGiaBandonhang.setPreferredSize(new Dimension(200, CbGiaBandonhang.getPreferredSize().height));

        int dodai = lbTrangthaidonhang.getPreferredSize().width;
        Dimension labelSize = new Dimension(dodai, lbTrangthaidonhang.getPreferredSize().height);
        setLabelSize(lbTrangthaidonhang, labelSize);
        setLabelSize(lbTensanphamdonhang, labelSize);
        setLabelSize(lbSoluongdonhang, labelSize);
        setLabelSize(lbGiaBandonhang, labelSize);
        setLabelSize(lbtenKhachhangdonhang, labelSize);
        addComponent(subrow1_2, lbTrangthaidonhang, gbc, 0, 0);
        addComponent(subrow1_2, CbTrangthaidonhang, gbc, 1, 0);
        addComponent(subrow1_2, lbTensanphamdonhang, gbc, 0, 1);
        addComponent(subrow1_2, CbTensanphamdonhang, gbc, 1, 1);
        addComponent(subrow1_2, lbSoluongdonhang, gbc, 0, 2);
        addComponent(subrow1_2, TfSoluongdonhang, gbc, 1, 2);
        addComponent(subrow1_2, lbGiaBandonhang, gbc, 0, 3);
        addComponent(subrow1_2, CbGiaBandonhang, gbc, 1, 3);
        addComponent(subrow1_2, lbtenKhachhangdonhang, gbc, 0, 4);
        addComponent(subrow1_2, CbtenKhachhangdonhang, gbc, 1, 4);
        row_1.add(subrow1_2);
        panel.add(row_1);
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchdonhang = new JTextField(20);
        TfSearchdonhang.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchdonhang = new JButton(resizedicon);
        btnSearchdonhang.setActionCommand("Tìm Kiếm6");
        btnSearchdonhang.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchdonhang);
        row_2.add(btnSearchdonhang);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        row_3.setBackground(Color.decode("#D1E8D8"));
        table_donhang = new JTable(new DefaultTableModel(
                new Object[]{"ID Đơn Hàng", "Ngày Tạo Đơn Hàng", "Thành Tiền", "Trạng Thái Đơn Hàng",
                    "Tên Khách Hàng"}, 0
        ));
        JTableHeader header = table_donhang.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_donhang);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnAdddonhang = new JButton("Thêm");
        btnAdddonhang.setPreferredSize(new Dimension(100, 50));
        btnAdddonhang.setBackground(Color.decode("#3F4952"));
        btnAdddonhang.setForeground(Color.decode("#FFFFFF"));
        btnAdddonhang.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditdonhang = new JButton("Sửa");
        btnEditdonhang.setPreferredSize(new Dimension(100, 50));
        btnEditdonhang.setBackground(Color.decode("#3F4952"));
        btnEditdonhang.setForeground(Color.decode("#FFFFFF"));
        btnEditdonhang.setFont(new Font("Arial", Font.BOLD, 20));
        btnDeletedonhang = new JButton("Xóa");
        btnDeletedonhang.setPreferredSize(new Dimension(100, 50));
        btnDeletedonhang.setBackground(Color.decode("#3F4952"));
        btnDeletedonhang.setForeground(Color.decode("#FFFFFF"));
        btnDeletedonhang.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnAdddonhang);
        row_4.add(btnEditdonhang);
        row_4.add(btnDeletedonhang);
        panel.add(row_4);
        return panel;
    }

    private JPanel createKhoHangPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#D1E8D8"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 35));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 50));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JLabel khohang = new JLabel("Kho Hàng");
        khohang.setFont(new Font("Arial", Font.BOLD, 40));
        row_1.add(khohang);
        panel.add(row_1);
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchkhohang = new JTextField(20);
        TfSearchkhohang.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchkhohang = new JButton(resizedicon);
        btnSearchkhohang.setActionCommand("Tìm Kiếm8");
        btnSearchkhohang.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchkhohang);
        row_2.add(btnSearchkhohang);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        row_3.setBackground(Color.decode("#D1E8D8"));
        table_khohang = new JTable(new DefaultTableModel(
                new Object[]{"ID Kho", "Tên Sản Phẩm", "Số Lượng", "Ngày Nhập", "Tên Nhà Cung Cấp",
                    "Tên Người Nhập"}, 0
        ));
        JTableHeader header = table_khohang.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_khohang);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 700));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 30));
        row_4.setBackground(Color.decode("#D1E8D8"));
        btnViewkhohang = new JButton("Xem");
        btnViewkhohang.setPreferredSize(new Dimension(100, 50));
        btnViewkhohang.setBackground(Color.decode("#3F4952"));
        btnViewkhohang.setForeground(Color.decode("#FFFFFF"));
        btnViewkhohang.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnViewkhohang);
        panel.add(row_4);
        return panel;
    }

    //Chi tiet don hang
    private JPanel creatchitietdonhangPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#D1E8D8"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 35));
        row_0.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.decode("#D1E8D8"));
        row_0.add(padding_0);
        panel.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.LEFT, 23, 1));
        row_1.setBackground(Color.decode("#D1E8D8"));
        JPanel subrow1_1 = new JPanel();
        subrow1_1.setBackground(Color.decode("#D1E8D8"));
        row_1.add(subrow1_1);
        JPanel subrow1_2 = new JPanel();
        subrow1_2.setLayout(new GridBagLayout());
        subrow1_2.setBackground(Color.decode("#D1E8D8"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        lbiddonhang_chitietdonhang = new JLabel("ID Đơn Hàng:");
        Tfiddonhang_chitietdonhang = new JTextField(20);
        lbTensanphamchitietdonhang = new JLabel("Tên Sản Phẩm:");

        TfTensanphamchitietdonhang = new JTextField(20);
        lbTenkhachhangchitietdonhang = new JLabel("Tên Khách Hàng:");
        TfTenkhachhangchitietdonhang = new JTextField(20);
        lbSoluongchitietdonhang = new JLabel("Số Lượng:");
        TfSoluongchitietdonhang = new JTextField(20);
        lbGiabanchitietdonhang = new JLabel("Giá Bán:");
        TfGiabanchitietdonhang = new JTextField(20);
        int dodai = lbTenkhachhangchitietdonhang.getPreferredSize().width;
        Dimension labelSize = new Dimension(dodai, lbTenkhachhangchitietdonhang.getPreferredSize().height);
        setLabelSize(lbiddonhang_chitietdonhang, labelSize);
        setLabelSize(lbTensanphamchitietdonhang, labelSize);
        setLabelSize(lbSoluongchitietdonhang, labelSize);
        setLabelSize(lbGiabanchitietdonhang, labelSize);
        addComponent(subrow1_2, lbiddonhang_chitietdonhang, gbc, 0, 0);
        addComponent(subrow1_2, Tfiddonhang_chitietdonhang, gbc, 1, 0);
        addComponent(subrow1_2, lbTensanphamchitietdonhang, gbc, 0, 1);
        addComponent(subrow1_2, TfTensanphamchitietdonhang, gbc, 1, 1);
        addComponent(subrow1_2, lbTenkhachhangchitietdonhang, gbc, 0, 2);
        addComponent(subrow1_2, TfTenkhachhangchitietdonhang, gbc, 1, 2);
        addComponent(subrow1_2, lbSoluongchitietdonhang, gbc, 0, 3);
        addComponent(subrow1_2, TfSoluongchitietdonhang, gbc, 1, 3);
        addComponent(subrow1_2, lbGiabanchitietdonhang, gbc, 0, 4);
        addComponent(subrow1_2, TfGiabanchitietdonhang, gbc, 1, 4);
        row_1.add(subrow1_2);
        panel.add(row_1);
        JPanel row_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 1));
        row_2.setBackground(Color.decode("#D1E8D8"));
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.decode("#D1E8D8"));
        padding_1.setPreferredSize(new Dimension(175, 10));
        TfSearchchitietdonhang = new JTextField(20);
        TfSearchchitietdonhang.setPreferredSize(new Dimension(0, 30));
        ImageIcon icon = new ImageIcon(getClass().getResource("iconsearch_50.png"));
        Image original = icon.getImage();
        Image resizedImage = original.getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        btnSearchchitietdonhang = new JButton(resizedicon);
        btnSearchchitietdonhang.setActionCommand("Tìm Kiếm7");
        btnSearchchitietdonhang.setBackground(Color.decode("#3F4952"));
        row_2.add(TfSearchchitietdonhang);
        row_2.add(btnSearchchitietdonhang);
        row_2.add(padding_1);
        panel.add(row_2);
        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        row_3.setBackground(Color.decode("#D1E8D8"));
        table_chitietdonhang = new JTable(new DefaultTableModel(
                new Object[]{"ID Chi Tiết Đơn Hàng", "ID Đơn Hàng", "Tên Sản Phẩm", "Tên Khách Hàng",
                    "Số Lượng", "Giá Bán"}, 0
        ));
        JTableHeader header = table_chitietdonhang.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(table_chitietdonhang);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(1200, 600));
        row_3.add(scrollPane);
        panel.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
        row_4.setBackground(Color.decode("#D1E8D8"));
//        btnAddchitietdonhang = new JButton("Thêm");
//        btnAddchitietdonhang.setPreferredSize(new Dimension(100, 50));
//        btnAddchitietdonhang.setBackground(Color.decode("#3F4952"));
//        btnAddchitietdonhang.setForeground(Color.decode("#FFFFFF"));
//        btnAddchitietdonhang.setFont(new Font("Arial", Font.BOLD, 20));
        btnEditchitietdonhang = new JButton("Sửa");
        btnEditchitietdonhang.setPreferredSize(new Dimension(100, 50));
        btnEditchitietdonhang.setBackground(Color.decode("#3F4952"));
        btnEditchitietdonhang.setForeground(Color.decode("#FFFFFF"));
        btnEditchitietdonhang.setFont(new Font("Arial", Font.BOLD, 20));
//        btnDeletechitietdonhang = new JButton("Xóa");
//        btnDeletechitietdonhang.setPreferredSize(new Dimension(100, 50));
//        btnDeletechitietdonhang.setBackground(Color.decode("#3F4952"));
//        btnDeletechitietdonhang.setForeground(Color.decode("#FFFFFF"));
//        btnDeletechitietdonhang.setFont(new Font("Arial", Font.BOLD, 20));
        btnUpdatechithietdonhang = new JButton("Cập Nhật");
        btnUpdatechithietdonhang.setPreferredSize(new Dimension(150, 50));
        btnUpdatechithietdonhang.setBackground(Color.decode("#3F4952"));
        btnUpdatechithietdonhang.setForeground(Color.decode("#FFFFFF"));
        btnUpdatechithietdonhang.setFont(new Font("Arial", Font.BOLD, 20));
        btnViewchitietdonhang = new JButton("Xem");
        btnViewchitietdonhang.setPreferredSize(new Dimension(100, 50));
        btnViewchitietdonhang.setBackground(Color.decode("#3F4952"));
        btnViewchitietdonhang.setForeground(Color.decode("#FFFFFF"));
        btnViewchitietdonhang.setFont(new Font("Arial", Font.BOLD, 20));
        row_4.add(btnUpdatechithietdonhang);
        row_4.add(btnEditchitietdonhang);
        row_4.add(btnViewchitietdonhang);
        panel.add(row_4);
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

    public void setBtnDeletencc(JButton btnDeletencc) {
        this.btnDeletencc = btnDeletencc;
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

    public JButton getBtnAdddonhang() {
        return btnAdddonhang;
    }

    public void setBtnAdddonhang(JButton btnAdddonhang) {
        this.btnAdddonhang = btnAdddonhang;
    }

    public JButton getBtnEditdonhang() {
        return btnEditdonhang;
    }

    public void setBtnEditdonhang(JButton btnEditdonhang) {
        this.btnEditdonhang = btnEditdonhang;
    }

    public JButton getBtnDeletedonhang() {
        return btnDeletedonhang;
    }

    public void setBtnDeletedonhang(JButton btnDeletedonhang) {
        this.btnDeletedonhang = btnDeletedonhang;
    }

    public JTextField getTfMasanpham() {
        return TfMasanpham;
    }

    public void setTfMasanpham(JTextField TfMasanpham) {
        this.TfMasanpham = TfMasanpham;
    }

    public JTextField getTfTensanpham() {
        return TfTensanpham;
    }

    public void setTfTensanpham(JTextField TfTensanpham) {
        this.TfTensanpham = TfTensanpham;
    }

    public JTextField getTfGiaBan() {
        return TfGiaBan;
    }

    public void setTfGiaBan(JTextField TfGiaBan) {
        this.TfGiaBan = TfGiaBan;
    }

    public JTextField getTfGiaNhap() {
        return TfGiaNhap;
    }

    public void setTfGiaNhap(JTextField TfGiaNhap) {
        this.TfGiaNhap = TfGiaNhap;
    }

    public JTextField getTfMoTa() {
        return TfMoTa;
    }

    public void setTfMoTa(JTextField TfMoTa) {
        this.TfMoTa = TfMoTa;
    }

    public JTextField getTfThoiGianNhap() {
        return TfThoiGianNhap;
    }

    public void setTfThoiGianNhap(JTextField TfThoiGianNhap) {
        this.TfThoiGianNhap = TfThoiGianNhap;
    }

    public JTextField getTfSoluong() {
        return TfSoluong;
    }

    public void setTfSoluong(JTextField TfSoluong) {
        this.TfSoluong = TfSoluong;
    }

    public JTextField getTfTenDanhmuc() {
        return TfTenDanhmuc;
    }

    public void setTfTenDanhmuc(JTextField TfTenDanhmuc) {
        this.TfTenDanhmuc = TfTenDanhmuc;
    }

    public JTextField getTfMotadanhmuc() {
        return TfMotadanhmuc;
    }

    public void setTfMotadanhmuc(JTextField TfMotadanhmuc) {
        this.TfMotadanhmuc = TfMotadanhmuc;
    }

    public JTextField getTfTenNhaCungCap1() {
        return TfTenNhaCungCap1;
    }

    public void setTfTenNhaCungCap1(JTextField TfTenNhaCungCap1) {
        this.TfTenNhaCungCap1 = TfTenNhaCungCap1;
    }

    public JTextField getTfDiachi() {
        return TfDiachi;
    }

    public void setTfDiachi(JTextField TfDiachi) {
        this.TfDiachi = TfDiachi;
    }

    public JTextField getTfSodienthoai() {
        return TfSodienthoai;
    }

    public void setTfSodienthoai(JTextField TfSodienthoai) {
        this.TfSodienthoai = TfSodienthoai;
    }

    public JTextField getTfTenKhachHang() {
        return TfTenKhachHang;
    }

    public void setTfTenKhachHang(JTextField TfTenKhachHang) {
        this.TfTenKhachHang = TfTenKhachHang;
    }

    public JTextField getTfDiachiKhachHang() {
        return TfDiachiKhachHang;
    }

    public void setTfDiachiKhachHang(JTextField TfDiachiKhachHang) {
        this.TfDiachiKhachHang = TfDiachiKhachHang;
    }

    public JTextField getTfSodienthoaiKhachHang() {
        return TfSodienthoaiKhachHang;
    }

    public void setTfSodienthoaiKhachHang(JTextField TfSodienthoaiKhachHang) {
        this.TfSodienthoaiKhachHang = TfSodienthoaiKhachHang;
    }

    public JTextField getTfEmailKhachHang() {
        return TfEmailKhachHang;
    }

    public void setTfEmailKhachHang(JTextField TfEmailKhachHang) {
        this.TfEmailKhachHang = TfEmailKhachHang;
    }

    public JTextField getTfTenNhanVien() {
        return TfTenNhanVien;
    }

    public void setTfTenNhanVien(JTextField TfTenNhanVien) {
        this.TfTenNhanVien = TfTenNhanVien;
    }

    public JTextField getTfEmailNhanVien() {
        return TfEmailNhanVien;
    }

    public void setTfEmailNhanVien(JTextField TfEmailNhanVien) {
        this.TfEmailNhanVien = TfEmailNhanVien;
    }

    public JTextField getTfmatkhauNhanVien() {
        return TfmatkhauNhanVien;
    }

    public void setTfmatkhauNhanVien(JTextField TfmatkhauNhanVien) {
        this.TfmatkhauNhanVien = TfmatkhauNhanVien;
    }

    public JTextField getTfSodienthoaiNhanVien() {
        return TfSodienthoaiNhanVien;
    }

    public void setTfSodienthoaiNhanVien(JTextField TfSodienthoaiNhanVien) {
        this.TfSodienthoaiNhanVien = TfSodienthoaiNhanVien;
    }

    public JLabel getLbtenKhachhangdonhang() {
        return lbtenKhachhangdonhang;
    }

    public void setLbtenKhachhangdonhang(JLabel lbtenKhachhangdonhang) {
        this.lbtenKhachhangdonhang = lbtenKhachhangdonhang;
    }

    public JComboBox<Item> getCbtenKhachhangdonhang() {
        return CbtenKhachhangdonhang;
    }

    public void setCbtenKhachhangdonhang(JComboBox<Item> CbtenKhachhangdonhang) {
        this.CbtenKhachhangdonhang = CbtenKhachhangdonhang;
    }

    public JPanel getSanPhamPanel() {
        return sanPhamPanel;
    }

    public void setSanPhamPanel(JPanel sanPhamPanel) {
        this.sanPhamPanel = sanPhamPanel;
    }

    public JComboBox<Item> getCbTenDanhMuc() {
        return CbTenDanhMuc;
    }

    public void setCbTenDanhMuc(JComboBox<Item> CbTenDanhMuc) {
        this.CbTenDanhMuc = CbTenDanhMuc;
    }

    public JComboBox<Item> getCbTenNhaCungCap() {
        return CbTenNhaCungCap;
    }

    public void setCbTenNhaCungCap(JComboBox<Item> CbTenNhaCungCap) {
        this.CbTenNhaCungCap = CbTenNhaCungCap;
    }

    public JComboBox<Item> getCbNguoiNhap() {
        return CbNguoiNhap;
    }

    public void setCbNguoiNhap(JComboBox<Item> CbNguoiNhap) {
        this.CbNguoiNhap = CbNguoiNhap;
    }

    public JTable getTable_hoadon() {
        return table_hoadon;
    }

    public void setTable_hoadon(JTable table_hoadon) {
        this.table_hoadon = table_hoadon;
    }

    public JTable getTable_danhmuc() {
        return table_danhmuc;
    }

    public void setTable_danhmuc(JTable table_danhmuc) {
        this.table_danhmuc = table_danhmuc;
    }

    public JTable getTable_nhacungcap() {
        return table_nhacungcap;
    }

    public void setTable_nhacungcap(JTable table_nhacungcap) {
        this.table_nhacungcap = table_nhacungcap;
    }

    public JTable getTable_khachhang() {
        return table_khachhang;
    }

    public void setTable_khachhang(JTable table_khachhang) {
        this.table_khachhang = table_khachhang;
    }

    public JTable getTable_nhanvien() {
        return table_nhanvien;
    }

    public void setTable_nhanvien(JTable table_nhanvien) {
        this.table_nhanvien = table_nhanvien;
    }

    public JTable getTable_donhang() {
        return table_donhang;
    }

    public void setTable_donhang(JTable table_donhang) {
        this.table_donhang = table_donhang;
    }

    public JLabel getLbNguoiNhap() {
        return lbNguoiNhap;
    }

    public void setLbNguoiNhap(JLabel lbNguoiNhap) {
        this.lbNguoiNhap = lbNguoiNhap;
    }

    public JLabel getLbSodienthoai() {
        return lbSodienthoai;
    }

    public void setLbSodienthoai(JLabel lbSodienthoai) {
        this.lbSodienthoai = lbSodienthoai;
    }

    public JLabel getLbDiachiKhachHang() {
        return lbDiachiKhachHang;
    }

    public void setLbDiachiKhachHang(JLabel lbDiachiKhachHang) {
        this.lbDiachiKhachHang = lbDiachiKhachHang;
    }

    public JLabel getLbSodienthoaiKhachHang() {
        return lbSodienthoaiKhachHang;
    }

    public void setLbSodienthoaiKhachHang(JLabel lbSodienthoaiKhachHang) {
        this.lbSodienthoaiKhachHang = lbSodienthoaiKhachHang;
    }

    public JLabel getLbEmailKhachHang() {
        return lbEmailKhachHang;
    }

    public void setLbEmailKhachHang(JLabel lbEmailKhachHang) {
        this.lbEmailKhachHang = lbEmailKhachHang;
    }

    public JLabel getLbEmailNhanVien() {
        return lbEmailNhanVien;
    }

    public void setLbEmailNhanVien(JLabel lbEmailNhanVien) {
        this.lbEmailNhanVien = lbEmailNhanVien;
    }

    public JLabel getLbmatkhauNhanVien() {
        return lbmatkhauNhanVien;
    }

    public void setLbmatkhauNhanVien(JLabel lbmatkhauNhanVien) {
        this.lbmatkhauNhanVien = lbmatkhauNhanVien;
    }

    public JLabel getLbSodienthoaiNhanVien() {
        return lbSodienthoaiNhanVien;
    }

    public void setLbSodienthoaiNhanVien(JLabel lbSodienthoaiNhanVien) {
        this.lbSodienthoaiNhanVien = lbSodienthoaiNhanVien;
    }

    public JTable getTable_khohang() {
        return table_khohang;
    }

    public void setTable_khohang(JTable table_khohang) {
        this.table_khohang = table_khohang;
    }

    public JLabel getLbTensanphamchitietdonhang() {
        return lbTensanphamchitietdonhang;
    }

    public void setLbTensanphamchitietdonhang(JLabel lbTensanphamchitietdonhang) {
        this.lbTensanphamchitietdonhang = lbTensanphamchitietdonhang;
    }

    public JLabel getLbTenkhachhangchitietdonhang() {
        return lbTenkhachhangchitietdonhang;
    }

    public void setLbTenkhachhangchitietdonhang(JLabel lbTenkhachhangchitietdonhang) {
        this.lbTenkhachhangchitietdonhang = lbTenkhachhangchitietdonhang;
    }

    public JTextField getTfTenkhachhangchitietdonhang() {
        return TfTenkhachhangchitietdonhang;
    }

    public void setTfTenkhachhangchitietdonhang(JTextField TfTenkhachhangchitietdonhang) {
        this.TfTenkhachhangchitietdonhang = TfTenkhachhangchitietdonhang;
    }

    public JLabel getLbSoluongchitietdonhang() {
        return lbSoluongchitietdonhang;
    }

    public void setLbSoluongchitietdonhang(JLabel lbSoluongchitietdonhang) {
        this.lbSoluongchitietdonhang = lbSoluongchitietdonhang;
    }

    public JTextField getTfSoluongchitietdonhang() {
        return TfSoluongchitietdonhang;
    }

    public void setTfSoluongchitietdonhang(JTextField TfSoluongchitietdonhang) {
        this.TfSoluongchitietdonhang = TfSoluongchitietdonhang;
    }

    public JLabel getLbGiabanchitietdonhang() {
        return lbGiabanchitietdonhang;
    }

    public void setLbGiabanchitietdonhang(JLabel lbGiabanchitietdonhang) {
        this.lbGiabanchitietdonhang = lbGiabanchitietdonhang;
    }

    public JTable getTable_chitietdonhang() {
        return table_chitietdonhang;
    }

    public void setTable_chitietdonhang(JTable table_chitietdonhang) {
        this.table_chitietdonhang = table_chitietdonhang;
    }

    public JComboBox<Item> getCbTrangthaidonhang() {
        return CbTrangthaidonhang;
    }

    public void setCbTrangthaidonhang(JComboBox<Item> CbTrangthaidonhang) {
        this.CbTrangthaidonhang = CbTrangthaidonhang;
    }

    public JLabel getLbTensanphamdonhang() {
        return lbTensanphamdonhang;
    }

    public void setLbTensanphamdonhang(JLabel lbTensanphamdonhang) {
        this.lbTensanphamdonhang = lbTensanphamdonhang;
    }

    public JComboBox<Item> getCbTensanphamdonhang() {
        return CbTensanphamdonhang;
    }

    public void setCbTensanphamdonhang(JComboBox<Item> CbTensanphamdonhang) {
        this.CbTensanphamdonhang = CbTensanphamdonhang;
    }

    public JLabel getLbSoluongdonhang() {
        return lbSoluongdonhang;
    }

    public void setLbSoluongdonhang(JLabel lbSoluongdonhang) {
        this.lbSoluongdonhang = lbSoluongdonhang;
    }

    public JTextField getTfSoluongdonhang() {
        return TfSoluongdonhang;
    }

    public void setTfSoluongdonhang(JTextField TfSoluongdonhang) {
        this.TfSoluongdonhang = TfSoluongdonhang;
    }

    public JLabel getLbGiaBandonhang() {
        return lbGiaBandonhang;
    }

    public void setLbGiaBandonhang(JLabel lbGiaBandonhang) {
        this.lbGiaBandonhang = lbGiaBandonhang;
    }

    public JComboBox<Item> getCbGiaBandonhang() {
        return CbGiaBandonhang;
    }

    public void setCbGiaBandonhang(JComboBox<Item> CbGiaBandonhang) {
        this.CbGiaBandonhang = CbGiaBandonhang;
    }

    //method clear san pham
    public void clearSanPham() {
        TfMasanpham.setText("");
        TfTensanpham.setText("");
        TfGiaBan.setText("");
        TfGiaNhap.setText("");
        TfMoTa.setText("");
        TfThoiGianNhap.setText("");
        CbTenDanhMuc.setSelectedIndex(0);
        CbTenNhaCungCap.setSelectedIndex(0);
    }

    //method clear danh muc
    public void clearDanhMuc() {
        TfTenDanhmuc.setText("");
        TfMotadanhmuc.setText("");
    }

    //method clear nha cung cap
    public void clearNhaCungCap() {
        TfTenNhaCungCap1.setText("");
        TfDiachi.setText("");
        TfSodienthoai.setText("");
    }

    //method clear nhan vien
    public void clearNhanVien() {
        TfTenNhanVien.setText("");
        TfEmailNhanVien.setText("");
        TfmatkhauNhanVien.setText("");
        TfSodienthoaiNhanVien.setText("");
    }

    //method clear khach hang
    public void clearKhachHang() {
        TfTenKhachHang.setText("");
        TfDiachiKhachHang.setText("");
        TfSodienthoaiKhachHang.setText("");
        TfEmailKhachHang.setText("");
    }

    public JButton getBtnDonHang() {
        return btnDonHang;
    }

    public void setBtnDonHang(JButton btnDonHang) {
        this.btnDonHang = btnDonHang;
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

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
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

    public JPanel getDonhangPanel() {
        return donhangPanel;
    }

    public void setDonhangPanel(JPanel donhangPanel) {
        this.donhangPanel = donhangPanel;
    }

    public JPanel getKhodangPanel() {
        return khodangPanel;
    }

    public void setKhodangPanel(JPanel khodangPanel) {
        this.khodangPanel = khodangPanel;
    }

    public JPanel getChitietdonhangPanel() {
        return chitietdonhangPanel;
    }

    public void setChitietdonhangPanel(JPanel chitietdonhangPanel) {
        this.chitietdonhangPanel = chitietdonhangPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JButton getBtnChitietdonhang() {
        return btnChitietdonhang;
    }

    public void setBtnChitietdonhang(JButton btnChitietdonhang) {
        this.btnChitietdonhang = btnChitietdonhang;
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

    public JLabel getLbSoluong() {
        return lbSoluong;
    }

    public void setLbSoluong(JLabel lbSoluong) {
        this.lbSoluong = lbSoluong;
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

    public JLabel getLbTenDanhmuc() {
        return lbTenDanhmuc;
    }

    public void setLbTenDanhmuc(JLabel lbTenDanhmuc) {
        this.lbTenDanhmuc = lbTenDanhmuc;
    }

    public JLabel getLbMotadanhmuc() {
        return lbMotadanhmuc;
    }

    public void setLbMotadanhmuc(JLabel lbMotadanhmuc) {
        this.lbMotadanhmuc = lbMotadanhmuc;
    }

    public JLabel getLbTenNhaCungCap1() {
        return lbTenNhaCungCap1;
    }

    public void setLbTenNhaCungCap1(JLabel lbTenNhaCungCap1) {
        this.lbTenNhaCungCap1 = lbTenNhaCungCap1;
    }

    public JLabel getLbDiachi() {
        return lbDiachi;
    }

    public void setLbDiachi(JLabel lbDiachi) {
        this.lbDiachi = lbDiachi;
    }

    public JLabel getLbTenKhachHang() {
        return lbTenKhachHang;
    }

    public void setLbTenKhachHang(JLabel lbTenKhachHang) {
        this.lbTenKhachHang = lbTenKhachHang;
    }

    public JLabel getLbTenNhanVien() {
        return lbTenNhanVien;
    }

    public void setLbTenNhanVien(JLabel lbTenNhanVien) {
        this.lbTenNhanVien = lbTenNhanVien;
    }

    public JLabel getLbTrangthaidonhang() {
        return lbTrangthaidonhang;
    }

    public void setLbTrangthaidonhang(JLabel lbTrangthaidonhang) {
        this.lbTrangthaidonhang = lbTrangthaidonhang;
    }

    public JLabel getLbidchitietdonhang() {
        return lbidchitietdonhang;
    }

    public void setLbidchitietdonhang(JLabel lbidchitietdonhang) {
        this.lbidchitietdonhang = lbidchitietdonhang;
    }

//    public JButton getBtnAddchitietdonhang() {
//        return btnAddchitietdonhang;
//    }
//
//    public void setBtnAddchitietdonhang(JButton btnAddchitietdonhang) {
//        this.btnAddchitietdonhang = btnAddchitietdonhang;
//    }
//
//    public JButton getBtnEditchitietdonhang() {
//        return btnEditchitietdonhang;
//    }
//
//    public void setBtnEditchitietdonhang(JButton btnEditchitietdonhang) {
//        this.btnEditchitietdonhang = btnEditchitietdonhang;
//    }
//
//    public JButton getBtnDeletechitietdonhang() {
//        return btnDeletechitietdonhang;
//    }
//
//    public void setBtnDeletechitietdonhang(JButton btnDeletechitietdonhang) {
//        this.btnDeletechitietdonhang = btnDeletechitietdonhang;
//    }
    public JButton getBtnShutdown() {
        return btnShutdown;
    }

    public void setBtnShutdown(JButton btnShutdown) {
        this.btnShutdown = btnShutdown;
    }

    public JButton getBtnUpdatechithietdonhang() {
        return btnUpdatechithietdonhang;
    }

    public void setBtnUpdatechithietdonhang(JButton btnUpdatechithietdonhang) {
        this.btnUpdatechithietdonhang = btnUpdatechithietdonhang;
    }

    public JButton getBtnViewchitietdonhang() {
        return btnViewchitietdonhang;
    }

    public void setBtnViewchitietdonhang(JButton btnViewchitietdonhang) {
        this.btnViewchitietdonhang = btnViewchitietdonhang;
    }

    public JLabel getLbMasanpham() {
        return lbMasanpham;
    }

    public JButton getBtnViewhoadon() {
        return btnViewhoadon;
    }

    public void setBtnViewhoadon(JButton btnViewhoadon) {
        this.btnViewhoadon = btnViewhoadon;
    }

    public JButton getBtnViewkhohang() {
        return btnViewkhohang;
    }

    public void setBtnViewkhohang(JButton btnViewkhohang) {
        this.btnViewkhohang = btnViewkhohang;
    }

    public JLabel getLbiddonhang_chitietdonhang() {
        return lbiddonhang_chitietdonhang;
    }

    public void setLbiddonhang_chitietdonhang(JLabel lbiddonhang_chitietdonhang) {
        this.lbiddonhang_chitietdonhang = lbiddonhang_chitietdonhang;
    }

    public JTextField getTfiddonhang_chitietdonhang() {
        return Tfiddonhang_chitietdonhang;
    }

    public void setTfiddonhang_chitietdonhang(JTextField Tfiddonhang_chitietdonhang) {
        this.Tfiddonhang_chitietdonhang = Tfiddonhang_chitietdonhang;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void setBtnLogout(JButton btnLogout) {
        this.btnLogout = btnLogout;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public JButton getBtnSearchsanpham() {
        return btnSearchsanpham;
    }

    public void setBtnSearchsanpham(JButton btnSearchsanpham) {
        this.btnSearchsanpham = btnSearchsanpham;
    }

    public JTextField getTfSearchsanpham() {
        return TfSearchsanpham;
    }

    public void setTfSearchsanpham(JTextField TfSearchsanpham) {
        this.TfSearchsanpham = TfSearchsanpham;
    }

    public JButton getBtnSearchhoadon() {
        return btnSearchhoadon;
    }

    public void setBtnSearchhoadon(JButton btnSearchhoadon) {
        this.btnSearchhoadon = btnSearchhoadon;
    }

    public JTextField getTfSearchhoadon() {
        return TfSearchhoadon;
    }

    public void setTfSearchhoadon(JTextField TfSearchhoadon) {
        this.TfSearchhoadon = TfSearchhoadon;
    }

    public JButton getBtnSearchdanhmuc() {
        return btnSearchdanhmuc;
    }

    public void setBtnSearchdanhmuc(JButton btnSearchdanhmuc) {
        this.btnSearchdanhmuc = btnSearchdanhmuc;
    }

    public JTextField getTfSearchdanhmuc() {
        return TfSearchdanhmuc;
    }

    public void setTfSearchdanhmuc(JTextField TfSearchdanhmuc) {
        this.TfSearchdanhmuc = TfSearchdanhmuc;
    }

    public JButton getBtnSearchnhacungcap() {
        return btnSearchnhacungcap;
    }

    public void setBtnSearchnhacungcap(JButton btnSearchnhacungcap) {
        this.btnSearchnhacungcap = btnSearchnhacungcap;
    }

    public JTextField getTfSearchnhacungcap() {
        return TfSearchnhacungcap;
    }

    public void setTfSearchnhacungcap(JTextField TfSearchnhacungcap) {
        this.TfSearchnhacungcap = TfSearchnhacungcap;
    }

    public JButton getBtnSearchkhachhang() {
        return btnSearchkhachhang;
    }

    public void setBtnSearchkhachhang(JButton btnSearchkhachhang) {
        this.btnSearchkhachhang = btnSearchkhachhang;
    }

    public JTextField getTfSearchkhachhang() {
        return TfSearchkhachhang;
    }

    public void setTfSearchkhachhang(JTextField TfSearchkhachhang) {
        this.TfSearchkhachhang = TfSearchkhachhang;
    }

    public JButton getBtnSearchnhanvien() {
        return btnSearchnhanvien;
    }

    public void setBtnSearchnhanvien(JButton btnSearchnhanvien) {
        this.btnSearchnhanvien = btnSearchnhanvien;
    }

    public JTextField getTfSearchnhanvien() {
        return TfSearchnhanvien;
    }

    public void setTfSearchnhanvien(JTextField TfSearchnhanvien) {
        this.TfSearchnhanvien = TfSearchnhanvien;
    }

    public JButton getBtnSearchdonhang() {
        return btnSearchdonhang;
    }

    public void setBtnSearchdonhang(JButton btnSearchdonhang) {
        this.btnSearchdonhang = btnSearchdonhang;
    }

    public JTextField getTfSearchdonhang() {
        return TfSearchdonhang;
    }

    public void setTfSearchdonhang(JTextField TfSearchdonhang) {
        this.TfSearchdonhang = TfSearchdonhang;
    }

    public JButton getBtnSearchkhohang() {
        return btnSearchkhohang;
    }

    public void setBtnSearchkhohang(JButton btnSearchkhohang) {
        this.btnSearchkhohang = btnSearchkhohang;
    }

    public JTextField getTfSearchkhohang() {
        return TfSearchkhohang;
    }

    public void setTfSearchkhohang(JTextField TfSearchkhohang) {
        this.TfSearchkhohang = TfSearchkhohang;
    }

    public JTextField getTfTensanphamchitietdonhang() {
        return TfTensanphamchitietdonhang;
    }

    public void setTfTensanphamchitietdonhang(JTextField TfTensanphamchitietdonhang) {
        this.TfTensanphamchitietdonhang = TfTensanphamchitietdonhang;
    }

    public JTextField getTfGiabanchitietdonhang() {
        return TfGiabanchitietdonhang;
    }

    public void setTfGiabanchitietdonhang(JTextField TfGiabanchitietdonhang) {
        this.TfGiabanchitietdonhang = TfGiabanchitietdonhang;
    }

    public JButton getBtnSearchchitietdonhang() {
        return btnSearchchitietdonhang;
    }

    public void setBtnSearchchitietdonhang(JButton btnSearchchitietdonhang) {
        this.btnSearchchitietdonhang = btnSearchchitietdonhang;
    }

    public JTextField getTfSearchchitietdonhang() {
        return TfSearchchitietdonhang;
    }

    public void setTfSearchchitietdonhang(JTextField TfSearchchitietdonhang) {
        this.TfSearchchitietdonhang = TfSearchchitietdonhang;
    }

}
