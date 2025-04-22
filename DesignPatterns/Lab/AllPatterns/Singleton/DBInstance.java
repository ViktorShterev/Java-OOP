package Singleton;

public class DBInstance {

    public static volatile DBInstance instance;

    private DBInstance() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DBInstance getInstance() {
        if (instance == null) {
            synchronized (DBInstance.class) {
                if (instance == null) {
                    instance = new DBInstance();
                }
            }
        }
        return instance;
    }

    public int createTable() {
        System.out.println("Table created");
        return 1;
    }
}
