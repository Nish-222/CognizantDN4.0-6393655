public class Main {
    public static void main(String[] args) {
        Logger l1=Logger.getInstance();
        Logger l2=Logger.getInstance();
        l1.log("Logger1");
        l2.log("Logger2");
        if (l1==l2) {
            System.out.println("Same instance");
        } else {
            System.out.println("Different instances");
        }
    }
}
