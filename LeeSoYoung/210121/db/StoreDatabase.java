package lsy.db;

import java.util.ArrayList;

import lsy.vo.User;

public class StoreDatabase {
	
	public static ArrayList<User> users = new ArrayList<User>();
	// DB 역할 위해 최초 메모리에 올린다.
	// 최초 메모리에 올리기위해서는 static 을 선언해준다.
	//public 어디에서도 사용할수 있다.
	//StoreDatabase.Users  로 사용가능하다
}