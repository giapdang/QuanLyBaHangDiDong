package view;

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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signup extends JFrame {

    JLabel logLB, userLB, passLB, emailLB, phoneLB;
    JButton sigBT, logBT;
    JTextField JTF1, JTF2, JTF3;
    JPasswordField JPF1;
    JLabel ERROR1, ERROR2, ERROR3, ERROR4;
    Background background;
    JPanel inputpn;

    public signup(String title) {
        super(title);
        addControl();
        addEvent();
    }

    ActionListener login = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            close();
        }
    };

    protected void close() {
        login ui = new login("Đăng nhập");
        ui.showWindow();
        dispose();
    }

    ActionListener signin = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            checksignin();
        }
    };

    protected void checksignin() {
        String username = JTF1.getText();
        String email = JTF2.getText();
        String password = new String(JPF1.getPassword());
        String phonenum = JTF3.getText();
        String userpat = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        String emailpat = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";
        String passpat = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
        String phonepat = "[0-9]{10}";

        boolean valid = true;

        if ("".equals(username)) {
            ERROR1.setText("Không được bỏ trống trường này!");
            valid = false;
        } else if (!username.matches(userpat)) {
            ERROR1.setText("Tên người dùng không hợp lệ!");
            valid = false;
        } else {
            ERROR1.setText("");
        }

        if ("".equals(email)) {
            ERROR2.setText("Không được bỏ trống trường này!");
            valid = false;
        } else if (!email.matches(emailpat)) {
            ERROR2.setText("Email không hợp lệ!");
            valid = false;
        } else {
            ERROR2.setText("");
        }

        if ("".equals(password)) {
            ERROR3.setText("Không được bỏ trống trường này!");
            valid = false;
        } else if (!password.matches(passpat)) {
            ERROR3.setText("Mật khẩu không hợp lệ!");
            valid = false;
        } else {
            ERROR3.setText("");
        }

        if ("".equals(phonenum)) {
            ERROR4.setText("Không được bỏ trống trường này!");
            valid = false;
        } else if (!phonenum.matches(phonepat)) {
            ERROR4.setText("Số điện thoại không hợp lệ!");
            valid = false;
        } else {
            ERROR4.setText("");
        }

        if (valid) {
            JOptionPane.showMessageDialog(null, "Đăng ký thành công! Yeah! ");
            JTF1.setText("");
            JTF2.setText("");
            JTF3.setText("");
            JPF1.setText("");
            login ui = new login("Đăng nhập");
            ui.showWindow();
            dispose();
        } else {
            // Revalidate and repaint the entire frame after updating error messages
            revalidate();
            repaint();
        }
    }

    public void addControl() {
        Container con = getContentPane();
        background = new Background();
        JPanel mainpn = new JPanel();
        mainpn.setOpaque(false);
        mainpn.setLayout(new GridBagLayout());
        mainpn.setBackground(new Color(0, 0, 0, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);

        JPanel pnsub = new JPanel();
        pnsub.setLayout(new BoxLayout(pnsub, BoxLayout.Y_AXIS));
        pnsub.setBackground(new Color(0, 0, 0, 150));
        pnsub.setPreferredSize(new Dimension(500, 470));

        JPanel pnLB = new JPanel();
        pnLB.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 30));
        pnLB.setBackground(new Color(0, 0, 0, 0));
        logLB = new JLabel("REGISTER");
        logLB.setFont(new Font("Verdana", Font.PLAIN, 50));
        logLB.setForeground(Color.white);
        logLB.setAlignmentX(CENTER_ALIGNMENT);
        pnLB.add(logLB);
        pnsub.add(pnLB);

        inputpn = new JPanel();
        inputpn.setLayout(new GridBagLayout());
        inputpn.setBackground(new Color(0, 0, 0, 0));

        userLB = new JLabel("Username:");
        emailLB = new JLabel("Email:");
        passLB = new JLabel("Mật khẩu:");
        phoneLB = new JLabel("Số điện thoại:");

        userLB.setFont(new Font("verdana", Font.PLAIN, 20));
        userLB.setForeground(Color.white);
        emailLB.setFont(new Font("verdana", Font.PLAIN, 20));
        emailLB.setForeground(Color.white);
        passLB.setFont(new Font("verdana", Font.PLAIN, 20));
        passLB.setForeground(Color.white);
        phoneLB.setFont(new Font("verdana", Font.PLAIN, 20));
        phoneLB.setForeground(Color.white);

        JTF1 = new JTextField(20);
        JTF2 = new JTextField(20);
        JPF1 = new JPasswordField(20);
        JTF3 = new JTextField(20);

        ERROR1 = new JLabel("");
        ERROR2 = new JLabel("");
        ERROR3 = new JLabel("");
        ERROR4 = new JLabel("");

        ERROR1.setFont(new Font("verdana", Font.PLAIN, 15));
        ERROR1.setForeground(Color.red);
        ERROR2.setFont(new Font("verdana", Font.PLAIN, 15));
        ERROR2.setForeground(Color.red);
        ERROR3.setFont(new Font("verdana", Font.PLAIN, 15));
        ERROR3.setForeground(Color.red);
        ERROR4.setFont(new Font("verdana", Font.PLAIN, 15));
        ERROR4.setForeground(Color.red);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.insets = new Insets(4, 4, 5, 10);

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        inputpn.add(userLB, gbc2);
        gbc2.gridx = 1;
        inputpn.add(JTF1, gbc2);
        gbc2.gridy++;
        gbc2.gridx = 1;
        inputpn.add(ERROR1, gbc2);

        gbc2.gridx = 0;
        gbc2.gridy++;
        inputpn.add(emailLB, gbc2);
        gbc2.gridx = 1;
        inputpn.add(JTF2, gbc2);
        gbc2.gridy++;
        gbc2.gridx = 1;
        inputpn.add(ERROR2, gbc2);

        gbc2.gridx = 0;
        gbc2.gridy++;
        inputpn.add(passLB, gbc2);
        gbc2.gridx = 1;
        inputpn.add(JPF1, gbc2);
        gbc2.gridy++;
        gbc2.gridx = 1;
        inputpn.add(ERROR3, gbc2);

        gbc2.gridx = 0;
        gbc2.gridy++;
        inputpn.add(phoneLB, gbc2);
        gbc2.gridx = 1;
        inputpn.add(JTF3, gbc2);
        gbc2.gridy++;
        gbc2.gridx = 1;
        inputpn.add(ERROR4, gbc2);

        pnsub.add(inputpn);

        JPanel pnbtn = new JPanel();
        pnbtn.setBackground(new Color(0, 0, 0, 0));
        pnbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        sigBT = new JButton("Đăng Ký");
        sigBT.setFont(new Font("verdana", Font.PLAIN, 25));
        sigBT.setForeground(Color.black);
        sigBT.setBackground(Color.decode("#FFF9D0"));
        sigBT.setPreferredSize(new Dimension(200, 50));
        logBT = new JButton("Đăng Nhập");
        logBT.setFont(new Font("verdana", Font.PLAIN, 25));
        logBT.setForeground(Color.black);
        logBT.setBackground(Color.decode("#FFF9D0"));
        logBT.setPreferredSize(new Dimension(200, 50));
        pnbtn.add(sigBT);
        pnbtn.add(logBT);
        pnsub.add(pnbtn);
        mainpn.add(pnsub, gbc);
        background.setLayout(new GridBagLayout());
        background.add(mainpn, gbc);
        con.add(background);
        this.pack();
    }

    public void addEvent() {
        sigBT.addActionListener(signin);
        logBT.addActionListener(login);
    }

    public void showWindow() {
        this.setTitle("Đăng Ký");
        this.setSize(1300, 800);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        signup ui = new signup("Đăng Nhập");
        ui.showWindow();
    }
}
