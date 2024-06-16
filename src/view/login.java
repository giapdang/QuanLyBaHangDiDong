package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class login extends JFrame {

    JLabel logLB, userLB, passLB;
    JButton logBT, sigBT;
    JTextField JTF1;
    JPasswordField JPF1;
    Background background;

    public login(String title) {
        super(title);
        initializeComponents();
        addComponents();
        addEvents();
    }

    private void initializeComponents() {
        background = new Background(); // Khởi tạo background panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false); // Đảm bảo mainPanel trong suốt
        int y=(800-400)/2;
        JPanel pncon= new JPanel();
        pncon.setLayout(new FlowLayout(FlowLayout.CENTER,1,y));
        pncon.setBackground(new Color(0, 0, 0, 0));
        JPanel pnsub = new JPanel();
        pnsub.setBackground(new Color(0, 0, 0, 150)); // Độ trong suốt
        pnsub.setLayout(new BoxLayout(pnsub, BoxLayout.Y_AXIS));
        pnsub.setPreferredSize(new Dimension(500,400));

        JPanel pnLB=new JPanel();
        pnLB.setLayout(new FlowLayout(FlowLayout.CENTER,1,20));
        pnLB.setBackground(new Color(0, 0, 0, 0));
        logLB = new JLabel("LOGIN");
        logLB.setFont(new Font("Verdana", Font.PLAIN, 50));
        logLB.setForeground(Color.white);
        logLB.setAlignmentX(CENTER_ALIGNMENT);
        pnLB.add(logLB);
        pnsub.add(pnLB);
        JPanel userPN = new JPanel();
        userPN.setBackground(new Color(0, 0, 0, 0)); // Độ trong suốt
        userLB = new JLabel("Username:");
        userLB.setFont(new Font("Verdana", Font.PLAIN, 25));
        userLB.setForeground(Color.white);
        JTF1 = new JTextField(20);
        userPN.add(userLB);
        userPN.add(JTF1);
        pnsub.add(userPN);

        JPanel passPN = new JPanel();
        passPN.setBackground(new Color(0, 0, 0, 0)); // Độ trong suốt
        passLB = new JLabel("Password:");
        passLB.setFont(new Font("Verdana", Font.PLAIN, 25));
        passLB.setForeground(Color.white);
        JPF1 = new JPasswordField(20);
        passPN.add(passLB);
        passPN.add(JPF1);
        pnsub.add(passPN);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,1));
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); 
        logBT = new JButton("Đăng nhập");
        logBT.setFont(new Font("Verdana", Font.PLAIN, 30));
        logBT.setForeground(Color.white);
        logBT.setPreferredSize(new Dimension(200,50));
        sigBT = new JButton("Đăng ký");
        sigBT.setFont(new Font("Verdana", Font.PLAIN, 30));
        sigBT.setForeground(Color.white);
        sigBT.setPreferredSize(new Dimension(200,50));
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

        // Placeholder for login validation
        boolean loginSuccessful = true; // Replace with actual validation logic

        if (loginSuccessful) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Sai username hoặc mật khẩu");
        }
    }

    private void open() {
        signin ui = new signin("Đăng Ký");
        ui.showWindow();
        dispose();
    }

    public void showWindow() {
        this.setTitle("Đăng nhập");
        this.setSize(1300, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null); // Đặt vị trí frame vào giữa màn hình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        login ui = new login("Đăng nhập");
        ui.showWindow();
    }
}
