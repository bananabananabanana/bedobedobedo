package rf.dao;

import rf.vdolgu.model.User;

import java.util.List;

/**
 * Created by mil on 13.04.2015.
 */
public interface UserDAO {
    public List<User> getAllUsers();
    public Integer insertUser(User user);
}
