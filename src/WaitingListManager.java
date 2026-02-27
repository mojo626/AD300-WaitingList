import java.util.HashSet;
import java.util.LinkedList;

public class WaitingListManager {
	LinkedList<String> peopleOrder;
	HashSet<String> peopleNames;
		
	public WaitingListManager() {
		peopleNames = new HashSet<>();
		peopleOrder = new LinkedList<>();
	}

	public void addPerson(String name) {
		if (peopleNames.contains(name)) {
			System.out.println(name + " is already in the queue!");
		}

		peopleOrder.add(name);
		peopleNames.add(name);
	}

	String servePerson() {
		String name = peopleOrder.removeFirst();
		peopleNames.remove(name);

		System.out.println(name + " has been served");

		return name;
	}

	boolean isPersonInList(String name) {
		return peopleNames.contains(name);
	}

	int waitingListSize() {
		return peopleNames.size();
	}

	void displayWaitingList() {
		for (int i = 0; i < peopleOrder.size(); i++) {
			System.out.println((i + 1) + ": " + peopleOrder.get(i));
		}
	}
}
