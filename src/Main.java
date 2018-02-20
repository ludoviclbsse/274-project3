import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void menuCategory(ArrayList<Category> categories) {
		Boolean boucle = true;
		int a = 1;
		int input;
		while (boucle) {
			input = -1;
			System.out.println("Choose Category");
			for (int i = 0; i < categories.size(); i++) {
				System.out.println(a + ". " + categories.get(i).getName());
				a++;
			}
			System.out.println("4. Quit Program");
			while (input < 1 || input > 4) {
				System.out.println("Input mus be [1-4]");
				input = categories.get(0).getNumber();
			}
			switch (input) {
			case 1:
				menuQuestion(categories.get(0));
				break;
			case 2:
				menuQuestion(categories.get(1));
				break;
			case 3:
				menuQuestion(categories.get(2));
				break;
			default:
				boucle = false;
			}
		}
	}

	public static void menuQuestion(Category cat) {
		Boolean boucle = true;
		int a = 1;
		int input;
		while (boucle) {
			input = -1;
			System.out.println(
					cat.getName() + "\n1. Take Quiz\n2. Add new question\n3. Modify question\n4. Change category");
			while (input < 1 || input > 4) {
				System.out.println("Input must be [1-4]");
				input = cat.getNumber();
			}
			switch (input) {
			case 1:
				System.out.println("Points: " + cat.takeQuiz());
				break;
			case 2:
				cat.addQuestion();
				break;
			case 3:
				cat.modifyQuestion();
				break;
			default:
				write(cat.getName(), cat);
				boucle = false;
			}
		}
	}

	public static void write(String fileName, Category cat) {
		try {
			PrintWriter writer = new PrintWriter(fileName + ".txt");
			for (int i = 0; i < cat.getQuestions().size(); i++) {
				writer.println(cat.getQuestions().get(i));
				writer.println(cat.getQuestions().get(i).getAnswer());
			}
			writer.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	public static void main(String[] args) {
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add(new Category("AdventureTime"));
		categories.add(new Category("HarryPotter"));
		categories.add(new Category("StarWars"));

		menuCategory(categories);
	}

}
