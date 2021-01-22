package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.StoreController;
import vo.Stuff;

public class StoreMain {
	private static String session = null;
	private static String sessionId = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StoreController controller = new StoreController();
		while (true) {
			System.out.println(" 1.로그인 / 2.회원가입  /  3. 종료");
			String menu = sc.next();
			// 로그인
			if (menu.equals("1")) {
				System.out.println("1. user /  2.manager");
				String option = sc.next();

				System.out.println("아이디를 입력하세요.");
				String id = sc.next();

				System.out.println("비밀번호를 입력하세요.");
				String pwd = sc.next();

				String result = controller.login(id, pwd, option);
				
				if (result != null) {
					session = result.substring(result.length() - 1, result.length());
					sessionId = result;
					// 로그인화면 변경
					while (true) {
						// user
						
						if (session.equals("U")) {
							// 로그인 한 유저만 사용 가능합니다.
							System.out.println("1.물건 결제하기  / 2.충전하기 / 3.로그아웃");
							String menuU = sc.next();

							if (menuU.equals("1")) {
								System.out.println("판매물품 리스트입니다.");
								ArrayList<Stuff> list = controller.stuffList();
								for (Stuff u : list) {
									System.out.println("이름 : " + u.getName() + " / 가격 : " + u.getPrice());

								}
								System.out.println("물건의 이름을 입력하세요");
								String stuffU = sc.next();
								boolean cashResult = controller.stuffCash(sessionId, stuffU);
								if (cashResult) {
									System.out.println("구매완료하였습니다.");
								} else {
									System.out.println("물건의 이름을 잘못입력하였거나, 금액이 부족합니다.");
								}
							} else if (menuU.equals("2")) {
								System.out.println("충전할 금액을 말씀해주세요.");
								int balance = sc.nextInt();
								boolean resultPoint = controller.insertPoint(sessionId, balance);
								if (resultPoint) {
									System.out.println("입급 성공하였습니다.");
								} else {
									System.out.println("입금 실패했습니다.");
								}

							} else if (menuU.equals("3")) {
								System.out.println("로그아웃 되었습니다.");
								break;
							}

							// manager
						} else if (session.equals("M")) {
							// manager만 가능한 조작입니다.
							System.out.println("1. 판매 물품 등록하기 / 2.판매 물품 리스트보기  /  3.로그아웃");
							String menuM = sc.next();

							// 판매물품 등록하기
							if (menuM.equals("1")) {
								System.out.println("판매할 물품의 이름 : ");
								String stuff = sc.next();
								System.out.println("판매할 물품의 금액 : ");
								int price = sc.nextInt();

								boolean resultStuff = controller.insertStuff(stuff, price);
								if (resultStuff) {
									System.out.println("물품을 등록했습니다.");
								} else {
									System.out.println("물품을 등록에 실패했습니다.");
								}
							} else if (menuM.equals("2")) {

								// 판매물품 리스트 보기
								System.out.println("판매물품 리스트입니다.");
								ArrayList<Stuff> list = controller.stuffList();
								for (Stuff u : list) {
									System.out.println("이름 : " + u.getName() + " / 가격 : " + u.getPrice());

								}
							}
							else if(menuM.equals("3")) {
								System.out.println("로그아웃 되었습니다.");
								break;
							}
						}
					}

				} else {
					System.out.println("로그인 실패");
				}

				// 회원가입
			} else if (menu.equals("2")) {
				System.out.println("1. user /  2.manager");
				String option = sc.next();

				System.out.println("아이디를 입력하세요.");
				String id = sc.next();

				System.out.println("비밀번호를 입력하세요.");
				String pwd = sc.next();

				boolean result = controller.singup(id, pwd, option);
				if (result) {
					System.out.println("회원가입 성공하였습니다.");
				} else {
					System.out.println("회원가입 실패하였습니다.");
				}

				// 종료
			} else if (menu.equals("3")) {
				break;
			}
		}

	}
}
