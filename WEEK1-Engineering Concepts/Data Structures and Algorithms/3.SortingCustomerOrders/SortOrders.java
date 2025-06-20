class Order {
    String id,name;
    double price;
    Order(String id,String name,double price) {
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public String toString() {
        return id+" "+name+" ₹"+price;
    }
}
public class SortOrders {
    static void bubbleSort(Order[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {
                if(arr[j].price>arr[j+1].price) {
                    Order temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    static void quickSort(Order[] arr,int low,int high) {
        if(low<high) {
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    static int partition(Order[] arr,int low,int high) {
        double pivot=arr[high].price;
        int i=low-1;
        for(int j=low;j<high;j++) {
            if(arr[j].price<pivot) {
                i++;
                Order temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        Order temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
    public static void main(String[] args) {
        Order[] orders={
            new Order("O1","Alice",450.0),
            new Order("O2","Bob",1200.0),
            new Order("O3","Charlie",750.0),
            new Order("O4","David",300.0)
        };

        System.out.println("Before Sort:");
        for(Order o:orders)
        	System.out.println(o);

        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        for(Order o:orders)
        	System.out.println(o);

        quickSort(orders,0,orders.length-1);
        System.out.println("\nAfter Quick Sort:");
        for(Order o:orders)
        	System.out.println(o);
    }
}
