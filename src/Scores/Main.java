package Scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 
public class Main {
 
    HashTable table;
 
    public static void main(String[] args) throws IOException {
        Main m = new Main();
 
        m.process();
    }
 
    Main() {
        table = new HashTable();
    }
 
    private void process() throws IOException {
        BufferedReader reader = new BufferedReader(
                   new InputStreamReader(System.in) );
 
        int m = Integer.parseInt(reader.readLine());
 
        for(int i=0; i<m; i++) {
            String[] items = reader.readLine().split(" ");
            int additionalScore = Integer.parseInt(items[1]);
            int currentScore = table.get(items[0]) + additionalScore;
 
            System.out.println(currentScore);
            table.put(items[0],currentScore);
        }
    }
}
