package IcecreamQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;



public class Main {
	int m;
	public static void main(String[] args) throws IOException{
		Main m = new Main();
		m.process();
	}

	void process()  throws NumberFormatException, IOException{
		PQ<Customer> pq = new PQ();
		//PriorityQueue<Customer> pq = new PriorityQueue();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(reader.readLine());
		System.out.println();
		for(int i = 0; i < m ; i++){
			String items[] = reader.readLine().split(" ");
			if((items.length == 1) && (items[0].equals("2"))){
				System.out.println(pq.poll().getId());
			}else{
				int numNewCustomer = Integer.parseInt(items[1]);
				for (int j = 0; j < numNewCustomer ; j++){
					int id = Integer.parseInt(items[2 + j * 2]);
					int age = Integer.parseInt(items[2 + j * 2 + 1]);
					pq.add(new Customer(id,age));

				}
			}
		}



	}


}
