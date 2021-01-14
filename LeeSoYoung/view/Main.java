package view;

import java.util.Scanner;

import controller.VideoController;

// view단
// 유저가 보고 조작할수 있는 곳입니다.
// 유저가 볼수 있는 System, Scanner는 여기서만 사용이 가능합니다. 
// 다만 예외처리는 제외됩니다.

public class Main {
	private static VideoController controller = new VideoController();
	private static Scanner sc = new Scanner(System.in);
	public static String option = "";

	// 조건
	// 이전과 같이 로그인은 HashMap을 활용해서 회원가입과 로그인 기능을 만들어보세요
	// 하지만 회원가입 할시 유저와 매니저를 분류합니다.
	// ex) 회원가입 : id-id1 / pw-pw1 / group-user -> HashMap<id1U,pw1>
	// ex) 회원가입 : id-id2 / pw-pw2 / group-manager -> HashMap<id2M,pw2>
	// "1.로그인"시 해당 아이디가 user와 manager서로 구분하여서 user에게 보여주는 화면이 다르게 표현됩니다.
	public static void main(String[] args) {
		while (true) {

			System.out.println("-------------------------------");
			System.out.println("1.로그인    2.회원가입");
			int num = sc.nextInt();
			if (num == 2) {
				// 2. 회원가입에 대한 처리
				System.out.print("아이디를 입력하세요");
				String id = sc.next();
				System.out.print("비밀번호를 입력하세요");
				String pwd = sc.next();
				System.out.print("USER: 1 MANAGER: 2");
				String option = sc.next();
				boolean addresult = controller.userAddController(id, pwd, option);
				if (addresult) {
					System.out.println("회원가입 되었습니다.");
				} else {
					System.out.println("회원가입 실패했습니다.");
				}
			} else if (num == 1) {
				// 로그인 관련 처리
				System.out.println("--------로그인-------");
				System.out.print("USER: 1 MANAGER: 2");
				String option = sc.next();
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pwd = sc.next();
				boolean result = controller.userLogin(id, pwd, option);// true

				// 성공
				System.out.println(result);

				if (result == true) {

					if (option.equals("1")) {
						//// "1.비디오 대여"선택시 비디오 리스트 출력후 유저가 비디오를 선택할 수 있도록 하세요.
						System.out.println("1.비디오 신청");
						System.out.println("대여할 비디오 제목을 입력해주세요");
						String videoName = sc.next();
						controller.requestVideo(videoName);

					} else if (option.equals("2")) {
						//// "1.로그인" - manager인 경우
						System.out.println("1.비디오신청리스트 ");
						num = sc.nextInt();
						if (num == 1) {
							System.out.println("신청된 비디오 리스트");
							String videoList = controller.listRequest();
							System.out.println(videoList);
						}
					}

				} else if (result = false) {
					System.out.println("로그인 실패");// 로그인
				}

			}
		}
	}
}
// "1.로그인" - user인 경우
// "1.비디오 대여"선택시 비디오 리스트 출력후 유저가 비디오를 선택할 수 있도록 하세요.
// System.out.println("1.비디오대여 2.새로운 비디오 신청");

// "1.로그인" - manager인 경우
// System.out.println("1.비디오추가 2.비디오신청리스트 ");
