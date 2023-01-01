
public class Transaction {
	String sender, receiver, currency, note;
	double amount;
	
	Transaction(String sender, String receiver, String currency, double amount, String note) {
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.currency = currency;
		this.note = note;
	}
}
