package boardPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardApplication {
	
	// user에게 값을 받을수 있는 Scanner 생성
	private static Scanner scanner = new Scanner(System.in);
	
	// user에 id와 password를 받을 hashMap입니다.
	private static HashMap<String, String> ids = new HashMap<String, String>();
	
	// 게시판들을 생성할수 있는 ArrayList입니다.
	private static ArrayList<Board> boards = new ArrayList<Board>();
	
	
	private static void login() {
		// 로그인이 성하면 아래 문자들을 보여주세요
		System.out.println("-----------------------------");
		System.out.println("1. 게시글 작성   2. 게시글 보기");
		System.out.println("-----------------------------");
		
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
			
			switch(menu) {
			case 1:
				login();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.out.println("시스템을 종료합니다.");
				break;
			}
			if(menu ==4) {
				break;
			}
		}
	}
	
}
