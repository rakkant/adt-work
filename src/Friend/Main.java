package Friend;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class Main {
	int n,m;
	List<Integer> [] adjList;
	int[] degrees;
	int[] inDegrees;
	int[] outDegrees;
	boolean[] found;
	int depth;
	int[] levels;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.process();
	}

	void process() {
		readInput();
	}

	public void findLevels(int s){
		List<Integer> nextLevel = new ArrayList<Integer>();
		for (int u = 0 ; u < n ; u++){
			levels[u] = -1;
		}
		levels[s] = 0;
		
		while(!nextLevel.isEmpty()){
			List<Integer> currentLevel = nextLevel;
			nextLevel = new ArrayList<Integer>();
			
			for(int u : currentLevel){
				for (int v : adjList[u]){
					if(levels[v] == -1){
						levels[v] = levels[u]+1;
						nextLevel.add(v);
					}
				}
			}
		}
		
	}
	
	public boolean isReachable(int s, int d){
		LinkedList<Integer> temp;
		boolean visited[] = new boolean[m];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		Iterator<Integer> i;
		while(queue.size() != 0){
			s = queue.poll();
			int n;
			i = adjList[s].listIterator();
			while(i.hasNext()){
				n = i.next();
				if((n == d)) return true;
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		} 
		return false;
	}


	private void readInput() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in) );

		try {
			String[] items = reader.readLine().split(" ");

			n = Integer.parseInt(items[0]);
			m = Integer.parseInt(items[1]);

			
			adjList = (List<Integer>[])(new List[n]);
			for(int i=0; i<n; i++) {
				adjList[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<m; i++) {
				items = reader.readLine().split(" ");
				int u = Integer.parseInt(items[0]);
				int v = Integer.parseInt(items[1]);

				adjList[u].add(v);
				adjList[v].add(u);
				
				degrees[u]++;
				degrees[v]++;
			}
		} catch(Exception e) {
		}
	}


}