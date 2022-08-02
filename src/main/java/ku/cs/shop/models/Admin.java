package ku.cs.shop.models;

public class Admin {
    private Account user;

    public Admin() {
        this.user = new Account("admin","onlyadmin");
    }
}
