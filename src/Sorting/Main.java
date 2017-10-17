package Sorting;
import java.io.BufferedReader;


import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Election> electionUS = new ArrayList<Election>();

	public static void main(String[] args) {
		Main m = new Main();
		m.process();
		

		String csvFile = "us-election.csv";
		String line = "";
		

		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			
			System.out.println("County                                     Obama     Romney   Obama%   Romney%");
	    	System.out.println("-------------------------------------------------------------------------------");
	    	String a = br.readLine();
	    	String[] arr ;
			while ((line = br.readLine()) != null) {
				arr = line.split(",");
				electionUS.add(new Election(arr[0],arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4])));
				
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process() {
		int count = 0;
		Collections.sort(electionUS);
		while (count < electionUS.size()){
			electionUS.get(count).toString();	
			count++;
		}
	}

	
	
	
	
	

}