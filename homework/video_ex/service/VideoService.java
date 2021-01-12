package service;

import dao.VideoDAO;

// service
// DAO를 호출하여 데이터를 받아 비즈니스 로직을 처리합니다.

public class VideoService {
	static VideoDAO dao = new VideoDAO();
	
	public static void userAddService(String id, String pwd) {
		dao.userAdd(id, pwd);
	}
	
}
