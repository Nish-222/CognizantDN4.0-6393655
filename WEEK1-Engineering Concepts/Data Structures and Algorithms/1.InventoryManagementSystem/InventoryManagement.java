import java.util.*;

class Product {
    String id, name;
    int qty;
    double price;
    Product(String id,String name,int qty,double price) {
        this.id=id;
        this.name=name;
        this.qty=qty;
        this.price=price;
    }
    public String toString(){
        return id+" "+name+" "+qty+" ₹"+price;
    }
}

class Inventory{
    HashMap<String,Product> map=new HashMap<>();

    void add(Product p){                           //O(1)
        map.put(p.id,p);
    }
    void update(String id,int qty,double price) {  //O(1)
        if(map.containsKey(id)) {
            Product p=map.get(id);
            p.qty=qty;
            p.price=price;
        }
    }

    void delete(String id) {                       //O(1)
        map.remove(id);
    }

    void show(){                                   //O(1)
        for(Product p:map.values())
            System.out.println(p);
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inv=new Inventory();
        inv.add(new Product("P1","Mouse",50,299.0));
        inv.add(new Product("P2","Keyboard",30,699.0));
        inv.add(new Product("P3","Monitor",10,1999.0));
        inv.update("P1",60,279.0);
        inv.delete("P2");
        inv.show();
    }
}
