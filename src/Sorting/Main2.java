package Sorting;


	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
	 
	public class Main2 {
	 
	
	    static ArrayList<Election> electionUS = new ArrayList<Election>();
	    public static void main(String[] args) {
	        Main2 m = new Main2();
	        try {
				m.readInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        m.process();
	        m.output();
	    }
	 
	    private void process() {
	    	quickSort(electionUS, 0, electionUS.size()-1);
	    }
	 
	    private void swap(int i, int j) {
	    	
	    	Election temp = electionUS.get(i);
	    	electionUS.set(i,electionUS.get(j));
	    	electionUS.set(j,temp);
	   
	    }
	 
	    private void quickSort(ArrayList<Election> x, int left, int right) {
	    	if(left >= right) {
	    		return;
	    	}
	    	double pivot = electionUS.get(right).getP1();
	    	int mid = partition(x, left, right-1, pivot);
	    	swap(mid, right);
	 
	    	quickSort(x, left, mid-1);
	    	quickSort(x, mid+1, right);
	    }
	 
	    private int partition(ArrayList<Election> x, int a, int b, double pivot) {
	    	int i = a;
	    	int j = b;
	    	while(i <= j ){
	    		while(( i <= b)&& (electionUS.get(i).getP1() > pivot)){
	    			i++;
	    		}
	    		while((j >= a) && (electionUS.get(j).getP1() < pivot)){
	    			j--;
	    		}
	    		if(i <= j){	
	    			swap(i++,j--);
	    		}
	    	}
	    	return i;
	    }
	 
	    private void output() {
	    	System.out.println("County                                     Obama     Romney   Obama%   Romney%");
	    	System.out.println("-------------------------------------------------------------------------------");
	    	try{
	    		for(int i = 0; i < electionUS.size(); i++){
	    			System.out.println(electionUS.get(i).toString());
	    		}
	    	}catch(Exception e){
	    		
	    	}
	    }
	 
	    private void readInput() throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("us-election.csv"));
			String line ;
			br.readLine();
			String[] arr;

			try{
				while (br.ready()) {
					arr = br.readLine().split(",");

					if(!arr[2].equals("0")){
						electionUS.add(new Election(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4])));
					}
					
				}
				
			}catch(IOException e){
				e.printStackTrace();
			} finally {
				br.close();
			}
			
		}
	}

