package rf.vdolgu.dao;

import org.springframework.stereotype.Repository;
import rf.vdolgu.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public Integer insertUser(User user) {
        entityManager.persist(user);
        return user.getId();
    }
}
