package rf.vdolgu.service;

import rf.vdolgu.model.User;

import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */
public interface UserService {


    public List<User> getAllUsers();
    public Integer insertUser(User user);

}
