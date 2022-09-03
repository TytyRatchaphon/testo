package ku.cs.appeal_system.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private String username;
    private String password;

    private String accountStatus = "Not_Banned";

    private Integer loginCount;

    private String name;

    private String lastname;

    private String type;

    //NewUser
    public Account(String name, String lastname, String username, String password) {
        setType("User");
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.loginCount = 0;

    }
    //for csv
    public Account(String name,String lastname,String username,String password, String status,Integer countLogin){
        this(name, lastname, username, password);
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
    public String toString(){
        return  type+","+username+","+accountStatus+","+loginCount;
    }
    public String toCsv(){
        return type+","+name+","+lastname+","+username+","+password+","+accountStatus+","+loginCount;
    }
}
