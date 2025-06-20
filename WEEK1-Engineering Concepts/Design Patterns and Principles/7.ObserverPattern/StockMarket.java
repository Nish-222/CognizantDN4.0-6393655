import java.util.*;
class StockMarket implements Stock {
    List<Observer> list=new ArrayList<>();
    double price;
    public void register(Observer o){
        list.add(o);
    }
    public void remove(Observer o){
        list.remove(o);
    }
    public void setPrice(double p){
        price=p;
        notifyObservers();
    }
    public void notifyObservers(){
        for (Observer o:list)
            o.update(price);
    }
}
