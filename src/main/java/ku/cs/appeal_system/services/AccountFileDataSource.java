package ku.cs.appeal_system.services;

import ku.cs.appeal_system.models.AccountList;
import ku.cs.appeal_system.models.Account;
import ku.cs.appeal_system.models.AdminAccount;

import java.io.*;

public class AccountFileDataSource implements DataSource<AccountList>{
    private String directoryName;
    private String filename;

    private AccountList accountList = new AccountList();

    public AccountFileDataSource(){
        this("Data","Accounts.csv");
    }

    public AccountFileDataSource(String directoryName, String filename){
        this.directoryName = directoryName;
        this.filename = filename;
        checkFileIsExisted();

    }



    private void checkFileIsExisted() {
        File file = new File(directoryName);

        if(!file.exists()){ //ถ้า directory ไม่มีอยู่ให้สร้าง
            file.mkdirs();
        }

        String path = directoryName+File.separator+filename;

        file = new File(path);

        //ถ้าไม่มี file ให้สร้าง file
        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) { e.printStackTrace(); }
        }
    }

    @Override
    public void writeData(AccountList accountList) {

        String path = directoryName + File.separator + filename;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(accountList.toCsv());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public AccountList readData() {
        String path = "Data"+File.separator+"Accounts.csv";
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";

            while( (line = buffer.readLine()) != null){

                String[] data = line.split(",");
                String type = data[0].trim();
                if(type.equals("User")){
                    accountList.addAccount(new Account(
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            data[4].trim(),
                            data[5].trim(),
                            Integer.parseInt(data[6].trim())
                    ));
                }

                if(type.equals("Admin")){
                    accountList.addAccount(new Account(
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            Integer.parseInt(data[4].trim())
                    ));
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public AccountList getAllAccountList(){
        return accountList;
    }
}
