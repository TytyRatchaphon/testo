package ku.cs.appeal_system.models;

public class AdminAccount extends Account{
    public AdminAccount(String username, String password , String status,String lastLogin,int loginCount) {
        super(username, password,status,lastLogin,loginCount);
        setType("Admin");
        setLoginCount(0);
    }
    @Override
    public String toCsv() {
        return getType()+","+getUsername()+","+getPassword()+","+getStatus()+","+getLastLogin()+","+getLoginCount();
    }
}

