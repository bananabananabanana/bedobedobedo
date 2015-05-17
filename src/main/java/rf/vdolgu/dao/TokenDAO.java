package rf.vdolgu.dao;

import rf.vdolgu.model.Token;

import java.util.List;

/**
 * Created by Vano on 17.05.2015.
 */
public interface TokenDao {

    public List<Token> getAllTokens();
    public void insertToken(Token token);
    public void deleteToken();
}
