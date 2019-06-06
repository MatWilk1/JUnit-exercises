package pl.edu.pw.ii.pte.junit.money;

class Money {
	private double fAmount;
	private String fCurrency;

	public Money(double amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public double amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;

			return a.currency().equals(currency()) && amount() == a.amount();
		}
		return false;
	}
	
	public Money multiplication(double x) {
		return new Money(amount() * x, currency());
	}
	
	public Money addDifferentCurr(Money m, double rate) {
		return new Money(amount() + m.amount() * rate, currency());
	}
	
	public boolean equalsDifferentCurr(Object anObject, double rate) {
		if(anObject instanceof Money) {
			Money a = (Money) anObject;
			
			return amount() == a.amount() * rate;
		}
		
		return false;
	}
	
	public Money investmentOneYear(double percent) {
		return new Money(amount() + amount() * percent/100, currency());
	}
}