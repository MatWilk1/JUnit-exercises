package pl.edu.pw.ii.pte.junit.money;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF);
		assertTrue(expected.equals(result));
	}

	@Test
	public void testEquals() {
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money m5PLN = new Money(5, "PLN");

		assertFalse(m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertFalse(m12CHF.equals(m14CHF));
		assertTrue(m12CHF.equals(m12CHF));
		assertFalse(m12CHF.equals(m5PLN));
	}
	
	@Test
	public void testMultiplication() {
		Money m12CHF = new Money(12, "CHF");
		double x = 2.;
		Money expected = new Money(24, "CHF");
		Money result = m12CHF.multiplication(x);
		
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testAddDifferentCurr() {
		Money m12CHF = new Money(12, "CHF");
		Money m8PLN = new Money(8, "PLN");
		double rate = 0.25;
		Money expected = new Money(14, "CHF");
		Money result = m12CHF.addDifferentCurr(m8PLN, rate);
		
		assertTrue(expected.equals(result));
	}
	
	@Test
	public void testEqualsDifferentCurr() {
		Money m12CHF = new Money(12, "CHF");
		Money m48PLN = new Money(48, "PLN");
		Money m30PLN = new Money(30, "PLN");
		double ratePLN = 0.25;

		assertFalse(m12CHF.equalsDifferentCurr(null, ratePLN));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(m12CHF.equalsDifferentCurr(m48PLN, ratePLN));
		assertFalse(m12CHF.equalsDifferentCurr(m30PLN, ratePLN));
	}
	
	@Test
	public void testInvestmentOneYear() {
		Money m12CHF = new Money(12, "CHF");
		double percent = 10;
		Money expected = new Money(13.2, "CHF");
		Money result = m12CHF.investmentOneYear(percent);
		
		assertTrue(expected.equals(result));
	}

}