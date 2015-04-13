package rf.vdolgu.dao;

import rf.vdolgu.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mil on 13.04.2015.
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void insert(User user) {
    }

    @Override
    public User findByCustomerId(int custId) {
        return null;
    }
}
