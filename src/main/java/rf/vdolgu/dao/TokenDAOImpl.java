package rf.vdolgu.dao;

import org.springframework.stereotype.Repository;
import rf.vdolgu.model.Token;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */
@Repository
public class TokenDaoImpl implements TokenDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Token> getAllTokens() {
        return entityManager.createQuery("select t from Token t").getResultList();
    }

    @Override
    public void insertToken(Token token) {
        entityManager.persist(token);
    }

    @Override
    public void deleteToken() {
        System.out.println("Пустой метод deleteToken");

    }
}
