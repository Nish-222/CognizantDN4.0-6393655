class PaymentContext {
    PaymentStrategy strategy;
    void setStrategy(PaymentStrategy s){
        strategy=s;
    }
    void makePayment(double amt){
        strategy.pay(amt);
    }
}
