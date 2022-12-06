package store;

import javax.swing.*;
import java.util.Objects;

public class Frame extends JFrame {
    boolean status=false;
    String Iname;
    Admin admin=new Admin();
    public Frame(){
        setTitle("超市管理系统");
        JMenu jm1=new JMenu("商品信息");
        JMenu jm2=new JMenu("商品管理");
        JMenuItem jmi1=new JMenu("进货商品信息");
        JMenuItem jmi2=new JMenu("商品交易信息");
        JMenuItem jmi3=new JMenu("上架商品");
        JMenuItem jmi4=new JMenu("下架商品");
        JMenuItem jmi5=new JMenu("交易商品");
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