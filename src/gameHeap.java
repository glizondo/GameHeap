import java.util.Scanner;

public class gameHeap {

	public static void main(String[] arg) throws Exception {
		int numelements = 100;
		int answerFirst = 0;
		int answerSecond;
		Scanner scn = new Scanner(System.in);
		MaxHeap2 maxHeap = new MaxHeap2(numelements);

		//Adding a few actions to get started
		maxHeap.insert(10);
		maxHeap.insert(8);
		maxHeap.insert(6);
		maxHeap.insert(4);
		maxHeap.insert(3);
		//Prints heap array
//		maxHeap.print();

		//Program executes while not reaching 99
		while (maxHeap.peek() != 99) {
			if (maxHeap.peek() == 0) {
				System.out.println("Idle");
				System.out.println("Add action: 1");
				answerFirst = scn.nextInt();
				if (answerFirst != 1) {
					System.out.println("Cannot do that");
					continue;
				}
			}
			if (maxHeap.peek() != 0) {
				System.out.println("Add action: 1 - Execute action: 2");
				answerFirst = scn.nextInt();
			}

			if (answerFirst == 1) {
				System.out.println("What action do you want to add?");
				System.out.println("Dodge (10)" + "\n" + "Jump (8)" + "\n" + "Look for treasures(6)" + "\n" + "Aim (4)" + "\n"
						+ "Shoot(3)" + "\n" + "Walk (2)" + "\n" + "Run (1) " + "\n" + "Exit (99)");
				answerSecond = scn.nextInt();
				maxHeap.insert(answerSecond);
				//Prints heap array
//				maxHeap.print();
			}
			if (answerFirst == 2) {
				if (maxHeap.peek() == 1) {
					System.out.println("Executing action Run " + maxHeap.peek());
				}
				if (maxHeap.peek() == 2) {
					System.out.println("Executing action Walk " + maxHeap.peek());
				}
				if (maxHeap.peek() == 3) {
					System.out.println("Executing action Shoot " + maxHeap.peek());
				}
				if (maxHeap.peek() == 4) {
					System.out.println("Executing action Aim " + maxHeap.peek());
				}
				if (maxHeap.peek() == 6) {
					System.out.println("Executing action Look for treasures " + maxHeap.peek());
				}
				if (maxHeap.peek() == 8) {
					System.out.println("Executing action Jump " + maxHeap.peek());
				}
				if (maxHeap.peek() == 10) {
					System.out.println("Executing action Dodge " + maxHeap.peek());
				}
				maxHeap.extractMax();
			}

		}
		System.out.println("Number 99 - End of game");
		scn.close();

	}

}
