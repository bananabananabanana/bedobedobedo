package rf.dao;

import rf.vdolgu.model.Token;

import java.util.List;

/**
 * Created by mil on 27.04.15.
 */
public interface TokenDAO {
    public List<Token> getAllTokens();
    public void insertToken(Token token);
    public void deleteToken();
}
