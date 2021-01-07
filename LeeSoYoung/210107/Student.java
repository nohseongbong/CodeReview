package codeReview200107;

public class Student {
	public  int getClassNo;
	private int classNo;
	private String name;
	private int age;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Student() {

	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public Student(int classNo, String name, int age, int korScore, int engScore, int mathScore) {
		this.classNo = classNo;
		this.name = name;
		this.age = age;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public int getClassNo() {
		return classNo;
	}
	
	public void setClassNo(int classNo) {
		this.classNo = classNo;
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