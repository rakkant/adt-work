package TopScores;

public class Team implements Comparable<Team> {
    public int score;
    public int id;
 
    public Team(int i, int s) {
        id = i; score = s;
    }
 
    @Override
    public int compareTo(Team a) {
        if(score < a.score) {
            return 1;
        } else if(score > a.score) {
            return -1;
        } else {
            return id - a.id;
        }
    }  
    
    public String toString(){
    	return id+","+score;
    }
}