public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer m = new MobileApp();
        Observer w = new WebApp();
        market.register(m);
        market.register(w);
        market.setPrice(1000);
        market.setPrice(1100);
        market.remove(m);
        market.setPrice(1200);
    }
}
