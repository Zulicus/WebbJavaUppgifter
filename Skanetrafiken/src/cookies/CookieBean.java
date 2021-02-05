package cookies;

//A bean that saved the cookie data
import java.util.ArrayList;

public class CookieBean {
	private ArrayList<String> To_Cookies, From_Cookies;

	public ArrayList<String> getTo_Cookies() {
		return To_Cookies;
	}

	public void setTo_Cookies(ArrayList<String> cookies) {
		this.To_Cookies = cookies;
	}

	public ArrayList<String> getFrom_Cookies() {
		return From_Cookies;
	}

	public void setFrom_Cookies(ArrayList<String> from_Cookies) {
		From_Cookies = from_Cookies;
	}
}
