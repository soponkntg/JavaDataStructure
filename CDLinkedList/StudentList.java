
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) throws Exception {
		Object data1 = i1.currentNode.data;
		Object data2 = i2.currentNode.data;
		Iterator it1 = super.findPrevious(i1);
		Iterator it2 = super.findPrevious(i2);
		super.removeAt(i1);
		super.removeAt(i2);
		insert(data1, it2);
		insert(data2, it1);
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) throws Exception {
		if(lst.isEmpty()) {
			return;
		}
		DListIterator it = new DListIterator(lst.header);
		while(it.hasNext()) {
			insert(it.next(), i1);
			i1.next();
			if(it.currentNode.nextNode == lst.header) {
				return;
			}
		}
	}

	// implement this method
	public void gender(String g) throws Exception {
		CDLinkedList temp = new CDLinkedList();
		DListIterator it = new DListIterator(header);
		DListIterator it_temp = new DListIterator(temp.header);
		while(it.hasNext()) {
			Object add = it.next();
			if(((Student)add).getSex() == g) {
				temp.insert(add, it_temp);
				removeAt(it);
				it_temp.next();
			}
			if(it.currentNode.nextNode == header) break;
		}
		insertList(new DListIterator(header), temp);
	}

}
