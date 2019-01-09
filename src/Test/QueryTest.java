package Test;

import com.exchangetask.Exchange;
import com.exchangetask.Query;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryTest {
	
	@Before
	public void setUp ( ) throws Exception {
		Exchange exchange = new Exchange ( );
		
		exchange.send ( 1, true, 6, 50 );
		exchange.send ( 2, false, 6, 50 );
		exchange.send ( 3, true, 6, 35 );
		exchange.send ( 4, false, 6, 4 );
		exchange.send ( 5, false, 6, 20 );
		exchange.send ( 6, true, 6, 200 );
		exchange.send ( 7, true, 7, 20 );
		exchange.send ( 8, false, 6, 450 );
		
	}
	
	@Test
	public void getTotalSizeAtPrice ( ) {
		Query query = new Query ( );
		
		int expected = query.getTotalSizeAtPrice ( 6 );
		int actual = 478;
		
		assertEquals ( expected, actual );
		
	}
	
	@Test
	public void getHighestBuyPrice ( ) {
		Query query = new Query ( );
		
		int expected = query.getHighestBuyPrice ( );
		int actual = 7;
		
		assertEquals ( expected, actual );
		
	}
	
	@Test
	public void getLowestSellPrice ( ) {
		Query query = new Query ( );
		
		int expected = query.getLowestSellPrice ( );
		int actual = 6;
		
		assertEquals ( expected, actual );
	}
}