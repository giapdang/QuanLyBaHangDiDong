/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class FormHoadon extends JFrame {
    //Cac component lam Input dau vao
    JLabel tencuahang;
    JLabel thongtin_diachi;
    JLabel thongtin_sodienthoai;
    JLabel thongtin_sohoadon;
    JLabel thongtin_hovatenkhachhang;
    JLabel thongtin_makhachhang;
    JLabel thongtin_nhanvienbh;
    JLabel thongtin_diachikhachhang;
    JLabel thongtin_ngaytao;
    JLabel thongtin_sdtkhachhang;
    JTable bang_chitietdonhang;
    JLabel thongtin_tongtien;
    JLabel thongtin_tongtienbangchu;
    JLabel thongtin_ngay, thongtin_thang, thongtin_nam;
    JLabel thongtin_khachhangky;
    JLabel thongtin_nguoilapphieuky;
    JLabel thongtin_thukhoky;
    JLabel thongtin_thunganky;
    //Cac component su dung de lam form
    JLabel diachi;
    JLabel sdt;
    JLabel sohoadon;
    JLabel hovatenkhachhang;
    JLabel makhachhang;
    JLabel nhanvienbh;
    JLabel diachikhachhang;
    JLabel ngaytao;
    JLabel sdtkhachhang;
    JLabel chitietdonhang;
    JLabel tongtien;
    JLabel tongtienbangchu;
    JLabel ngay, thang, nam;
    JLabel khachhangky;
    JLabel nguoilapphieuky;
    JLabel thukhoky;
    JLabel thunganky;

    public FormHoadon() {
        showui();
        addcomponent();
        addevent();
    }

    public void addcomponent() {
        Container con = getContentPane();
        JPanel mainpn = new JPanel();
        mainpn.setLayout(new BoxLayout(mainpn, BoxLayout.Y_AXIS));
        mainpn.setBackground(Color.WHITE);
        LineBorder line = new LineBorder(Color.BLACK, 2);
        JScrollPane scrollPane0 = new JScrollPane(mainpn);
        scrollPane0.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane0.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel row_0 = new JPanel();
        row_0.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        row_0.setBackground(Color.WHITE);
        JPanel A = new JPanel();
        A.setLayout(new BoxLayout(A, BoxLayout.Y_AXIS));
        A.setBackground(Color.WHITE);
        JPanel subA_1 = new JPanel();
        subA_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subA_1.setBackground(Color.WHITE);
        tencuahang = new JLabel("Tên Cửa Hàng");
        tencuahang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tencuahang.setForeground(Color.BLACK);
        subA_1.add(tencuahang);
        A.add(subA_1);
        JPanel subA_2 = new JPanel();
        subA_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subA_2.setBackground(Color.WHITE);
        diachi = new JLabel("Địa Chỉ:");
        diachi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        diachi.setForeground(Color.BLACK);
        subA_2.add(diachi);
        thongtin_diachi = new JLabel("....................................");
        thongtin_diachi.setBackground(Color.WHITE);
        thongtin_diachi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_diachi.setForeground(Color.BLACK);
        subA_2.add(thongtin_diachi);
        A.add(subA_2);
        JPanel subA_3 = new JPanel();
        subA_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subA_3.setBackground(Color.WHITE);
        sdt = new JLabel("Số Điện Thoại:");
        sdt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        sdt.setForeground(Color.BLACK);
        subA_3.add(sdt);
        thongtin_sodienthoai = new JLabel(".........................");
        thongtin_sodienthoai.setBackground(Color.WHITE);
        thongtin_sodienthoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_sodienthoai.setForeground(Color.BLACK);
        subA_3.add(thongtin_sodienthoai);
        A.add(subA_3);
        row_0.add(A);
        mainpn.add(row_0);
        JPanel row_1 = new JPanel();
        row_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        row_1.setBackground(Color.WHITE);
        JPanel padding_0 = new JPanel();
        padding_0.setBackground(Color.WHITE);
        row_1.add(padding_0);
        mainpn.add(row_1);
        JPanel row_2 = new JPanel();
        row_2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        row_2.setBackground(Color.WHITE);
        JPanel B = new JPanel();
        B.setLayout(new BoxLayout(B, BoxLayout.Y_AXIS));
        B.setBackground(Color.WHITE);
        JPanel subB_1 = new JPanel();
        subB_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
        subB_1.setBackground(Color.WHITE);
        JLabel tieude = new JLabel("Hoá Đơn Bán Hàng");
        tieude.setFont(new Font("Times New Roman", Font.BOLD, 40));
        tieude.setForeground(Color.BLACK);
        subB_1.add(tieude);
        B.add(subB_1);
        JPanel subB_2 = new JPanel();
        subB_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 1));
        subB_2.setBackground(Color.WHITE);
        sohoadon = new JLabel("Số Hoá Đơn:");
        sohoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        sohoadon.setForeground(Color.BLACK);
        thongtin_sohoadon = new JLabel("............");
        thongtin_sohoadon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_sohoadon.setForeground(Color.BLACK);
        subB_2.add(sohoadon);
        subB_2.add(thongtin_sohoadon);
        B.add(subB_2);
        row_2.add(B);
        mainpn.add(row_2);

        JPanel row_3 = new JPanel();
        row_3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        row_3.setBackground(Color.WHITE);
        JPanel C = new JPanel();
        C.setLayout(new BoxLayout(C, BoxLayout.Y_AXIS));
        C.setBackground(Color.WHITE);
        JPanel subC_1 = new JPanel();
        subC_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_1.setBackground(Color.WHITE);
        hovatenkhachhang = new JLabel("Họ Và Tên Khách Hàng:");
        hovatenkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        hovatenkhachhang.setForeground(Color.BLACK);
        subC_1.add(hovatenkhachhang);
        thongtin_hovatenkhachhang = new JLabel("................................");
        thongtin_hovatenkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_hovatenkhachhang.setForeground(Color.BLACK);
        subC_1.add(thongtin_hovatenkhachhang);
        C.add(subC_1);
        JPanel subC_2 = new JPanel();
        subC_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_2.setBackground(Color.WHITE);
        makhachhang = new JLabel("Mã Khách Hàng:");
        makhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        makhachhang.setForeground(Color.BLACK);
        subC_2.add(makhachhang);
        thongtin_makhachhang = new JLabel("............................................");
        thongtin_makhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_makhachhang.setForeground(Color.BLACK);
        subC_2.add(thongtin_makhachhang);
        C.add(subC_2);
        JPanel subC_3 = new JPanel();
        subC_3.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_3.setBackground(Color.WHITE);
        nhanvienbh = new JLabel("Nhân Viên BH:");
        nhanvienbh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nhanvienbh.setForeground(Color.BLACK);
        subC_3.add(nhanvienbh);
        thongtin_nhanvienbh = new JLabel("..............................................");
        thongtin_nhanvienbh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_nhanvienbh.setForeground(Color.BLACK);
        subC_3.add(thongtin_nhanvienbh);
        C.add(subC_3);
        JPanel subC_4 = new JPanel();
        subC_4.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_4.setBackground(Color.WHITE);
        diachikhachhang = new JLabel("Địa Chỉ:");
        diachikhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        diachikhachhang.setForeground(Color.BLACK);
        subC_4.add(diachikhachhang);
        thongtin_diachikhachhang = new JLabel(".........................................................");
        thongtin_diachikhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_diachikhachhang.setForeground(Color.BLACK);
        subC_4.add(thongtin_diachikhachhang);
        C.add(subC_4);
        JPanel subC_5 = new JPanel();
        subC_5.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_5.setBackground(Color.WHITE);
        ngaytao = new JLabel("Ngày Tạo:");
        ngaytao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        ngaytao.setForeground(Color.BLACK);
        subC_5.add(ngaytao);
        thongtin_ngaytao = new JLabel("......................................................");
        thongtin_ngaytao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_ngaytao.setForeground(Color.BLACK);
        subC_5.add(thongtin_ngaytao);
        C.add(subC_5);
        JPanel subC_6 = new JPanel();
        subC_6.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_6.setBackground(Color.WHITE);
        sdtkhachhang = new JLabel("Số Điện Thoại:");
        sdtkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        sdtkhachhang.setForeground(Color.BLACK);
        subC_6.add(sdtkhachhang);
        thongtin_sdtkhachhang = new JLabel("..............................................");
        thongtin_sdtkhachhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_sdtkhachhang.setForeground(Color.BLACK);
        subC_6.add(thongtin_sdtkhachhang);
        C.add(subC_6);
        JPanel subC_7 = new JPanel();
        subC_7.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subC_7.setBackground(Color.WHITE);
        chitietdonhang = new JLabel("Chi Tiết Đơn Hàng:");
        chitietdonhang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        chitietdonhang.setForeground(Color.BLACK);
        subC_7.add(chitietdonhang);
        C.add(subC_7);
        row_3.add(C);
        mainpn.add(row_3);
        JPanel row_4 = new JPanel();
        row_4.setLayout(new FlowLayout(FlowLayout.CENTER));
        row_4.setBackground(Color.WHITE);
        bang_chitietdonhang = new JTable(new DefaultTableModel(
                new Object[]{"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Giá Bán", "Thành Tiền"}, 0
        ));
        JTableHeader header = bang_chitietdonhang.getTableHeader();
        header.setFont(new Font("Tamoha", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(bang_chitietdonhang);
        scrollPane.getViewport().setBackground(Color.white);
        scrollPane.setPreferredSize(new Dimension(900, 600));
        row_4.add(scrollPane);
        mainpn.add(row_4);
        JPanel row_5 = new JPanel();
        row_5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        row_5.setBackground(Color.WHITE);
        JPanel D = new JPanel();
        D.setLayout(new BoxLayout(D, BoxLayout.Y_AXIS));
        D.setBackground(Color.WHITE);
        JPanel subD_1 = new JPanel();
        subD_1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subD_1.setBackground(Color.WHITE);
        tongtien = new JLabel("Tổng Tiền:");
        tongtien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tongtien.setForeground(Color.BLACK);
        subD_1.add(tongtien);
        thongtin_tongtien = new JLabel("..............................................");
        thongtin_tongtien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_tongtien.setForeground(Color.BLACK);
        subD_1.add(thongtin_tongtien);
        D.add(subD_1);
        JPanel subD_2 = new JPanel();
        subD_2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));
        subD_2.setBackground(Color.WHITE);
        tongtienbangchu = new JLabel("Tổng Tiền Bằng Chữ:");
        tongtienbangchu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tongtienbangchu.setForeground(Color.BLACK);
        subD_2.add(tongtienbangchu);
        thongtin_tongtienbangchu = new JLabel("..............................................");
        thongtin_tongtienbangchu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_tongtienbangchu.setForeground(Color.BLACK);
        subD_2.add(thongtin_tongtienbangchu);
        D.add(subD_2);
        row_5.add(D);
        mainpn.add(row_5);
        JPanel row_6 = new JPanel();
        row_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        row_6.setBackground(Color.WHITE);
        JPanel E = new JPanel();
        E.setBackground(Color.WHITE);
        ngay = new JLabel("Hà Nội, ngày");
        ngay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        ngay.setForeground(Color.BLACK);
        thang = new JLabel("tháng");
        thang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thang.setForeground(Color.BLACK);
        nam = new JLabel("năm");
        nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        nam.setForeground(Color.BLACK);
        thongtin_ngay = new JLabel(".....");
        thongtin_ngay.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_ngay.setForeground(Color.BLACK);
        thongtin_thang = new JLabel(".....");
        thongtin_thang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_thang.setForeground(Color.BLACK);
        thongtin_nam = new JLabel(".....");
        thongtin_nam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        thongtin_nam.setForeground(Color.BLACK);
        E.add(ngay);
        E.add(thongtin_ngay);
        E.add(thang);
        E.add(thongtin_thang);
        E.add(nam);
        E.add(thongtin_nam);
        row_6.add(E);
        JPanel padding_1 = new JPanel();
        padding_1.setBackground(Color.WHITE);
        row_6.add(padding_1);
        mainpn.add(row_6);

        JPanel row_7 = new JPanel();
        row_7.setLayout(new GridBagLayout());
        row_7.setBackground(Color.WHITE);

        // Font cho các nhãn và mô tả
        Font labelFont = new Font("Times New Roman", Font.PLAIN, 20);

        // Thiết lập các nhãn và mô tả ký tên
        khachhangky = new JLabel("Khách hàng");
        khachhangky.setFont(labelFont);
        khachhangky.setForeground(Color.BLACK);
        khachhangky.setHorizontalAlignment(SwingConstants.CENTER);

        thongtin_khachhangky = new JLabel("(ký, họ tên)");
        thongtin_khachhangky.setFont(labelFont);
        thongtin_khachhangky.setForeground(Color.BLACK);
        thongtin_khachhangky.setHorizontalAlignment(SwingConstants.CENTER);

        nguoilapphieuky = new JLabel("Người lập phiếu");
        nguoilapphieuky.setFont(labelFont);
        nguoilapphieuky.setForeground(Color.BLACK);
        nguoilapphieuky.setHorizontalAlignment(SwingConstants.CENTER);

        thongtin_nguoilapphieuky = new JLabel("(ký, họ tên)");
        thongtin_nguoilapphieuky.setFont(labelFont);
        thongtin_nguoilapphieuky.setForeground(Color.BLACK);
        thongtin_nguoilapphieuky.setHorizontalAlignment(SwingConstants.CENTER);

        thukhoky = new JLabel("Thủ kho");
        thukhoky.setFont(labelFont);
        thukhoky.setForeground(Color.BLACK);
        thukhoky.setHorizontalAlignment(SwingConstants.CENTER);

        thongtin_thukhoky = new JLabel("(ký, họ tên)");
        thongtin_thukhoky.setFont(labelFont);
        thongtin_thukhoky.setForeground(Color.BLACK);
        thongtin_thukhoky.setHorizontalAlignment(SwingConstants.CENTER);

        thunganky = new JLabel("Thu ngân");
        thunganky.setFont(labelFont);
        thunganky.setForeground(Color.BLACK);
        thunganky.setHorizontalAlignment(SwingConstants.CENTER);

        thongtin_thunganky = new JLabel("(ký, họ tên)");
        thongtin_thunganky .setFont(labelFont);
        thongtin_thunganky .setForeground(Color.BLACK);
        thongtin_thunganky .setHorizontalAlignment(SwingConstants.CENTER);

        // Thiết lập các ràng buộc cho GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 10, 10); // Khoảng cách các thành phần
        gbc.weightx = 1.0; // Chia đều khoảng cách ngang

        // Thêm các nhãn và mô tả ký tên vào row_8
        gbc.gridx = 0;
        gbc.gridy = 0;
        row_7.add(khachhangky, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        row_7.add(thongtin_khachhangky, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        row_7.add(nguoilapphieuky, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        row_7.add(thongtin_nguoilapphieuky, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        row_7.add(thukhoky, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        row_7.add(thongtin_thukhoky, gbc);

        gbc.gridx = 6;
        gbc.gridy = 0;
        row_7.add(thunganky, gbc);

        gbc.gridx = 6;
        gbc.gridy = 1;
        row_7.add(thongtin_thunganky, gbc);

        mainpn.add(row_7);

        con.add(scrollPane0);
    }

    public void addevent() {

    }

    public void showui() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setSize(1000, 1000);
        this.setTitle("Hoá Đơn");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormHoadon ui = new FormHoadon();
            ui.setVisible(true);
        });
    }
}
