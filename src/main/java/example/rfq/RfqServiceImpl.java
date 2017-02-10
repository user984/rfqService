package example.rfq;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 07/02/17
 * Author     : vicky
 */
public class RfqServiceImpl implements RfqService
{
    private LiveOrderBoard lob =  new LiveOrderBoardImpl();

    public void setLob(LiveOrderBoard lob) {
        this.lob = lob;
    }

    private static Logger logger = Logger.getLogger(RfqServiceImpl.class);

    @Override
    public Optional<Quote> quoteFor(String currency, int amount) {
        Optional<Quote> quote = Optional.empty();
        List<Order> orders = lob.ordersFor(currency);
        Optional<Order> orderSell = offerOrder(orders, amount);
        Optional<Order> orderBuy = bidOrder(orders, amount);

        if (orderBuy.isPresent() && orderSell.isPresent()) {
            logger.info("Buy price is " + orderBuy.get().getPrice());
            logger.info("Sell price is " + orderSell.get().getPrice());
            BigDecimal buyAfterMargin = orderBuy.get().getPrice().subtract(MarginConstants.BID_MARGIN);
            BigDecimal sellAfterMargin = orderSell.get().getPrice().add(MarginConstants.OFFER_MARGIN);
            logger.info("Creating quote: Buy: " + buyAfterMargin.doubleValue() + ", Sell: " + sellAfterMargin.doubleValue());
            quote = Optional.of(new Quote(buyAfterMargin.doubleValue(), sellAfterMargin.doubleValue()));
        }
        return quote;
    }

    private Optional<Order> bidOrder(List<Order> orderList, int qty) {
        return orderList.stream().filter(
                (t) -> (t.getAmount() == qty) && t.getDirection().equals("Buy")).max((Comparator.comparing(Order::getPrice)));
    }

    private Optional<Order> offerOrder(List<Order> orderList, int qty) {
        return orderList.stream().filter(
                (t) -> (t.getAmount() == qty) && t.getDirection().equals("Sell")).min((Comparator.comparing(Order::getPrice)));
    }
}
