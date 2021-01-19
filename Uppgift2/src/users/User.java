package users;

public class User {
	private String username, password, firstName, lastName, bio;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public User getUser(String username) {
		User user = new User();
		switch (username) {
		case "zulicus":
			user.setFirstName("Robin");
			user.setLastName("Stenford");
			user.setUsername("Zulicus");
			user.setPassword("admin");
			user.setBio("Hello I am Robin! I am user #1!");
			return user;
		case "gescha":
			user.setFirstName("Erik");
			user.setLastName("Geschwindt");
			user.setUsername("Gescha");
			user.setPassword("Admin96");
			user.setBio("Yo I'm Erik, sadly I'm no.2 :(");
			return user;
		default:
			return null;
		}

	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
