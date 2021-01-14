package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import dao.VideoDAO;
import vo.Video;

// service
// DAO를 호출하여 데이터를 받아 비즈니스 로직을 처리합니다.

public class VideoService {
	static VideoDAO dao = new VideoDAO();
	
	public  boolean userAddService(String id, String pwd) {
		// 중복인지 아닌지 확인
		
		boolean userAddresult = dao.userAdd(id, pwd);
		return userAddresult;
	}
	
	public boolean login (String id, String pwd) {
		boolean userLogin = dao.userLogin(id, pwd);
		
		return userLogin;
	}
	
	public boolean videoAdd (Video v) {
		boolean videoAddresult = dao.videoAdd(v);
		return videoAddresult;
	}
	
	public  ArrayList<Video> videoList() {
		ArrayList<Video> v = dao.videoList();
		return v;
	}
	
	public ArrayList<String> userList(){
		// hashmap에서 아이디만 출력
		ArrayList<String> user =new ArrayList<String>(); 
		HashMap<String,String> users = dao.userList();
		for(Entry<String,String> entry : users.entrySet() ) {
			// 아이디 뒤에 있는 옵션을 제외하고 출력합니다.
//			String userId = entry.getKey().substring(0, entry.getKey().length()-1);
//			user.add(userId);
			
			// 아이디 뒤에 있는 옵션까지 전부 보여준다.
			user.add(entry.getKey());

		}
		return user;	
	}
	
	public boolean videoRequestAdd(Video v) {
		return dao.videoRequestAdd(v);
	}
	
	
	public ArrayList<Video> videoRequestList(){
		return dao.videoRequestList();
	}
	
	public boolean videoRental(String title) {
		return dao.videoRental(title);
	}
	
}
