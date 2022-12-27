package Stack;
import java.util.*;

public class StackApp {
	
	
	//Given a integer array A, return the next greater element for every element in A.
	public static int[] NextLarElemRight(int[] arr) {
		int n=arr.length;
		int res[] = new int[n];
		Stack<Integer> sc = new Stack<Integer>();
		
		for(int i=n-1;i>=0;i--) {
			while(sc.isEmpty()==false && arr[i]>=sc.peek()) {
				sc.pop();
			}
			
			
			if(sc.isEmpty()==false && arr[i]<sc.peek())
					res[i]=sc.peek();
			else
					res[i]=-1;

			
			sc.push(arr[i]);
			
			
		}
		
		return res;
	}
	
	//Given a circular integer array A, return the next greater element for every element in A.
	//It is circular array
	public static int[] NextLarElemRightLeft(int[] arr) {
		int n=arr.length;
		int res[] = new int[n];
		Stack<Integer> sc = new Stack<Integer>();
		
		for(int i=2*n-1;i>=0;i--) {
			while(sc.isEmpty()==false && arr[i%n]>=sc.peek()) {
				sc.pop();
			}
			
			if(i<n) {
				if( sc.isEmpty()==false && arr[i]<sc.peek())
					res[i]=sc.peek();
				else
					res[i]=-1;
			}
			
			sc.push(arr[i%n]);
			
			
		}
		
		return res;
	}
	
	//Given a integer array A, return the next smallest element for every element in A.
	public static int[] NextSmallElemRight(int[] arr) {
		int n=arr.length;
		int res[] = new int[n];
		Stack<Integer> sc = new Stack<Integer>();
		
		for(int i=n-1;i>=0;i--) {
			while(sc.isEmpty()==false && arr[i]<=sc.peek()) {
				sc.pop();
			}
			
			
			if(sc.isEmpty()==false && arr[i]>sc.peek())
					res[i]=sc.peek();
			else
					res[i]=-1;

			
			sc.push(arr[i]);
			
			
		}
		
		return res;
	}
	
	
	//Given a circular integer array A, return the next smallest element for every element in A.
	public static int[] NextSmallElemRightLeft(int[] arr) {
		int n=arr.length;
		int res[] = new int[n];
		Stack<Integer> sc = new Stack<Integer>();
		
		for(int i=2*n-1;i>=0;i--) {
			while(sc.isEmpty()==false && arr[i%n]<=sc.peek()) {
				sc.pop();
			}
			
			if(i<n) {
				if( sc.isEmpty()==false && arr[i]>sc.peek())
					res[i]=sc.peek();
				else
					res[i]=-1;
			}
			
			sc.push(arr[i%n]);
			
			
		}
		
		return res;
	}
	
	
	
public static void main(String[] args) {
	   int arr[]= {15,2,4,1,0,7,12,8,1,10};
	   
	   int res1[]=NextLarElemRight(arr);
	   int res2[]=NextLarElemRightLeft(arr);
	   int res3[]=NextSmallElemRight(arr);
	   int res4[]=NextSmallElemRightLeft(arr);
	   
	   
	   System.out.println("Next Largest Element Right: ");
	   for(int i=0;i<arr.length;i++)
		   System.out.print(res1[i]+ " ");
	   System.out.println();
	   
	   System.out.println("Next Largest Element Right And Left: ");
	   for(int i=0;i<arr.length;i++)
		   System.out.print(res2[i]+ " ");
	   System.out.println();
	   
	   System.out.println("Next Smallest Element Right: ");
	   for(int i=0;i<arr.length;i++)
		   System.out.print(res3[i]+ " ");
	   System.out.println();
	   
	   System.out.println("Next Smallest Element Right And Left: ");
	   for(int i=0;i<arr.length;i++)
		   System.out.print(res4[i]+ " ");
	
	   
	
	

	}

}
