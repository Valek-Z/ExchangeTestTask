package com.exchangetask;

import com.exchangetask.Entity.Order;
import com.sun.istack.internal.NotNull;
import org.springframework.security.web.firewall.RequestRejectedException;

import java.util.List;
import java.util.stream.Collectors;

import static com.exchangetask.Entity.HistoryOrderList.toHistory;
import static com.exchangetask.Entity.OrderList.limitOrders;


public class Exchange implements ExchangeInterface {
	
	
	@Override
	public void send ( @NotNull long orderId, boolean isBuy, int price, int size ) {
		
		List < Order > collect = limitOrders ( ).orderList.stream ( )
		                                                  .filter ( ( Order p ) -> p.getPrice ( ) == price )
		                                                  .filter ( ( Order p ) -> p.isBuy ( ) != isBuy )
		                                                  .collect ( Collectors.toList ( ) );
		if ( collect.size ( ) <= 0 ) {
			limitOrders ( ).addNewOrder ( new Order ( orderId, price, size, isBuy ) );
		} else {
			for ( Order order : collect ) {
				int sizeOrderToChange = order.getSize ( );
				if ( sizeOrderToChange == size ) {
					toHistory ( ).addNewOrder ( order );
					toHistory ( ).addNewOrder ( new Order ( orderId, price, size, isBuy ) );
					limitOrders ( ).deleteOrder ( order );
					size = 0;
				} else if ( size > sizeOrderToChange ) {
					toHistory ( ).addNewOrder ( order );
					toHistory ( ).addNewOrder ( new Order ( orderId, price, sizeOrderToChange, isBuy ) );
					limitOrders ( ).deleteOrder ( order );
					size = size - sizeOrderToChange;
				} else {
					order.setSize ( size );
					toHistory ( ).addNewOrder ( order );
					toHistory ( ).addNewOrder ( new Order ( orderId, price, size, isBuy ) );
					int newSize = sizeOrderToChange - size;
					order.setSize ( newSize );
					size = 0;
				}
			}
			if ( size > 0 ) {
				limitOrders ( ).addNewOrder ( new Order ( orderId, price, size, isBuy ) );
			}
		}
		
	}
	
	
	@Override
	public void cancel ( long orderId ) throws RequestRejectedException {
		
		
			if ( limitOrders ( ).getOrderById ( orderId ) != null ) {
				limitOrders ( ).deleteOrder ( limitOrders ( ).getOrderById ( orderId ) );
		
		
		
	}
}
