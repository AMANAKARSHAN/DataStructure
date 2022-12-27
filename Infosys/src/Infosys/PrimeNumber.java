package Infosys;

public class PrimeNumber {
	int arr[]=new int[1000000];
	
	//https://www.youtube.com/watch?v=yB57bcffJo4&ab_channel=CodingBlocks
	//There are three approach to find prime number
	
	//Naive Approach O(N)
	boolean isPrimeN(int n) {
		if(n==1)
			return false;
		if(n==2)
			return true;
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
		
	}
	
	//Naive Approach O(logN)
	boolean isPrimeLogN(int n) {
		if(n==1)
			return false;
		if(n==2)
			return true;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
		
	}
	
	//prime sieve approach = Generate array containing prime number
	
	void primeSeive(int n) {
		// First mark all odd number's prime
		for(int i=3;i<=n;i+=2)
			arr[i]=1;
		
		//Sieve
		for(int j=3;j<=n;j+=2) {
			//if current number is not marked (it is prime) 
			if(arr[j]==1) {
				//mark all the multiple of i as not prime
				for(int i=j*j;i<=n;i=i+j)
					arr[i]=0;
			}
		}
		
		//special case
		arr[2]=1;
		arr[0]=arr[1]=0;
		
		
		// print prime number
		System.out.println("Print Prime Number prime Seive approach: ");
		for(int i=0;i<n;i++) {
			if(arr[i]==1)
				System.out.print(i+" ");
		}
}
	
	public static void main(String []args) {
		PrimeNumber ob = new PrimeNumber();
		int n=50;
		System.out.println("Print Prime Number method 1: ");
		for(int i=1;i<n;i++) {
			if(ob.isPrimeN(i)==true)
				System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println("Print Prime Number method 2: ");
		for(int i=1;i<n;i++) {
			if(ob.isPrimeLogN(i)==true)
				System.out.print(i+" ");
		}
		
		System.out.println();
		ob.primeSeive(n);
		
		
	}

}
