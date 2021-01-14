package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.Video;

// DAO : Data Access Object
// 원래는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담
// 하지만 아직 이기능을 제대호 사용할수 없을것으로 판단하여 필요한 인터페이스 구현할것

public interface VideoInterface {
	
	// 유저 추가
	public boolean userAdd(String id, String pwd);
	
	
	// 동일한 아이디 확인
	public boolean userSearch(String id) ;
	
	// 로그인
	public boolean userLogin(String id, String pwd);
	
	// 비디오 저장
	public boolean videoAdd(Video v);
	
	// 비디오 리스트
	public ArrayList<Video> videoList();
	
	// 유저 리스트
	public HashMap<String,String> userList();
	
	// 비디오신청 리스트
	public ArrayList<Video> videoRequestList();
	
	// 비디오 신청 추가
	public boolean videoRequestAdd(Video v);
	
	// 비디오 렌탈
	public boolean videoRental(String title);

}
