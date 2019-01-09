package com.exchangetask.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class OrderList {
	
	private static OrderList instance;
	public LinkedList < Order > orderList = new LinkedList < Order > ( );
	
	
	private OrderList ( ) {
	}
	
	public static OrderList limitOrders ( ) {
		if ( instance == null ) {
			instance = new OrderList ( );
		}
		return instance;
	}
	
	public void addNewOrder ( Order order ) {
		orderList.add ( order );
	}
	
	public void deleteOrder ( Order order ) {
		orderList.remove ( order );
	}
	
	public Order getOrderById ( long orderId ) {
		return orderList.stream ( ).filter ( order -> order.getOrderId ( ) == orderId ).findFirst ( ).orElse ( null );
	}
	
	public List < Order > getOrderByPrice ( int price ) {
		return orderList.stream ( ).filter ( ( Order p ) -> p.getPrice ( ) == price ).collect ( Collectors.toList ( ) );
	}
	
	public List < Order > getOrderBuySide ( boolean isBuy ) {
		return orderList.stream ( ).filter ( ( Order p ) -> p.isBuy ( ) == isBuy ).collect ( Collectors.toList ( ) );
	}
	
	@Override
	public int hashCode ( ) {
		return Objects.requireNonNull ( getOrderList ( ) ).hashCode ( );
	}
	
	private LinkedList < Order > getOrderList ( ) {
		if ( orderList == null ) {
			return null;
		}
		return orderList;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( ! ( o instanceof OrderList ) ) return false;
		
		OrderList orderList1 = ( OrderList ) o;
		
		return Objects.equals ( getOrderList ( ), orderList1.getOrderList ( ) );
	}
	
	@Override
	public String toString ( ) {
		return "Limit Order List{" + orderList + '}';
	}
}
