package vo;

// vo
// 필요한 getter, setter와 생성자를 생성해주세요.
// 자동완성이 아니라 직접 입력해보세요.
public class Video {
	private String videoName;
	private String videoContent;
	private int ageLimit;
	
	
	public Video(String videoName, String videoContent, int ageLimit) {
		super();
		this.videoName = videoName;
		this.videoContent = videoContent;
		this.ageLimit = ageLimit;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoContent() {
		return videoContent;
	}
	public void setVideoContent(String videoContent) {
		this.videoContent = videoContent;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}	
	
	
	
}
