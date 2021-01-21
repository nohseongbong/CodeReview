package lsy.controller;

import lsy.service.StoreService;
import lsy.vo.User;

public class StoreController {
	public String newId = "";

	private StoreService storeService = null;

	public int join(String id, String pwd) {

		storeService = new StoreService();

		int result = 0;
		// id = lsy
		// id 가 있는지
		result = storeService.idCheck(id);
		// result [ 0 : 아이디가 없는경우, 1 : 아이디가 있는경우]
		if (result == 0) { // 즉 가입이 되는 아이디
			System.out.println("회원가입 진행");
			// 나중에 너가 해봐
			// PWD 숫자,대문자,소문자인지 확인하는 로직 체크 이건 너가 만들어봐
			int joinResult = storeService.join(id, pwd);
			if (joinResult == 1) {
				System.out.println(id + " 회원님의 가입이 완료 되었습니다.");
			} else {
				System.out.println("가입 도 중 오류 발생하였습니다.");
			}
		} else {
			System.out.println("아이디가 이미 사용 중입니다.");
		}

		// pw 구성이 맞는지 : 소문자,대문자, 숫자, 특수문자가 포함되 잇는지

		return result;
	}

	public User login(String id, String pwd) {
		storeService = new StoreService();

		if (id != null && !"".equals(id)) {
			if (pwd != null && !"".equals(pwd)) {
				User user = storeService.login(id, pwd);
				if (user == null) {
					System.out.println("로그인에 실패하였습니다.");
				} else {
					return user;
				}
			} else {
				System.out.println("비밀번호가 잘못 입력 되었거나 빈값입니다.");
			}
		} else {
			System.out.println("아이디가 잘못 입력 되었거나 빈값입니다.");
		}

		return null;
	}

}