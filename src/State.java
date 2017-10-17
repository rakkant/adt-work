import java.util.LinkedList;
import java.util.List;
 
public class State {
    static final int LEFT = 1;
    static final int RIGHT = 2;
 
    public int wolf;
    public int goat;
    public int cabbage;
    public int boat;
 
    public State(int w, int g, int c, int b) {
        wolf = w;
        goat = g;
        cabbage = c;
        boat = b;
    }
 
    public int opposite(int bank) {
        if(bank == LEFT) {
            return RIGHT;
        } else {
            return LEFT;
        }
    }
 
    public boolean isVariableValid(int v) {
        return (v == LEFT) || (v == RIGHT);
    }
 
    public boolean isValidState() {
        return isVariableValid(wolf) && isVariableValid(goat) &&
                isVariableValid(cabbage) && isVariableValid(boat);
    }
 
    public boolean isOk() {
        if(!isValidState()) {
            return false;
        }
 
        if((wolf == goat) && (boat != goat)) 
            return false;
 
        if((goat == cabbage) && (boat != cabbage))
            return false;
 
        return true;
    }
 
    public int getId() {
        return 1000 * wolf + 100 * goat + 10 * cabbage + boat; 
    }
 
    static public State createFromId(int id) {
        int w = id / 1000;
        int g = (id % 1000) / 100;
        int c = (id % 100) / 10;
        int b = id % 10;
 
        return new State(w,g,c,b);
    }
 
    List<State> getNextStates() {
        LinkedList<State> allStates = new LinkedList<State>();         
 
        allStates.add(new State(wolf, goat, cabbage, opposite(boat)));
        if(wolf == boat) {
            allStates.add(new State(opposite(wolf), goat, cabbage, 
                    opposite(boat)));
        }
        if(goat == boat) {
            allStates.add(new State(wolf, opposite(goat), cabbage, 
                    opposite(boat)));            
        }
        if(cabbage == boat) {
            allStates.add(new State(wolf, goat , opposite(cabbage), 
                    opposite(boat)));            
        }
 
        LinkedList<State> states = new LinkedList<State>();         
        for(State s : allStates) {
            if(s.isOk()) {
                states.add(s);
            }
        }
        return states;
    }
    public String toString() {
        String bl = "";
        String br = "";
 
        if(wolf == LEFT) {
            bl += "W ";
            br += "  ";
        } else {
            bl += "  ";
            br += "W ";            
        }
        if(goat == LEFT) {
            bl += "G ";
            br += "  ";
        } else {
            bl += "  ";
            br += "G ";            
        }
        if(cabbage == LEFT) {
            bl += "C ";
            br += "  ";
        } else {
            bl += "  ";
            br += "C ";            
        }
 
        if(boat == LEFT) {
            return bl + "| B         | " + br;
        } else {
            return bl + "|         B | " + br;
        }
    }
}