package lsy.service;

import lsy.dao.StoreDAO;
import lsy.vo.User;

public class StoreService implements StoreServiceImpl {
	
	private StoreDAO storeDAO= null;

	@Override
	public int idCheck(String id) {  //여기는 공통적으로 해주고 dao 접근 == database(oracle,mysql,mssql,mriadb ...) access object   d a o
		storeDAO = new StoreDAO();
		int result = storeDAO.idCheck(id);
		return result;
	}

	@Override
	public int join(String id, String pwd) {
		storeDAO = new StoreDAO();
		int result = storeDAO.join(id, pwd);
		return result;
	}

	@Override
	public User login(String id, String pwd) {
		storeDAO = new StoreDAO();
		User user = storeDAO.login(id, pwd);
		return user;
	}

}