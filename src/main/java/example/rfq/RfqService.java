package example.rfq;

import java.util.Optional;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 07/02/17
 * Author     : vicky
 */
public interface RfqService
{
    Optional<Quote> quoteFor(String currency, int amount);
}
