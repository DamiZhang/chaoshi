package store;


import javax.swing.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
public class Operation_panel extends JPanel {
    Admin admin=new Admin();
    JDBC jdbc=new JDBC();
    public String username;
    public Operation_panel(String username){
        this.username=username;
        JLabel l1=new JLabel("选择进售货");
        String []str1={"进货","销售"};
        JComboBox jcb1=new JComboBox(str1);
        JLabel l2=new JLabel("选择商品");
        JComboBox jcb2=new JComboBox(new JDBC().str2);
        JLabel l3=new JLabel("选择件数");
        JTextField jtf=new JTextField(20);
        JButton b=new JButton("确认");
        l1.setBounds(20,20,70,30);
        jcb1.setBounds(120,20,100,30);
        l2.setBounds(20,80,70,30);
        jcb2.setBounds(120,80,100,30);
        l3.setBounds(20,150,70,30);
        jtf.setBounds(120,150,100,30);
        b.setBounds(260,80,70,30);
        b.addActionListener(e -> {
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd HH-mm");
            String str= sdf.format(date);
            String str2=jtf.getText();//个数
            String str3= (String) jcb1.getSelectedItem();//进货/售货
            String str4= (String) jcb2.getSelectedItem();//商品名
            String sum="1";
            for (int i=0;i<admin.list.size();i++){
                if (Objects.equals(admin.list.get(i).name, username))sum=String.valueOf(admin.list.get(i).sum);
            }
            String jj=jdbc.jin.get(str4);
            String sj=jdbc.shou.get(str4);
            BigDecimal bd1=new BigDecimal(str2).multiply(new BigDecimal(jj));
            BigDecimal bd2=new BigDecimal(str2).multiply(new BigDecimal(sj));
            if (str3.equals("进货")){
                sum=(String.valueOf(new BigDecimal(sum).subtract(bd1)));
            }else {
                sum=String.valueOf(new BigDecimal(sum).add(bd2));
            }
            String url1="insert into shell values (null, '"+str+"','" +str2+"','"+str3+"','" +str4+"')";
            System.out.println(username);
            String url2="update operator set sum = '"+sum+"' where  name= '"+username+"'";
            System.out.println(url2);
            new Transaction(url1);
            new Transaction(url2);
            JOptionPane.showMessageDialog(null,"交易成功","提示",JOptionPane.INFORMATION_MESSAGE);
        });
        add(l1);
        add(l2);
        add(l3);
        add(jcb1);
        add(jcb2);
        add(jtf);
        add(b);
        setLayout(null);
    }
}
