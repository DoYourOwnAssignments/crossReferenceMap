
public class test2 {
	public static void main(String[] args) {
		LinkedList vertList = new LinkedList();
		
//		for (int i=1;i<=10;i++) {
//		int rng = (int)(Math.random()*100);
//		LinkedList placeholder = new LinkedList();
//		//vertList.addToTail(new LinkedList(rng));
//		placeholder.addToTail(rng);
//		vertList.addToTail(placeholder);
//		}
//		
//		System.out.println(vertList);
//
//		// This is suppose to find the LinkedList but java said it can't!!!
//		// Get reference pointer then to the Linked List
//		// Exception: Index out of bound!!!
//		System.out.println(vertList.getLinkedList(2));
//		LinkedList thisList = (LinkedList) vertList.getLinkedList(2);
//		thisList.addToTail("Success"); 
//		System.out.println(vertList);

		// insert by order?
		LinkedList list = new LinkedList();
		list.insertInOrder(99);
		list.insertInOrder(87);
		list.insertInOrder(42);
		System.out.println(list);
	}
}
