package example.rfq;

import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
public class RfqMain
{
    private static Logger logger = Logger.getLogger(RfqMain.class);

    public static void main(String[] args) {
        logger.info("Starting RFQ quoting service");
        if (args.length != 2) {
            logger.fatal("Usage: java RfqMain <currency> <amount>");
            System.exit(1);
        }
        if (!CurrencyAmountValidator.validate(args[0]) ||
                !CurrencyAmountValidator.validatePositiveInt(args[1])) {
            logger.fatal("Check arguments: Currency not valid or Not a positive amount");
        }
        int amount = Integer.parseInt(args[1]);
        RfqService rfqService = new RfqServiceImpl();
        Optional<Quote> q = rfqService.quoteFor(args[0], amount);
        if (q.isPresent()) {
            logger.info("Bid(we buy) = " + q.get().getBid() + ".");
            logger.info("Ask(we sell) = " + q.get().getAsk() + ".");
        } else {
            logger.info(" *** No quote available ***");
        }
        logger.info("Finishing...");
    }

}

