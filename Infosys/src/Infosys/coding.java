package Infosys;

public class coding {
	boolean armstrongNumber(int n) {
		int count=0,num1=n,num2=n;
	    double sum=0;
		while(num1!=0) {
			count++;
			num1=num1/10;
		}
		
		
		while(num2!=0) {
			sum=sum + Math.pow(num2%10, count);
			num2=num2/10;
		}
		
		if(sum==n)
			return true;
		else
			return false;
		
	}
	
	
	int reverseNumber(int n) {
		int rev=0;
		while(n!=0) {
			rev=rev*10+(n%10);
			n=n/10;
		}
		return rev;
	}
	
	////O(N)
	 void fibonacciIteration(int N)
	    {
	        int num1 = 0, num2 = 1;
	  
	        int counter = 0;
	  
	        while (counter < N) {
	  
	            System.out.print(num1 + " ");
	            int num3 = num2 + num1;
	            num1 = num2;
	            num2 = num3;
	            counter = counter + 1;
	        }
	    }
	 
	 
	 //O(2^N)
	 int fibonacciRecursive(int n)
	    {
	        if (n <= 1)
	            return n;
	  
	        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	    }
	 
	 int fibonacciDP(int n) {
		 int dp[]=new int[n+2];
		 int i;
		 dp[0]=0;
		 dp[1]=1;
		 
	     for(i=2;i<=n;i++) {
	            dp[i] = dp[i-1] + dp[i-2];
	        }
	        return dp[n];
		 
	 }
	 
	
	
	public static void main(String args[]) {
		coding ob=new coding();
		System.out.println(ob.armstrongNumber(371));
		System.out.println(ob.reverseNumber(371));
		ob.fibonacciIteration(10);
		
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(ob.fibonacciRecursive(i)+" ");
		}
		
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(ob.fibonacciDP(i)+" ");
		}
		
		
		
		
	}

}
