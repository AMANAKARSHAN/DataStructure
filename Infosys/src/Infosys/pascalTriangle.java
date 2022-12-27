package Infosys;

public class pascalTriangle {

	void pascalTri(int n) {
		
		int arr[][]=new int[n+1][n+1]; 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j || j==0)
					arr[i][j]=1;
				else
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	void pascalRow(int n) {
		int val=1;
		for(int i=1;i<=n;i++) {
			System.out.print(val+ " ");
			val=(val*(n-i))/i;
		}
	}
	
	
	int factorial(int n) {
		int fac=1;
		for(int i=2;i<=n;i++)
			fac=fac*i;
		return fac;
	}
	
	
	void pascalEle(int row, int col) {
		int res=1;
//		System.out.println(factorial(row-1));
//		System.out.println(factorial(row-col));
//		System.out.println(factorial(col-1));
		res=factorial(row-1)/(factorial(row-col)*factorial(col-1));
		System.out.println(res);
	}
	
	
	public static void main(String args[]) {
		pascalTriangle ob = new pascalTriangle();
		ob.pascalTri(5);
		ob.pascalEle(5, 3);
		ob.pascalRow(5);
		
	}
}
