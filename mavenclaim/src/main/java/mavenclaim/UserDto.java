package mavenclaim;

public class UserDto {
	private String username;
	private String password;
	private String rolecode;
	
	
	public UserDto() {
		super();
	}
	public UserDto(String username, String password, String rolecode) {
		super();
		this.username = username;
		this.password = password;
		this.rolecode = rolecode;
	}
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
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", rolecode=" + rolecode + "]";
	}

}
