package rf.vdolgu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by mil on 20.04.15.
 */

@Entity
@Table(name = "CONTACTS")
public class Contact {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "ID_VK")
    private String idvk;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "Rate")
    private Integer rate;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdvk() {
        return idvk;
    }

    public void setIdvk(String idvk) {
        this.idvk = idvk;
    }

    public Date getDate() {
        return createdate;
    }

    public void setDate(Date date) {
        this.createdate = date;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
