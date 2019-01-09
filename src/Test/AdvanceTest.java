package Test;

import com.exchangetask.Entity.OrderList;
import com.exchangetask.Exchange;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AdvanceTest {
	
	
	@org.junit.Test
	public void Test ( ) {
		
		Exchange exchange = new Exchange ( );
		Random r = new Random ( );
		
		long l = 1;
		int b = r.nextInt ( 20000 );
		int s = r.nextInt ( 2000 );
		boolean value = r.nextBoolean ( );
		for ( int i = 1 ; i < 400 ; i++ ) {
			exchange.send ( l, value, s, b );
			l++;
		}
		
		
		// Assert
		assertNull ( OrderList.limitOrders ( ).getOrderById ( 0 ) );
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( l - 1 ) );
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( l - 2 ) );
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( l - 22 ) );
		
		
	}
	
	
}