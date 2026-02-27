import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);


		WaitingListManager man = new WaitingListManager();

		boolean shouldRun = true;
		while (shouldRun) {
			System.out.print("Please type a number for what you would like to do (0 for help): ");

			int option = -10;
			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please input a number");
				scanner.nextLine();
			}

			String name;

			switch (option) {
				case -1:
					shouldRun = false;
					break;
				case 0:
					System.out.println("-1: exit \n0: show this help page \n1: add someone new to the waiting list \n2: serve next person in line \n3: display the current waiting list \n4: check if person is in list \n5: display waiting list size");
					break;
				case 1:
					System.out.print("Please type the name of the person to add: ");
					name = scanner.next();
					man.addPerson(name);
					break;
				case 2:
					man.servePerson();
					break;
				case 3:
					man.displayWaitingList();
					break;
				case 4:
					System.out.print("Please type the name of the person to check: ");
					name = scanner.next();
					System.out.println(man.isPersonInList(name) ? "The person is in queue" : "The person is not in queue");
					break;
				case 5:
					System.out.println("There are " + man.waitingListSize() + " people in the queue");
					break;
				case -10:
					break;
				default:
					System.out.println("Please type a different number");
					break;
			}
		}

		scanner.close();
		
	}
}
