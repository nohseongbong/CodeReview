package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import vo.Video;

// DAO저장소로 사용될 공간입니다.
//DAO : Data Access Object
//원래는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담
// 이곳에서 List interface를 활용하여서 데이터를 생성하세요.
public class VideoDAO implements VideoInterface {

	HashMap<String, String> user = new HashMap<String, String>();
	ArrayList<Video> video = new ArrayList<Video>();
	ArrayList<Video> requestVideo = new ArrayList<Video>();

	// 유저 추가
	@Override
	public boolean userAdd(String id, String pwd) {
		boolean idCheck = userSearch(id);
		if (idCheck) {
			user.put(id, pwd);
			return true;
		}

		return false;
	}

	// 중복아이디 확인
	@Override
	public boolean userSearch(String id) {
		for (int i = 0; i < user.size(); i++) {
			// 아이디 중복
			if (user.containsKey(id)) {
				return false;
			}

		}
		// 반복문을 다돌았는데 같은 아이디가 없으면 true 반환
		return true;
	}

	// 유저 로그인
	@Override
	public boolean userLogin(String id, String pwd) {

		for (Entry<String, String> entry : user.entrySet()) {

			if (entry.getKey().equals(id) && entry.getValue().equals(pwd)) {
				return true;
			}
		}

		return false;
	}

	// 비디오 저장
	public boolean videoAdd(Video v) {
		video.add(v);
		return false;
	}

	// 비디오 리스트
	@Override
	public ArrayList<Video> videoList() {

		return video;
	}

	// 유저 리스트
	@Override
	public HashMap<String, String> userList() {

		return user;
	}

	// 요청 비디오 리스트
	@Override
	public ArrayList<Video> videoRequestList() {
		return requestVideo;
	}

	// 요청비디오 추가하기
	@Override
	public boolean videoRequestAdd(Video v) {
		if (v.getVideoName().isEmpty()) {
			return false;
		} else {
			requestVideo.add(v);
			return true;
		}

	}

	// 비디오 대여
	@Override
	public boolean videoRental(String title) {
		boolean result= false;
		for(int i=0; i<video.size(); i++) {
			if(video.get(i).getVideoName().equals(title)) {
				int cnt = video.get(i).getCnt();
				video.get(i).setCnt(cnt-1);
				result = true;
				break;
			}
		}
		return result;
	}

}
