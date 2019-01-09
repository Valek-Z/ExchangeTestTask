package com.exchangetask;

import com.exchangetask.Entity.Order;
import com.exchangetask.Entity.OrderList;
import org.springframework.security.web.firewall.RequestRejectedException;


public class AdvancedExchange implements AdvancedExchangeInterface {
	
	
	@Override
	public void modify ( long orderId, int newPrice, int newSize ) throws RequestRejectedException {
		
		try {
			Order orderById = OrderList.limitOrders ( ).getOrderById ( orderId );
			if ( orderById != null ) {
				orderById.setPrice ( newPrice );
				orderById.setSize ( newSize );
			}
			
		} catch (RequestRejectedException e) {
			throw new RequestRejectedException ( "This order can't modify: because there's not found" );
		}
		
		
	}
	
	@Override
	public void send ( long orderId, boolean isBuy, int price, int size ) {
	
	}
	
	@Override
	public void cancel ( long orderId ) throws RequestRejectedException {
	
	}
}
