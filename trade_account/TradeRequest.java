package trade_account;

import java.math.BigDecimal;

public class TradeRequest {
    private int amount; //Количество товара
    private BigDecimal total; //Полная стоимость
    public TradeRequest(int amount, int total) {
        this.amount = amount;
        this.total = new BigDecimal(total);
    }

    public String toString() {
        try {
            if (registerTrade()) return "Trade registered with total price = " + total + " for amount = " + amount;
        } catch (InvalidTotalException | InvalidAmountException | InvalidTotalScaleException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "Unknown error";
        }
        return "Trade registered with total price = " + total + " for amount = " + amount;
    }
    private boolean registerTrade() throws InvalidTotalException, InvalidAmountException, InvalidTotalScaleException{
        if (amount <= 0) throw new InvalidAmountException("Amount should be greater than 0");
        if (total.compareTo(new BigDecimal(0)) <= 0) throw new InvalidTotalException("Total should be greater than 0");
        if (total.scale() > 2) {
            String message = "Total has scale = " + total.scale() + " instead of scale = " + InvalidTotalScaleException.validScale;
            throw new InvalidTotalScaleException(message, total.scale());
        }
        return true;
    }
}
