package boardPackage;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.naming.spi.DirStateFactory.Result;

import java.util.Scanner;

public class BoardApplication {

	// user에게 값을 받을수 있는 Scanner 생성
	private static Scanner scanner = new Scanner(System.in);

	// user에 id와 password를 받을 hashMap입니다.
	private static HashMap<String, String> ids = new HashMap<String, String>();

	// 게시판들을 생성할수 있는 ArrayList입니다.
	private static ArrayList<Board> boards = new ArrayList<Board>();

	private static String sessionId = "";

	private static void login() {
		System.out.println("아이디를 입력하세요 > ");
		String id = scanner.nextLine();

		System.out.println("비밀번호를 입력하세요 >  ");
		String pwd = scanner.nextLine();

		for (Entry<String, String> entry : ids.entrySet()) {
			String result = "";
			// 로그인 성공
			if (entry.getKey().equals(id) && entry.getValue().equals(pwd)) {
				System.out.println("로그인 성공");
				sessionId = id;
				while (true) {
					// 로그인이 성하면 아래 문자들을 보여주세요
					System.out.println("-----------------------------");
					System.out.println("1. 게시글 작성   2. 게시글 보기   3. 로그아웃");
					System.out.println("-----------------------------");
					String menu = scanner.nextLine();

					switch (menu) {
					case "1":
						// 게시글 작성
						creatBoard();
						break;
					case "2":
						// 게시글 보기
						listBoard();
						break;
					case "3":
						// 로그아웃
						result = "quit";
						break;
					}
					if (result.equals("quit")) {
						break;
					}
				}

			}
			
		}
		
	}

	// 2. 회원가입
	private static void singup() {

		// 아이디 입력후에 같은 아이디 있는지 확인하는 반복문으로 한번 검사합니다.
		System.out.println("아이디를 입력하세요. >");
		String id = scanner.nextLine();
		String result = null;

		for (Entry<String, String> entry : ids.entrySet()) {
			if (entry.getKey().equals(id)) {
				result = "해당아이디가 있습니다.";
				break;
			}
		}

		if (result != null) {
			System.out.println(result);
		} else {
			System.out.println("비밀번호를 입력하세요. >");
			String pw = scanner.nextLine();

			ids.put(id, pw);
			System.out.println("회원 가입이 완료되었습니다.");
		}

	}

	// 3.게시글 작성
	private static void creatBoard() {
		String content = "";
		System.out.println("제목을 입력하세요. >");
		String title = scanner.nextLine();
		// 게시글 작성내용에 '작성완료'를 입력하지 않으면 무한 반복으로 게시글 내용을 입력할 수 있습니다.
		while (true) {
			
			System.out.println("내용을 입력해주세요. ('작성완료' 입력하시면 작성이 안료됩니다.) >");
			String immContent = scanner.nextLine();
			if (immContent.equals("작성완료")) {
				break;
			} else {
				//게시글 내용에 마지막에 TT를 적용합니다. 
				//추후에 "TT"를 기준으로 split할 예정입니다.
				content += immContent + "TT";
			}
		}

		Board board = new Board(title, content, sessionId);
		boards.add(board);
	}

	// 4.게시글 보기
	private static void listBoard() {
		// board arraylist 비어있는지 확인
		if (!boards.isEmpty()) {
			
			for (int i = 0; i < boards.size(); i++) {
				// 게시글 내용을 담을 배열
				String[] immContent = new String[10];
				System.out.println(boards.get(i).getTitle());
				String content = boards.get(i).getContent();
				// 게시글 내용에 'TT'를 기준으로 split를 사용해서 enter를 적용시켜준다.
				immContent = content.split("TT");

				// 게시글 내용에 enter를 적용시킨다.
				for (int j = 0; j < immContent.length; j++) {
					System.out.print(immContent[j]);
					System.out.println();
				}
				System.out.println(boards.get(i).getId());
				System.out.println("----------------------------");
				System.out.println();
			}
		}else {
			System.out.println("작성된 게시물이 없습니다.");
		}
	}

	// 회원 리스트를 출력합니다.
	private static void memberList() {
		System.out.println("회원 리스트");
		// HashMap ids를 for문을 돌려서 리스트를 출력합니다.
		for (Entry<String, String> entry : ids.entrySet()) {
			System.out.println(entry.getKey());

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
			String menu = scanner.nextLine();

			switch (menu) {
			case "1":
				login();
				break;
			case "2":
				singup();
				break;
			case "3":
				listBoard();
				break;
			case "4":
				System.out.println("시스템을 종료합니다.");
				break;
			case "5":
				memberList();
				break;
			}
			if (menu.equals("4")) {
				break;
			}
		}
	}

}
