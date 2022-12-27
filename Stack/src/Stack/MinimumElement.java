package Stack;
import java.util.*;



//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Using two stack
class MinimumElementMethod1{
	
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		
       public void pushElement(int val) {
    	   st1.push(val);
    	   if(st2.isEmpty()) {
    		   st2.push(val);
    	   }
    	   else {
    		   if(val<st2.peek()) {
    			   st2.push(val);
    		   }
    	   }
    	   
    	 }
       
       public int popElement() {
    	   if(st1.empty()) {
    		   System.out.println("Stack is empty");
    		   return -1;
    	   }
    	   if(st1.peek()==st2.peek()) {
    		   st2.pop();
    	   }
    	   return st1.pop();
    	}
       
       public int findMin() {
    	   if(st1.empty()) {
    		   System.out.println("Stack is empty");
    		   return -1;
    	   }
    	   
    	   return st2.peek();
    	   
       }
       
       
}
	
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Using Single stack

class MinimumElementMethod2{
	Stack<Integer> st1 = new Stack<>();
	int MIN;
	
    public void pushElement(int val) {
 	   if(st1.isEmpty()) {
 		   MIN=val;
 		  st1.push(val);
 		  return;
 	   }
 		   if(val<MIN) {
 			   st1.push(2*val-MIN);
 			   MIN=val;
 		   }else {
 			   st1.push(val);
 		   }
 	   }
 	   
    
    public int popElement() {
 	   if(st1.empty()) {
 		   System.out.println("Stack is empty");
 		   return -1;
 	   }
 	   if(st1.peek()<MIN) {
 		   MIN=2*MIN-st1.peek();
 	   }
 	   return st1.pop();
 	}
    
    
    public int findMin() {
 	   if(st1.empty()) {
 		   System.out.println("Stack is empty");
 		   return -1;
 	   }
 	   
 	   return MIN;
 	   
    }
	
	

	
}



public class MinimumElement {
	
	public static void main(String[] args) {
		MinimumElementMethod1 ob1=new MinimumElementMethod1();
		ob1.pushElement(87);
		ob1.pushElement(0);
		ob1.pushElement(58);
		ob1.pushElement(32);
		System.out.println("Popped Element: "+ob1.popElement());
		System.out.println("Minimum Value: "+ob1.findMin());
		ob1.pushElement(25);
		System.out.println("Minimum Value: "+ob1.findMin());
		System.out.println("Popped Element: "+ob1.popElement());
		ob1.pushElement(4);
		System.out.println("Minimum Value: "+ob1.findMin());
		
		
		MinimumElementMethod2 ob2=new MinimumElementMethod2();
		ob2.pushElement(4);
		ob2.pushElement(7);
		ob2.pushElement(45);
		ob2.pushElement(89);
		System.out.println("Popped Element: "+ob2.popElement());
		System.out.println("Minimum Value: "+ob2.findMin());
		ob2.pushElement(67);
		System.out.println("Minimum Value: "+ob2.findMin());
		System.out.println("Popped Element: "+ob2.popElement());
		ob2.pushElement(34);
		System.out.println("Minimum Value: "+ob2.findMin());

	}

}
