package core.models;

/**
 *
 */
public abstract class User {

    protected User(){}

    protected User(String id, String email, String phone, String password, String nickname, Float balance) {
        this.id=id;
        this.email=email;
        this.phone=phone;
        this.password=password;
        this.nickname=nickname;
        this.balance=balance;
    }


    protected String id;
    protected String email;
    protected String phone;
    protected String nickname;
    protected String password;
    protected Float balance;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getId(){ return this.id;}

    public String getEmail(){ return this.email;}

    public String getPhone(){ return this.phone;}

    public String getNickname(){return this.nickname;}

    public String getPassword(){return this.password;}

    public Float getBalance(){return this.balance;}

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}