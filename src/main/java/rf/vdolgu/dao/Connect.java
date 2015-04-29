package rf.vdolgu.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import rf.vdolgu.model.User;
import rf.vdolgu.model.Token;

/**
 * Created by mil on 13.04.2015.
 */
public class Connect {
///characterEncoding=utf-8&useUnicode=true
    private static final String URL = "jdbc:mysql://192.168.50.17:3306/banana?characterEncoding=utf-8&useUnicode=true";
    private static final String LOGIN = "banana";
    private static final String PASSWORD = "y3l0l3k0r";


/*    public Integer getUser() {
        Connection connection = null;
        Integer id = null;

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
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5)
                );
                System.out.println(user.getId() + " _ " + user.getFirstName());
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

    }*/

    /**
     *
     * @return
     */
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
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getDouble(8)
                );
                System.out.println(user.getId() + " _ " + user.getFirstName());
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

    public Integer insertUser(User user) {
        Connection connection = null;

        Integer idUser = null;

        System.out.println("insertUser");

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

            String query = "INSERT INTO users (FIRST_NAME, LAST_NAME, PATRANOMIC, CREATE_DATE, ID_VK, IMAGE, RATING) VALUE (?,?,?,?,?,?,?);";

            PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, user.getFirstName());
            preparedStmt.setString(2, user.getLastName());
            preparedStmt.setString(3, user.getPatranomic());
            preparedStmt.setDate(4, new java.sql.Date(user.getDateCreate().getTime()));
            preparedStmt.setInt(5, user.getIdVk().intValue());
            preparedStmt.setString(6, user.getImage());
            preparedStmt.setDouble(7, user.getRating());
            //preparedStmt.execute();
            preparedStmt.executeUpdate();

            ResultSet rs = preparedStmt.getGeneratedKeys();
            if(rs.next())
            {
                idUser = rs.getInt(1);
            }


            connection.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {}
        }

        return idUser;

    }


    ////////////////////////////////////////////////////TOKEN

    public void insertToken(Token token) {
        Connection connection = null;

        System.out.println("insertToken");

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

            String query = "INSERT INTO tokens (ID_USER, TOKEN, DATE_CREATE, USER_AGENT) VALUE (?,?,?,?);";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, token.getIdUser());
            preparedStmt.setString(2, token.getToken());
            preparedStmt.setDate(3, new java.sql.Date(token.getDateCreate().getTime()));
            preparedStmt.setString(4, token.getUserAgent());
            preparedStmt.execute();

            connection.close();

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
