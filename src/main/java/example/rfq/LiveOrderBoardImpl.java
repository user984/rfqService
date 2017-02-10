package example.rfq;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
public class LiveOrderBoardImpl implements LiveOrderBoard
{
    @Override
    public List<Order> ordersFor(String currency) {

        List<Order> orderList = Lists.newArrayList();
        // Modify as necessary
        orderList.add(new Order("Buy", "USD", 200,
                BigDecimal.valueOf(232.71).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Sell", "USD", 100,
                BigDecimal.valueOf(232.74).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Sell", "USD", 200,
                BigDecimal.valueOf(232.73).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Buy", "USD", 500,
                BigDecimal.valueOf(232.71).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Buy", "USD", 100,
                BigDecimal.valueOf(232.70).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Sell", "USD", 200,
                BigDecimal.valueOf(232.75).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Buy", "USD", 500,
                BigDecimal.valueOf(232.69).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Sell", "USD", 300,
                BigDecimal.valueOf(232.76).setScale(2, RoundingMode.HALF_UP)));
        orderList.add(new Order("Buy", "USD", 200,
                BigDecimal.valueOf(232.70).setScale(2, RoundingMode.HALF_UP)));
        return orderList;
    }
}
