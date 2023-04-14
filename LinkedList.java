public class LinkedList {
	private ListNode head;
	private ListNode tail;
	private Comparator comparator;

	public LinkedList(Comparator comparator) {
		head = tail = null;
		this.comparator = comparator;
	}

	public LinkedList(Object item) {
		addToTail(item);
	}

	public LinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void addToHead(Object item) {
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			head = new ListNode(item, head);
		}
	}

	public void addToTail(Object item) {
		if (isEmpty()) {
			head = tail = new ListNode(item);
		} else {
			tail.next = new ListNode(item);
			tail = tail.next;
		}
	}

	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty()) {
			throw new EmptyListException();
		}
		item = head.data;
		if (head == tail) // there's only one single node
			head = tail = null;
		else
			head = head.next;
		return item;

	}

	public Object removeFromTail() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
		Object item = tail.data;
		if (head == tail) { // there is only one node
			head = tail = null;
			return item;
		}
		ListNode current = head;
		while (current.next != tail)
			current = current.next;
		tail = current;
		tail.next = null;
		return item;
	}

	public String toString() {
		String s = "[ ";
		ListNode current = head;
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s + "]";
	}

	public void insertInOrder(Object item) {
		if (isEmpty()) {
			addToHead(item); // Update head and tail
		} else {
			if (comparator.isGreaterThanOrEqualTo(head.data, item)) {
				addToHead(item);	// update head
				
			} else if (comparator.isLessThanOrEqualTo(tail.data, item)) {
				addToTail(item);	// update tail
				
			} else {	// case 4: general case, list has at least 2 nodes
				// insert in the middle
				ListNode previous = null;
				ListNode current = head;
				ListNode newNode = new ListNode(item);
				while (comparator.isGreaterThanOrEqualTo(current.next.data, item)) {
					previous = current;
					current = current.next;
				}
				previous.next = newNode;
				newNode.next = current;
			}
		}
	}

	public void removeItem(Object item) throws ItemNotFoundException {
		if (isEmpty()) {
			throw new ItemNotFoundException();
		}
		if (comparator.isEqualTo(head.data, item))
			removeFromHead();
		else if (comparator.isEqualTo(tail.data, item))
			removeFromTail();
		else {
			// remove a node in the middle
			ListNode current = head;
			while (current.next != null) {
				if (comparator.isEqualTo(current.next.data, item)) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
			throw new ItemNotFoundException();
		}
	}

	public int getCount() {
		int counter = 0;
		ListNode current = head;
		while (current != null) {
			counter++;
			current = current.next;
		}
		return counter;
	}
	
	public Object getLinkedList(int num) {
		ListNode current = head;
		while (num != 0) {
			num--;
			current = current.next;
		}
		return current.data;
	}

}
