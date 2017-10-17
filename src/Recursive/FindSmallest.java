package Recursive;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class FindSmallest {
	 
    LinkedList<Integer> inList;
    LinkedList<Integer> outList;
    int n;
 
    public static void main(String[] args) {
    	FindSmallest m = new FindSmallest();
 
        m.readInput();
        m.process();
        m.output();
    }
 
    private void process() {
        outList = new LinkedList<Integer>();
 
        sortList(inList, outList);
 
      
    }
 
    private void output() {
        for(Iterator<Integer> i = outList.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    }
 
    private void sortList(LinkedList<Integer> inList, LinkedList<Integer> outList) {
        
    	if(inList.isEmpty()){
    		outList.clear();
    	}else{
    		int minElt = inList.getFirst();
    		int minIndex = 0;
    		
    		ListIterator <Integer> i = inList.listIterator();
    		while(i.hasNext()){
    			int y = i.next();
    			if(y < minElt){
    				minElt = y;
    				minIndex = i.previousIndex();
    			}
    		}
    		inList.remove(minIndex);
    		sortList(inList,outList);
    		outList.addFirst(minElt);
    		 
    	}
    	
    	
    }
 
    private void readInput() {
        BufferedReader reader = new BufferedReader(
                   new InputStreamReader(System.in) );
 
        try {
            n = Integer.parseInt(reader.readLine());
            inList = new LinkedList<Integer>();
 
            for(int i=0; i<n; i++) {
                int x = Integer.parseInt(reader.readLine());
                inList.add(x);
            }
        } catch(Exception e) {
            System.out.println("Input error");
            n = 0;
            inList = null;
        }
    }
}