package Review2;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentApplication {

	static List<Student> ban = new ArrayList<>();
	static List<List<Student>> school = new ArrayList();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		

		
		boolean run = true;
		
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.반생성    2.학생추가    3.학생제거    4.학생수정    5.평균    6.합계    7.학생 리스트");
			System.out.println("---------------------------------------------------------");
			String menu = sc.next();
			
			
			if(menu.equals("1")) {		
				classAdd();
			}else if(menu.equals("2")) {
				studentAdd();
			}else if(menu.equals("3")) {
				remove();
			}else if(menu.equals("4")) {
				update();
			}else if(menu.equals("5")) {
				avg();
			}else if(menu.equals("6")) {
				sum();
			}else if(menu.equals("7")) {
				all();
			}else { 	
				System.out.println("해당 메뉴가 존재하지 않습니다.");
			}
		}
		
		
			
	}//메인메소드
	
	
	
	public static void classAdd() {
		System.out.println("반 생성 ");
		List<Student> ban2 = new ArrayList<>();
		school.add(ban2);
		System.out.println(school.size() + " 반");
		
	}
	
	public static void studentAdd() {//학생추가
		
		try {
			for(int i=0;i<school.size();i++) {//현재 생성된 반 출력
				System.out.print((i+1) + "반 , ");
			}
			
			
			System.out.println(" ");
			System.out.println("원하시는 반을 입력해 주세요.");
			
			
			int classNo = sc.nextInt();
			
			
			if(school.size() >= classNo) {//입력한 반이 school 리스트에 존재하는지 확인
				System.out.println("이름을 입력하세요.");
				String name = sc.next();
				System.out.println("나이를 입력하세요.");
				int age = sc.nextInt();
				System.out.println("국어 점수를 입력하세요.");
				int korScore = sc.nextInt();
				System.out.println("영어 점수를 입력하세요.");
				int engScore = sc.nextInt();
				System.out.println("수학 점수를 입력하세요.");
				int mathScore = sc.nextInt();

				Student st = new Student(classNo,name,age,korScore,engScore,mathScore);//학생정보
				
				
				
				school.get(classNo-1).add(st);//반 리스트에 학생들정보를 가져와 학생정보 추가
				
				
				
				System.out.println(" 반 : " + st.getClassNo()+" 이름 : " + st.getName() + " 나이 : " + st.getAge());
				System.out.println(" 국어 : " + st.getKorScore()+" 영어 : " + st.getEngScore() + " 수학 : " + st.getMathScore());
				
			}else {
				System.out.println("존재하지 않는 반입니다.");
			}
		}catch(InputMismatchException e) {
			System.out.println("숫자만 입력해 주세요.");
		}
		
		
	}
	
	
	
	
	public static void remove() {//제거메서드
		System.out.println("학생정보를 제거 할 이름을 적어주세요.");
		String name = sc.next();
		
		Student st = findStudent(name);
		if(st != null) {
			for(int i =0;i<school.size();i++) {//각 반을 만큼 돌리는 반복문
				school.get(i).remove(st); //각 반마다 꺼내 온 학생이름이 있으면 제거
			}
			System.out.println("삭제완료");
		}else {
			System.out.println("존재하지 않는 학생입니다.");
		}
	}
	
	
	public static void update() {//수정메서드
		System.out.println("수정 할 학생 이름을 적어주세요.");
		String name = sc.next();
		
		Student st = findStudent(name);
		if(st != null) {
			System.out.println("국어 점수를 입력하세요.");
			int korScore = sc.nextInt();
			System.out.println("영어 점수를 입력하세요.");
			int engScore = sc.nextInt();
			System.out.println("수학 점수를 입력하세요.");
			int mathScore = sc.nextInt();
			
			st.setKorScore(korScore);
			st.setEngScore(engScore);
			st.setMathScore(mathScore);
			
			System.out.println("수정완료");
			System.out.println(" 반 : " + st.getClassNo()+" 이름 : " + st.getName() + " 나이 : " + st.getAge());
			System.out.println(" 국어 : " + st.getKorScore()+" 영어 : " + st.getEngScore() + " 수학 : " + st.getMathScore());
			
		}else {
			System.out.println("존재하지 않는 학생입니다.");
		}
		
	}
	
	
	
	
	
	public static void sum() {//합계
		System.out.println("합계점수를 볼 학생 이름을 적어주세요.");
		String name = sc.next();
		
		Student st = findStudent(name);
		if(st != null) {
			
			int sum = st.getKorScore() + st.getEngScore() + st.getMathScore();

			
			System.out.println(" 합계점수 : " + sum);
			System.out.println(" 반 : " + st.getClassNo()+" 이름 : " + st.getName() + " 나이 : " + st.getAge());
			System.out.println(" 국어 : " + st.getKorScore()+" 영어 : " + st.getEngScore() + " 수학 : " + st.getMathScore());
			
		}else {
			System.out.println("존재하지 않는 학생입니다.");
		}
	}
	
	
	
	
	
	public static void avg() {//평균
		System.out.println("평균점수를 볼 학생 이름을 적어주세요.");
		String name = sc.next();
		
		Student st = findStudent(name);
		if(st != null) {
			
			double avg = ((double)st.getKorScore() + (double)st.getEngScore() + (double)st.getMathScore())/3 ;

			
			System.out.println(" 평균점수 : " + avg);
			System.out.println(" 반 : " + st.getClassNo()+" 이름 : " + st.getName() + " 나이 : " + st.getAge());
			System.out.println(" 국어 : " + st.getKorScore()+" 영어 : " + st.getEngScore() + " 수학 : " + st.getMathScore());
			
		}else {
			System.out.println("존재하지 않는 학생입니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void all() {//각 반에 존재하는 학생들 정보 출력
		for(int i=0;i<school.size();i++) {//school 리스트 사이즈 만큼 돌려서 각반 반복문
			List<Student> cl;
			System.out.println((i+1) + "반" );
			cl = school.get(i);
			for(int j = 0;j<cl.size();j++) {//각 반에 있는 학생들 정보 출력
				Student st = cl.get(j);
				System.out.println("이름 : "+st.getName() +" 나이 : "+ st.getAge());
			}
		}
	}
	
	
	
	public static Student findStudent(String name) {// 학생찾기

		try {
			for(int i=0;i<school.size();i++) {
				List<Student> cl = school.get(i);
				for(int j=0;j<cl.size();j++) {
					Student st = cl.get(j);
					if(name.equals(st.getName())) {
						return st; //이름이 같으면 해당 객체를 내보냄
					}
				}
				
			}
		}catch (IndexOutOfBoundsException e) {//배열의 값보다 더 많은 일을 했을 때 예외처리
		}
		
		return null;
	}
	
	
	
	
	
}