package mvc;

import users.User;

public class LoginBean {
	private String name, password;
	private User user;

	public String getUserName() {
		return name;
	}

	public void setUserName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean validate() {
		User user = new User();
		user = user.getUser(this.getUserName().toLowerCase());
		if (user.getUsername().toLowerCase().equals(this.getUserName().toLowerCase())
				&& user.getPassword().equals(this.getPassword())) {
			this.user=user;
			return true;
		}
		return false;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user=user;
	}

}
