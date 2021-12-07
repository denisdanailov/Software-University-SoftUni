package designPatterns.solid;

public class DbInstance {
    private static DbInstance instance;

    private DbInstance () {}

    public static DbInstance getInstance() {
        if (instance == null) {
            return instance = new DbInstance();
        }
        return instance;
    }
}
