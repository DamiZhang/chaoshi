package store;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Transaction_panel extends JPanel {
    public Transaction_panel(){//This is the sales panel shows the transaction information imported from the sql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaoshi?serverTimezone=GMT%2b8",
                            "root", "root")) {
                PreparedStatement ps = c.prepareStatement("select *from shell",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet res= ps.executeQuery();
                res.last();
                int row=res.getRow();
                res.beforeFirst();
                String[][] str=new String[row][5];
                res.next();
                for (int i=0;i<row;i++){
                    str[i][0]=res.getString("id");
                    str[i][1]=res.getString("date");
                    str[i][2]=res.getString("count");
                    str[i][3]=res.getString("Pname");
                    str[i][4]=res.getString("Oname");
                    res.next();
                }
                String []name={"No.","Time","Amount","Buy/Sale","Product Name"};
                JTable jt=new JTable(str,name);
                jt.setPreferredScrollableViewportSize(new Dimension(350,200));
                JScrollPane jsp=new JScrollPane(jt);
                add(jsp,BorderLayout.CENTER);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
