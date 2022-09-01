package ku.cs.appeal_system.models;

import java.time.LocalDateTime;

public class Account {
    private String username;
    private String password;

    private String accountStatus = "Not_Banned";

    private Integer loginCount;

    private String name;

    private String lastname;

    private String type;

    //NewUser
    public Account(String username, String password, String name, String lastname) {
        setType("User");
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.loginCount = 0;

    }
    //for csv
    public Account(String username,String name,String lastname,String password, String status,Integer countLogin){
        this(username, name, lastname, password);
        this.accountStatus = status;
        this.loginCount = countLogin;

    }
    //extend for Admin
    public Account(String username, String password,String status,int loginCount) {
        this.username = username;
        this.password = password;
        this.accountStatus = status;
        this.loginCount = loginCount;
    }


    public String getUsername() {
        return username;
    }

    public void setPassword(String newPasswordString){
        this.password = newPasswordString;
    }

    public void setType(String type){this.type = type;}

    public void setLoginCount(){this.loginCount++;}
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public  boolean isAdmin(String type){
        return this.type.equals("Admin");
    }
    public boolean isLastname(String lastname) {
        return this.lastname.equals(lastname);
    }
    public boolean isUsername(String username) {return this.username.equals(username);}
    public boolean isDuplicateName(String name) {
        return this.name.equals(name);
    }
    public boolean isBanned() {return this.accountStatus.equals("Banned"); }

    public boolean isPassword(String password){
        return this.password.equals(password);
    }
    public String getType(){return type;}
    public String getName() {return name;}
    public String getLastname() {return lastname;}
    public String getPassword() {return password;}
    public String getStatus() {
        return accountStatus;
    }
    public Integer getLoginCount(){return loginCount;}
    public String toCsv(){
        return type+","+name+","+lastname+","+username+","+password+","+accountStatus+","+loginCount;
    }
}
