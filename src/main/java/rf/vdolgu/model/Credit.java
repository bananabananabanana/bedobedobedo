package rf.vdolgu.model;

/**
 * Created by mil on 13.04.15.
 */
public class Credit {

    private Integer id;
    private String creditor;
    private String promiser;
    private Integer credit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getPromiser() {
        return promiser;
    }

    public void setPromiser(String promiser) {
        this.promiser = promiser;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Credit() {

    }

}
