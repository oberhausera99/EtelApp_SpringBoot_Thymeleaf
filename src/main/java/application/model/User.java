package application.model;

public class User {
	public User(String name, String uName, String password, String email, boolean jogosultsag) {
		this.name = name;
		this.uName = uName;
		this.password = password;
		this.email = email;
		this.jogosultsag = jogosultsag;
	}
	
	private String name;
	private String uName;
	private String password;
	private String email;
	private boolean jogosultsag;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUName() {
		return uName;
	}
	public void setUName(String uName) {
		this.uName = uName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getJogosultsag() {
		return jogosultsag;
	}
	public void setJogosultsag(boolean jogosultsag) {
		this.jogosultsag= jogosultsag;
	}
}
