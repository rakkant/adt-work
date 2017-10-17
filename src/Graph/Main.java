package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.process();
	}

	int n,m; 
	List<Integer> [] adjList;
	private int[] levels;

	void process() {
		readInput();
		// findLevels();
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
			}
		} catch(Exception e) {
		}
	}

	void findLevels(int s) {
		List<Integer> nextLevel = new ArrayList<Integer>();
		levels = new int[n];
		for(int u=0; u<n; u++) {
			levels[u] = -1;
		}
		levels[s] = 0;
		nextLevel.add(s);

		while(! nextLevel.isEmpty()) {
			List<Integer> currentLevel = nextLevel;
			nextLevel = new ArrayList<Integer>();

			for(int u : currentLevel) {
				for(int v : adjList[u]) {
					if(levels[v] == -1) {
						levels[v] = levels[u] + 1;
						nextLevel.add(v);
					}
				}
			}
		}
	}
}
