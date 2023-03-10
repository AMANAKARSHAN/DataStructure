package DynamicProgramming;

public class KnapsackApp {
	int [][]dp;
	
	public void ArrayInit(int n,int tot_wt) {
		dp = new int[n+1][tot_wt+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<tot_wt+1;j++) {
				dp[i][j]=-1;
			}
		}
	}
	
	public void ArrayInit1(int n,int tot_wt) {
		dp = new int[n+1][tot_wt+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<tot_wt+1;j++) {
				dp[i][j]=0;
			}
		}
	}
	
	
	public int recKnapsack_01(int wt[],int val[],int tot_wt,int n){
		if(tot_wt==0 || n==0)
			return 0;
		
		if(wt[n-1]<=tot_wt)
			return Math.max(val[n-1]+recKnapsack_01(wt,val,tot_wt-wt[n-1],n-1),
					recKnapsack_01(wt,val,tot_wt,n-1));
		else
			return recKnapsack_01(wt,val,tot_wt,n-1);
	}
	
	
	
	public int memKnapsack_01(int wt[],int val[],int tot_wt,int n){
		if(tot_wt==0 || n==0)
			return 0;
		if(dp[n][tot_wt]!=-1)
			return dp[n][tot_wt];
		
		if(wt[n-1]<=tot_wt)
			return dp[n][tot_wt]=Math.max(val[n-1]+memKnapsack_01(wt,val,tot_wt-wt[n-1],n-1),
					memKnapsack_01(wt,val,tot_wt,n-1));
		else
			return dp[n][tot_wt]=memKnapsack_01(wt,val,tot_wt,n-1);
	}
	
	
	
	public int tabKnapsack_01(int wt[],int val[],int tot_wt,int n) {		
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<tot_wt+1;j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(wt[i-1]<=j) {
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
				}
				else
					dp[i][j]=dp[i-1][j];	
			}
		}
		
		
		return dp[n][tot_wt];
	}
	
	
	public static void main(String[] args) {
		KnapsackApp ka = new KnapsackApp();
		int wt[] = {3,4,1,7,2};
		int val[] = {15,2,4,2,8};
		int n = wt.length;
		int tot_wt=10;
		ka.ArrayInit(n,tot_wt);
		//System.out.print(ka.dp.length);
		
//		for(int i=0;i<n+1;i++) {
//			for(int j=0;j<n+1;j++) {
//				System.out.print(ka.dp[i][j]);
//			}
//		}
		System.out.println(ka.recKnapsack_01(wt,val,tot_wt,n));
		
		System.out.println(ka.memKnapsack_01(wt,val,tot_wt,n));
	
		ka.ArrayInit1(n,tot_wt);

		System.out.println(ka.tabKnapsack_01(wt,val,tot_wt,n));
	}

}
