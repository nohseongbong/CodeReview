package controller;

import java.util.ArrayList;

import service.StoreService;
import vo.Stuff;
import vo.User;

public class StoreController {
	private StoreService service = new StoreService();

	public String login(String id, String pwd, String option) {
		if(option.equals("1")) {
			option = "U";
		}else {
			option="M";
		}
		String newId = id+option;
		User u = new User(newId, pwd, 0);
		return service.login(u);
		

	}

	public boolean singup(String id, String pwd, String option) {
		if(option.equals("1")) {
			option = "U";
		}else {
			option="M";
		}
		String newId = id+option;
		User u = new User(newId, pwd, 0);
		return service.singup(u);
	}

	public boolean insertStuff(String stuff, int price) {
		Stuff s = new Stuff(stuff,price);
		return service.insertStuff(s);
		
	}
	
	public ArrayList<Stuff> stuffList (){
		return service.stuffList();
	}

	public boolean stuffCash(String id,String stuffU) {
		return service.stuffCash(id,stuffU);
		
	}

	public boolean insertPoint(String sessionId, int balance) {
		return service.insertPoint( sessionId, balance);
		
	}

}
