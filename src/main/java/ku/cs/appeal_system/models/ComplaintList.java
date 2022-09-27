package ku.cs.appeal_system.models;

import java.util.ArrayList;

public class ComplaintList {

    private ArrayList<Complaint> complaints;

    public ComplaintList() {
        complaints = new ArrayList<>();
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public ArrayList<Complaint> getAllComplaints() {
        return complaints;
    }

    public Complaint searchTopic(String topic){
        for(Complaint complaint:this.complaints){
            if(complaint.isTopic(topic)){
                return complaint;
            }
        }return null;
    }

    public String toCsv() {
        String result = "";
        for (Complaint complaint : this.complaints){
            result += complaint.toCsv() + "\n";
        }
        return result;
    }
}
