package rf.vdolgu.model;

import java.util.Date;

/**
 * Created by mil on 27.04.15.
 */
public class Token {
    private Integer id;
    private Integer idUser;
    private String token;
    private Date dateCreate;
    private String userAgent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Token() {
    }

    public Token(Integer idUser, String token, Date dateCreate, String userAgent) {
        this.idUser = idUser;
        this.token = token;
        this.dateCreate = dateCreate;
        this.userAgent = userAgent;
    }

    public Token(Integer id, Integer idUser, String token, Date dateCreate, String userAgent) {
        this.id = id;
        this.idUser = idUser;
        this.token = token;
        this.dateCreate = dateCreate;
        this.userAgent = userAgent;
    }

}