package Expression;

public class Term {
    enum Type {
        NUMBER, PAREN, OPERATOR
    }
 
    private Type termType;
    private String termStr;
    private int val;
 
    public Term(String st) {
        termStr = st;
        if(st.equals("(") || st.equals(")")) {
            termType = Type.PAREN;
        } else if(st.equals("+") || st.equals("-") || st.equals("*")) {
            termType = Type.OPERATOR;
        } else {
            termType = Type.NUMBER;
            val = Integer.parseInt(termStr);
        }
    }
 
    public Term(int val) {
        termType = Type.NUMBER;
        this.val = val;
    }
 
    public Type getTermType() {
        return termType;
    }
 
    public int getVal() {
        return val;
    }
 
    public boolean isOpenParen() {
        return (termType == Type.PAREN) && (termStr.equals("("));
    }
 
    public boolean isCloseParen() {
        return (termType == Type.PAREN) && (termStr.equals(")"));
    }
 
    public boolean isOperator() {
        return termType == Type.OPERATOR; 
    }
 
    public int performOperator(int o1, int o2) {
        switch(termStr.charAt(0)) {
        case '+':
            return o1 + o2;
        case '-':
            return o1 - o2;
        case '*':
            return o1 * o2;
        }
        return 0;
    }
 
    public String toString() {
        return termStr;
    }
}