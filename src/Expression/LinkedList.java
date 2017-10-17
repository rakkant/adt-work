package Expression;

public class LinkedList<T> {

	private class Node {
		private T val;
		protected Node next = null;

		public Node(T val) {
			this.val = val;
			this.next = null;
		}

		public Node() {
			this(null);
		}

		public Node getNext() {
			return next;
		}

		public T getVal() {
			return val;
		}

		public void setVal(T v) {
			val = v;
		}
	}

	public class Iterator {
		private Node currentNode;
		private LinkedList<T> list;

		Iterator(Node node, LinkedList<T> list) {
			currentNode = node;
			this.list = list;
		}

		public T getVal() {
			return currentNode.getVal();
		}

		public void setVal(T v) {
			currentNode.setVal(v);
		}

		public void next() {
			currentNode = currentNode.getNext();
		}

		public boolean isEnded() {
			return currentNode != null;
		}

		public Iterator add(T v) {
			Node newNode = new Node(v);
			newNode.next = currentNode.next;
			currentNode.next = newNode;

			list.size++;
			return new Iterator(newNode, list);
		}

		public void removeAfter() {
			if(currentNode.next != null)
				currentNode.next = currentNode.next.next;
			list.size--;
		}
	}

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return tail == null;
	}

	public int size() {
		return size;
	}

	public Iterator addHead(T v) {
		if (isEmpty()) {
			return add(v);
		} else {
			Node newNode = new Node(v);
			newNode.next = head;
			head = newNode;
			size++;
			return new Iterator(newNode, this);
		}
	}

	public void removeHead() {

		if (size > 1){
			head = head.next;
		}else{
			head = tail = null;
		}
		size--;
	}

	public Iterator add(T v) {
		Node newNode = new Node(v);

		if (!isEmpty()) {
			tail.next = newNode;
			tail = newNode;
		} else {
			head = tail = newNode;
		}

		size++;
		return new Iterator(newNode, this);
	}

	public Iterator iterator() {
		return new Iterator(head, this);
	}
}