package example.rfq;

import java.math.BigDecimal;

/**
 * Copyright 2017 (C) Java RFQ
 *
 * Created on : 06/02/17
 * Author     : vicky
 */
class Order
{
    public Order(String direction, String currency, int amount, BigDecimal price) {
        this.direction = direction;
        this.currency = currency;
        this.amount = amount;
        this.price = price;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private String direction;

    private String currency;

    private int amount;

    private BigDecimal price;

    @Override
    public String toString() {
        return "Order{" +
                "direction='" + direction + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (amount != order.amount) return false;
        if (!direction.equals(order.direction)) return false;
        return currency.equals(order.currency) && price.equals(order.price);
    }

    @Override
    public int hashCode() {
        int result = direction.hashCode();
        result = 31 * result + currency.hashCode();
        result = 31 * result + amount;
        result = 31 * result + price.hashCode();
        return result;
    }
}
