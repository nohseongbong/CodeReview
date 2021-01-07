package codeReview200107;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApplication {
	public static ArrayList<Student> students = new ArrayList<Student>(); // 학생저장소

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int sum = 0;
		boolean run = true;

		while (run) {
			System.out.println("---------------------------------------------------------");
			System.out.println("1.반생성    2.학생추가    3.학생제거    4.학생수정    5.평균    6.합계    7.학생리스트   8.종료");
			System.out.println("---------------------------------------------------------");
			String menu = sc.next();

			if (menu.equals("1")) {
				studentClass();
			} else if (menu.equals("2")) {
				studentInsert();
			} else if (menu.equals("3")) {
				studentDelete();
			} else if (menu.equals("4")) {
				studentUpdate();
			} else if (menu.equals("5")) {
				studentAverage();
			} else if (menu.equals("6")) {
				studentSum();
			} else if (menu.equals("7")) {
				studentList();
			} else if (menu.equals("8")) {
				run = false;
			}
		}
		System.out.println("프로그램이 종료됩니다.");

	}

	public static void studentClass() {
		System.out.println("=========");
		System.out.println(" 랜덤 반을 생성하세요 ");
		System.out.println("=========");

		System.out.println("반을 랜덤으로 돌립니다.(1반,2반,3반)");
		for (int i = 0; i < students.size(); i++) {
			int j = (int) ((Math.random() * 3) + 1);

			if (students.get(i).getClassNo() == 0) {
				students.get(i).setClassNo(j);
				Student student = students.get(i);
				System.out.println(
						"반 : " + j + "반  / " + "학생이름 : " + student.getName() + " / " + "나이 : " + student.getAge());
			} else {
				System.out.println("이미 반이 생성되었습니다.");
			}
		}
	}

	public static void studentInsert() {
		System.out.println("=========");
		System.out.println(" 학 생 추 가 ");
		System.out.println("=========");

		System.out.println("학생이름을 입력하여 주십시오");
		String name = sc.next();
		// System.out.println("반을 입력하여 주십시오");
		// int classNo = sc.nextInt();
		System.out.println("나이를 입력하여 주십시오");
		int age = sc.nextInt();
		if (name.equals("") || name == null || age == 0) {
			System.out.println("다시입력하여 주십시오");
		}
		Student student = new Student(name, age);
		if (student != null) {
			students.add(student);
			System.out.println("학생이 추가되었습니다.");
		}
		System.out.println("학생정보가 생성되지 않았습니다. 다시 입력하여 주십시오");

	}

	public static void studentDelete() {
		System.out.println("=========");
		System.out.println(" 학 생 삭 제 ");
		System.out.println("=========");

		System.out.println("삭제 할 학생이름을 입력하여 주십시오");
		String name = sc.next();

		if (name.equals(null) || name.equals("")) {
			System.out.println("다시입력하여 주십시오");
		}
		Student student = findStudent(name);

		if (student != null) {
			students.remove(student);
			System.out.println("학생 :" + name + "삭제되었습니다.");
		}
	}

	public static void studentUpdate() {
		System.out.println("=========");
		System.out.println(" 학 생 수 정 ");
		System.out.println("=========");

		System.out.println("학생이름을 입력하여 주십시오");
		String name = sc.next();

		Student student = findStudent(name);
		if (student != null) {

			// System.out.println("수정할 반을 입력하여 주십시오");
			// int classNo = sc.nextInt();
			System.out.println("수정할 나이를 입력하여 주십시오");
			int age = sc.nextInt();

			if (age != 0) {
				// student.setClassNo(classNo);
				student.setAge(age);
				System.out.println("학생이름 : " + student.getName() + " / " + "나이 : " + student.getAge());
			}
		}
	}

	public static void studentAverage() {
		System.out.println("=========");
		System.out.println(" 평균 ");
		System.out.println("=========");

		System.out.println("학생이름을 입력하여 주십시오");
		String name = sc.next();

		Student student = findStudent(name);

		if (student != null) {

			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().equals(name)) {
					int sum1 = students.get(i).getSum();
					double studentagerage = (double) (sum1 / 3);
					System.out.println("평균점수는 : " + studentagerage);
				}
			}
		}

	}

	public static void studentSum() {
		System.out.println("=========");
		System.out.println(" 합계  ");
		System.out.println("=========");

		System.out.println("학생이름을 입력하여 주십시오");
		String name = sc.next();

		Student student = findStudent(name);

		if (student != null) {

			System.out.println("국어점수를 입력하여 주십시오");
			int korScore = sc.nextInt();
			System.out.println("영어점수를 입력하여 주십시오");
			int engScore = sc.nextInt();
			System.out.println("수학점수를 입력하여 주십시오");
			int mathScore = sc.nextInt();
			int sum = korScore + engScore + mathScore;
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getName().equals(name)) {
					students.get(i).setKorScore(korScore);
					students.get(i).setEngScore(engScore);
					students.get(i).setMathScore(mathScore);
					students.get(i).setSum(sum);
				}
			}

			if (student.getClassNo() != 0) {
				System.out.println("반 : " + student.getClassNo() + "반  / " + "학생이름 : " + student.getName() + " / "
						+ "나이 : " + student.getAge());
				System.out.println(
						"국어점수 :" + korScore + "점  /" + "영어점수 :" + engScore + "점  /" + "수학점수 :" + mathScore + "점  /");
				System.out.println(" 합계  : " + sum + " 점");
			} else {
				System.out.println("반 : 랜덤으로 돌릴예정  /" + "반  / " + "학생이름 : " + student.getName() + " / " + "나이 : "
						+ student.getAge());
				System.out.println(
						"국어점수 :" + korScore + "점  /" + "영어점수 :" + engScore + "점  /" + "수학점수 :" + mathScore + "점  /");
				System.out.println(" 합계  : " + sum + " 점");
			}
		}

	}

	public static void studentList() {
		for (int i = 0; i < students.size(); i++) {
			Student name1 = students.get(i);
			if (name1.getClassNo() != 0) {
				System.out.println(
						"반 :" + name1.getClassNo() + "반 / 학생이름 :" + name1.getName() + " / " + "나이 :" + name1.getAge());
			} else {
				System.out.println("반 : 랜덤으로 돌릴예정  / 학생이름 :" + name1.getName() + " / " + "나이 :" + name1.getAge());

			}
		}
	}

	public static Student findStudent(String name) {
		for (int i = 0; i < students.size(); i++) {
			String name1 = students.get(i).getName();
			if (name1.equals(name)) {
				return students.get(i);
			}
		}
		return null;

	}
}