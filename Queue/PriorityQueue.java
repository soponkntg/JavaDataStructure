
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if(q.isEmpty()) {
			q.insertLast(x);
			return;
		}
		if(x >= q.back()) {
			q.insertLast(x);
			return;
		}
		int i;
		for(i = 0; i < q.size(); i++) {
			if(x < q.front()) {
				q.insertLast(x);
				break;
			}
			q.insertLast(q.removeFirst());
			
		}
		for(int j = 0; j < q.size()-i-1; j++) {
			q.insertLast(q.removeFirst());
		}
		

	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();

	}

	// implement this
	public int top() throws Exception {
		int x = q.front();
		return x;
	}

}
