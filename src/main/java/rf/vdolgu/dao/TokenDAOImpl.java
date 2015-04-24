package rf.vdolgu.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rf.vdolgu.model.Token;

import java.util.List;

/**
 * Created by mil on 23.04.15.
 */

@Repository
public class TokenDAOImpl implements TokenDAO {



    @Override
    public void addToken(Token token) {

    }

    @Override
    public List<Token> listToken() {
        return null;
    }

    @Override
    public void removeToken(Integer id) {

    }
}
