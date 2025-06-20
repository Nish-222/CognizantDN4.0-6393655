class Product {
    String id,name,prod;
    Product(String id,String name,String prod) {
        this.id=id;
        this.name=name;
        this.prod=prod;
    }
    public String toString() {
        return id+" "+name+" "+prod;
    }
}
public class Searchh{
    static Product linearSearch(Product[] arr,String key) {
        for(Product p:arr)
            if(p.name.equals(key))
                return p;
        return null;
    }
    static Product binarySearch(Product[] arr,String key) {
        int l=0,r=arr.length-1;
        while(l<=r) {
            int m=(l+r)/2;
            int cmp=arr[m].name.compareTo(key);
            if(cmp==0) return arr[m];
            if(cmp<0) l=m+1;
            else r=m-1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products={
            new Product("P1","Bag","Travel"),
            new Product("P2","Shoes","Footwear"),
            new Product("P3","Watch","Accessories"),
            new Product("P4","Laptop","Electronics")
        };
        Product res1=linearSearch(products,"Watch");
        System.out.println("Linear: "+(res1!=null? res1:"Not found"));

        for(int i=0;i<products.length-1;i++) {
            for(int j=0;j<products.length-i-1;j++) {
                if(products[j].name.compareTo(products[j+1].name)>0) {
                    Product temp=products[j];
                    products[j]=products[j+1];
                    products[j+1]=temp;
                }
            }
        }

        Product res2=binarySearch(products,"Watch");
        System.out.println("Binary: "+(res2!=null? res2:"Not found"));
    }
}
