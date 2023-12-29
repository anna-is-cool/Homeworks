package trade_account: 
реализовать метод registerTrade(TradeRequest req) регистрирующий сделку
class TradeRequest {
    int amount // кол-во товара
    BigDecimal total // полная стоимость
}
если amount <= 0 должен выброситься InvalidAmountException (нужно реализовать самостоятельно)
если total <= 0, должен выброситься InvalidTotalException
если total имеет больше 2 знаков после запятой (атрибут scale в BigDecimal), должен выброситься InvalidTotalScaleException с параметрами currentScale (текущее округление) и validScale (правильное округление=2)
над вызовом метода registerTrade(..) должны быть try catch, которые должны ловить каждую из этих ошибок и печатать “Amount should be greater than 0”, “Total should be greater than 0”, “Total has scale=%currentScale% instead of scale=%validScale%”, и в случае любой другой ошибки печатать “Unknown error”

ну и если ошибок не возникает, то просто напечатать что-то вроде "Trade registered with total price=%totalPrice% for amount=%amount%"
