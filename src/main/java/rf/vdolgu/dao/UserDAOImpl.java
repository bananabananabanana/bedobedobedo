package rf.vdolgu.dao;

import rf.vdolgu.model.User;

import java.util.List;

/**
 * Created by mil on 13.04.2015.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUsers() {

        Connect connect = new Connect();

        List<User> users = connect.getAllUsers();

        return users;
    }

    @Override
    public void insertUser(User user) {

        Connect connect = new Connect();

        connect.insertUser(user);

    }

}
