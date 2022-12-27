package DynamicProgramming;

public class SubsetSum {
	public int dp[][];
	public boolean dp1[][];
	
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
	
	
	public boolean recSubsetSum(int wt[],int total_sum,int n){
		if(total_sum==0)
			return true;
		else if(n==0)
			return false;
		
		if(wt[n-1]<=total_sum)
			return recSubsetSum(wt,total_sum-wt[n-1],n-1) ||
					recSubsetSum(wt,total_sum,n-1);
		else
			return recSubsetSum(wt,total_sum,n-1);
	}
	
	public int memSubsetSum(int wt[],int total_sum,int n){
		if(total_sum==0)
			return 1;
		if(n==0)
			return 0;
		
		if(dp[n][total_sum]!=-1) {
			
			return dp[n][total_sum];
		}

		if(wt[n-1]<=total_sum) {
			if(memSubsetSum(wt,total_sum-wt[n-1],n-1)!=0 || memSubsetSum(wt,total_sum,n-1)!=0)
				return dp[n][total_sum]=1;
			else
				return dp[n][total_sum]=0;
			
		}
		else
			return dp[n][total_sum]=memSubsetSum(wt,total_sum,n-1);
	}
	
	
	
	
	public boolean tabSubsetSum(int wt[],int total_sum,int n) {		
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<total_sum+1;j++) {
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
	return dp1[n][total_sum];
	}
	
	
	
	
	public static void main(String[] args) {
		SubsetSum ob = new SubsetSum();
		int wt[]= {3,4,2,1,2};
		int total_sum=6;
		int n=wt.length;
		
		System.out.println(ob.recSubsetSum(wt,total_sum,n));
		
		ob.ArrayInit(n,total_sum);
		System.out.println(ob.memSubsetSum(wt,total_sum,n));
//		
//		for(int i=0;i<n+1;i++) {
//			for(int j=0;j<total_sum+1;j++) {
//				System.out.print(ob.dp[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		ob.ArrayInit1(n,total_sum);
		System.out.println(ob.tabSubsetSum(wt,total_sum,n));
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<total_sum+1;j++) {
				System.out.print(ob.dp1[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	}

}
