package controller;

import service.VideoService;

// controller
// view에서 처리해야 할 데이터를 받아온다.
// 담당할 service를 선택하여 호출한다.

public class VideoController {
	public static VideoService service = new VideoService();
	
	public static void userAddController(String id, String pwd, String option) {
		if(option.equals("1")) {
			//user
			String newId = id+"U";
		}else if(option.equals("2")) {
			//manager
			String newId = id+"M";
		}else {
			System.out.println("예외발생에 대한 처리 ");
		}
		
		service.userAddService(id, pwd);
	}
}
