package Review3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoardApplication {
	
	// user에게 값을 받을수 있는 Scanner 생성
	private static Scanner sc = new Scanner(System.in);
	
	// user에 id와 password를 받을 hashMap입니다.
	private static HashMap<String, String> ids = new HashMap<String, String>();
	
	// 게시판들을 생성할수 있는 ArrayList입니다.
	private static ArrayList<Board> boards = new ArrayList<Board>();
	

	
	
	//login 한 ID값 저장
	private static String loginId ; //현재 로그인 중인 아이디를 String 에 저장 후 게시물 작성자로 출력 할 때 씀
	
	
	
	
	
	
	
	
	private static boolean findId(String id) {
		return ids.containsKey(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private static Board newBoard() {// 게시물 작성
		
		System.out.println("-----------------------------------------");
		System.out.println("제목을 입력 해 주세요.");
		System.out.println("-----------------------------------------");
		
		sc.nextLine();//버퍼안에  menu를 초기화 할 때 엔터 라는 개행문자가 남아 있어 한 번 비워주고 실행 
		String title = sc.nextLine();
		String content = "게시물 내용";
		List<String> contents = new ArrayList<String>(); // 게시글 내용을 String 타입으로 list에 저장
		
		System.out.println("게시글 내용을 입력해 주세요.(작성완료를 입력해 주시면 작성이 완료됩니다.");
		System.out.println("-----------------------------------------");
		while(true) {
			content = sc.nextLine();
			if(content.equals("작성완료")) {// 작성완료라는 글이 확인되면 저장하지 않고 종료
				break;
			}
			
			contents.add(content);
		}
		
		Board bd = new Board(title,contents,loginId);
		return bd;
	}
	
	
	
	
	
	
	
	
	
	
	private static void viewBoard() {//모든 게시물 보기 메서드
		
		for(int i=0;i<boards.size();i++) {//보드즈 안에 있는 모든 게시물 출력
			Board bd = boards.get(i);
			System.out.println("-----------------------------------------");
			System.out.println("게시글 번호 : " + (i+1));
			System.out.println("-----------------------------------------");
			System.out.println("제목 : " + bd.getTitle());
			

			System.out.println("-----------------------------------------");
			System.out.println("게시글 내용 :");
			List<String> cts = bd.getContents(); //사용자가 작성한 게시물 String들을 cts에 저장 
			for(int j =0;j<cts.size();j++) {// 저장된 String들을 출력
				System.out.println(cts.get(j));
			}
			
			
			System.out.println("-----------------------------------------");
			System.out.println("작성자 : " + bd.getId());
			
			System.out.println();

		}
	}
	
	
	
	
	
	
	
	
	
	
	private static void memberJoin() {

		
		System.out.println("생성할 아이디를 입력해 주세요.");
		String id = sc.next();
		
		
		if(findId(id)) {
			System.out.println("이미 사용 중인 ID입니다.");
	
		}else {//find 아이디 메서드를 통해 동일 한 아이디가 없으면 실행
			System.out.println("비밀번호를 입력해 주세요.");
			String pwd = sc.next();
			
			ids.put(id,pwd); //키 와 값을 추가
			System.out.println("봉봉월드에 오신 걸 환영합니다.");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	private static boolean listView() {//로그인중인 사용자가 작성 한 게시물이 있는지 확인하는 메서드
		int num = 0; // 작성한 게시물들 출력 후 게시물이 있는지 없는지 확인하기 위한 변수
		for(int i=0;i<boards.size();i++) {
			Board bd = boards.get(i);
			if(bd.getId().equals(loginId)) {
				
				System.out.println("게시물 번호 : " + (i+1) + "  제목 : "+bd.getTitle());
				num = 1;
			}	
		}	
		if(num == 1) {// 작성 한 게시물이 있으면 true 반환
			return true;
		}else {// 작성 한 게시물이 없으면 false 반환
			System.out.println("작성하신 게시물이 존재하지 않습니다.");
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	private static void modifyBoard() {//게시물 수정
		
		if(listView()) {//사용자가 작성한 게시물이 있으면 실행
			try {
				System.out.println("수정하실 게시물 번호를 입력해 주세요.");
				int no = sc.nextInt();
				no = no- 1; // 게시물 번호는 인덱스 번호의 +1 이라 그래서 -1로 수정
				if(boards.get(no).getId().equals(loginId)) {
					Board bd = newBoard();
					boards.set(no, bd);
				}else {
					System.out.println("사용자가 작성한 게시물 번호가 아닙니다.");// 잘못입력했을때
				}
				
				
			}catch(InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("숫자만 입력해 주세요."); // 문자를 입력했을 때
			}catch(IndexOutOfBoundsException e) {
				System.out.println("없는 게시물 번호입니다."); //없는 인덱스 번호를 건들 때
			}
		}
		

	}
	
	
	
	private static void removeBoard() {
		
		if(listView()) {//사용자가 작성한 게시물이 있으면 실행
			try {
				System.out.println("삭제하실 게시물 번호를 입력해 주세요.");
				int no = sc.nextInt();
				no = no- 1; // 게시물 번호는 인덱스 번호의 +1 이라 그래서 -1로 수정
				if(boards.get(no).getId().equals(loginId)) {
					boards.remove(no);
					System.out.println("삭제 되었습니다.");
				}else {
					System.out.println("사용자가 작성한 게시물 번호가 아닙니다.");// 잘못입력했을때
				}
				
				
			}catch(InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("숫자만 입력해 주세요."); // 문자를 입력했을 때
			}catch(IndexOutOfBoundsException e) {
				System.out.println("없는 게시물 번호입니다."); //없는 인덱스 번호를 건들 때
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	private static void loging() {
		boolean run = true;
		
		while(run) {
			// 로그인이 성공하면 아래 문자들을 보여주세요
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 게시글 작성   2. 게시글 보기    3. 게시글 수정    4.게시물 삭제      5. 로그아웃" );
			System.out.println("-------------------------------------------------------");
			
			int menu = sc.nextInt();
			
			
			if(menu == 1) {
				Board bd = newBoard();
				boards.add(bd);				
				System.out.println("게시물이 올라갔습니다.");
			}else if(menu == 2) {
				viewBoard();
			}else if(menu == 3) {
				modifyBoard();
			}else if(menu == 4){
				removeBoard();				
			}else if(menu == 5){
				System.out.println("로그아웃 합니다.");
				run = false;
			}else {
				System.out.println("없는 메뉴는 없니다. 다시 입력해주세요.");
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	private static void login() {
		System.out.println("-----------------------------");
		System.out.println("아이디를 입력 해 주세요.");
		String id = sc.next();
		
		if(findId(id)==true) {// 아이디 조회 후 있으면 실행
			System.out.println("-----------------------------");
			System.out.println("비밀번호를 입력 해 주세요.");
			String pwd = sc.next();
			if(ids.get(id).equals(pwd)) {// 해당 아이디 키 에 맞는 값이면 로그인
				System.out.println("로그인에 성공했습니다.");
				loginId = id; //현재 로그인중인 아이디 값 초기화
				loging(); //로그인 메서드 실행

				
			}else {
				System.out.println(ids.get(id));
				System.out.println("비밀번호가 틀렸습니다.");
			}
			
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// user 아이디와 비밀번호는 hashMap를 활용하여서 생성하세요
		// 게시판은 ArrayList를 활용하여서 생성하세요.
		// 게시판 생성은 로그인이 하였을때만 가능합니다.
		// 해당 코드는 고정되지 않았으며 바꾸셔도 용의합니다.
		// 바꾸신 내용은 codeReview시간에 같이 말씀 부탁드립니다.
		
		boolean run = true;
		
		while (run) {//기존에 스위치문을 사용할 때 다른 숫자를 입력했을 때 처리가 힘들어서 if문으로 변경

			try {
				System.out.println("-----------------------------------------");
				System.out.println("1.로그인   2. 회원가입   3.게시글보기   4. 종료  " );
				System.out.println("-----------------------------------------");
				
				
				int menu = sc.nextInt();
				if(menu == 1) {
					login();
				}else if(menu == 2) {
					memberJoin();
				}else if(menu == 3) {
					viewBoard();
				}else if(menu == 4) {
					System.out.println("시스템을 종료합니다.");
					run = false;
				}else {
					System.out.println("존재하지 않는 메뉴입니다.");
				}
				
			}catch(InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("존재하지 않는 메뉴입니다.");
			}
			
		}
	}
	
}