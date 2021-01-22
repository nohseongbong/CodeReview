
package lsy.dao;

import java.util.ArrayList;

import lsy.db.StoreDatabase;
import lsy.vo.User;

public class StoreDAO {

	public int idCheck(String id) {

		ArrayList<User> users = StoreDatabase.users; // DB 라고 가정할때
		// table 명 : Users = StoreDatabase.users
		// create table Users(
		// id varchar2(20) primary key,
		// password varchar2(50),
		// balance number(20)
		// );
		// select * from Users where id = 파라미터변수id;

		int idOk = 0;

		// 원래 DB 에서 하는 역할
		for (int i = 0; i < users.size(); i++) { // 20개
			User user = users.get(i);
			if (id.equals(user.getId())) {// 2번째에 equals
				idOk = 1;
				break;
				// for문 기준
				// break : 더이상 돌지말고 포문을 벗어나;
				// continue : 해당 조건만 한번 건너뛰어;
				// return : 메소드를 벗어나~;
			}
		}
		// 여기서부터 시작
		return idOk;
	}

	public int join(String id, String pwd) {
		User user = new User(id, pwd);
		try {
			// insert into Users (id, pwd) values(파라미터변수id, 파라미터변수pwd);
			StoreDatabase.users.add(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public User login(String id, String pwd) {
		// select * from User where id = 파라미터변수id and pwd = 파라미터변수pwd;
		ArrayList<User> users = StoreDatabase.users;
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (id.equals(user.getId())) {
				if (pwd.equals(user.getPwd())) {
					return user;
				}
			}

		}
		return null;
	}
}