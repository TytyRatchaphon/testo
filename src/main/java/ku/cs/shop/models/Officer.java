package ku.cs.shop.models;

public class Officer {
    private Account account;
    private String name;
    private String agency;

    public Officer(Account user, String name, String agency) {
        this.account = user;
        this.name = name;
        this.agency = agency;
    }
}
