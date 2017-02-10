package example.rfq;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 08/02/17
 * Author     : vicky
 */
public class CurrencyAmountValidatorTest {

    @Test
    public void validate() throws Exception {
        assertTrue(CurrencyAmountValidator.validate("usd"));
        assertTrue(CurrencyAmountValidator.validate("gbp"));
        assertFalse(CurrencyAmountValidator.validate("aud"));
    }

    @Test
    public void validatePositiveInt() throws Exception {
        assertTrue(CurrencyAmountValidator.validatePositiveInt("400"));
        assertTrue(CurrencyAmountValidator.validatePositiveInt("1"));
        assertFalse(CurrencyAmountValidator.validatePositiveInt("0"));
        assertFalse(CurrencyAmountValidator.validatePositiveInt("-12"));
        assertFalse(CurrencyAmountValidator.validatePositiveInt("-12.986"));
    }

}