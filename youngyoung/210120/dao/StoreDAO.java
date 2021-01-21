package dao;

import java.util.ArrayList;

import vo.Stuff;
import vo.User;

public class StoreDAO {
	
	// 회원 목록을 가지고 있는 ArryaList입니다.
	private ArrayList<User> users = new ArrayList<User>();
	
	// 물건 목록을 가지고 있는 ArrayList입니다.
	private ArrayList<Stuff> stuffs = new ArrayList<Stuff>();

	public String login(User u) {
		for(int i = 0; i<users.size(); i++) {
			String id = users.get(i).getId();
			String pwd  = users.get(i).getPwd();
			if(id.equals(u.getId()) && pwd.equals(u.getPwd())){
				return id;
			}
		}
		return null;
		
	}
	
	public boolean singup(User u) {
		if(selectById(u.getId())) {
			users.add(u);
			
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public boolean selectById(String id) {
		for(int i=0; i<users.size(); i++) {
			if(id.equals(users.get(i).getId())) {
				return false;
			}
		}
		return true;
	}

	public boolean insertStuff(Stuff s) {
		int size = stuffs.size();
		stuffs.add(s);
		if(size< stuffs.size()) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<Stuff> stuffList (){
		return stuffs;
	}
	
	public boolean insertPoint(String id, int balance) {
		for(User u : users){
			if(u.getId().equals(id)) {
				u.setBalance(balance);
				return true;
			}
		}
		return false;
	}
	
	public boolean stuffcash(String id,String stuff) {
		int price = 0;
		for(Stuff s : stuffs) {
			if(s.getName().equals(stuff)) {
				price=s.getPrice();
				
				break;
			}
		}
		
		for(User u : users) {
			if(u.getId().equals(id)) {
				int bal = u.getBalance();
				
				if(bal>= price) {
					u.setBalance(bal-price); 
					return true;
				}else if(bal<price){
					return false;
				}
				
			}
		}
		return false;

	}
	
	 
	

}
