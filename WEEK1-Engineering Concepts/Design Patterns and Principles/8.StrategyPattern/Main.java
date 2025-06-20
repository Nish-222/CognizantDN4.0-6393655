public class Main {
    public static void main(String[] args) {
        PaymentContext p= new PaymentContext();
        p.setStrategy(new CreditCardPayment());
        p.makePayment(50000);
        p.setStrategy(new PayPalPayment());
        p.makePayment(3000000);
    }
}
