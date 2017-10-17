package Maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	char[] maze ;
	static int posx = 0;
	static int poso = 0;
	int row ;
	int column ;
	static int[] levels;
	static int[] parents;
	Graph g;
	public static void main(String[] args) throws IOException{
		Main main = new Main();
		main.process();
		main.breadthFirstSearch(poso); //กำหนดตำแหน่ง
		System.out.println(levels[posx]);
		main.changeMaze();
		main.printString();
	}


	private void process() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in) );

		String[] input = reader.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		column = Integer.parseInt(input[1]);
		maze = new char[row*column];
		g = new Graph(row*column);
		int temp = 0;
		for (int i = 0; i < row ; i++ ){
				String sqr = reader.readLine();
				for (int l = 0; l < sqr.length(); l++) {
					maze[temp] = sqr.charAt(l);
					if (maze[temp] == 'O') poso = temp;  
					if (maze[temp] == 'X') posx = temp;
					if (l > 0 && maze[temp] != '#' && maze[temp-1] != '#' ) g.addEdge(temp-1, temp); //เช็คตัวเอง
					if (i > 0 && maze[temp-column] != '#' && maze[temp] != '#') g.addEdge(temp-column,temp );
					temp++;
					
				}

			
		}
	}
	public void printString(){
		

		
		for (int i = 0; i < maze.length ; i++){
			System.out.print(maze[i]);
			if ((i+1)% column == 0){
				System.out.println();
			}
		}
	}
	
	void breadthFirstSearch(int s) {
        List<Integer> nextLevel = new ArrayList<Integer>();
        levels = new int[g.getN()];
        parents = new int[g.getN()];
        for(int u=0; u < g.getN(); u++) {
            levels[u] = -1;
            parents[u] = -1;
        }
        levels[s] = 0;
        nextLevel.add(s);
 
        while(! nextLevel.isEmpty()) {
            List<Integer> currentLevel = nextLevel;
            nextLevel = new ArrayList<Integer>();
 
            for(int u : currentLevel) {
                for(int v : g.getAdjList(u)) {
                    if(levels[v] == -1) {
                        levels[v] = levels[u] + 1;
                        parents[v] = u;
                        nextLevel.add(v);
                    }
                }
            }
        }
    }
	public void changeMaze(){
		int index = parents[posx];
		int temp = posx;
		
		while (index != poso){
			
			if (temp - index == 1) maze[index] = '>';
			else if (temp - index == column ) maze[index] = 'v';
			else if (temp - index == -column) maze[index] = '^';
			else maze[index] = '<';
			temp = index;
			index = parents[index];
			
		}
	}
	
}
