package example.rfq;

import java.math.BigDecimal;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
class MarginConstants
{
    private MarginConstants() { }  // Prevents instantiation
    static final BigDecimal BID_MARGIN   = BigDecimal.valueOf(0.02d);
    static final BigDecimal OFFER_MARGIN = BigDecimal.valueOf(0.02d);
}
