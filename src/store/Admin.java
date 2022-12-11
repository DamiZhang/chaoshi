package store;
//The Default Username and Password all is 111

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin {

    public Map<String,String> map=new HashMap<>();
    public List<operator> list=new ArrayList<>();
    public Admin(){//Use to connect the account info from sql to the frontend
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaoshi?serverTimezone=GMT%2b8",
                            "root", "root")) {
                PreparedStatement ps = c.prepareStatement("select *from operator",ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);

                ResultSet res= ps.executeQuery();//The final result
                res.last();
                int row=res.getRow();
                res.beforeFirst();
                res.next();
                for (int i=0;i<row;i++){
                    int id=Integer.parseInt(res.getString("id"));
                    String name=res.getString("name");
                    String password=res.getString("pwd");
                    String sum=res.getString("sum");
                    map.put(name,password);
                    list.add(new operator(id,name,password,sum));
                    res.next();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
