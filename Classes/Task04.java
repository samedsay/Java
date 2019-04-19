class Config {
    private final static Config config = new Config();

    private Config() {
        //...
    }

    public static Config getInstance() {
        return config;
    }
}

class Connect {
    private static Connect connection = null;

    private Connect() {
    }

    public static Connect getInstance() {
        if (connection == null) {
            connection = new Connect();
        }
        return connection;
    }
}

public class Task04 {
    public static void main(String[] args) {
        Connect con1 = Connect.getInstance();
        Connect con2 = Connect.getInstance();
        if (con1 == con2)
            System.out.println("con1 == con2");
        Config cnf1 = Config.getInstance();
        Config cnf2 = Config.getInstance();
        if (cnf1 == cnf2)
            System.out.println("cnf1 == cnf2");
    }
}
