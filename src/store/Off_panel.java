package store;

import javax.swing.*;

public class Off_panel extends JPanel {
    JDBC jdbc=new JDBC();
    public Off_panel(){
        JLabel l=new JLabel("选择需要下架的商品:");
        JComboBox jcb=new JComboBox(jdbc.str2);
        JButton b=new JButton("确定");
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
            JOptionPane.showMessageDialog(null,"已下架","提示",JOptionPane.INFORMATION_MESSAGE);
        });
    }
}