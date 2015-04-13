package rf.vdolgu.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import rf.vdolgu.model.User;
import rf.vdolgu.model.Credit;

/**
 * Created by mil on 13.04.2015.
 */
public class Connect {
/*    private static final String URL = "jdbc:mysql://ares.beget.ru:3306/mil_os";
    private static final String LOGIN = "mil_os";
    private static final String PASSWORD = "y3l0l3k0r";*/

    private static final String URL = "jdbc:mysql://localhost:3306/os";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "y3l0l3k0r";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users;");

            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                System.out.println(user.getId() + " _ " + user.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
