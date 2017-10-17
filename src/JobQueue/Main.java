package JobQueue;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private int n = 0;
    private int k = 0;
    private Job[] jobs;
 
    public static void main(String[] args) {
        Main m = new Main();
        m.process();
    }
 
    private void process() {
        readInput();
        Queue<Job> []q = new Queue[k];
		for (int i = 0 ; i < k ; i++){
			q[i] = new Queue<>();
		}
		for (int i = 0 ; i < n ; i++){
			q[jobs[i].getNextServerId()].add(jobs[i]);
		}

		int finish = 0;
		while (finish < n){
			ArrayList<Job> temp = new ArrayList<>(); 
			for (int j = 0; j < k ; j++){
				if (!q[j].isEmpty()){
					Job num = q[j].remove();
					jobs[num.id].markCurrentStepDone();
					
					if(jobs[num.id].isDone()){
						finish++;
						System.out.println(num.id);
					}else{
						temp.add(num);
					}	
				}
			}
			
			while(!temp.isEmpty()){
				q[temp.get(0).getNextServerId()].add(jobs[temp.get(0).id]);
				temp.remove(0);
			}
		}
    }
 
    private void readInput() {
        BufferedReader reader = new BufferedReader(
                   new InputStreamReader(System.in) );
 
        try {
            String[] items = reader.readLine().split(" ");
            n = Integer.parseInt(items[0]);
            k = Integer.parseInt(items[1]);
            jobs = new Job[n];
 
            for(int i=0; i<n; i++) {
                jobs[i] = new Job(i, reader.readLine());
            }
        } catch (Exception e) {
            System.out.println("Input error");
            n = 0; 
            k = 0;
        }
    }
}