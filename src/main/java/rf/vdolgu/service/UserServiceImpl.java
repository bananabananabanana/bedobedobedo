package rf.vdolgu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rf.vdolgu.dao.UserDAO;

import rf.vdolgu.model.User;

import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Override
    public List<User> getAllUsers() {
        System.out.println("получение юзеров всех");
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public Integer insertUser(User user) {
        System.out.println("сохранение юзера");
        userDao.insertUser(user);
        return user.getId();
    }
}
