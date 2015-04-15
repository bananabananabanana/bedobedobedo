package rf.vdolgu.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import rf.vdolgu.model.User;
import rf.vdolgu.model.Credit;

/**
 * Created by mil on 13.04.2015.
 */
public class Connect {

    private static final String URL = "jdbc:mysql://192.168.50.17:3306/banana";
    private static final String LOGIN = "banana";
    private static final String PASSWORD = "y3l0l3k0r";

    public List<User> getAllUsers() {
        Connection connection = null;
        List <User> users = new ArrayList<User>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.
                    executeQuery("select * from users;");

            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
                System.out.println(user.getId() + " _ " + user.getName());
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {}
        }

        return users;
    }

    public void insertUser(User user) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            statement.
                    /*executeUpdate("INSERT INTO users (name) VALUE ('" + user.getName() + "');");*/
                            executeUpdate("INSERT INTO users (name, access_token, user_id) VALUE ('"
                            + user.getName() + "', '" + "123" + "', " + 123 + ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {}
        }

    }

}
