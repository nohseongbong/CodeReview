package service;

import java.util.ArrayList;

import dao.StoreDAO;
import vo.Stuff;
import vo.User;

public class StoreService {
private static StoreDAO dao =new StoreDAO();
	public String login(User u) {
		return dao.login(u);
		
	}
	
	public boolean singup(User u) {
		return dao.singup(u);
	}

	public boolean insertStuff(Stuff s) {
		return dao.insertStuff(s);
		
	}
	
	public ArrayList<Stuff> stuffList(){
		return dao.stuffList();
	}

	public boolean insertPoint(String sessionId, int balance) {
		return dao.insertPoint(sessionId, balance);
	}

	public boolean stuffCash(String id, String stuffU) {
		return dao.stuffcash(id, stuffU);
	}

}
