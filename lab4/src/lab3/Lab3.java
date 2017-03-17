package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab3 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/RRS", "root", "root");
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("firstName");
                String last_name = rs.getString("lastName");
                System.out.println(id_col + " " + first_name + " " + last_name + " ");
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        Restaurant rest = new Restaurant(11, 22);
        Order or = new Order(rest);
        or.orderSystem();

    }
}
