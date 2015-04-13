package rf.vdolgu.dao;

import rf.vdolgu.model.User;

/**
 * Created by mil on 13.04.2015.
 */
public interface UserDAO {
    public void insert(User user);
    public User findByCustomerId(int custId);
}
