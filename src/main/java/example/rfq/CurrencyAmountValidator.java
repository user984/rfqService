package example.rfq;

import org.apache.log4j.Logger;

import java.util.Arrays;

import static example.rfq.Currency.*;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
class CurrencyAmountValidator
{
    private static Logger logger = Logger.getLogger(RfqMain.class);

    static boolean validate(final String currency) {
        if (Arrays.asList(strangeCurrencies).contains(currency.toUpperCase())) {
            logger.debug(" Currency " + currency + " is valid.");
            return true;
        } else {
            logger.debug(" Currency " + currency + " is invalid.");
            return false;
        }
    }

    // Assumed positive integer for amount
    static boolean validatePositiveInt(String amount) {
        try {
            int i = Integer.parseInt(amount);
            if (i > 0) {
                logger.debug(" Amount = " + i);
                return true;
            }
            logger.debug(" Amount int but <=0 = " + amount);
            return false;
        } catch (NumberFormatException e) {
            logger.debug(" Amount not int = " + amount);
            return false;
        }
    }
}
