package rf.vdolgu.dao;

import java.util.List;
import rf.vdolgu.model.Token;

/**
 * Created by mil on 23.04.15.
 */
public interface TokenDAO {

    public void addToken(Token token);

    public List<Token> listToken();

    public void removeToken(Integer id);

}
