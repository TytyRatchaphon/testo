package ku.cs.appeal_system.services;
import ku.cs.appeal_system.models.AccountList;
public interface DataSource <T>{
    void writeData(T t);

    T readData();
}
