package vo;

public class User {
	private String id;
	private String pwd;
	private int balance;
	
	
	public User(String id, String pwd, int balance) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
}
