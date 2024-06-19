package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.service.LoginService;

public class login extends JFrame {

  JLabel logLB, userLB, passLB;
  JButton logBT, sigBT;
  JTextField JTF1;
  JPasswordField JPF1;
  Background background;
  JPanel inputpn;

  public login(String title) {
    super(title);
    initializeComponents();
    addComponents();
    addEvents();
  }

  private void initializeComponents() {
    background = new Background();
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setOpaque(false); // Đảm bảo mainPanel trong suốt
    int y = (800 - 400) / 2;
    JPanel pncon = new JPanel();
    pncon.setLayout(new FlowLayout(FlowLayout.CENTER, 1, y));
    pncon.setBackground(new Color(0, 0, 0, 0));
    JPanel pnsub = new JPanel();
    pnsub.setBackground(new Color(0, 0, 0, 150));
    pnsub.setLayout(new BoxLayout(pnsub, BoxLayout.Y_AXIS));
    pnsub.setPreferredSize(new Dimension(500, 400));

    JPanel pnLB = new JPanel();
    pnLB.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));
    pnLB.setBackground(new Color(0, 0, 0, 0));
    logLB = new JLabel("LOGIN");
    logLB.setFont(new Font("Verdana", Font.PLAIN, 50));
    logLB.setForeground(Color.white);
    logLB.setAlignmentX(CENTER_ALIGNMENT);
    pnLB.add(logLB);
    pnsub.add(pnLB);

    JPanel paddingPN = new JPanel();
    paddingPN.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 15));
    paddingPN.setBackground(new Color(0, 0, 0, 0));
    pnsub.add(paddingPN);
    inputpn = new JPanel();
    inputpn.setLayout(new GridBagLayout());
    userLB = new JLabel("Username:");
    passLB = new JLabel("Password:");
    inputpn.setBackground(new Color(0, 0, 0, 0));
    userLB.setFont(new Font("Verdana", Font.PLAIN, 25));
    userLB.setForeground(Color.white);
    JTF1 = new JTextField(20);
    passLB.setFont(new Font("Verdana", Font.PLAIN, 25));
    passLB.setForeground(Color.white);
    JPF1 = new JPasswordField(20);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(4, 4, 5, 10);
    gbc.gridx = 0;
    gbc.gridy = 0;
    inputpn.add(userLB, gbc);
    gbc.gridx = 1;
    inputpn.add(JTF1, gbc);
    gbc.gridx = 0;
    gbc.gridy = 1;
    inputpn.add(passLB, gbc);
    gbc.gridx = 1;
    inputpn.add(JPF1, gbc);
    pnsub.add(inputpn);
    JPanel padding2PN = new JPanel();
    padding2PN.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 5));
    padding2PN.setBackground(new Color(0, 0, 0, 0));
    pnsub.add(padding2PN);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 55));
    buttonPanel.setBackground(new Color(0, 0, 0, 0));
    logBT = new JButton("Đăng Nhập");
    logBT.setFont(new Font("Verdana", Font.PLAIN, 25));
    logBT.setForeground(Color.black);
    logBT.setBackground(Color.decode("#FFF9D0"));
    logBT.setPreferredSize(new Dimension(200, 50));
    sigBT = new JButton("Đăng Ký");
    sigBT.setFont(new Font("Verdana", Font.PLAIN, 25));
    sigBT.setForeground(Color.black);
    sigBT.setBackground(Color.decode("#FFF9D0"));
    sigBT.setPreferredSize(new Dimension(200, 50));
    buttonPanel.add(logBT);
    buttonPanel.add(sigBT);
    pnsub.add(buttonPanel);
    pncon.add(pnsub);
    mainPanel.add(pncon);
    background.add(mainPanel);
  }

  private void addComponents() {
    Container con = getContentPane();
    con.setLayout(new BorderLayout());
    JPanel contentPane = new JPanel(new BorderLayout());
    contentPane.add(background, BorderLayout.CENTER);
    con.add(contentPane, BorderLayout.CENTER);
  }

  private void addEvents() {
    logBT.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        goin();
      }
    });

    sigBT.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        open();
      }
    });
  }

  private void goin() {
    String username = JTF1.getText();
    String password = new String(JPF1.getPassword());

    LoginService loginService = new LoginService(this);
    boolean dangnhapthanhcong = loginService.Login(username, password);
    if (dangnhapthanhcong) {
      this.dispose();
      JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
      HomePage homePage = new HomePage();
      homePage.run();
    } else {
      if ("".equals(username) || "".equals(password)) {
        JOptionPane.showMessageDialog(null, "Hãy điền đủ các thông tin của bạn");
      }
    }
  }

  public JLabel getLogLB() {
    return logLB;
  }

  public void setLogLB(JLabel logLB) {
    this.logLB = logLB;
  }

  public JLabel getUserLB() {
    return userLB;
  }

  public void setUserLB(JLabel userLB) {
    this.userLB = userLB;
  }

  public JLabel getPassLB() {
    return passLB;
  }

  public void setPassLB(JLabel passLB) {
    this.passLB = passLB;
  }

  public JButton getLogBT() {
    return logBT;
  }

  public void setLogBT(JButton logBT) {
    this.logBT = logBT;
  }

  public JButton getSigBT() {
    return sigBT;
  }

  public void setSigBT(JButton sigBT) {
    this.sigBT = sigBT;
  }

  public JTextField getJTF1() {
    return JTF1;
  }

  public void setJTF1(JTextField JTF1) {
    this.JTF1 = JTF1;
  }

  public JPasswordField getJPF1() {
    return JPF1;
  }

  public void setJPF1(JPasswordField JPF1) {
    this.JPF1 = JPF1;
  }

  public void setBackground(Background background) {
    this.background = background;
  }

  public JPanel getInputpn() {
    return inputpn;
  }

  public void setInputpn(JPanel inputpn) {
    this.inputpn = inputpn;
  }

  private void open() {
    signup ui = new signup("Đăng Ký");
    ui.showWindow();
    this.dispose();
  }

  public void showWindow() {
    this.setTitle("Đăng Nhập");
    this.setSize(1350, 830);
    this.setResizable(false);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}


