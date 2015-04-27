package rf.vdolgu.dao;

import rf.vdolgu.model.Token;

import java.util.List;

/**
 * Created by mil on 27.04.15.
 */
public class TokenDAOImpl implements TokenDAO {
    @Override
    public List<Token> getAllTokens() {
        Connect connect = new Connect();


        return null;
    }

    @Override
    public void insertToken(Token token) {
        Connect connect = new Connect();
        connect.insertToken(token);

    }

    @Override
    public void deleteToken() {
        Connect connect = new Connect();

    }
}
