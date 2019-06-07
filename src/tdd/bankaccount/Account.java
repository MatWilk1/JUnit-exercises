package tdd.bankaccount;

public class Account {

	private String owner = null;
	private int balance = 0;
	private int limit;
	
	public Account(String owner, int balance) {
		this.owner = owner;
		this.balance = balance;
		this.limit = balance;
//		this.state = new AccountOpen();
	}
	
		
	public int getBalance() {
		return balance;
	}

	public int depositMoney(int m) {
		return balance += m;
	}
	
	public int takeMoney(int m) throws Exception {
		
		if(m > balance) {
			throw new Exception("Nie ma tylu pieniędzy na koncie");
		}else if(m > limit) {
			throw new Exception("Podana kwota jest większa od limitu transakcji");
		}
		else {
			return balance -= m;
		}
	}
	
	public void setTakeLimit(int limit) {
		this.limit = limit;
	}
	
	public Investment createInvestment(int amount, int period) throws Exception {
		
		if(amount > balance) {
			throw new Exception("Nie ma tylu pieniędzy na koncie");
		}
		
		balance -= amount;
		return new Investment(amount, period);
	}
	
}
