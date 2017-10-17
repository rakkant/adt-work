package Expression;



public class Stack<T> {

	private LinkedList<T> list;

	Stack() {
		list = new LinkedList<T>();
	}

	public boolean empty() {
		return list.isEmpty();
	}

	public T peek() {
		if(list.isEmpty()) {
			return null;
		} else {
			return list.iterator().getVal();
		}
	}

	public T pop() {
		if (!empty()){
			T numTemp = list.iterator().getVal();
			list.removeHead();
			return numTemp;
		}
		return null;
	}

	public T push(T val) {
		list.addHead(val);
		return peek();
	}
}