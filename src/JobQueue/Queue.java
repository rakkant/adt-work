package JobQueue;

import java.util.NoSuchElementException;

public class Queue<T> {

	private LinkedList<T> list;

	Queue() {
		list = new LinkedList<T>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public T peek() {
		if(!isEmpty()) {
			return list.iterator().getVal();
		} else {
			return null;
		}
	}

	public T remove() {
		T res = poll();
		if(res == null) {
			throw new NoSuchElementException();            
		}
		return res;
	}

	public T poll() {
		if(!isEmpty()){
			T temp = list.iterator().getVal();
			list.removeHead();
			return temp;
		}else{
			return null;
		}
	}

	public boolean add(T val) {
		list.add(val);
		return true;
	}

	// --------------  additional method for debugging -------
	public void printItems() {
		LinkedList<T>.Iterator head = list.iterator();
		while(head != null) {
			System.out.print("" + head.getVal() + " ");
			head.next();
		}
		System.out.println();
	}
}