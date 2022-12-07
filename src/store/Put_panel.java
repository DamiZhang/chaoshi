package store;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Put_panel extends JPanel {
    public Put_panel(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaoshi?serverTimezone=GMT%2b8",
                    "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JLabel l1=new JLabel("Product Name:");
        JLabel l2=new JLabel("Buy-in Price:");
        JLabel l3=new JLabel("Saling Price:");
        JLabel l4=new JLabel("Discount:");
        JTextField jtf1=new JTextField(20);
        JTextField jtf2=new JTextField(20);
        JTextField jtf3=new JTextField(20);
        JRadioButton jrb1=new JRadioButton("Yes");
        JRadioButton jrb2=new JRadioButton("No");
        jrb2.setSelected(true);
        JButton b=new JButton("Confirm");
        ButtonGroup bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        l1.setBounds(20,20,70,30);
        l2.setBounds(20,70,70,30);
        l3.setBounds(20,120,70,30);
        l4.setBounds(20,170,70,30);
        jtf1.setBounds(90,25,90,20);
        jtf2.setBounds(90,75,90,20);
        jtf3.setBounds(90,125,90,20);
        jrb1.setBounds(90,175,70,20);
        jrb2.setBounds(140,175,70,20);
        b.setBounds(200,75,70,30);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(jtf1);
        add(jtf2);
        add(jtf3);
        add(jrb1);
        add(jrb2);
        add(b);
        setLayout(null);
        b.addActionListener(e -> {
            String name=jtf1.getText();
            String Jprice=jtf2.getText();
            String Sprice=jtf3.getText();
            String bool;
            if(jrb1.isSelected())bool="Yes";
            else bool="No";
            String url="insert into store values (null, '"+name+"', '"+Jprice+"', '"+Sprice+"' ,'"+bool+"')";
            new Transaction(url);
            JOptionPane.showMessageDialog(null,"On the shelf now!","Notification",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}