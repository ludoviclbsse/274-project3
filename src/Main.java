import java.util.ArrayList;

public class Main {

	public static void menuCategory(ArrayList<Category> categories) {
		Boolean boucle = true;
		int a = 1;
		int input;
		while (boucle) {
			System.out.println("Choose Category");
			for (int i = 0; i < categories.size(); i++) {
				System.out.println(a + ". " + categories.get(i).getName());
				a++;
			}
			System.out.println("4. Quit Program");
			input = categories.get(0).getNumber();
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
			System.out.println(cat.getName() + "\n1. Take Quiz\n2. Add new question\n3. Modify question\n4. Change category");
			
			input = cat.getNumber();
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
				boucle = false;
			}
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
