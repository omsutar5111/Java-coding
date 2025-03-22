package Java_Design_Patterns.Singletone.ConnectionPoolManagement;

public interface ConnectionPool {
    void initializePool();

    DatabaseConnection getConnection();

    void releaseConnection(DatabaseConnection connection);

    int getAvailableConnectionsCount();

    int getTotalConnectionsCount();
}
