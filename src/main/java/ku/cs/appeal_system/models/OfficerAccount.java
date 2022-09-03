package ku.cs.appeal_system.models;

public class OfficerAccount extends Account {
    private String agency;

    public OfficerAccount(String username,String password,String name,String lastname, String agency) {
        super(username,password, name, lastname);
        setType("Officer");
        this.agency = agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
    }
    @Override
    public String toCsv() {
            return getType()+","+getUsername()+","+getPassword()+","+getStatus()+","+getLoginCount()+","+getAgency();
        }
}
