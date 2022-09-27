package ku.cs.appeal_system.models;

public class Complaint {

    private String topic;

    private String detail;

    private String status = "not completed";
    private String studentId;

    public Complaint(String topic, String detail, String status,String studentId) {
        this.topic = topic;
        this.detail = detail;
        this.status = status;
        this.studentId = studentId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTopic() {
        return topic;
    }

    public String getDetail() {
        return detail;
    }

    public String getStatus() { return status; }

    public boolean isTopic(String topic) {return this.topic.equals(topic);}

    public void setStatusProgressing(String progressing) {
        this.status = "Progressing";
    }

    public void setStatusComplete() {
        this.status = "Complete";
    }

    @Override
    public String toString() {
        return topic+", "+detail+", "+status;
    }
    public String toCsv() {
        return topic+","+detail+","+status+","+studentId;
    }
}
