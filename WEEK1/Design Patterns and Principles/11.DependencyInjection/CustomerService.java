class CustomerService {
    CustomerRepository r;
    CustomerService(CustomerRepository r){
        this.r=r;
    }
    void getCustomer(String id) {
        System.out.println(r.findCustomerById(id));
    }
}
