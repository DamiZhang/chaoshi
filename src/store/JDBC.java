package store;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBC {
    public  String[][]str1;
    public  String[]str2;
    public Map<String,String> jin=new HashMap<>();
    public Map<String,String> shou=new HashMap<>();
    public  JDBC(){ //Connect the product information from sql to front end
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaoshi?serverTimezone=GMT%2b8",
                            "root", "root")) {
                PreparedStatement ps = c.prepareStatement("select *from store",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet res= ps.executeQuery();//The result you got
                res.last();
                int row=res.getRow();
                res.beforeFirst();
                str1=new String[row][5];
                str2=new String[row];
                res.next();
                for (int i=0;i<row;i++){
                    str1[i][0]=res.getString("id");
                    str1[i][1]=res.getString("commodityname");
                    str2[i]=str1[i][1];
                    str1[i][2]=res.getString("Unit_Price");
                    jin.put(str1[i][1],str1[i][2]);
                    str1[i][3]=res.getString("price");
                    shou.put(str1[i][1],str1[i][3]);
                    str1[i][4]=res.getString("Discount");
                    res.next();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}