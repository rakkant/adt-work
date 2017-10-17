
public class LinkedList {


	private ListNode head = null;
	private ListNode tail = null;
	
	public LinkedList(){
		head = tail = null;
	}
	
	public ListNode add (int v){
		ListNode newNode = new ListNode(v);
		
		if (tail != null){
			tail.next = newNode;
			tail = newNode;
		}else{
			head = tail = newNode;
		}
		return newNode;
	}
	
}
