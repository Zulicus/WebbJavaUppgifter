package cookies;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieController {
	// Function to check that cookies are allowed
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

	// Creates a cookie
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

	// Cleans out any symbols that are no allowed in cookies
	private String clean(String string) {
		return string.replaceAll(" ", "+").replaceAll("Ã¶", "o").replaceAll("Ã¤", "a").replaceAll("Ã¥", "a");
	}

	// Adds back the spaces of the cookies
	private String unClean(String string) {
		return string.replaceAll("\\+", " ");
	}

	// Searches through cookies to find the ones with the ! which signifies that
	// they are the correct cookie
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
