package application.data;
import java.sql.*;

public class ConnectionJDBC {
   public String url = "jdbc:mysql://localhost:3306/coursejdbc";
   public String user = "root";
   public String password = "123456";

    public ConnectionJDBC() {
    }


        public Connection getConnection () throws SQLException, ClassNotFoundException {

              // load driver JDBC
              Class.forName("com.mysql.cj.jdbc.Driver");
              // Obtain connection
              return DriverManager.getConnection(url, user, password);
        }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
