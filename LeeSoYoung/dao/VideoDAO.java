package dao;

import java.util.HashMap;
import java.util.List;

import vo.Video;

// DAO저장소로 사용될 공간입니다.
//DAO : Data Access Object
//원래는 DB를 사용해 데이터를 조화하거나 조작하는 기능을 전담
// 이곳에서 List interface를 활용하여서 데이터를 생성하세요.
public class VideoDAO implements VideoInterface {
	
	HashMap<String, String> user = new HashMap<String, String>();
	private List<Video> videoList;

	@Override
	public boolean userAdd(String id, String pwd) {
		if (findById(id)) {
			return false;
		} else {
			user.put(id, pwd);
			return true;
		}
	}

	public boolean findById(String id) {
		boolean result = false;
		// for(int i=0; i<user.size();i++){
		if (user.containsKey(id)) {
			result = true;
			// break;
		}
		// }
		return result;
	}

	public boolean login(String id, String pwd) {
		if (user.containsKey(id) && user.get(id).equals(pwd)) {
			return true;
		}
		return false;
	}
	
	public boolean requestVideo(String videoName){
		Video vid = new Video(videoName);
		return true;
	}

	public List<Video> listRequest(){
		
		return videoList;
	}

}
