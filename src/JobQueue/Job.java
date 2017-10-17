package JobQueue;

public class Job {
    public int id;
    public int numSteps;
    public int[] serverIds;
    public int numStepsDone = 0;
 
    public Job(int id, String line) {
        this.id = id;
 
        String[] items = line.split(" ");
        numSteps = Integer.parseInt(items[0]);
        numStepsDone = 0;
 
        serverIds = new int[numSteps];
        for(int i=0; i<numSteps; i++) {
            serverIds[i] = Integer.parseInt(items[i+1]);
        }
    }
 
    public int getNextServerId() {
        return serverIds[numStepsDone];
    }
 
    public void markCurrentStepDone() {
        numStepsDone++;
    }
 
    public boolean isDone() {
        return numSteps == numStepsDone;
    }
 
    // added to help you debugging
    public String toString() {
        return "" + id + "(" + numStepsDone + "/" + numSteps + ")";
    }
}
