package controller;

import java.util.ArrayList;

import service.VideoService;
import vo.Video;

// controller
// view에서 처리해야 할 데이터를 받아온다.
// 담당할 service를 선택하여 호출한다.

public class VideoController {
	public static VideoService service = new VideoService();
	
	// veiw에서 회원가입기능입니다.
	// 회원가입을 위해서 받아온 값들을 가공해서 service.userAddService로 넘겨줍니다.
	public String  userAddController(String id, String pwd, String option) {
		String message="";
		String newId="";
		if(option.equals("1")) {
			//user
			 newId = id+"U";
		}else if(option.equals("2")) {
			//manager
			 newId = id+"M";
		}
		
		boolean result = service.userAddService(newId, pwd);
		if(result) {
			message = "추가되었습니다.";
		}else {
			message = "중복된 아이디가 있습니다.";
		}
		return message;
	}
	
	
	// view단에 login기능입니다.
	// 로그인을 위해서 입력 받은 값들을 가공해서 Servic.login으로 넘겨줍니다.
	// service.login으로 부터 return 값을 이용해서 view단에 어떻게 보여줄지 결정됩니다.
	public boolean login(String id, String pwd, String option) {
		String message = "";
		String newId="";
		if(option.equals("1")) {
			//user
			 newId = id+"U";
		}else if(option.equals("2")) {
			//manager
			 newId = id+"M";
		}
		boolean loginResult = service.login(newId, pwd);
		
		return loginResult;
		
	}
	
	// 비디오 추가
	// view단에 manager가 비디오를 비디오를 추가한 기능입니다.
	// manager가 비디오 추가를 위해서 입력받은 Video객체로 만들어서 반환해줍니다.
	// 그값을 그대로 service.videoAdd로 반환해주고 return값을 boolean을 받아옵니다.
	public boolean videoAdd(Video v) {
		boolean videoAddresult = service.videoAdd(v);
		return videoAddresult;
	}
	
	
	// 비디오 리스트
	// view단에서 manager가 비디오 리스트를 출력하고 햇을때 작동되는 method입니다.
	// 이 method는 리스트를 가져와서 view로 던져조는 역할을 하기때문에 view로 부터 매개변수를 받지 않고
	// 바로 ArrayList<Video>를 View단으로 반환해줍니다.
	public ArrayList<Video> videoList() {
		ArrayList<Video> v =service.videoList();
		return v;
	}
	
	// 유저 아이디 리스트
	// ArrayList<String>에 유저id들 받아와서 반환해줍니다.
	public ArrayList<String> userList(){
		ArrayList<String> user = service.userList();
		return user;
	}
	
	// 비디오 신청 추가하기
	// user가 입력한 데이터를 video객체를 생성하여서 requestVideo ArryaList<Video>에 저장해준다.
	public boolean videoRequestAdd(String title, String content, int agelimit) {
		Video v = new Video(title,content,agelimit);
		return service.videoRequestAdd(v);
	}
	
	// 비디오 신청 리스트
	// ArrayList<Video> requestVideo를 가져와서 값을 반환해줍니다. 
	public ArrayList<Video> videoRequestList(){
		return service.videoRequestList();
	}
	
	// 비디오를 렌트
	// user가 입력한 제목을 가지고 service로 이동합니다.
	public boolean videoRental(String title) {
		return service.videoRental(title);
	}
	
	
}
