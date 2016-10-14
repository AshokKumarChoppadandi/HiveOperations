package com.ashok.hive;

import java.sql.*;

/**
 * Created by cloudwick on 10/13/16.
 */

public class Operations {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException {
        try{
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Connection conn = DriverManager.getConnection("jdbc:hive://localhost:10000/default",
                "hive", "hive");
        Statement st = conn.createStatement();

        String tableName = "test";
        ResultSet rs = st.executeQuery("select * from " + tableName);

        while(rs.next()){
            System.out.println("Name :: " + rs.getString(1));
            System.out.println("Age :: " + Integer.parseInt(rs.getString(2)));
            System.out.println("Department :: " + rs.getString(3));
            System.out.println("*************************************************************");
        }

        rs.close();
        st.close();
        conn.close();
    }

}
