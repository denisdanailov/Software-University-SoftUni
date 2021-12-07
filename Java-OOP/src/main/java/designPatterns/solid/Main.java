package designPatterns.solid;

public class Main {
    public static void main(String[] args) {

        DbInstance dbInstance1 = DbInstance.getInstance();
        DbInstance dbInstance2 = DbInstance.getInstance();

        boolean isTheSameObject = dbInstance1.equals(dbInstance2);

        System.out.println(dbInstance1);
        System.out.println(dbInstance2);
        System.out.println(isTheSameObject);
    }
}
