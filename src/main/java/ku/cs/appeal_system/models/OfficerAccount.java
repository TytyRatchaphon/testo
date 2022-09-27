package ku.cs.appeal_system.models;

public class OfficerAccount extends Account {
    public OfficerAccount(String name, String lastname, String username, String password, String status, String agency,String lastLogin,Integer loginCount) {
        super(name,lastname, username, password,status,agency,lastLogin,loginCount);
        setType("Officer");
        this.setAgency(agency);
    }

    @Override
    public String toCsv() {
            return getType()+","+getName()+","+getLastname()+","+getUsername()+","+getPassword()+","+getStatus()+","+getAgency()+","+getLastLogin()+","+getLoginCount();
        }
}
