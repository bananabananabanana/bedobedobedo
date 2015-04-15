package rf.vdolgu.model;

/**
 * Created by mil on 03.04.15.
 */
public class User {
    private Integer id;
    private String name;
    private String access_token;
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String access_token, Integer user_id) {
        this.name = name;
        this.access_token = access_token;
        this.user_id = user_id;
    }

    public User(Integer id, String name, String access_token, Integer user_id) {
        this.id = id;
        this.name = name;
        this.access_token = access_token;
        this.user_id = user_id;
    }

}
