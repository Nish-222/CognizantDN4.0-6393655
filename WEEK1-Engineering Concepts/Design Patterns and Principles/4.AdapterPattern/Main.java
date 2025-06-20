public class Main {
    public static void main(String[] args) {
        PaymentProcessor p1 = new PhonePeAdapter();
        PaymentProcessor p2 = new PaytmAdapter();
        p1.process(300);
        p2.process(450);
    }
}
