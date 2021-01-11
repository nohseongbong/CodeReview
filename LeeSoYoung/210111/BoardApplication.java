package codeReview20200111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class BoardApplication {

	// user에게 값을 받을수 있는 Scanner 생성
	private static Scanner scanner = new Scanner(System.in);

	// user에 id와 password를 받을 hashMap입니다.
	private static HashMap<String, String> ids = new HashMap<String, String>();

	// 게시판들을 생성할수 있는 ArrayList입니다.
	private static ArrayList<Board> boards = new ArrayList<Board>();
	static boolean run = true;
	private static String stId = "";

	public static void memberJoin() {
		System.out.println("-----------------");
		System.out.println("------회 원 가 입-----");
		System.out.println("-----------------");

		System.out.println("아이디를 입력하여 주십시오");
		String id = scanner.next();
		System.out.println("비밀번호를 입력하여 주십시오");
		String pwd = scanner.next();
		// 아이디 중복체크

		// ids hashMap안에 있는 map을 불러와서 아이디를 반복하는 함수입니다,
		// 이반복문안에 조건문을 사용하여서 사용자가 입력하는 id와 hashmap안에 있는 아이디가 있는지 없는지 확인해서
		// 조건문을 처리하세요.

		// ids hashMap이 비어있으면 그냥 넣어줌
		if (ids.isEmpty()) {
			ids.put(id, pwd);
			// ids hashMap이 비어있을경우 for문이 안돌아가므로 조건문을 사용해서 해결해줌
		} else {
			for (Entry<String, String> entry : ids.entrySet()) {
				// 중복된 아읻 체크
				if (entry.getKey().equals(id)) {
					System.out.println("이미생성되었습니다.");
				} else {
					// 입렵받은 id pwd의 값을 HashMap 저장
					ids.put(id, pwd);
					System.out.println("id:" + id);
					System.out.println("회원가입되었습니다.");

				}

			}
		}

	}

	private static void login() {
		System.out.println("아이디를 입력하여 주십시오");
		String id = scanner.next();
		System.out.println("비밀번호를 입력하여 주십시오");
		String pwd = scanner.next();
		try {
			for (Entry<String, String> entry : ids.entrySet()) {
				if (entry.getKey().equals(id)) {
					stId = id;
					System.out.println("[id]:" + id + "로그인이성공되었습니다");

					// 로그인이 성공하면 아래 문자들을 보여주세요
					while (run) {
						System.out.println("-----------------------------");
						System.out.println("1. 게시글 작성   2. 나의 게시글 보기  3. 게시글 수정   4.게시글 삭제   5.탈퇴  6.로그아웃");
						System.out.println("-----------------------------");

						String menu = scanner.next();
						if (menu.equals("1")) {
							createMessage();
						} else if (menu.equals("2")) {
							messageView(id);
						} else if (menu.equals("3")) {
							messageUpdate();
						} else if (menu.equals("4")) {
							messageDelete();
						} else if (menu.equals("5")) {
							idDelete(id);
						} else if (menu.equals("6")) {
							break;
						}
					}
				}
			}
		} catch (NullPointerException e) {

		}
	}

	public static void createMessage() {
		System.out.print("제목 입력>");
		String title = scanner.next();
		System.out.print("내용 입력>");
		String content = scanner.next();
		// HashMap 클래스 내부구조로 Set 자료구조에 key를 보관한 객체가 존재한다.
		// Set 객체를 통해 key를 가져오는 것이다.
		// Set set = ids.keySet();

		String id = stId;
		Board board = new Board(title, content, id);
		boards.add(board);

		System.out.println("제목입력>" + title + "\n내용>" + content + "\nid>" + id);

	}

	public static void messageView(String id) {
		for (int i = 0; i < boards.size(); i++) {
			String mv = boards.get(i).getId();
			if (mv.equals(id)) {
				System.out.println("제목입력>" + boards.get(i).getTitle() + "\n내용>" + boards.get(i).getContent() + "\nid>"
						+ boards.get(i).getId());
			}
		}

	}

	public static void allView() {
		for (Board boards1 : boards)
			System.out
					.println("제목입력>" + boards1.getTitle() + "\n내용>" + boards1.getContent() + "\nid>" + boards1.getId());

	}

	public static void messageUpdate() {
		System.out.print("제목 입력>");
		String title = scanner.next();

		for (int i = 0; i < boards.size(); i++) {
			String mv = boards.get(i).getTitle();
			if (mv.equals(title)) {
				System.out.print("제목 수정>");
				String titleUpdate = scanner.next();
				System.out.print("내용 수정>");
				String contentUpdate = scanner.next();

				Board b = new Board(titleUpdate, contentUpdate, boards.get(i).getId());
				boards.set(i, b);
				System.out.println("제목>" + boards.get(i).getTitle() + "\n내용" + boards.get(i).getContent());
			}

		}
	}

	public static void messageDelete() {
		for (int i = 0; i < boards.size(); i++) {
			String mv = boards.get(i).getTitle();
			String getId = boards.get(i).getId();
			// 제목을 입력받고, id도 입력받아서 삭제하는 방향으로
			// id 를 입력받는다
			System.out.println("id를 입력하시오");
			String id = scanner.next();
			// 제목을 입력받는다.
			System.out.println("제목을 입력하시오");
			String title = scanner.next();

			if (mv.equals(title) && getId.equals(id)) {
				// 지워!!
				boards.remove(i);
				System.out.println("게시글 : " + mv + "게시글이 삭제되었습니다");
			}
		}
	}

	public static void idDelete(String id) {
		for (int i = 0; i < boards.size(); i++) {
			String mv = boards.get(i).getId();
			if (mv.equals(id)) {
				boards.remove(id);
				System.out.println("id:" + id + "삭제되었습니다.");
			}
		}
	}

	public static void main(String[] args) {
		// user 아이디와 비밀번호는 hashMap를 활용하여서 생성하세요
		// 게시판은 ArrayList를 활용하여서 생성하세요.
		// 게시판 생성은 로그인이 하였을때만 가능합니다.
		// 해당 코드는 고정되지 않았으며 바꾸셔도 용의합니다.
		// 바꾸신 내용은 codeReview시간에 같이 말씀 부탁드립니다.

		while (true) {

			System.out.println("-----------------------------------------");
			System.out.println("1.로그인   2. 회원가입   3.게시글보기   4. 종료");
			System.out.println("-----------------------------------------");
			int menu = scanner.nextInt();

			switch (menu) {
			case 1:
				login();
				break;
			case 2:
				memberJoin();
				break;
			case 3:
				allView();
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