package studentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApplication {
//	private static Student[][] students = new Student[][];
	private static List<Student> students = new ArrayList<Student>();
	private static Scanner sc = new Scanner(System.in);
	private static int ban;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.반생성    2.학생추가    3.학생제거    4.학생수정    5.평균    6.합계    7.학생리스트");
			System.out.println("---------------------------------------------------------");

			String menu = sc.nextLine();

			if (menu.equals("1")) {
				createClass();
			} else if (menu.equals("2")) {
				studentAdd();
			} else if (menu.equals("3")) {
				remove();
			} else if (menu.equals("4")) {
				modify();
			} else if (menu.equals("5")) {
				average();
			} else if (menu.equals("6")) {
				sum();
			} else if (menu.equals("7")) {
				studentList();
			} else {
				break;
			}
		}

	}

	private static void createClass() {
		System.out.print("생성할 반의 갯수를 정해주세요");
		String eban = sc.nextLine();
		ban = Integer.parseInt(eban);
	}

	private static void studentAdd() {
		try {
		System.out.println("학생을 추가해 주세요");
		System.out.print("학생의 반번호:");
		String eClassNo = sc.nextLine();
		int classNo = Integer.parseInt(eClassNo);
		System.out.print("학생 이름:");
		String name = sc.nextLine();
		System.out.print("학생 나이:");
		String eAge = sc.nextLine();
		int age = Integer.parseInt(eAge);
		System.out.println("학생의 성적을 입력해주세요");
		System.out.print("국어 점수 :");
		String eKor = sc.nextLine();
		int korScore = Integer.parseInt(eKor);
		System.out.print("영어 점수:");
		String eEng = sc.nextLine();
		int engScore = Integer.parseInt(eEng);
		System.out.print("수학 점수:");
		String eMath = sc.nextLine();
		int mathScore = Integer.parseInt(eMath);
	
		if (classNo == 0 || classNo > ban) {
			System.out.println("해당 반이 존재하지 않습니다.");
		}else {
			students.add(new Student(classNo, name, age, korScore, engScore, mathScore));
		}	
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력세요");
			}
	
	}

	private static void remove() {
		System.out.print("학생 이름:");
		String name = sc.nextLine();
		int idx = pick(name);
		students.remove(idx);

	}

	private static void modify() {
		System.out.print("학생 이름:");
		String name = sc.nextLine();
		int idx = pick(name);
		Student st = students.get(idx);
		try {
			System.out.println("수정할 학생의 정보를 입력하세요");
			System.out.print("학생의 반번호:");
			String eClassNo = sc.nextLine();
			int classNo = Integer.parseInt(eClassNo);
			System.out.print("학생 이름:");
			String sname = sc.nextLine();
			System.out.print("학생 나이:");
			String eAge = sc.nextLine();
			int age = Integer.parseInt(eAge);
			System.out.println("학생의 성적을 입력해주세요");
			System.out.print("국어 점수 :");
			String eKor = sc.nextLine();
			int korScore = Integer.parseInt(eKor);
			System.out.print("영어 점수:");
			String eEng = sc.nextLine();
			int engScore = Integer.parseInt(eEng);
			System.out.print("수학 점수:");
			String eMath = sc.nextLine();
			int mathScore = Integer.parseInt(eMath);

			Student ch = new Student(classNo, sname, age, korScore, engScore, mathScore);
			students.set(idx, ch);

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력세요");
		}
	}

	private static void average() {
		for (int i = 0; i < students.size(); i++) {
			int sum = students.get(i).getKorScore() + students.get(i).getEngScore() + students.get(i).getMathScore();
			System.out.println(students.get(i).getName() + "의 총점 : " + sum / 3);
		}
	}

	private static void sum() {
		for (int i = 0; i < students.size(); i++) {
			int sum = (students.get(i).getKorScore()) + (students.get(i).getEngScore())
					+ (students.get(i).getMathScore());
			System.out.println(students.get(i).getName() + "의 총점 : " + sum);
		}

	}

	private static void studentList() {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("이름: " + students.get(i).getName() + "나이: " + students.get(i).getAge() + "국어점수: "
					+ students.get(i).getKorScore() + "영어점수: " + students.get(i).getEngScore() + "수학점수:"
					+ students.get(i).getMathScore());
		}

	}

	private static int pick(String name) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {

				return i;
			}
		}
		return 0;

	}

}