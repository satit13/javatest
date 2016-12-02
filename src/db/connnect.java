package db;

/**
 * Created by satit on 01/12/2016.
 */

import java.sql.*;


public class connnect {

    public static void main(String[] args) {
        Connection connect = null ;
        Statement s = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(""+"jdbc:sqlserver://s02db.nopadol.com;databaseName=bcnp;user=sa;password=[ibdkifu");
            if(connect != null){
                    System.out.println("Database Connected.");
                s = connect.createStatement();
                String sql = "select top 10 code,name1 from bcar order by roworder desc";
                ResultSet rec = s.executeQuery(sql);
                System.out.println("code      name1");
                System.out.println("----------------------------");

                while ((rec != null) && (rec.next()))
                {

                    System.out.print(rec.getString("code")+" : ");
                    System.out.print(rec.getString("name1"));
                    System.out.println("");
                }



            }else {
                    System.out.println("Database Connect Failed.");
            }
        } catch (Exception e) {
            System.out.println("error 1");
            e.printStackTrace();
        }

        try {
            //System.out.println("connected");
            connect.close();
        } catch (SQLException e){
            System.out.println("error 2");
            e.printStackTrace();
        }
    }
}
