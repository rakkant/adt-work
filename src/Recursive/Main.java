package Recursive;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	static private int countIfLoop(LinkedList<Integer> list, int target) {
		ListIterator<Integer> ii = list.listIterator();
		int count = 0;
		while(ii.hasNext()) {
			if(ii.next() == target) {
				count++;
			}
		}
		return count;
	}

	static private int countIf(LinkedList<Integer> list, int target) {
		ListIterator<Integer> ii = list.listIterator();
		return countIf0(ii,target);
	}

	static private int countIf0(ListIterator<Integer> ii, int target) {
		if ( ! ii.hasNext()){
			return 0;
		}else{
			if(ii.next() == target){
				return 1+ countIf0(ii,target);
			}else{
				return countIf0(ii,target);
			}
		}
	}

	static private int sumList(ListIterator<Integer> ii) {
		if(!ii.hasNext()){
			return 0;
		}else{
			int x = ii.next();
			int s = sumList(ii);
			return x+s;
		}
	}

	static private int findSize0(ListIterator<Integer> ii) {
		if(! ii.hasNext()) {
			return 0;
		} else {
			ii.next();
			int k = findSize0(ii);
			return k + 1;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(10); list.add(200); list.add(15);
		list.add(11); list.add(200); list.add(15);
		list.add(12); list.add(201); list.add(15);
		list.add(13); list.add(200); list.add(15);

		System.out.println(countIf(list,10));
		System.out.println(countIf(list,15));
		System.out.println(countIf(list,20));
		System.out.println(countIf(list,200));
		System.out.println(sumList(list.listIterator()));
	}

	private static void printList(LinkedList<Integer> list) {
		Iterator<Integer> i = list.iterator();
		while(i.hasNext()) {
			System.out.print("" + i.next() + " ");
		}
		System.out.println();
	}

}