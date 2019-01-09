package Test;

import com.exchangetask.AdvancedExchange;
import com.exchangetask.Entity.Order;
import com.exchangetask.Entity.OrderList;
import com.exchangetask.Exchange;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvancedExchangeTest {
	
	@Before
	public void setUp ( ) throws Exception {
		Exchange exchange = new Exchange ( );
		
		exchange.send ( 1, true, 6, 50 );
		exchange.send ( 2, false, 6, 5 );
		
	}
	
	@Test
	public void modify ( ) {
		AdvancedExchange mod = new AdvancedExchange ( );
		
		Order orderById = OrderList.limitOrders ( ).getOrderById ( 1 );
		int expectedPrice = orderById.getPrice ( );
		int expectedSize = orderById.getSize ( );
		int actualPrice = 6;
		int actualSize = 45;
		
		assertEquals ( expectedPrice, actualPrice );
		assertEquals ( expectedSize, actualSize );
		
		mod.modify ( 1, 34, 54 );
		int expectedNewPrice = orderById.getPrice ( );
		int expectedNewSize = orderById.getSize ( );
		int actualNewPrice = 34;
		int actualNewSize = 54;
		
		assertEquals ( expectedNewPrice, actualNewPrice );
		assertEquals ( expectedNewSize, actualNewSize );
		// Assert
		assertNull ( OrderList.limitOrders ( ).getOrderById ( 2 ) );
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( 1 ) );
		
		
	}
}