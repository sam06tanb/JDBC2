package application;
import application.data.ConnectionJDBC;
import db.DB;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = connectionJDBC.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO seller"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Samir Tajra");
            st.setString(2, "samirtajra53@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("27/08/2006").getTime()));
            st.setDouble(4, 5.0000);
            st.setInt(5, 4);

        int rowsAffected = st.executeUpdate();

        if (rowsAffected > 0) {
           ResultSet rs = st.getGeneratedKeys();
           while (rs.next()) {
               int id = rs.getInt(1);
               System.out.println("Done! id = " + id);
           }
        } else {
            System.out.println("No rows affected!");
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}