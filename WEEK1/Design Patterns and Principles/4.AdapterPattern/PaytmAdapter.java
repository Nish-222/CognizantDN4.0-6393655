class PaytmAdapter implements PaymentProcessor{
    Paytm p=new Paytm();
    public void process(double amount){
        p.transfer(amount);
    }
}
