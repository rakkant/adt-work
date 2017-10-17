package WebCache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;





public class Main {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.process();
	}

	private void process() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in) );
		String[] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int miss = 0;
		for (int i = 0 ; i < m ; i++){
			String num = reader.readLine();
			int request = Integer.parseInt(num);
			if(!arr.contains(request)){
				
					pq.add(request);
					arr.add(request);
					miss++;
					
					
					
				
			}else {
				if(arr.size() == n){
				arr.remove(0);
				pq.poll();
				}
			}
		}
		System.out.print(miss);
	}
}
