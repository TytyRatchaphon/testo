package ku.cs.shop.models;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void newPassword(String pass){
        this.password = pass;
    }
}
