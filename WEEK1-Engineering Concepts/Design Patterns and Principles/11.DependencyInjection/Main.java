public class Main {
    public static void main(String[] args){
        CustomerRepository r=new CustomerRepositoryImpl();
        CustomerService service=new CustomerService(r);
        service.getCustomer("001");
    }
}
