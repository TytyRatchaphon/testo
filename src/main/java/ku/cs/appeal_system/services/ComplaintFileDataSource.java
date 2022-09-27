package ku.cs.appeal_system.services;

import ku.cs.appeal_system.models.*;

import java.io.*;

public class ComplaintFileDataSource implements DataSource<ComplaintList> {

    private String directoryName;

    private String fileName;

    private ComplaintList complaint = new ComplaintList();

    public ComplaintFileDataSource(){
        this("Data","Complaints.csv");
    }

    public ComplaintFileDataSource(String directoryName, String fileName) {
        this.directoryName = directoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(directoryName);

        if(!file.exists()){ //ถ้า directory ไม่มีอยู่ให้สร้าง
            file.mkdir();
        }

        String path = directoryName+File.separator+fileName;

        file = new File(path);

        if(!file.exists()){
            try {
                file.createNewFile();

            } catch (IOException e) { throw new RuntimeException(e); }
        }
    }

    @Override
    public void writeData(ComplaintList complaintList) {

        String path = directoryName + File.separator + fileName;
        File file = new File(path);

        FileWriter writer = null;
        BufferedWriter buffer = null;
        try {
            writer = new FileWriter(file);
            buffer = new BufferedWriter(writer);

            buffer.write(complaintList.toCsv());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffer.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ComplaintList readData() {

        String path = "Data" + File.separator + "Complaints.csv";
        File file = new File(path);

        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);

            String line = "";

            while ((line = buffer.readLine()) != null) {
                String[] data = line.split(",");
                 complaint.addComplaint(new Complaint(
                         data[0],
                         data[1],
                         data[2],
                         data[3])
                );
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return complaint;
    }

    public ComplaintList getAllComplaintList() { return complaint; }
}
