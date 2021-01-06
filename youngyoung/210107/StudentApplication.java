package studentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApplication {
	// 반을 저장하는 list
	private static List<String> bans = new ArrayList<String>();
	// 학생을 저장하는 list
	private static List<Student> students = new ArrayList<Student>();
	private static Scanner sc = new Scanner(System.in);

	// 생성되어있는 반을 보여줍니다.
	private static void selectBans() {
		System.out.println(bans);

	}

	// 2. 학생 추가
	private static void addStudent() {
		System.out.println("학생을 추가할 반을 선택해주세요.");
		selectBans();
		String searchBan = null;
		String selectBan = sc.next();
		// 선택한 반이 있는지 없는지 확인하는 반복문입니다.
		for (int i = 0; i < bans.size(); i++) {
			if (selectBan.equals(bans.get(i))) {
				searchBan = bans.get(i);
				break;
			} else {
				searchBan = null;
			}
		}

		if (searchBan != null) {

			System.out.print("학생이름 >");
			String name = sc.next();
			System.out.print("학생나이 >");
			int age = sc.nextInt();
			System.out.print("학생의 국어점수 >");
			int korS = sc.nextInt();
			System.out.print("학생의 영어점수 >");
			int engS = sc.nextInt();
			System.out.print("학생의 수학점수 >");
			int mathS = sc.nextInt();

			Student student = new Student(searchBan, name, age, korS, engS, mathS);
			students.add(student);

		} else {
			System.out.println("해당 반이 없습니다.");
		}

	}

	// 3. 학생제거
	private static void removeStudent() {
		// 목록을 보여주고 삭제할 대상을 고른다.
		listStudent();
		System.out.print("삭제하고픈 학생의 반 > ");
		String ban = sc.next();
		System.out.print("삭제하고픈 학생의 이름 > ");
		String name = sc.next();
		String remove = "remove";
		String result = null;
		result = searchStudent(ban, name, remove);
		System.out.println (result);
	}

	// 4. 학색 수정
	private static void updateStudent() {
		// 수정할 학생을 알기위해서 전체 리스트 출력
		listStudent();
		System.out.print("수정하고픈 학생의 반 > ");
		String ban = sc.next();
		System.out.print("수정하고픈 학생의 이름 > ");
		String name = sc.next();
		String update = "update";
		String result = searchStudent(ban, name, update);
		System.out.println(result);

	}

	// 5. 평균 6.함계
	private static void avgStudent(String option) {
		for (int i = 0; i < bans.size(); i++) {
			int cnt = 0;
			int sumkor = 0;
			int sumeng = 0;
			int summath = 0;
			for (int j = 0; j < students.size(); j++) {
				if (bans.get(i).equals(students.get(j).getClassNo())) {

					sumkor += students.get(j).getKorScore();
					sumeng += students.get(j).getEngScore();
					summath += students.get(j).getMathScore();
					cnt++;

				}

			}
			if (option.equals("avg")) {
				if(cnt !=0) {
					System.out.println("반 : " + bans.get(i) + " 국어 평균 :" + sumkor / cnt + " 영어 평균 : " + sumeng / cnt
							+ " 수학 평균 :" + summath / cnt);
				}else {
					System.out.println(
							"반 : " + bans.get(i) + " 국어 평균 :" + sumkor + " 영어 평균 : " + sumeng + " 수학 평균 :" + summath);
				}
				
			} else if (option.equals("sum")) {
				System.out.println(
						"반 : " + bans.get(i) + " 국어 합계 :" + sumkor + " 영어 합계 : " + sumeng + " 수학 합계 :" + summath);
			}
		}

	}

	// 7. 학생 리스트
	private static void listStudent() {
		Student st = new Student();
		for (int i = 0; i < students.size(); i++) {
			st = students.get(i);
			System.out.println("반: " + st.getClassNo() + " 이름: " + st.getName() + " 나이: " + st.getAge() + " 국어점수: "
					+ st.getKorScore() + " 영어점수: " + st.getEngScore() + " 수학점수:" + st.getMathScore());

		}

	}

	// 찾고자하는 반이랑 이름을 가져와서 비교한다.
	private static String searchStudent(String ban, String name, String option) {
		Student st;
		String result = null;
		for (int i = 0; i < students.size(); i++) {
			st = students.get(i);
			if (st.getClassNo().equals(ban) && st.getName().equals(name)) {
				if (option.equals("remove")) {
					students.remove(i);
					result = "제거가 완료되었습니다.";
					break;
				} else if (option.equals("update")) {
					System.out.println("바꿀반을 입력하세요 > ");
					String newBan = sc.next();
					
					System.out.println("바꿀 이름을 입력하세요 > ");
					String newName = sc.next();
					
					students.get(i).setClassNo(newBan);
					students.get(i).setName(newName);
					result = "수정이 완료되었습니다.";
					break;
				}

				
			} else {
				if (option.equals("remove")) {
					result = "제거가 완료되지 않았습니다.";
				} else if (option.equals("update")) {
					result = "업데이트가 완료되지 않았습니다.";
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {

		while (true) {

			System.out.println("---------------------------------------------------------");
			System.out.println("1.반생성    2.학생추가    3.학생제거    4.학생수정    5.평균    6.합계    7.학생 리스트");
			System.out.println("---------------------------------------------------------");
			String menu = sc.next();

			// 1. 반생성 메뉴
			if (menu.equals("1")) {

				System.out.println("생성할 방의 이름을 정해주세요.");
				String ban = sc.next();

				bans.add(ban);

			} else if (menu.equals("2")) {
				addStudent();

			} else if (menu.equals("3")) {
				removeStudent();
			} else if (menu.equals("4")) {
				updateStudent();
			} else if (menu.equals("5")) {
				avgStudent("avg");
			} else if (menu.equals("6")) {
				avgStudent("sum");
			} else if (menu.equals("7")) {
				listStudent();
			}
		}
	}

}
