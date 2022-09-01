package ku.cs.appeal_system.models;

public class AdminAccount extends Account{
    public AdminAccount(String username, String password , String status,int loginCount) {
        super(username, password,status,loginCount);
        setType("Admin");
        setLoginCount(0);
    }
    @Override
    public String toCsv() {
        return getType()+","+getUsername()+","+getPassword()+","+getStatus()+","+getLoginCount();
    }
}

