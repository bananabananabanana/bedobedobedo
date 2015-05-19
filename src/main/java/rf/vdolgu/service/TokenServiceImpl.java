package rf.vdolgu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rf.vdolgu.dao.TokenDAO;
import rf.vdolgu.model.Token;

import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    TokenDAO tokenDao;


    @Override
    public List<Token> getAllTokens() {
        System.out.println("получение токенов всех");
        return tokenDao.getAllTokens();
    }

    @Override
    @Transactional
    public void insertToken(Token token) {
        System.out.println("вставить токен");
        tokenDao.insertToken(token);
    }

    @Override
    public void deleteToken() {
        System.out.println("Пустой метод");
    }
}
