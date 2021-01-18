package Review3;

import java.util.ArrayList;
import java.util.List;

public class Board {
	// 게시글 제목
	private String title;
//	// 게시글 내용
//	private String content;
	// 게시글 업로드한 유저id
	private String id;
	// 게시글 내용
	private List<String> contents = new ArrayList();
	
	
	public Board(String title, List<String> contents, String id) {
		super();
		this.title = title;
		this.contents = contents;
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public List<String> getContents(){
		return contents;
	}
	
	public void setContents(List<String> contents){
		this.contents = contents;
	}
	
}