package dao;

import java.util.HashMap;

// DAO저장소로 사용될 공간입니다.
//DAO : Data Access Object
//원래는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담
// 이곳에서 List interface를 활용하여서 데이터를 생성하세요.
public class VideoDAO implements VideoInterface {
	
	HashMap<String, String> user = new HashMap<String, String>();
	
	@Override
	public boolean userAdd(String id, String pwd) {
		user.put(id, pwd);
		
		return false;
	}

}
