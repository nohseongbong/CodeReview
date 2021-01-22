package lsy.view;

import java.util.ArrayList;
import java.util.Scanner;

import lsy.controller.StoreController;
import lsy.vo.User;

public class StoreMain {

	private static ArrayList<User> dbUsers = new ArrayList<User>();
	
	private User loginUser = null;

	public static void main(String[] args) {
		
		StoreController storeController = new StoreController();  // 이 안에잇는것을 갔다 쓰겟다
		
      boolean run = true;
      Scanner sc = new Scanner(System.in);

      while (run) {
         System.out.println("-------------------------------");
         System.out.println(" 1. 로그인   2. 회원가입");
         System.out.println("-------------------------------");

         int num = sc.nextInt();

        try {
     
            if (num == 1) {
               System.out.print("id를 입력하여 주십시오");
               String id = sc.next();
               System.out.println();
               System.out.print("비밀번호를 입력하여 주십시오");
               String pwd = sc.next();
               
               
               //분기란 : 흐름을 조절하는 거라고 보면되 프로세스가 어디로 가라 저기로 가라 즉 if 문 같은   == 1이면 로그인 , 2면 회원가입처럼 분류해주는게 분기야
               
               //controller 분기 // 로그인 정보가 있는지에대한 상세로직은 보질않아  // 그건 service + dao 보는거야
               
               User user = storeController.login(id, pwd);
               //사용자 정보가 들어와야되
               
               //loginUser = user; // "어떠한 정상적으로 로그인된 사용자 정보가 들어갈거야";
               if (user != null) { // 로그인 한 유저만 사용 가능합니다.
                  System.out.println("로그인성공");
                  
                  user.getBalance(); //

               } else {
                  System.out.println("로그인실패");
               }

            } else if (num == 2) {
               System.out.print("id를 입력하여 주십시오");
               String id = sc.next();
               System.out.print("비밀번호를 입력하여 주십시오");
               String pwd = sc.next();

               storeController.join(id, pwd); // 너가 곧 html  을 배울건데 거기가 view야 화면단에 보이는 곳이 뷰
               
            }

         } catch (StackOverflowError e) {

         }

      }
   }
}