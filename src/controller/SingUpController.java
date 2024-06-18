package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.service.SingUpService;
import view.signup;

public class SingUpController {

  private final signup singUpView;
  private final SingUpService singUpService;

  public SingUpController(signup singUpView, SingUpService singUpService) {
    this.singUpView = singUpView;
    this.singUpService = singUpService;
    addUser();
  }

  //method them user
  public void addUser() {
    singUpView.getSigBT().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          String TenNguoiNhap = singUpView.getJTF1().getText();
          String Email = singUpView.getJTF2().getText();
          String MatKhau = singUpView.getJPF1().getText();
          String SoDienThoai = singUpView.getJTF3().getText();
          singUpService.CreateUser(TenNguoiNhap, Email, MatKhau, SoDienThoai);
        } catch(Exception a) {
          a.printStackTrace();
        }
      }
    });
  }
}
