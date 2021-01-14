package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.VideoController;
import vo.Video;

// view단
// 유저가 보고 조작할수 있는 곳입니다.
// 유저가 볼수 있는 System, Scanner는 여기서만 사용이 가능합니다. 
// 다만 예외처리는 제외됩니다.

public class Main {
	private static VideoController controller = new VideoController();
	private static Scanner sc = new Scanner(System.in);

	// 조건
	// 이전과 같이 로그인은 HashMap을 활용해서 회원가입과 로그인 기능을 만들어보세요
	// 하지만 회원가입 할시 유저와 매니저를 분류합니다.
	// ex) 회원가입 : id-id1 / pw-pw1 / group-user -> HashMap<id1U,pw1>
	// ex) 회원가입 : id-id2 / pw-pw2 / group-manager -> HashMap<id2M,pw2>
	// "1.로그인"시 해당 아이디가 user와 manager서로 구분하여서 user에게 보여주는 화면이 다르게 표현됩니다.
	public static void main(String[] args) {
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1.로그인    2.회원가입   3.종료");
			String num = sc.next();

			// 2. 회원가입에 대한 처리
			if (num.equals("2")) {
				System.out.print("아이디를 입력하세요");
				String id = sc.next();
				System.out.print("비밀번호를 입력하세요");
				String pwd = sc.next();
				System.out.print("USER: 1 MANAGER: 2");
				String option = sc.next();
				
				// 회원가입에 입력한 입력사항들을 controller.userAddController로 값을 넘겨줍니다.
				String message =controller.userAddController(id, pwd, option);
				System.out.println(message);
				
				// 1. 로그인
			} else if (num.equals("1")) {
				
				String option = "";
				System.out.print("USER: 1 MANAGER: 2");
				option = sc.next();
				System.out.print("아이디를 입력하세요");
				String id = sc.next();
				System.out.print("비밀번호를 입력하세요");
				String pwd = sc.next();
				// 로그인에 입력한 입력사항들을 controller.login에 값을 넘겨줍니다.
				// 넘겨주고 로그인 성고하면 return 값은 true를 반환합니다. 하지만 실패하면 false를 반환합니다.
				boolean loging = controller.login(id, pwd, option);
				
				if (loging) {
					System.out.println("로그인을 성공하였습니다.");
					if (option.equals("1")) {
						// user
						while (true) {
							System.out.println("1.비디오대여   2.새로운 비디오 신청   3.로그아웃");
							String numUser = sc.next();
							
							// 비디오 대여하기 전에 비디오 리스트를 출력해서 대여할 비디오 선택을 할수 있도록 한다.
							if(numUser.equals("1")) {	
								ArrayList<Video>v = controller.videoList();
								for(int i=0; i<v.size(); i++) {
									System.out.println("제목 : "+ v.get(i).getVideoName());
									System.out.println("내용 : "+v.get(i).getVideoContent());
									System.out.println("연령제한 : "+v.get(i).getAgeLimit());
								}
								System.out.println("대여하고 싶은 비디오의 제목을 입력해주세요.");
								String videoTitle = sc.next();
								// 비디오 대여에 대한 처리 입니다.
								// 비디오 제목을 입력한 값을 controller.videoRental로 넘겨줍니다.
								// return 값은 boolean입니다. boolean을 이용하여서 대여 여부를 보여줍니다.
								if(controller.videoRental(videoTitle)) {
									System.out.println("대여가 완료되었습니다.");
								}else {
									System.out.println("입력하신 비디오는 없습니다.");
								}
								
								// 새로운 비디오 신청
							}else if(numUser.equals("2")){
								System.out.println("새로운 비디오를 신청하실수 있습니다.");
								System.out.println("제목을 입력하세요.");
								String title = sc.next();
								System.out.println("간략한 내용을 적어주세요.");
								String content = sc.next();
								System.out.println("연령제한을 적어주세요.");
								int agelimit = sc.nextInt();
								
								// 비디오 신청을 위한 내용을 입력 받은값들을 controller.videoRequestAdd로 보냅니다.
								// 이또한 boolean타입으로 return받습니다.  이점을 이용해서 메세지를 출력합니다.
								if(controller.videoRequestAdd(title, content, agelimit)) {
									System.out.println("새로운 비디오를 요청 완료하였습니다.");
								}else {
									System.out.println("새로운 비디오를 요청 실패하였습니다.");
								}
								
							}else if(numUser.equals("3")){
								break;
							}else {
								System.out.println("1,2,3 이외에 숫자나 문자를 입려하지마세요.");
							}

						}
						// manager
					} else if (option.equals("2")) {

						while (true) {
							System.out.println("-------------------------------");
							System.out.println("1.비디오추가   2.비디오신청리스트   3.유저아이디 리스트 보기   4.비디오 리스트 보기   5.종료");
							String numManager = sc.next();
							
							// 비디오추가
							if(numManager.equals("1")) {
								
								System.out.print("비디오 제목을 입력하세요.");
								String title = sc.next();
								System.out.print("비디오 내용을 입력하세요.");
								String content = sc.next();
								System.out.print("연령제한을 입력해주세요.");
								int ageLimit = sc.nextInt();
								System.out.print("해당 비디오는 몇개 추가 하시겠습니까?");
								int videoCnt = sc.nextInt();
								
								// 추가할 비디오에 대한 내용을 Video 객체를 만들어줍니다.
								Video v = new Video(title,content,ageLimit,videoCnt);
								// 만든 객체를 controller.videoAdd로 값을 넘겨줍니다.
								if(controller.videoAdd(v)) {
									System.out.println("비디오 추가가 완료되었습니다.");
								}else {
									System.out.println("비디오 추가 실패하였습니다.");
								}
								// 비디오 신청 리스트
							}else if(numManager.equals("2")) {
								
								// 리스트를 출력해야 하는 사항임이므로 넘겨줄값이 없고,
								// return 값으로  ArryaList<Video>로 받아와서 반복문을 이용해서 출력해줍니다.
								ArrayList<Video> arrVideo = controller.videoRequestList();
								for(int i= 0; i<arrVideo.size(); i++) {
									System.out.println("제목 : "+arrVideo.get(i).getVideoName());
									System.out.println("내용 : "+arrVideo.get(i).getVideoContent());
									System.out.println("연령제한 : " +arrVideo.get(i).getAgeLimit());
									System.out.println("-----------------------------------");
								}
								// 고객 리스트 출력
							}else if(numManager.equals("3")) {
								
								// 유저에 id를 ArrayList<String>로 값을 받아옵니다.
								// 그대로 값을 출력합니다. ex) [id1, id2, id3]
								ArrayList<String> userList = controller.userList();
								System.out.println(userList);
								
								
								// 현재 추가된 비디로 리스트들을 출력합니다.
							}else if(numManager.equals("4")) {
								// 리스트를 출려가하는 것입니다. 넘겨줄 값은 없고 return 값으로는 ArrayList<Video>를 받아와서 반복문을 통해서 출력해줍니다.
								ArrayList<Video>v = controller.videoList();
								for(int i=0; i<v.size(); i++) {
									System.out.println("제목 : "+ v.get(i).getVideoName());
									System.out.println("내용 : "+v.get(i).getVideoContent());
									System.out.println("연령제한 : "+v.get(i).getAgeLimit());
									System.out.println("남은개수 : "+v.get(i).getCnt());
								}
							}else if(numManager.equals("5")) {
								break;
							}
						}
					}

				} else {
					System.out.println("로그인을 실패하였습니다.");
				}

			} else if (num.equals("3")) {
				break;
			} else {
				System.out.println("1번과 2번외에는 작동하지 않습니다.");
			}
		}	
	}
}
