import java.util.regex.Pattern;

public class Utils {
	
	public double btcToEth = 13.51;
	public double btcToLtc = 210.68;
	public double ethToBtc = 0.074;
	public double ethToLtc = 15.56;
	public double ltcToEth = 0.064;
	public double ltcToBtc = 0.0047;
	
	public double btcToUsd = 16558;
	public double ltcToUsd = 69;
	public double ethToUsd = 1197;
	
	public boolean isValid(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                        "[a-zA-Z0-9_+&*-]+)*@" +
	                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                        "A-Z]{2,7}$";
	                          
	    Pattern pat = Pattern.compile(emailRegex);
	    if (email == null) return false;
	    return pat.matcher(email).matches();
    }
	
	 public String randromString(int n) {
	  String allLetterAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

	  StringBuilder sb = new StringBuilder(n);
	 
	  for (int i = 0; i < n; i++) {
	   int index = (int)(allLetterAlpha.length() * Math.random());
	   sb.append(allLetterAlpha.charAt(index));
	  }
	 
	  return sb.toString();
	 }
	 
	 public double convertToUsd(String crypto, double amount) {
		 if(crypto == "btc") {
			 return this.btcToUsd * amount;
		 }
		 if(crypto == "ltc") {
			 return this.ltcToUsd * amount;
		 }
		 if(crypto == "eth") {
			 return this.ethToUsd * amount;
		 }
		 
		 return 0;
	 }
	 
	 public String doubleToString(double amount) {
		 return String.format("%.9f", amount);
	 }
}
