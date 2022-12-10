package store;

import javax.swing.*;

public class Off_panel extends JPanel {//set up all the functions and variables in the taek off the shelf panel
    JDBC jdbc=new JDBC();
    public Off_panel(){
        JLabel l=new JLabel("Off which product?");
        JComboBox jcb=new JComboBox(jdbc.str2);
        JButton b=new JButton("Confirm");
        l.setBounds(100,70,130,30);
        jcb.setBounds(250,70,70,30);
        b.setBounds(150,120,70,40);
        add(l);
        add(jcb);
        add(b);
        b.addActionListener(e -> {
            String name= (String) jcb.getSelectedItem();
            String url="delete from store where commodityname = '"+name+"'";
            new Transaction(url);
            JOptionPane.showMessageDialog(null,"Off the Shelf now!","Notification",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}