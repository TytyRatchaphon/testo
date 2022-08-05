package ku.cs.shop.models;


public class Student {
    private String name;
    private Account account;

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public Student(String name, String user, String pass) {
        this.name = name;
        this.account = new Account(user,pass);
    }
}
