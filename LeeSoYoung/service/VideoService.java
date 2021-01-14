package service;

import java.util.List;

import dao.VideoDAO;
import vo.Video;

// service
// DAO를 호출하여 데이터를 받아 비즈니스 로직을 처리합니다.

public class VideoService {
	static VideoDAO dao = new VideoDAO();

	public  boolean userAddService(String id, String pwd) {
		boolean result = dao.userAdd(id, pwd);
		return result;
	}
	public boolean userLogin(String id, String pwd){
		boolean result = dao.login(id,pwd);
		return result;
	}
	public boolean requestVideo(String videoName){
		boolean result =dao.requestVideo(videoName);
		return result;
	}
	public List<Video> listRequest(){
		List<Video> result = dao.listRequest();
		return result;
	}
}