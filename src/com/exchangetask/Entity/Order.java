package com.exchangetask.Entity;


public class Order {
	
	private long orderId;
	private int price;
	private int size;
	private boolean isBuy;
	
	
	public Order ( long orderId, int price, int size, boolean isBuy ) {
		
		this.orderId = orderId;
		this.price = price;
		this.size = size;
		this.isBuy = isBuy;
	}
	
	@Override
	public int hashCode ( ) {
		int result = ( int ) ( getOrderId ( ) ^ ( getOrderId ( ) >>> 32 ) );
		result = 31 * result + getPrice ( );
		result = 31 * result + getSize ( );
		result = 31 * result + ( isBuy ( ) ? 1 : 0 );
		return result;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( ! ( o instanceof Order ) ) return false;
		
		Order order = ( Order ) o;
		
		if ( getOrderId ( ) != order.getOrderId ( ) ) return false;
		if ( getPrice ( ) != order.getPrice ( ) ) return false;
		if ( getSize ( ) != order.getSize ( ) ) return false;
		return isBuy ( ) == order.isBuy ( );
	}
	
	long getOrderId ( ) {
		return orderId;
	}
	
	public int getPrice ( ) {
		return price;
	}
	
	public void setPrice ( int price ) {
		this.price = price;
	}
	
	public int getSize ( ) {
		return size;
	}
	
	public void setSize ( int size ) {
		this.size = size;
	}
	
	public boolean isBuy ( ) {
		return isBuy;
	}
	
	@Override
	public String toString ( ) {
		return "Order{" + "Id-" + orderId + ", Price=" + price + ", Size=" + size + ", Buy=" + isBuy + '}';
	}
}
