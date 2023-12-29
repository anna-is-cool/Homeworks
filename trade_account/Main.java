package trade_account;

public class Main {
    public static void main(String[] args) {
        TradeRequest trade1 = new TradeRequest(0, 1);
        TradeRequest trade2 = new TradeRequest(1, 0);
        TradeRequest trade3 = new TradeRequest(-2, 2);
        TradeRequest trade4 = new TradeRequest(-3, -3);
        TradeRequest trade5 = new TradeRequest(100, 100);
        System.out.println(trade1);
        System.out.println(trade2);
        System.out.println(trade3);
        System.out.println(trade4);
        System.out.println(trade5);
    }

}