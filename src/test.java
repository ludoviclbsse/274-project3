import java.util.ArrayList;
import java.util.Random;

public class test {

	public static void main(String[] args) {

		ArrayList<Integer> arraylist = new ArrayList<Integer>();

		for (int i = 1; i <= 12; i++)
			arraylist.add(i);

		System.out.println(arraylist);

		Random rand = new Random();

		int random;

		for (int i = 0; i < 10; i++) {
			random = arraylist.get(rand.nextInt(arraylist.size()));
			System.out.println(arraylist.get(random));
		}

	}

	
	/*
	if (l % 6 == 1)
		quest = line;
	if (l % 6 == 2)
		a1 = line;
	if (l % 6 == 3)
		a2 = line;
	if (l % 6 == 4)
		a3 = line;
	if (l % 6 == 5)
		a4 = line;
	if (l % 6 == 0) {
		a = Integer.parseInt(line);
		q.setQuestion(quest);
		q.setA1(a1);
		q.setA2(a2);
		q.setA3(a3);
		q.setA4(a4);
		q.setAnswer(a);
		questions.add(q);
		System.out.println("6");*/
}
