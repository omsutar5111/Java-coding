package Java_Design_Patterns.Singletone.ConnectionPoolManagement;

import javax.xml.crypto.Data;

public class DatabaseConnection {

    int maxConnections;
    boolean isAvailable;
    public DatabaseConnection(int maxConnections,boolean isAvailable){
        this.maxConnections=maxConnections;
        this.isAvailable=isAvailable;
    }
}
