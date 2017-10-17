package Expression;

import java.io.BufferedReader;

import java.io.InputStreamReader;


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
			LinkedList<Term> terms = parseTerms(st);
			System.out.println(evaluate(terms));
		}
	}

	private int evaluate(LinkedList<Term> terms) {
		Stack<Term> temp =  new Stack();
		
		while(!terms.isEmpty()){
			if (terms.iterator().getVal().isCloseParen()){
				Term num2 = temp.pop ();
				Term operate = temp.pop();
				Term num1 = temp.pop();
				temp.pop();
				int finalAns = operate.performOperator(num1.getVal(),num2.getVal());
				Term answer = new Term (finalAns);
				temp.push(answer);
				terms.removeHead();
			}else{
				temp.push(terms.iterator().getVal());
				terms.removeHead();
			}
		}
		return temp.peek().getVal() ;
	}

	private LinkedList<Term> parseTerms(String st) {
		LinkedList<Term> output = new LinkedList<Term>();
		int i=0;
		while(i<st.length()) {
			char ch = st.charAt(i);
			if((ch >= '0') && (ch <= '9')) {
				int j = i;
				while((st.charAt(j) >= '0') && (st.charAt(j) <= '9')) {
					j++;
				}

				String termStr = st.substring(i, j);
				output.add(new Term(termStr));

				i = j;
			} else {
				output.add(new Term("" + ch));
				i++;
			}
		}
		return output;
	}
}