package tdd.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccountTest {
	
//	@BeforeEach
//	public void setUp() throws Exception {
//		Account a = new Account("Adam", 100);
//	}
	
	@Test
	public void depositMoneyTest() {
		Account a = new Account("Adam", 100);
		int expected = 150;
		int result = a.depositMoney(50);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void takeMoneyTest() throws Exception {
		Account a = new Account("Adam", 100);
		int expected = 50;
		int result = a.takeMoney(50);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void takeMoneyToMuchTest() {
		Account a = new Account("Adam", 100);
		
		assertThrows(Exception.class, () -> a.takeMoney(300));
	}
	
	@Test
	public void setTakeLimitTest() {
		Account a = new Account("Adam", 100);
		a.setTakeLimit(70);
		
		assertThrows(Exception.class, () -> a.takeMoney(80));
	}
	
	@Test
	public void createInvestmentTest() throws Exception {
		Account a = new Account("Adam", 100);
		
		Investment result = a.createInvestment(40, 12);
		
		assertEquals(60, a.getBalance());
		assertEquals(new Investment(40, 12).getAmount(), result.getAmount());
		assertEquals(new Investment(40, 12).getPeriodMonths(), result.getPeriodMonths());
		assertThrows(Exception.class, () -> a.takeMoney(80));
	}
	
	@Test
	public void createInvestmentToMuchTest() throws Exception {
		Account a = new Account("Adam", 100);
		
		assertThrows(Exception.class, () -> a.createInvestment(150, 12));
	}
	


}
