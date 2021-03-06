package core.models;

import java.io.Serializable;

public class StoreOwner extends User implements Serializable {

    /**
     * Default constructor
     *
     * @param email
     * @param phone
     * @param password
     * @param nickname
     * @param balance
     * @param validationCode
     */
    private String siret;
    private String companyName;
    private String address;

    public StoreOwner(String id, String email, String phone, String siret, String password, String nickname, Float balance, String companyName, String address) {
        super(id, email, phone, password, nickname, balance);
        this.siret = siret;
        this.companyName = companyName;
        this.address = address;
    }

    public StoreOwner() {
        super();
    }

    public String getSiret() {
        return this.siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "User{" +
                "id='" + this.getId() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", nickname='" + this.getNickname() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", balance=" + this.getBalance() +
                ", companyName='" + this.getCompanyName() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                '}';
    }
}
