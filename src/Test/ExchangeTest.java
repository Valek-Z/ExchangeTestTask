package Test;

import com.exchangetask.Entity.HistoryOrderList;
import com.exchangetask.Entity.OrderList;
import com.exchangetask.Exchange;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ExchangeTest {
	
	@Before
	public void setUp ( ) throws Exception {
		Exchange exchange = new Exchange ( );
		
		
		exchange.send ( 1, true, 6, 50 );
		exchange.send ( 2, false, 6, 50 );
		exchange.send ( 3, true, 6, 35 );
		exchange.send ( 4, false, 6, 4 );
		exchange.send ( 5, false, 6, 20 );
		exchange.send ( 6, true, 5, 200 );
		exchange.send ( 7, true, 7, 20 );
		exchange.send ( 8, false, 6, 450 );
	}
	
	@Test
	public void send ( ) {
		Exchange exchange = new Exchange ( );
		
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( 6 ) );
		assertNotNull ( HistoryOrderList.toHistory ( ).toString ( ) );
		assertNull ( OrderList.limitOrders ( ).getOrderById ( 3 ) );
		
	}
	
	@Test
	public void cancel ( ) {
		Exchange exchange = new Exchange ( );
		
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( 8 ) );
		
		exchange.cancel ( 8 );
		
		assertNull ( OrderList.limitOrders ( ).getOrderById ( 8 ) );
		assertNotNull ( OrderList.limitOrders ( ).getOrderById ( 7 ) );
	}
}