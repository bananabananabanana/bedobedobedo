package rf.vdolgu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by mil on 03.04.15.
 */
@Entity
@Table (name = "userd")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String patranomic;
    private Date dateCreate;
    private Integer idVk;
    private String image;
    private Double rating;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public User() {
    }

    public User(String firstName, String lastName, String patranomic, Date dateCreate, Integer idVk, String image, Double rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patranomic = patranomic;
        this.dateCreate = dateCreate;
        this.idVk = idVk;
        this.image = image;
        this.rating = rating;
    }

    public User(Integer id, String firstName, String lastName, String patranomic, Date dateCreate, Integer idVk, String image, Double rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patranomic = patranomic;
        this.dateCreate = dateCreate;
        this.idVk = idVk;
        this.image = image;
        this.rating = rating;
    }
}
