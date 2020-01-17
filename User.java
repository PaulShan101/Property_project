package Home;

/**
 * Basic information entered at registration about a registered user.
 * In reality you would store more information about the user
 */
public class User {
    private String username;
    private String password;
    private char userType; // A - Admin, C - Customer

    public User(String username, String password, char userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userType = 'C';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getUserType() {
        return userType;
    }

    public void setUserType(char userType) {
        this.userType = userType;
    }
}
