package pl.edu.pw.ii.pte.junit.inheritance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

public class ManagerTest {
	
//	@Test
//	public void setBonusTestTest() {
//		Manager manager = new Manager("Adam Adamski", 7000, 1975, 03, 20);
//	}
	
	
	@Test
	public void raiseSalaryTest() {
		Manager manager = new Manager("Adam Adamski", 7000, 1975, 03, 20);
		double byPercent = 10;
		manager.raiseSalary(byPercent);
		
		double expected = 7700;
		double result = manager.getSalary();
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void getSalaryTest() {
		Manager manager = new Manager("Adam Adamski", 7000, 1975, 03, 20);
		double bonus = 500;
		manager.setBonus(bonus);
		
		double expected = 7500;
		double result = manager.getSalary();
		
		assertEquals(expected, result);

	}
	
	@Test
	public void getNameTest() {
		Manager manager = new Manager("Adam Adamski", 7000, 1975, 03, 20);
		String expected = "Adam Adamski";
		String result = manager.getName();
		
		assertEquals(expected, result);

	}
	
	@Test
	public void getHireDayTest() {
		Manager manager = new Manager("Adam Adamski", 7000, 1975, 03, 20);
		String expectedS = "Thu Mar 20 00:00:00 CET 1975";
		String resultS = manager.getHireDay().toString();
		
		Date expectedD = new GregorianCalendar(1975, 03-1, 20).getTime();
		Date resultD = manager.getHireDay();
		
		assertEquals(expectedS, resultS);
		assertEquals(expectedD, resultD);
		

	}


}
