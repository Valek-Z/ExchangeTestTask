package com.exchangetask;

import com.exchangetask.Entity.Order;
import com.exchangetask.Entity.OrderList;

import java.util.List;
import java.util.stream.Collectors;


public class Query implements QueryInterface {
	
	
	@Override
	public int getTotalSizeAtPrice ( int price ) {
		List < Order > collect = OrderList.limitOrders ( ).getOrderByPrice ( price );
		return collect.stream ( )
		              .mapToInt ( Order :: getSize )
		              .sum ( );
	}
	
	
	@Override
	public int getHighestBuyPrice ( ) {
		List < Order > collect = OrderList.limitOrders ( ).getOrderBuySide ( true );
		if ( collect.size ( ) > 0 ) {
			return collect.stream ( )
			              .collect ( Collectors.summarizingInt ( Order :: getPrice ) )
			              .getMax ( );
		}
		return - 1;
	}
	
	
	@Override
	public int getLowestSellPrice ( ) {
		List < Order > collect = OrderList.limitOrders ( ).getOrderBuySide ( false );
		if ( collect.size ( ) > 0 ) {
			return collect.stream ( )
			              .collect ( Collectors.summarizingInt ( Order :: getPrice ) )
			              .getMin ( );
		}
		return - 1;
	}
}
