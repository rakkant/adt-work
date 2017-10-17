package TopScores;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.PriorityQueue;


public class Main {

	HashMap<Integer,Team> sorting = new HashMap<Integer,Team>();
	PriorityQueue<Team> pq = new PriorityQueue<Team>();
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.process();
	}


	private void process() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in) );

		String[] items = reader.readLine().split(" ");
		int m = Integer.parseInt(items[0]);
		int k = Integer.parseInt(items[1]);

		for(int i=0; i<m; i++) {
			String[] input = reader.readLine().split(" ");
			int teamID = Integer.parseInt(input[0]);
			int scores = Integer.parseInt(input[1]);

			if (sorting.containsKey(teamID)){
				sorting.get(teamID).score += scores;
			}else{
				sorting.put(teamID,new Team(teamID,scores));
			}
			if((i+1)% k ==0){
				pq.clear();
				pq.addAll(sorting.values());
				if(pq.size() <= m){
					while (!pq.isEmpty()){
						System.out.println(pq.peek().toString());
						pq.poll();
					}
				}else{
					for (int j = 0; j < m ; j++){
						System.out.println(pq.peek().toString());
						pq.poll();
					}
				}
				System.out.println();
			}
		}
	}
}
