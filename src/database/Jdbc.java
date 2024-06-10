package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

  public static Connection getJdbc() {
    final String url = "jdbc:mysql://localhost:3306/quanlybanhang";
    final String user = "root";
    final String password = "";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    Connection connection = getJdbc();
    if (connection != null) {
      System.out.println("ket noi thanh cong");
    } else {
      System.out.println("ket noi that bai");
    }
  }
}

