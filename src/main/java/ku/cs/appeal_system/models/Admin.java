package ku.cs.appeal_system.models;

public class Admin {
    private Account account;

    public Admin() {
        this.account = new Account("admin","onlyadmin");
    }
}
