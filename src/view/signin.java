package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class signin extends JFrame {
    JLabel logLB,userLB,passLB,emailLB,phoneLB;
    JButton sigBT,logBT;
    JTextField JTF1,JTF2,JTF3;
    JPasswordField JPF1;
    public signin(String title) {
        super(title);
        addControl();
        addEvent();
    }
    ActionListener login = new ActionListener(){
         @Override
        public void actionPerformed(ActionEvent e) {         
            close();
        }
     }; 
     protected void close(){
         login ui=new login("Đăng nhập");
                ui.showWindow();
         dispose(); 
     }  
     ActionListener signin = new ActionListener(){
         @Override
        public void actionPerformed(ActionEvent e) {         
            checksignin();            
        }
     }; 
     protected void checksignin(){
        String username =JTF1.getText();
        String email=JTF2.getText();
        String passwword= new String(JPF1.getPassword());
        String phonenum=JTF3.getText();
        // usetname tên liền
        String userpat="^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        // email thường
        String emailpat="^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$";      
        //passa 8 ký tự có in chữ in hoa , số, ký tự đặc biệt
        String passpat="^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
        String phonepat="[0-9]{10}";
        int count=0;
        if(username.matches(userpat)){
         count+=1;
        }
        if(email.matches(emailpat)){
         count+=1;
        }
        if(passwword.matches(passpat)){
         count+=1;
        }
        if(phonenum.matches(phonepat)){
         count+=1;
        }
        if(count == 4){
            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            login ui=new login("Đăng nhập");
                ui.showWindow();
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ mời nhập lại");
            JTF1.setText("");
            JTF2.setText("");
            JTF3.setText("");
            JPF1.setText("");
        }
     }
    public void addControl(){
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        JPanel pn1 = new JPanel();       
        pn1.setPreferredSize(new Dimension(150,0));
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(150,0));    

        // panel đăng ký
        JPanel pnsub = new JPanel();
        pnsub.setBackground(Color.pink);
        pnsub.setLayout(new BoxLayout(pnsub,BoxLayout.Y_AXIS));
        
        //panel tróng
        JPanel blankPN = new JPanel();
        blankPN.setBackground(Color.pink);
        blankPN.setPreferredSize(new Dimension(10,20));
        //tiêu đề
        JPanel logPN = new JPanel();
        logPN.setBackground(Color.pink);
        logPN.setPreferredSize(new Dimension(100,100));
        logLB = new JLabel("Đăng ký");
        logLB.setFont(new Font("verdana",Font.PLAIN,60));
        logLB.setForeground(Color.white);       
        logPN.add(logLB);

        //username
        JPanel userPN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPN.setBackground(Color.pink);        
        userLB = new JLabel("Username:");
        userLB.setPreferredSize(new Dimension(250,30));
        userLB.setFont(new Font("verdana",Font.PLAIN,30));
        userLB.setForeground(Color.white);  
        JTF1 = new JTextField();
        JTF1.setPreferredSize(new Dimension(500,30));       
        userPN.add(userLB);
        userPN.add(JTF1);

        //email    
        JPanel emailPN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPN.setBackground(Color.pink);        
        emailLB = new JLabel("Email:");
        emailLB.setPreferredSize(new Dimension(250,30));
        emailLB.setFont(new Font("verdana",Font.PLAIN,30));
        emailLB.setForeground(Color.white);             
        JTF2 = new JTextField();
        JTF2.setPreferredSize(new Dimension(500,30));
        emailPN.add(emailLB);
        emailPN.add(JTF2);

        //pass       
        JPanel passPN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passPN.setBackground(Color.pink);
        passLB = new JLabel("Mật khẩu:");
        passLB.setPreferredSize(new Dimension(250,30));
        passLB.setFont(new Font("verdana",Font.PLAIN,30));
        passLB.setForeground(Color.white);      
        JPF1 = new JPasswordField();
        JPF1.setPreferredSize(new Dimension(500,30));        
        passPN.add(passLB);
        passPN.add(JPF1);
        
        //SĐT
        JPanel phonePN = new JPanel(new FlowLayout(FlowLayout.LEFT));
        phonePN.setBackground(Color.pink);       
        phoneLB = new JLabel("Số điện thoại:");
        phoneLB.setPreferredSize(new Dimension(250,30));
        phoneLB.setFont(new Font("verdana",Font.PLAIN,30));
        phoneLB.setForeground(Color.white);      
        JTF3 = new JTextField();
        JTF3.setPreferredSize(new Dimension(500,30));
        phonePN.add(phoneLB);
        phonePN.add(JTF3);
        
        //Button
        JPanel buttPN = new JPanel();
        buttPN.setBackground(Color.pink);
        buttPN.setPreferredSize(new Dimension(250,50));
        sigBT = new JButton("Đăng ký");
        sigBT.setFont(new Font("verdana",Font.PLAIN,40));
        sigBT.setForeground(Color.white);
        sigBT.setOpaque(false);
        sigBT.setContentAreaFilled(false);
        sigBT.setBorderPainted(false);
        sigBT.setPreferredSize(new Dimension(300,100));
        logBT = new JButton("Đăng nhập");
        logBT.setFont(new Font("verdana",Font.PLAIN,40));
        logBT.setForeground(Color.white);
        logBT.setOpaque(false);
        logBT.setContentAreaFilled(false);
        logBT.setBorderPainted(false);        
        buttPN.add(sigBT);
        buttPN.add(logBT);
        
        pnsub.add(blankPN);
        pnsub.add(logPN);
        pnsub.add(userPN);
        pnsub.add(emailPN);
        pnsub.add(passPN);
        pnsub.add(phonePN);
        pnsub.add(buttPN);
        
        pnMain.add(pn1, BorderLayout.WEST );
        pnMain.add(pn2, BorderLayout.EAST );
        pnMain.add(pnsub, BorderLayout.CENTER);
        con.add(pnMain);
    }
    public void addEvent() {
    sigBT.addActionListener(signin);
    logBT.addActionListener(login);
    }
     public void showWindow() {
        this.setTitle("Đăng ký");
        this.setSize(1200, 1000);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
         public static void main(String[] args) {
        signin ui = new  signin("Đăng nhập");
        ui.showWindow();
    }
}
