package DynamicProgramming;
//import java.util.*;

public class minSubsetDiff {
	//Arraylist<integer> recArray = new Arraylist<>();
	public int dp[][];
	public static boolean dp1[][];
	
	
	public void ArrayInit(int n,int total_sum) {
		dp = new int[n+1][total_sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<total_sum+1;j++) {
					dp[i][j]=-1;
			}
		}
	}
	
	
	public void ArrayInit1(int n,int total_sum) {
		dp1 = new boolean[n+1][total_sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<total_sum+1;j++) {
				if(j==0)
					dp1[i][j]=true;
				else
					dp1[i][j]=false;
			}
		}
	}
	
	
	
//	public boolean recMinSubsetDiff(int wt[],int sum,int n) {
//		if(n==0)
//			return false;
//		if(sum==0) {
//			System.out.println("aman");
//			return true;
//		}
//		
//		if(wt[n-1]<=sum)
//			return recMinSubsetDiff(wt,sum,n-1) || recMinSubsetDiff(wt,sum-wt[n-1],n-1);
//		else
//			return recMinSubsetDiff(wt,sum,n-1);
//
//	}
	
//	public int memMinSubsetDiff(int wt[],int sum,int n) {
//		if(n==0)
//			return 0;
//		if(sum==0) {
//			return 1;
//		}
//		
//		if(dp[n][sum]!=-1)
//			return dp[n][sum];
//		
//		if(wt[n-1]<=sum) {
//			if(memMinSubsetDiff(wt,sum,n-1)!=0 || memMinSubsetDiff(wt,sum-wt[n-1],n-1)!=0)
//				return dp[n][sum]=1;
//			else
//				return dp[n][sum]=0;
//		}
//		else
//			return dp[n][sum]=0;
//		
//	}
	
	public static void tabMinSubsetDiff(int wt[],int sum,int n) {
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(j==0)
					dp1[i][j]=true;
				
				else if(i==0)
					dp1[i][j]=false;
				
				else if(wt[i-1]<=j) {
					dp1[i][j]=dp1[i-1][j-wt[i-1]] || dp1[i-1][j];
				}
				else
					dp1[i][j]=dp1[i-1][j];				
			}
		}
	}
	
	
	
	public void allMinSubsetDiff(int wt[],int n) {
		int sum=0;
		int min=0;
		for(int i=0;i<n;i++)
			sum=sum+wt[i];
		
		//System.out.println(recMinSubsetDiff(wt,sum,n));
//		ArrayInit(n,sum);
//		System.out.println(memMinSubsetDiff(wt,sum,n));
		ArrayInit1(n,sum);
		tabMinSubsetDiff(wt,sum,n);
		
//		for(int i=0;i<n+1;i++) {
//			for(int j=0;j<sum+1;j++) {
//				System.out.print(dp1[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		for(int j=sum/2;j>=0;j--) {
			if(dp1[n][j]==true) {
				min=sum-2*j;
				break;
			}
		}
		
		System.out.println(min);
		
	}
	

	public static void main(String[] args) {
		minSubsetDiff ob = new minSubsetDiff();
		int wt[]= {23,2};
		int n=wt.length;
		ob.allMinSubsetDiff(wt,n);
		
		
	}

}
