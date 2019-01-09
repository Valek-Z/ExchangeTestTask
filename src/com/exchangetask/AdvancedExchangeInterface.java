package com.exchangetask;

import org.springframework.security.web.firewall.RequestRejectedException;

public interface AdvancedExchangeInterface extends ExchangeInterface{

    public void modify(long orderId, int newPrice, int newSize) throws RequestRejectedException;

}
