package Parenth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.process();
	}

	private void process() throws Exception {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in) );

		int t = Integer.parseInt(reader.readLine());

		for(int i=0; i<t; i++) {
			String st = reader.readLine(); 

			if(check(st)) {
				System.out.println("yes");
			} else {
				System.out.println("no");                
			}
		}
	}

	private boolean check(String st) {
		Stack<Character> unmatched = new Stack<Character>();

		for (int i = 0; i < st.length() ; i++){
			char ch = st.charAt(i);

			if( ch == '('){
				unmatched.push(ch);
			}
			else if(ch == '{'){
				unmatched.push(ch);
			}
			else if (ch == ')'){
				if(unmatched.empty()){
					return false;
				}else if (unmatched.peek() == '('){
					unmatched.pop();
				}else{
					return false;
				}
			}
			else if(ch == '}'){
				if(unmatched.empty()){
					return false;
				}else if (unmatched.peek() == '{'){
					unmatched.pop();
				}else{
					return false;
				}
			}
			
			return unmatched.empty(); 
		}
		return false;
	}
}