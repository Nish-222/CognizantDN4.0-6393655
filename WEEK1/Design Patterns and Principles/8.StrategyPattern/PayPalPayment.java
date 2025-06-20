class PayPalPayment implements PaymentStrategy {
    public void pay(double amt){
        System.out.println("Paid ₹"+amt+" with PayPal");
    }
}
