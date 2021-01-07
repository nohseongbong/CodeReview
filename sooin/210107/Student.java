package studentClass;

public class Student {
	private int classNo;
	private String name;
	private int age;
	private int korScore;
	private int engScore;
	private int mathScore;
	
	public Student(int classNo, String name, int age, int korScore, int engScore, int mathScore) {
		this.classNo = classNo;
		this.name = name;
		this.age = age;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	
}