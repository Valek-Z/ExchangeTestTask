package com.exchangetask.Entity;

import java.util.LinkedList;


public class HistoryOrderList {
	
	private static HistoryOrderList instance;
	private LinkedList < String > historyListOrder = new LinkedList <> ( );
	
	private HistoryOrderList ( ) {
	}
	
	public static HistoryOrderList toHistory ( ) {
		if ( instance == null ) {
			instance = new HistoryOrderList ( );
		}
		return instance;
	}
	
	public void addNewOrder ( Order order ) {
		historyListOrder.addLast ( order.toString ( ) );
	}
	
	@Override
	public String toString ( ) {
		return "HistoryListOrders {" + "List = " + historyListOrder + '}';
	}
	
}
