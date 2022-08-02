package ku.cs.shop.models;

public class Officer {
    private Account user;
    private String name;
    private String agency;

    public Officer(Account user, String name, String agency) {
        this.user = user;
        this.name = name;
        this.agency = agency;
    }
}
