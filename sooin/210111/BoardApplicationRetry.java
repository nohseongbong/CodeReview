package boardPackage;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardApplicationRetry {

	// user에게 값을 받을수 있는 Scanner 생성
	private static Scanner sc = new Scanner(System.in);

	// user에 id와 password를 받을 hashMap입니다.
	private static HashMap<String, String> ids = new HashMap<String, String>();

	// 게시판들을 생성할수 있는 ArrayList입니다.
	private static ArrayList<Board> boards = new ArrayList<Board>();

	// ids정보와 Board를 묶어주는 hashMap

	private static void signup() {// 회원가입 메소드

		while (true) {
			System.out.println("-------회원가입-------");
			System.out.print("생성할 아이디를 입력해주세요");
			String id = sc.next();
			if (!ids.containsKey(id)) {//ids에 같은 id가 입력되지 않는다면 실행.
				System.out.print("비밀번호를 입력해주세요");
				String pwd = sc.next();
				System.out.print("비밀번호를 확인해주세요");
				String pwd2 = sc.next();
				if (pwd.equals(pwd2)) {// 입력한 비밀번호가 같으면 회원가입 완료
					ids.put(id, pwd);// 아이디와 비밀번호 값 저장.
					System.out.println("회원가입되었습니다.");
					break;
				} else {
					System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
					System.out.println("회원가입을 다시 해 주세요.");// 패스워드가 같지 않으면 재실행
					System.out.println();
					continue;
				}

			}else {//아이디가 이미 저장되어있다면 회원가입 재시도
				System.out.println("이미 생성된 아이디입니다.");
				System.out.println("다른 아이디로 회원가입을 해주세요.");
				System.out.println();
				continue;
			}

		}
	}

	private static void login() {// 로그인 메소드
		String comid;
		boolean run = true;
		// 로그인
		while (true) {

			System.out.println("-------로그인-------");
			System.out.print("아이디를 입력해주세요 :");
			String cid = sc.next();
			System.out.print("비밀번호를 입력해주세요 :");
			String cpwd = sc.next();

			if (!ids.containsKey(cid)) {// 입력받은 cid가 ids의 key값으로 입려되지 않았을 때
				System.out.println("해당 아이디가 존재하지 않습니다.");
				System.out.println("다시 확인해 주시기 바랍니다.");
				continue;// 다시 로그인
			} else {// id가 존재할 경우
				if (!ids.get(cid).equals(cpwd)) {// 입력받은 아이디의 value값이 입력받은 패스와드와 일치하지 않을 떄
					System.out.println("패스워드를 잘못 입력하였습니다.");
					continue;// while문 반복수행
				} else {
					System.out.println("로그인 성공!");
					comid = cid;// 로그인 된 아이디 -> comid
					break;// while문 빠져나감
				}
			}
		}

		while (run) {
			// 로그인이 성공하면 아래 문자들을 보여주세요
			System.out.println("-----------------------------------");
			System.out.println("1. 게시글 작성   2. 게시글 보기   3. 로그아웃");
			System.out.println("-----------------------------------");
			// 1.게시글 작성 : 새로운 게시글 작성, 게시물 제목, 내용 , 게시글작성자를 저장.
			// 게시물 내용은 while문으로 받는다.
			// 2.게시글 보기 : 내가 쓴 게시물을 리스트로 볼 수 있음.
			System.out.print("실행할 작업을 선택하세요 >");
			int num = sc.nextInt();//수행할 작업 선택

			switch (num) {

			case 1:

				String title;
				String content = null;
				String eContent;

					System.out.println("게시글 작성");
					System.out.print("제목 : ");
					title = sc.next();// 제목입력
					System.out.println("내용 작성 완료시 '끝'를 입력하여 종료하세요.");
					System.out.println("내용 >");

					do {
						eContent = sc.next();
						 content = content +"\n" + eContent;

					} while (!eContent.equals("끝"));

				Board writing = new Board(title, content, comid);
				boards.add(writing);// arraylist 안에 객체저장.
				
				break;

			case 2:
				System.out.println("내가 생성한 게시글");// 내가 생성한 게시글의 제목을 보여줌.
				for (int i = 0; i < boards.size(); i++) {
					String id = boards.get(i).getId();//id에 board에 저장된 id를 뺀다.
					if (id.equals(comid)) {//꺼낸 아이디와 입력한 아이디를 비교
						System.out.println(boards.get(i).getTitle());//아이디가 같다면 같은 id가 저장된 객체에서 title을 꺼낸다.
					}
				}

				break;
			case 3:
				run = false;//while문 종료하여 로그아웃.

			}

		}
	}

	public static void showAll() {
		for(int i = 0; i<boards.size();i++) {
			System.out.print("제목 : ");
			System.out.println(boards.get(i).getTitle());
			System.out.println("----내용----");
			System.out.println(boards.get(i).getContent());
			System.out.print("작성자 : ");
			System.out.println(boards.get(i).getId()+"\n");
			
		}


	}

	public static void main(String[] args) {
		// user 아이디와 비밀번호는 hashMap를 활용하여서 생성하세요
		// 게시판은 ArrayList를 활용하여서 생성하세요.
		// 게시판 생성은 로그인이 하였을때만 가능합니다.
		// 해당 코드는 고정되지 않았으며 바꾸셔도 용의합니다.
		// 바꾸신 내용은 codeReview시간에 같이 말씀 부탁드립니다.

		while (true) {

			System.out.println("------------------------------------");
			System.out.println("1.로그인   2. 회원가입   3.게시글보기   4. 종료");
			System.out.println("------------------------------------");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				login();
				break;
			case 2:
				signup();
				break;
			case 3:// 타인이 적은 게시물까지 볼 수있음.\
				showAll();
				break;
			case 4:
				System.out.println("시스템을 종료합니다.");
				break;
			}
			if (menu == 4) {
				break;
			}
		}
	}

}
