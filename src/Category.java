import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Category {
	private String name;
	private ArrayList<Question> questions;

	public void read(String fileName) {
		int i = 0;
		int l = 1;
		Question q = new Question();
		try {
			Scanner read = new Scanner(new File(fileName));
			do {
				
				String line = read.nextLine();
				if (l % 6 == 1)
					q.setQuestion(line);
				if (l % 6 == 2)
					q.setA1(line);
				if (l % 6 == 3)
					q.setA2(line);
				if (l % 6 == 4)
					q.setA3(line);
				if (l % 6 == 5)
					q.setA4(line);
				if (l % 6 == 0) {
					q.setAnswer(Integer.parseInt(line));
					questions.add(q);
					q = new Question();
				}
				l++;
			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	Category(String name) {
		this.name = name;
		questions = new ArrayList<Question>();
		read(name + ".txt");
		/*for (int i = 0; i < questions.size(); i++) {
			System.out.println(questions.get(i).toString());
		}*/
	}

	public int getNumber() {
		Scanner in = new Scanner(System.in);
		int input = 0;
		boolean isInvalid = true;
		while (isInvalid) {
			System.out.println("Enter a number: ");
			if (in.hasNextInt()) {
				input = in.nextInt();
				isInvalid = false;
			} else {
				in.nextLine(); // clear out invalid input
				System.out.println("Invalid Input");
			}
		}
		return input;
	}

	public static String getString() {
		Scanner in = new Scanner( System.in );
		String input = in.nextLine();
		return input;
	}

	public void modifyQuestion() {
		int input = -1;
		int a = 1;
		System.out.println("Which question do you want to modify");
		for (int i = 0; i < questions.size(); i++) {
			System.out.println(a + ". " + questions.get(i).getQuestion());
			a++;
		}
	
		while (input < 1 || input > questions.size()) {
			System.out.println("Input must be [1-" + questions.size() + "]");
			input = getNumber();
		}
		questionPart(input);
	}

	public void questionPart(int index) {
		int input = -1;
		System.out.println("What part of the question modify?\n" + "1. Question\n" + "2. Answer 1\n" + "3. Answer 2\n"
				+ "4. Answer 3\n" + "5. Answer 4\n" + "6. The correct answer (1-4)");

		while (input < 1 || input > 6) {
			System.out.println("Input must be [1-6]");
			input = getNumber();
		}
		
		/*A REFAIRE*/
		
		switch (input) {
		case 1:
			questions.get(index).setQuestion(getString());
			break;
		case 2:
			questions.get(index).setA1(getString());
			break;
		case 3:
			questions.get(index).setA2(getString());
			break;
		case 4:
			questions.get(index).setA3(getString());
			break;
		case 5:
			questions.get(index).setA4(getString());
			break;
		default:
			questions.get(index).setAnswer(getNumber());

		}
	}

	public void addQuestion() {
		System.out.println("1. Question");
		String question = getString();
		System.out.println("2. Answer 1");
		String a1 = getString();
		System.out.println("3. Answer 2");
		String a2 = getString();
		System.out.println("4. Answer 3");
		String a3 = getString();
		System.out.println("5. Answer 4");
		String a4 = getString();
		System.out.println("6. The correct answer (1-4)");
		int answer = getNumber();
		Question q = new Question(question, a1, a2, a3, a4, answer);
		questions.add(q);
	}

	public int takeQuiz() {
		ArrayList<Question> listq = questions;
		int points = 0;
		int input;
		Random rand = new Random();
		int q;
		for (int i = 0; i < 10; i++) {
			input = -1;
			q = rand.nextInt(listq.size()) + 0;
			System.out.println(listq.get(q).toString());
			while (input < 1 || input > 4)
				input = getNumber();
			if (input == listq.get(q).getAnswer())
				points++;
			listq.remove(q);
		}

		return points;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
}
