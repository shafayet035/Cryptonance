
public class Account {
	String userName, email, key;
	double BTC = 0, LTC = 0, ETH = 0;
	
	public Account(String userName, String email, String key, double BTC, double LTC, double ETH) {
		this.userName = userName;
		this.email = email;
		this.key = key;
		this.BTC = BTC;
		this.LTC = LTC;
		this.ETH = ETH;
	}
}
