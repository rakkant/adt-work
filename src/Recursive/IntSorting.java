package Recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
 
public class IntSorting {
 
    LinkedList<Integer> inList;
    LinkedList<Integer> outList;
    int n;
 
    public static void main(String[] args) {
    	IntSorting m = new IntSorting();
 
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
    		int x = inList.remove();
    		sortList(inList,outList);
    		  
    		  
    		  ListIterator<Integer> i = outList.listIterator();
    		  while(i.hasNext()){
    			  int c = i.next();
    			  if(c >= x){
    				  i.previous();
    				  break;
    			  }
    		  }
    		  i.add(x);
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