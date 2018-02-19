
public class Question {
	private String question;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private int answer;

	Question() {
	}

	Question(String q, String a1, String a2, String a3, String a4, int a) {
		this.question = q;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.answer = a;
	}

	public void setQuestion(String q) {
		this.question = q;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public void setAnswer(int a) {
		this.answer = a;
	}

	public String getQuestion() {
		return this.question;
	}

	public String getA1() {
		return this.a1;
	}

	public String getA2() {
		return this.a2;
	}

	public String getA3() {
		return this.a3;
	}

	public String getA4() {
		return this.a4;
	}

	public int getAnswer() {
		return this.answer;
	}

	public String toString() {
		return this.question + "\n" + this.a1 + "\n" + this.a2 + "\n" + this.a3 + "\n" + this.a4;
	}
}
