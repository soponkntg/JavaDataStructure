
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		if(s.isEmpty()) {
			return s;
		}
		ArrayListStack re = new ArrayListStack();
		ArrayListStack temp = new ArrayListStack();
		re.push(s.top());
		s.pop();
		while(!s.isEmpty()) {
			if(s.top() <= re.top()) {
				re.push(s.top());
				s.pop();
			}else{
				while(!s.isEmpty()) {
					if(re.isEmpty()) break;
					if(s.top() <= re.top()) break;
					temp.push(re.top());
					re.pop();
				}
				re.push(s.top());
				s.pop();
				while(!temp.isEmpty()) {
					re.push(temp.top());
					temp.pop();
				}
			}		
		}return re;
	}

}
