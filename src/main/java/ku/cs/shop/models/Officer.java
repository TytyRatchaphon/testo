package ku.cs.shop.models;

public class Officer {
    private Account account;
    private String name;
    private String agency;

    public Account getAccount() {
        return account;
    }

    public String getAgency() {
        return agency;
    }

    public String getName() {
        return name;
    }

    public Officer(String agency,String name,String user,   String pass) {
        this.name = name;
        this.agency = agency;
        this.account = new Account(user,pass);
    }
}
