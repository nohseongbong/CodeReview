package view;

// view단
// 유저가 보고 조작할수 있는 곳입니다.
// 유저가 볼수 있는 System, Scanner는 여기서만 사용이 가능합니다. 
// 다만 예외처리는 제외됩니다.

public class Main {
	
	// 조건
	// 이전과 같이 로그인은 HashMap을 활용해서 회원가입과 로그인 기능을 만들어보세요
	// 하지만 회원가입 할시 유저와 매니저를 분류합니다.
	// ex) 회원가입 : id-id1 / pw-pw1 / group-user -> HashMap<id1U,pw1>
	// ex) 회원가입 : id-id2 / pw-pw2 / group-manager -> HashMap<id2M,pw2>
	// "1.로그인"시 해당 아이디가 user와 manager서로 구분하여서 user에게 보여주는 화면이 다르게 표현됩니다.
	public static void main(String[] args) {
		System.out.println("1.로그인    2.회원가입");
		
		
		// "1.로그인" - user인 경우
		// "1.비디오 대여"선택시 비디오 리스트 출력후 유저가 비디오를 선택할 수 있도록 하세요.
		System.out.println("1.비디오대여   2.새로운 비디오 신청");
		
		
		// "1.로그인" - manager인 경우
		System.out.println("1.비디오추가   2.비디오신청리스트   3.블랙리스트추가   4. 회원정보 수정");
		
	}
}
