package Scores;

public class HashTable {
	static final int M = 1000;
	static final int P = 997;
	static final int EMPTY_KEY = -1;

	int [] values;
	int [] keys;

	public HashTable() {
		values = new int[M];
		keys = new int[M];
		for(int i=0; i<M; i++) {
			keys[i] = EMPTY_KEY;
		}
	}

	int hash (String key){

		
		
		int val = 0;
	    for(char c : key.toCharArray())
	        val = Math.abs((val + 31*(int)c) % M);
	    return val;
	}

	void put(String k, int v) {
		int idx = hash(k); 
		while((keys[idx] != EMPTY_KEY) && (keys[idx] != hash(k))){
			idx++;
			if(idx == M) {
				idx = 0;
			}
			
		}
		keys[idx] = hash(k);
		values[idx] = v;
	}

	int get(String items) {
		int idx = hash(items);

		while((keys[idx] != hash(items)) && (keys[idx] != EMPTY_KEY)) {
			idx++;
			if(idx == M) {
				idx = 0;
			}

		}
		if(keys[idx] == hash(items)) {
			return values[idx];
		} else {
			return 0;
		}
	}
}