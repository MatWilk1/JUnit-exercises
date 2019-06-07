package tdd.bankaccount;

public class Investment {
	
	private int amount;
	private int periodMonths;
	
	public Investment(int amount, int periodMonths) {
		this.amount = amount;
		this.periodMonths = periodMonths;
	}

	public int getAmount() {
		return amount;
	}

	public int getPeriodMonths() {
		return periodMonths;
	}
	
	
	
}
