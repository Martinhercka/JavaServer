package sk.akademiasovy.world.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL
{
   private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/world_x";
    private String userName ="user3";
            String password="secret";
    public List<String> getCountries() throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();
        }catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
            conn = DriverManager.getConnection(url,userName,password);
            String query =" SELECT Name FROM country";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString("name");
                list.add(name);

            }
        }






        return list;


    }

}
