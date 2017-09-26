package ph.mramos.ocjsfd.model;

public class User {

	private String username;
	
	public User() {
		super();
	}

	public User(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
}
