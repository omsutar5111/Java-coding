package Java_Design_Patterns.Singletone.ConnectionPoolManagement;

import java.util.ArrayList;

public class ConnectionPoolImpl implements  ConnectionPool{
    int maxConnections;
    private static volatile ConnectionPoolImpl Instance;
    private final ArrayList<DatabaseConnection>databaseConnections=new ArrayList<>();
    public ConnectionPoolImpl(int maxSize){
        this.maxConnections=maxSize;
        initializePool();
    }
    @Override
    public void initializePool() {
      for(int i=0;i<maxConnections;i++){
          databaseConnections.add(new DatabaseConnection(i,true));
      }
    }

    @Override
    public DatabaseConnection getConnection() {
        for(DatabaseConnection db:databaseConnections){
            if(db.isAvailable){
                db.isAvailable=false;
                return db;
            }
        }
        return null;
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
         connection.isAvailable=false;
    }

    @Override
    public int getAvailableConnectionsCount() {
        int count=0;
        for (DatabaseConnection db:databaseConnections){
            if(db.isAvailable){
                count++;
            }
        }
        return  count;
    }

    @Override
    public int getTotalConnectionsCount() {

        return  databaseConnections.size();
    }

    public  static ConnectionPoolImpl getInstance(int maxConnections){
                if(Instance==null){
            synchronized (ConnectionPoolImpl.class){
                if(Instance==null){
                    Instance=new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return  Instance;
    }

    public  static void resetConnections(){
        Instance=null;
    }
}
