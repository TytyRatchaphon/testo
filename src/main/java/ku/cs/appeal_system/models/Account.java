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
    private String agency;
    private String imagePath;
    private LocalDateTime lastLogin ;

    //NewUser
    public Account(String name, String lastname, String username, String password) {
        setType("User");
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.loginCount = 0;
        this.imagePath = "images/user_default.png";

    }
    //for csv
    public Account(String name,String lastname,String username,String password, String status,String imagePath,String lastLogin,Integer countLogin){
        this(name, lastname, username, password);
        this.accountStatus = status;
        this.imagePath = imagePath;
        this.lastLogin = LocalDateTime.parse(lastLogin);
        this.loginCount = countLogin;


    }
    //extend for Admin
    public Account(String username, String password,String status,String lastLogin,int loginCount) {
        this.username = username;
        this.password = password;
        this.accountStatus = status;
        this.loginCount = loginCount;
        this.lastLogin = LocalDateTime.parse(lastLogin);
    }

    public Account(String name,String lastname,String username,String password, String status,String agency,String imagePath,String lastLogin,Integer loginCount){
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.accountStatus = status;
        this.agency = agency;
        this.loginCount = loginCount;
        this.imagePath = imagePath;
        this.lastLogin = LocalDateTime.parse(lastLogin);
    }




    public String getUsername() {
        return username;
    }

    public void setPassword(String newPasswordString){
        this.password = newPasswordString;
    }

    public void setType(String type){this.type = type;}
    public void setAgency(String agency){this.agency = agency;}
    public String getAgency() {
        return agency;
    }

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
    public String getImagePath() {
        return imagePath;
    }
    public String getLastLogin() { return lastLogin.toString(); }
    public void setImagePath() {
        this.imagePath = "images/user_default.png";
    }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
    public void setStatus() {
        this.accountStatus = "Banned";
    }
    public void setStatus(String unbanned){
        this.accountStatus = "Not Banned";
    }
    public void setLastLogin(){
        this.lastLogin = LocalDateTime.now();
        lastLogin.toString();
    }

    public String toCsv(){
        return type+","+name+","+lastname+","+username+","+password+","+accountStatus+","+imagePath+","+lastLogin+","+loginCount;
    }

    @Override
    public String toString(){
        //ใช้ DateTimeFormatter showListview
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = lastLogin.format(format);
        return  type+","+username+","+accountStatus+","+formatDateTime+","+loginCount;
    }
}

