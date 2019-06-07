package tdd.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
	
	private Account a;
	
	@BeforeEach
	public void setUp() throws Exception {
		a = new Account("Adam", 100);
	}
	
	@Test
	public void depositMoneyTest() {
		int expected = 150;
		int result = a.depositMoney(50);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void takeMoneyTest() throws Exception {
		int expected = 50;
		int result = a.takeMoney(50);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void takeMoneyToMuchTest() {
		assertThrows(Exception.class, () -> a.takeMoney(300));
	}
	
	@Test
	public void setTakeLimitTest() {
		a.setTakeLimit(70);
		
		assertThrows(Exception.class, () -> a.takeMoney(80));
	}
	
	@Test
	public void createInvestmentTest() throws Exception {
		Investment result = a.createInvestment(40, 12);
		
		assertEquals(60, a.getBalance());
		assertEquals(new Investment(40, 12).getAmount(), result.getAmount());
		assertEquals(new Investment(40, 12).getPeriodMonths(), result.getPeriodMonths());
		assertThrows(Exception.class, () -> a.takeMoney(80));
	}
	
	@Test
	public void createInvestmentToMuchTest() throws Exception {
		assertThrows(Exception.class, () -> a.createInvestment(150, 12));
	}
	


}
