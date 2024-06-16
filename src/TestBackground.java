import java.awt.Container;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import view.Background;

public class TestBackground extends JFrame {

    public TestBackground(String title) {
        super(title);
        addControl();
    }

    public void addControl() {
        Container con = getContentPane();
        Background pnMain = new Background();
        con.add(pnMain);
    }

    public void showWindow() {
        this.setTitle("Test Background");
        this.setSize(1200, 800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TestBackground ui = new TestBackground("Test Background");
        ui.showWindow();
    }
}
