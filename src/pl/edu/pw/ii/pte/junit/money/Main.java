package pl.edu.pw.ii.pte.junit.money;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Money m12CHF = new Money(12, "CHF");
		Money m14CHF = new Money(14, "CHF");
		Money m8PLN = new Money(8, "PLN");
		Money m48PLN = new Money(48, "PLN");
		
		
		System.out.println("dodawanie:" + m12CHF.add(m14CHF).amount());
		
		System.out.println("porównywanie:" + m12CHF.equals(m14CHF));
		
		System.out.println("mno¿enie:" + m12CHF.multiplication(2).amount());
		
		System.out.println("dodawanie ró¿nych walut:" + m12CHF.addDifferentCurr(m8PLN, 0.25).amount());
		
		System.out.println("porównanie ró¿nych walut:" + m12CHF.equalsDifferentCurr(m48PLN, 0.25));
		
		System.out.println("lokata:" + m12CHF.investmentOneYear(10).amount());

	}

}
