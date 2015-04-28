package rf.vdolgu.model;

import java.util.Date;

/**
 * Created by mil on 03.04.15.
 */
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String patranomic;
    private Date dateCreate;
    private Integer idVk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatranomic() {
        return patranomic;
    }

    public void setPatranomic(String patranomic) {
        this.patranomic = patranomic;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getIdVk() {
        return idVk;
    }

    public void setIdVk(Integer idVk) {
        this.idVk = idVk;
    }

    public User() {
    }

    public User(String firstName, String lastName, String patranomic, Date dateCreate, Integer idVk) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patranomic = patranomic;
        this.dateCreate = dateCreate;
        this.idVk = idVk;
    }

    public User(Integer id, String firstName, String lastName, String patranomic, Date dateCreate, Integer idVk) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patranomic = patranomic;
        this.dateCreate = dateCreate;
        this.idVk = idVk;
    }
}
