import java.util.ArrayList;
import java.util.List;

public class MainG {

	int levels[];
	int parents[];
	Graph g;
	
	public static void main(String[] args){
		MainG main = new MainG();
		main.process();
	}
	
	private void process() {
        buildGraph();
        State startingState = new State(State.LEFT, State.LEFT,
                State.LEFT,State.LEFT);
        State finalState = new State(State.RIGHT, State.RIGHT,
                State.RIGHT,State.RIGHT);
        breadthFirstSearch(startingState.getId());
 
        int v = finalState.getId();
        while(true) {
            State s = State.createFromId(v);
            System.out.println(s);
            v = parents[v];
            if(v == -1) {
                break;
            }
        }
        System.out.println();
    }
 
    private void buildGraph() {
        g = new Graph(3000);
        for(int i=0; i<3000; i++) {
            State s = State.createFromId(i);
            if(s.isValidState() && s.isOk()) {
                List<State> nextStates = s.getNextStates();
 
                for(State ns : nextStates) {
                    g.addArc(i, ns.getId());
                }
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
}