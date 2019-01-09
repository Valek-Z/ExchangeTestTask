package com.exchangetask;
import org.springframework.security.web.firewall.RequestRejectedException;

public interface ExchangeInterface {
    public void send(long orderId, boolean isBuy, int price, int size);

    public void cancel(long orderId) throws RequestRejectedException;
}
