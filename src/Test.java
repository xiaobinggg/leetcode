import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.isValid("()"));
	}
	public boolean isValid(String s) {
		if (null == s || s.length() ==0) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray()){
			if ('(' == c || '{' == c || '[' == c) {
				stack.push(c);
			} else {
				char cinStack = stack.pop();
				if (cinStack != c) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
