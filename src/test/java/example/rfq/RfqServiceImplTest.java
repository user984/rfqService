package example.rfq;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */

@RunWith(MockitoJUnitRunner.class)
public class RfqServiceImplTest
{
    @InjectMocks
    private RfqServiceImpl rfqService;

    @Mock
    private LiveOrderBoardImpl lob;

    @Before
    public void setup() {
        //  create mock
        Order mockOrder1 = Mockito.mock(Order.class);
        Order mockOrder2 = Mockito.mock(Order.class);
        Order mockOrder3 = Mockito.mock(Order.class);
        Order mockOrder4 = Mockito.mock(Order.class);
        // define return value for method getUniqueId()
        when(mockOrder1.getDirection()).thenReturn("Buy");
        when(mockOrder1.getCurrency()).thenReturn("USD");
        when(mockOrder1.getAmount()).thenReturn(200);
        when(mockOrder1.getPrice()).thenReturn(BigDecimal.valueOf(350.50d));

        when(mockOrder2.getDirection()).thenReturn("Buy");
        when(mockOrder2.getCurrency()).thenReturn("USD");
        when(mockOrder2.getAmount()).thenReturn(200);
        when(mockOrder2.getPrice()).thenReturn(BigDecimal.valueOf(350.60d));

        when(mockOrder3.getDirection()).thenReturn("Sell");
        when(mockOrder3.getCurrency()).thenReturn("USD");
        when(mockOrder3.getAmount()).thenReturn(200);
        when(mockOrder3.getPrice()).thenReturn(BigDecimal.valueOf(351.60d));

        when(mockOrder4.getDirection()).thenReturn("Sell");
        when(mockOrder4.getCurrency()).thenReturn("USD");
        when(mockOrder4.getAmount()).thenReturn(800);
        when(mockOrder4.getPrice()).thenReturn(BigDecimal.valueOf(355.90d));

        List<Order> orderList = Arrays.asList(mockOrder1, mockOrder2, mockOrder3);
        when(lob.ordersFor("USD")).thenReturn(orderList);

    }

    @Test
    public void quoteFor() throws Exception {
        rfqService = new RfqServiceImpl();
        rfqService.setLob(lob);
        Optional<Quote> quote = rfqService.quoteFor("USD", 800);
        assertEquals(false, quote.isPresent());

        Optional<Quote> quote2 = rfqService.quoteFor("USD", 200);
        assertEquals(true, quote2.isPresent());
        assertEquals(BigDecimal.valueOf(350.58d), BigDecimal.valueOf(quote2.get().getBid()));
    }

}