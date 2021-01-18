package controller;

import java.util.List;

import service.VideoService;
import vo.Video;

// controller
// view에서 처리해야 할 데이터를 받아온다.
// 담당할 service를 선택하여 호출한다.

public class VideoController {
	public static VideoService service = new VideoService();
	public String newId = "";

	public boolean userAddController(String id, String pwd, String option) {
		if (option.equals("1")) {
			// user
			String newId = id + "U";

		} else if (option.equals("2")) {
			// manager
			String newId = id + "M";
		} else {
			System.out.println("예외발생에 대한 처리 ");
		}

		boolean result = service.userAddService(newId, pwd);
		return result;

	}

	public boolean userLogin(String id, String pwd, String option) {
		String newId = "";
		if (option.equals("1")) {
			// user
			 newId = id + "U";

		} else if (option.equals("2")) {
			// manager
			 newId = id + "M";
		} else {
			System.out.println("예외발생에 대한 처리 ");
		}

		boolean result = service.userLogin(newId, pwd);
		return result;
	}

	public String requestVideo(String videoName) {
		boolean result =service.requestVideo(videoName);
		if(result){
			String str ="신청되었습니다.";
			return str;
		}return null;
	}

	public String listRequest() {
		List<Video> result = service.listRequest();
		for (int i = 0; i < result.size(); i++) {
			String vName = result.get(i).getVideoName();

			return vName;
		}
		return null;
	}

}