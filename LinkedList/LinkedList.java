class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}

	public boolean isEmpty() {
		return header.nextNode == null;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception{
		Iterator itr = new MyListIterator(header);
		int size = 0;
		while(itr.hasNext()) {
			itr.next();
			size++;
		}
		return size;

	}
	
	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception{
		Iterator itr = new MyListIterator(header);
		while(itr.hasNext()) {
			Object temp = itr.next();
			String p = temp.toString();
			System.out.println(p);
		}
	}

	//Return iterator pointing to value that stores a given name, or null otherwise.
	//To be completed by students.
	public Iterator findPosition(String name) throws Exception{
		Iterator itr = new MyListIterator(header);
		while(itr.hasNext()) {
			Contact current = (Contact) itr.next();
			if (current.name == name) {
				return itr;
			}
		}
		return null;
	}
	
	//add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.
	
	public void add(Object c)throws Exception{
		Iterator itr = new MyListIterator(header);
		if (!(c instanceof Contact)){
			throw new Exception();
		}
		Contact match = (Contact) c;
		while (itr.hasNext()) {
			Contact current = (Contact) itr.next();
			if(current.name.compareToIgnoreCase(match.name) > 0) {
				Iterator in = findPrevious(current);
				insert(c, in);
				return;
			}
		}insert(c,itr);
	}
	
	//Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact. 
	//If the removed contact is the last one, return the iterator pointing to the first contact 
	//   (if there is no first contact, make the iterator point to header). 
	//If i is marking an illegal position that cannot be removed, just return null. 
	//To be completed by students.
	public Iterator removeAt(Iterator p)throws Exception{
		if (p == null || !(p instanceof MyListIterator))
			return null;
		MyListIterator p2 = (MyListIterator) p;
		if(p2.currentNode != null && p2.currentNode.data != null ) {
			Object data = p2.currentNode.data;
			if (find(data) == -1) return null;
			Iterator previous = findPrevious(data);
			remove(previous);
			if (p2.hasNext()) {
				p2.next();
				return p2;
			}else {
				Iterator head = new MyListIterator(header);
				if(isEmpty())
					return head;
				else {
					head.next();
					return head;
				}
			}
		}return null;
	}
	

}