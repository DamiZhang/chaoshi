package store;

import javax.swing.*;
import java.util.Objects;

public class Frame extends JFrame {
    boolean status=false;
    String Iname;
    Admin admin=new Admin();//Set up the main look of all functions of this system
    public Frame(){
        setTitle("Merchandise Management System");
        JMenu jm1=new JMenu("Product Information");
        JMenu jm2=new JMenu("Product Adjustment");
        JMenuItem jmi1=new JMenu("Storage");
        JMenuItem jmi2=new JMenu("Transaction Record");
        JMenuItem jmi3=new JMenu("Put on");
        JMenuItem jmi4=new JMenu("Take off");
        JMenuItem jmi5=new JMenu("Transaction now！");
        jm1.add(jmi1);
        jm1.add(jmi2);
        jm2.add(jmi3);
        jm2.add(jmi4);
        jm2.add(jmi5);
        JMenuBar jmb=new JMenuBar();
        jmb.add(jm1);
        jmb.add(jm2);
        setJMenuBar(jmb);
        setBounds(300,200,400,300);
        setLayout(null);
        Login_panel jl=new Login_panel();
        //commodityPanel cp=new commodityPanel();
        setContentPane(jl);
        jmi1.addItemListener(e -> {//The Information about buy-in product
            if (status){
                setContentPane(new commodityPanel());
                revalidate();
            }
        });
        jmi2.addItemListener(e -> {//The information about product transaction
            if (status){
                setContentPane(new Transaction_panel());
                revalidate();
                pack();
            }
        });
        jmi3.addItemListener(e -> {//The information about putting on the shelf
            if (status){
                setContentPane(new Put_panel());
                revalidate();
            }
        });
        jmi4.addItemListener(e -> {//The information about taking off the shelf
            if (status){
                setContentPane(new Off_panel());
                revalidate();
            }
        });
        jmi5.addItemListener(e -> {//The information about the storage
            if (status){
                setContentPane(new Operation_panel(Iname));
                revalidate();
            }
        });
        jl.b.addActionListener(e -> { //The Login page of the storage administrator and sales person
            if (Objects.equals(admin.map.get(jl.jtf.getText()), jl.jwf.getText()) &&admin.map.containsKey(jl.jtf.getText())) {
                status=true;
                Iname=jl.jtf.getText();
                setContentPane(new Operation_panel(jl.jtf.getText()));
                revalidate();
                JOptionPane.showMessageDialog(null,"Welcome!","Notification",JOptionPane.WARNING_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Name or Password Error","Warning",JOptionPane.ERROR_MESSAGE);
        });
        setVisible(true);
    }
}