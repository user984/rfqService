package example.rfq;

import java.util.stream.Stream;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
public enum Currency
{
    USD,
    EUR,
    CHF,
    GBP;

    public static final String[] strangeCurrencies = Stream.of(Currency.values()).map(Currency::name).toArray(String[]::new);
}
