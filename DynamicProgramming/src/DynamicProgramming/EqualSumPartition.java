package DynamicProgramming;

public class EqualSumPartition {
	static int dp[][];
	static boolean dp1[][];
	
	public static void ArrayInit(int n,int tot_wt) {
		dp = new int[n+1][tot_wt+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<tot_wt+1;j++) {
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
	
	
	public static boolean recEqualSumPartition(int wt[],int tot_sum,int n) {
		if(tot_sum==0)
			return true;
		if(n==0)
			return false;
		if(wt[n-1]<=tot_sum)
			return recEqualSumPartition(wt,tot_sum,n-1) ||
					recEqualSumPartition(wt,tot_sum-wt[n-1],n-1);
		else
			return recEqualSumPartition(wt,tot_sum,n-1);
	}
	
	
	public static int memEqualSumPartition(int wt[],int tot_sum,int n) {
		if(tot_sum==0)
			return 1;
		if(n==0)
			return 0;
		
		if(dp[n][tot_sum]!=-1)
			return dp[n][tot_sum];
		
		if(wt[n-1]<=tot_sum) {
			if(memEqualSumPartition(wt,tot_sum-wt[n-1],n-1)!=0 || memEqualSumPartition(wt,tot_sum,n-1)!=0)
				return dp[n][tot_sum]=1;
			else
				return dp[n][tot_sum]=0;
		}
		else
			return dp[n][tot_sum]=memEqualSumPartition(wt,tot_sum,n-1);
	}
	
	
	public static boolean tabEqualSumPartition(int wt[],int tot_sum,int n) {
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<tot_sum+1;j++) {
				if(i==0) 
					dp1[i][j]=false;
				
				else if(j==0)
					dp1[i][j]=true;
				
				else if(wt[i-1]<=j) 
					dp1[i][j]=dp1[i-1][j-wt[i-1]] || dp1[i-1][j];
				
				else
					dp1[i][j]=dp1[i-1][j];	
			}
		}
	return dp1[n][tot_sum];
}
	
	public void allEqualSumPartition(int wt[],int n) {
		int sum=0;
		for(int i=0;i<n;i++)
			sum=sum+wt[i];
		
		if(sum%2!=0)
			System.out.println(false);
		else {
		System.out.println(recEqualSumPartition(wt,sum/2,n));
		ArrayInit(n,sum/2);
		System.out.println(memEqualSumPartition(wt,sum/2,n));
		ArrayInit1(n,sum/2);
		System.out.println(tabEqualSumPartition(wt,sum/2,n));
		
		}
	}
	

	public static void main(String[] args) {
		EqualSumPartition ob = new EqualSumPartition();
		int wt[]= {3,4,2,1,2};
		int n=wt.length;
		ob.allEqualSumPartition(wt,n);
	}

}
