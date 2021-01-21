package lsy.vo;

public class User {
	private String id;
	private String pwd;
	private String option;
	private int balance;

	public User() {
		super();
	}

	public User(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public User(String id, String pwd, String option, int balance) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.option = option;
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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}