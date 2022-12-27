package Stack;
import java.util.Stack;


public class StackApplication {

	public static String reverseString(String S) {
		Stack<Character> st = new Stack<>();
		String reversedstring = "";
		for(int i = 0; i < S.length(); i++ ) {
			char ch = S.charAt(i);
			st.push(ch);
		}
		
		while(!st.isEmpty()) {
			reversedstring = reversedstring + st.pop();
		}
		
		
		return reversedstring;
	}
	
	public static Boolean checkCorrectBracket(String S) {
		Stack<Character> st = new Stack<>();
		for(int i=0;i<S.length();i++) {
			char ch = S.charAt(i);
			switch(ch) {
			case '(':
			case '{':
			case '[':
				st.push(ch);
				break;
			case ')':
			case '}':
			case ']':
				if(!st.isEmpty()) {
					char c = st.pop();
					if((c=='{' && ch!='}') || (c=='(' && ch!=')') ||(c=='[' && ch!=']')) {
						System.out.println("String is not Valid1");
						return false;
					}
				}
				else {
					System.out.println("String is not Valid2");
					return false;
					}
				break;
			}
		}
	
	
	if(!st.empty()) {
		System.out.println("String is not Valid3");
		return false;
	}
	
		return true;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String str1 = "Aman Akarshan Sinha";
		System.out.println(reverseString(str1));
		
		String str2 = "Sagar Sinha";
		System.out.println(reverseString(str2));
		
		String str3 = "Reversing Of String";
		System.out.println(reverseString(str3));
		
		String str4 = "United Institute Of Technology";
		System.out.println(reverseString(str4));
		
		String st1 = "a[b+{c*(u-r)}]";
		System.out.println(checkCorrectBracket(st1));
		    
		String st2 = "a[b+{c*(u-r)}}]";
		System.out.println(checkCorrectBracket(st2));
		    
		String st3 = "a+b+c*u-r)}}]";
		System.out.println(checkCorrectBracket(st3));
		    
		String st4 = "a[[b+{c*(u-r)}]";
		System.out.println(checkCorrectBracket(st4));
		
		

	}

}
