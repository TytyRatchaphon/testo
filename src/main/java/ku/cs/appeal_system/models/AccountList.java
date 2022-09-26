package ku.cs.appeal_system.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AccountList {
    private ArrayList<Account> accounts;
    private ArrayList<OfficerAccount> OfficerAccounts;

    public AccountList(){
        accounts = new ArrayList<>();
        OfficerAccounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void addOfficerAccount(OfficerAccount account) {
        OfficerAccounts.add(account);
    }

    public ArrayList<Account> getAllAccounts(){return accounts; }


    public boolean checkUsername(String username){
        for(Account account:this.accounts){
            if(account.isUsername(username)){
                return true;
            }
        }return false;

    }

    public Account searchUsername(String username){
        for(Account account:this.accounts){
            if(account.isUsername(username)){
                return account;
            }
        }return null;
    }
    public boolean checkName(String name){
        for(Account account:this.accounts){
            System.out.println(account.getUsername());

            if(account.getType().equals("Admin")){
                return false;
            }
            if(account.isDuplicateName(name)){
                return true;
            }
        }return false; //วน account แล้วไม่เจอ username
    }
//    public void sortAccount(){
//        Comparator<Account> comparator = (c1, c2) -> {
//            return c2.getLastLogin().compareTo(c1.getLastLogin());
//        };
//        Collections.sort(accounts, comparator);
//    }
    public String toCsv() {
        String result = "";
        for (Account account : this.accounts){
            result += account.toCsv() + "\n";
        }
        return result;
    }

}
