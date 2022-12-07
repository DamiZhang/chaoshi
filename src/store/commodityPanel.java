package store;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class commodityPanel extends JPanel {
    public commodityPanel(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaoshi?serverTimezone=GMT%2b8",
                            "root", "root")) {
                PreparedStatement ps = c.prepareStatement("select *from store", ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet res= ps.executeQuery();//获取的结果
                res.last();
                int row=res.getRow();
                res.beforeFirst();
                String[][] str=new String[row][5];
                res.next();
                for (int i=0;i<row;i++){
                    str[i][0]=res.getString("id");
                    str[i][1]=res.getString("commodityname");
                    str[i][2]=res.getString("Unit_Price");
                    str[i][3]=res.getString("price");
                    str[i][4]=res.getString("Discount");
                    res.next();
                }
                String []name={"No.","Product Name","BP","SP","Discount?"};
                JTable jt=new JTable(str,name);
                jt.setPreferredScrollableViewportSize(new Dimension(350,200));
                JScrollPane jsp=new JScrollPane(jt);
                add(jsp,BorderLayout.CENTER);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        JDBC jdbc=new JDBC();
//        String []name={"id","商品名","进价","售价","是否打折"};
//        JTable jt=new JTable(jdbc.str1,name);
//        jt.setPreferredScrollableViewportSize(new Dimension(350,200));
//        JScrollPane jsp=new JScrollPane(jt);
//        add(jsp,BorderLayout.CENTER);
    }

}