package store;

import javax.swing.*;
import java.awt.*;

public class Login_panel extends JPanel { //set up the look of Log in page
    public JButton b;
    public JTextField jtf;
    public JPasswordField jwf;
    public Login_panel(){
        JLabel l=new JLabel("Merchandise System");
        JLabel l1=new JLabel("Username:");
        JLabel l2=new JLabel("Password:");
        jtf=new JTextField(20);
        jwf=new JPasswordField(20);
        jwf.setEchoChar('*');
        b=new JButton("Log in");
        l.setBounds(70,20,300,50);
        l.setForeground(Color.red);
        l.setFont(new Font("宋体",Font.BOLD,23));
        l1.setBounds(120,75,100,40);
        l2.setBounds(120,110,100,40);
        jtf.setBounds(180,75,100,30);
        jwf.setBounds(180,110,100,30);
        b.setBounds(170,170,70,40);
        add(l);
        add(l1);
        add(l2);
        add(jtf);
        add(jwf);
        add(b);
        setLayout(null);
    }
}