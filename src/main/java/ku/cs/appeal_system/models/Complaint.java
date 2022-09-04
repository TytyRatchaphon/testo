package ku.cs.appeal_system.models;

public class Complaint {

    private String topic;

    private String detail;

    public Complaint(String topic, String detail) {
        this.topic = topic;
        this.detail = detail;
    }

    public String getTopic() {
        return topic;
    }

    public String getDetail() {
        return detail;
    }

    public String toCsv() {
        return topic+","+detail;
    }
}
