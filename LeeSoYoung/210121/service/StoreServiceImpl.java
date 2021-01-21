package lsy.service;

import lsy.vo.User;

public interface StoreServiceImpl {
	
	public abstract int idCheck(String id);
	
	public abstract int join(String id, String pwd);
	
	public abstract User login(String id, String pwd);

}
