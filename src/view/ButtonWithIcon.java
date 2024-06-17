package view;

import javax.swing.*;
import java.awt.*;

public class ButtonWithIcon {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Button with Icon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Tạo JPanel
        JPanel panel = new JPanel();
        frame.add(panel);

        // Tạo ImageIcon từ đường dẫn tới tệp ảnh
        String iconPath = "C:\\Users\\Admin\\OneDrive\\Pictures\\Saved Pictures\\search-icon-2048x2048-cmujl7en.png";
        ImageIcon originalIcon = new ImageIcon(iconPath);

        // Kiểm tra xem icon có được tải thành công không
        if (originalIcon.getIconWidth() == -1) {
            System.out.println("Icon not found or failed to load.");
        } else {
            // Thay đổi kích thước icon
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            // Tạo JButton và gắn ImageIcon vào
            JButton button = new JButton("Click Me", resizedIcon);
            button.setPreferredSize(new Dimension(400, 200));
            
            // Thêm JButton vào JPanel
            panel.add(button);

            // Hiển thị JFrame
            frame.setVisible(true);
        }
    }
}
