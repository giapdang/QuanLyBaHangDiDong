package view;

import javax.swing.JFrame;

public class HomeView extends JFrame {


  public HomeView() {
    this.setTitle("Quản lý bán hàng thiết bị di động");
    this.setSize(1500, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    HomeUi();
    this.setVisible(true);
  }

  public void HomeUi() {
  }
}
