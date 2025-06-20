class PhonePeAdapter implements PaymentProcessor{
    PhonePe p=new PhonePe();
    public void process(double amount){
        p.send(amount);
    }
}
