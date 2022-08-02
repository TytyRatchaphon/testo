package ku.cs.shop.models;


public class Student {
    private String name;
    private Account user;

    public Student(String name,String user,String pass) {
        this.name = name;
        this.user = new Account(user,pass);
    }
}
