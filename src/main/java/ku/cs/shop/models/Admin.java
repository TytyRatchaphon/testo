package ku.cs.shop.models;

public class Admin {
    private Account account;

    public Admin() {
        this.account = new Account("admin","onlyadmin");
    }
}
