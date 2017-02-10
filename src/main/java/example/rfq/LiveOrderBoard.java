package example.rfq;

import java.util.List;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
public interface LiveOrderBoard
{
    List<Order> ordersFor(String currency);
}
