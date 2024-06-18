package view;

import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;

public class TitledBorderExample {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Titled Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        
        // Tạo JPanel với TitledBorder
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel with Titled Border"));
        
        // Tạo TitledBorder
        TitledBorder titledBorder = BorderFactory.createTitledBorder("My Title");
        titledBorder.setTitleFont(new Font("Arial",Font.BOLD,20));
        titledBorder.setTitleJustification(TitledBorder.CENTER); // Căn giữa tiêu đề
        titledBorder.setTitlePosition(TitledBorder.TOP); // Đặt tiêu đề ở trên
        
        // Áp dụng TitledBorder vào JPanel
        panel.setBorder(titledBorder);
        
        // Thêm JPanel vào JFrame
        frame.add(panel);
        
        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
