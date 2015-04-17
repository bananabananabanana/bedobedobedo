package rf.vdolgu.model;

import javax.persistence.*;

import java.util.Date;


/**
 * Created by mil on 17.04.15.
 */

@Entity
@Table(name = "token")
public class Token {

    public Token() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    //@Column(name = "LOGIN_DATE")
    private Date loginDate;

    //@Column(name = "TOKEN")
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
