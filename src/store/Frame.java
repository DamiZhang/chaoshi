package store;

import javax.swing.*;
import java.util.Objects;

public class Frame extends JFrame {
    boolean status=false;
    String Iname;
    Admin admin=new Admin();
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
        jmi1.addItemListener(e -> {//进货商品信息
            if (status){
                setContentPane(new commodityPanel());
                revalidate();
            }
        });
        jmi2.addItemListener(e -> {//商品交易详情
            if (status){
                setContentPane(new Transaction_panel());
                revalidate();
                pack();
            }
        });
        jmi3.addItemListener(e -> {
            if (status){
                setContentPane(new Put_panel());
                revalidate();
            }
        });
        jmi4.addItemListener(e -> {
            if (status){
                setContentPane(new Off_panel());
                revalidate();
            }
        });
        jmi5.addItemListener(e -> {
            if (status){
                setContentPane(new Operation_panel(Iname));
                revalidate();
            }
        });
        jl.b.addActionListener(e -> {//售货员登录
            if (Objects.equals(admin.map.get(jl.jtf.getText()), jl.jwf.getText()) &&admin.map.containsKey(jl.jtf.getText())) {
                status=true;
                Iname=jl.jtf.getText();
                setContentPane(new Operation_panel(jl.jtf.getText()));
                revalidate();
                JOptionPane.showMessageDialog(null,"登陆成功","提示",JOptionPane.WARNING_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"账号或密码错误","警告",JOptionPane.ERROR_MESSAGE);
        });
        setVisible(true);
    }
}