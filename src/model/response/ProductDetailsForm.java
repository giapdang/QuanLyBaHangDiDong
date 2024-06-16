package model.response;

import java.text.NumberFormat;
import javax.swing.*;
import java.awt.*;

public class ProductDetailsForm extends JFrame {

  private JTextField tfIDSanPham;
  private JTextField tfTenSanPham;
  private JTextField tfGiaBanRa;
  private JTextField tfGiaNhap;
  private JTextField tfMoTa;
  private JTextField tfThoiGianNhap;
  private JTextField tfTenDanhMuc;
  private JTextField tfTenNhaCungCap;

  private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

  public JTextField getTfIDSanPham() {
    return tfIDSanPham;
  }

  public void setTfIDSanPham(JTextField tfIDSanPham) {
    this.tfIDSanPham = tfIDSanPham;
  }

  public JTextField getTfTenSanPham() {
    return tfTenSanPham;
  }

  public void setTfTenSanPham(JTextField tfTenSanPham) {
    this.tfTenSanPham = tfTenSanPham;
  }

  public JTextField getTfGiaBanRa() {
    return tfGiaBanRa;
  }

  public void setTfGiaBanRa(JTextField tfGiaBanRa) {
    this.tfGiaBanRa = tfGiaBanRa;
  }

  public JTextField getTfGiaNhap() {
    return tfGiaNhap;
  }

  public void setTfGiaNhap(JTextField tfGiaNhap) {
    this.tfGiaNhap = tfGiaNhap;
  }

  public JTextField getTfMoTa() {
    return tfMoTa;
  }

  public void setTfMoTa(JTextField tfMoTa) {
    this.tfMoTa = tfMoTa;
  }

  public JTextField getTfThoiGianNhap() {
    return tfThoiGianNhap;
  }

  public void setTfThoiGianNhap(JTextField tfThoiGianNhap) {
    this.tfThoiGianNhap = tfThoiGianNhap;
  }

  public JTextField getTfTenDanhMuc() {
    return tfTenDanhMuc;
  }

  public void setTfTenDanhMuc(JTextField tfTenDanhMuc) {
    this.tfTenDanhMuc = tfTenDanhMuc;
  }

  public JTextField getTfTenNhaCungCap() {
    return tfTenNhaCungCap;
  }

  public void setTfTenNhaCungCap(JTextField tfTenNhaCungCap) {
    this.tfTenNhaCungCap = tfTenNhaCungCap;
  }

  public ProductDetailsForm() {
    setLayout(new FlowLayout());

    JPanel chitietsanpham = new JPanel();
    chitietsanpham.setPreferredSize(new Dimension(200, 45));
    JLabel lbchitietsanpham = new JLabel("Chi tiết sản phẩm");
    lbchitietsanpham.setFont(new Font("verdana", Font.PLAIN, 20));
    lbchitietsanpham.setForeground(Color.magenta);
    chitietsanpham.add(lbchitietsanpham);

    JPanel IDSanPham = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbIDSanPham = new JLabel("ID sản phẩm");
    lbIDSanPham.setPreferredSize(new Dimension(100, 15));
    lbIDSanPham.setForeground(Color.magenta);
    tfIDSanPham = new JTextField(20);
    IDSanPham.add(lbIDSanPham);
    IDSanPham.add(tfIDSanPham);

    JPanel TenSanPham = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbTenSanPham = new JLabel("Tên sản phẩm");
    lbTenSanPham.setPreferredSize(new Dimension(100, 15));
    lbTenSanPham.setForeground(Color.magenta);
    tfTenSanPham = new JTextField(20);
    TenSanPham.add(lbTenSanPham);
    TenSanPham.add(tfTenSanPham);

    JPanel GiaBan = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbGiaBan = new JLabel("Giá bán");
    lbGiaBan.setPreferredSize(new Dimension(100, 15));
    lbGiaBan.setForeground(Color.magenta);
    tfGiaBanRa = new JTextField(20);
    GiaBan.add(lbGiaBan);
    GiaBan.add(tfGiaBanRa);

    JPanel GiaNhap = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbGiaNhap = new JLabel("Giá nhập");
    lbGiaNhap.setPreferredSize(new Dimension(100, 15));
    lbGiaNhap.setForeground(Color.magenta);
    tfGiaNhap = new JTextField(20);
    GiaNhap.add(lbGiaNhap);
    GiaNhap.add(tfGiaNhap);

    JPanel MoTa = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbMoTa = new JLabel("Mô tả");
    lbMoTa.setPreferredSize(new Dimension(100, 15));
    lbMoTa.setForeground(Color.magenta);
    tfMoTa = new JTextField(20);
    MoTa.add(lbMoTa);
    MoTa.add(tfMoTa);

    JPanel ThoiGianNhap = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbThoiGianNhap = new JLabel("Thời gian nhập");
    lbThoiGianNhap.setPreferredSize(new Dimension(100, 15));
    lbThoiGianNhap.setForeground(Color.magenta);
    tfThoiGianNhap = new JTextField(20);
    ThoiGianNhap.add(lbThoiGianNhap);
    ThoiGianNhap.add(tfThoiGianNhap);

    JPanel TenDanhMuc = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbTenDanhMuc = new JLabel("Tên danh mục");
    lbTenDanhMuc.setPreferredSize(new Dimension(100, 15));
    lbTenDanhMuc.setForeground(Color.magenta);
    tfTenDanhMuc = new JTextField(20);
    TenDanhMuc.add(lbTenDanhMuc);
    TenDanhMuc.add(tfTenDanhMuc);

    JPanel TenNhaCungCap = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lbTenNhaCungCap = new JLabel("Tên nhà cung cáp");
    lbTenNhaCungCap.setPreferredSize(new Dimension(100, 15));
    lbTenNhaCungCap.setForeground(Color.magenta);
    tfTenNhaCungCap = new JTextField(20);
    TenNhaCungCap.add(lbTenNhaCungCap);
    TenNhaCungCap.add(tfTenNhaCungCap);

    add(chitietsanpham);
    add(IDSanPham);
    add(TenSanPham);
    add(GiaBan);
    add(GiaNhap);
    add(MoTa);
    add(ThoiGianNhap);
    add(TenDanhMuc);
    add(TenNhaCungCap);

    setSize(400, 400);
    setVisible(true);
    setLocationRelativeTo(null);
  }

}