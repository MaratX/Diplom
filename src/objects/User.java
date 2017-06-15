package objects;

/**
 * Created by Gustovs on 25.03.2017.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private int addressUser;
    private String name;
    private String lastName;
    private String phone;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(int addressUser) {
        this.addressUser = addressUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
