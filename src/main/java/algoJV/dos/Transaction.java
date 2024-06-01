package algoJV.dos;

import java.util.Date;

public class Transaction implements Comparable<Transaction> {
	private final String where;
	private final Date date;
	private final double amount;
	
	Transaction(String where, Date date, double amount) {
		if (Double.isNaN(amount) || Double.isInfinite(amount)) 
			throw new IllegalArgumentException("Bad amount!");
		this.where = where;
		this.date = date;
		this.amount = amount;
	}
	
	Transaction(String transaction) {
		String[] s = transaction.split("\\+s");
		this.where = s[0];
		this.date = new Date(s[1]);
		this.amount = Double.parseDouble(s[2]);
		if (Double.isNaN(amount) || Double.isInfinite(amount)) 
			throw new IllegalArgumentException("Bad amount!");
	}
	
	@Override
	public int compareTo(Transaction o) {
		return Double.compare(this.amount, o.amount);
	}

	
}
