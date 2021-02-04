package cookies;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieController {

	public boolean cookiesAllowed(HttpServletRequest request) {
		try {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookiebar")) {
					if (cookies[i].getValue().equalsIgnoreCase("CookieAllowed")) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}

	public void createCookie(HttpServletResponse response, String to, String from) {
		try {
			String cleanTo = clean(to);
			String cleanFrom = clean(from);
			System.out.println((cleanTo + cleanFrom));
			Cookie cookie = new Cookie((cleanTo + cleanFrom), (cleanTo + "!" + cleanFrom));
			response.addCookie(cookie);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private String clean(String string) {
		return string.replaceAll(" ", "+").replaceAll("Ã¶", "o").replaceAll("Ã¤", "a").replaceAll("Ã¥", "a");
	}

	private String unClean(String string) {
		return string.replaceAll("\\+", " ");
	}

	public ArrayList<String> getCookies(HttpServletRequest request) {
		ArrayList<String> cookieList = new ArrayList<String>();
		try {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getValue().contains("!")) {
					cookieList.add(unClean(cookies[i].getValue()));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cookieList;
	}

}
