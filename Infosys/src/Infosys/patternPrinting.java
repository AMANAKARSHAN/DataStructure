package Infosys;

public class patternPrinting {
		
	void increasingTriangle(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	void decreasingTriangle(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
					System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	void rightSidedTriangle1(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
					System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("*");
		}
			System.out.println();
		}
		
	}
	
	void rightSidedTriangle2(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
		}
			for(int j=i;j<=n;j++) {
					System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
	
	void leftSidedTriangle(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=n;j++) {
					System.out.print("*");
			}
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
		}
			System.out.println();
		}
		
	}
	
	
	void hill(int n) {
		int k=0;
		for(int i=1;i<=n/2+1;i++) {
			for(int j=1;j<=n;j++) {
				if(j<=n/2+1)
					k=n/2+2-j;
				else
					k=j-n/2;
				
				if(k<=i)
					System.out.print("*");
				else
					System.out.print(" ");
					
			}
			System.out.println();
		}
		
	}
	
	void reverseHill(int n) {
		int l=0;
		for(int i=1;i<=n/2+1;i++) {
			for(int j=1;j<=n;j++) {
				if(j<=n/2+1)
					l=j;
				else
					l=n-j+1;
				
				if(l>=i)
					System.out.print("*");
				else
					System.out.print(" ");
					
			}
			System.out.println();
		}
		
	}
	
	void diamond(int n) {
		int k=0,l=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(j<=n/2+1)
					k=n/2+2-j;
				else
					k=j-n/2;
				
				if(i<=n/2+1)
					l=i;
				else
					l=n-i+1;
				
				if(k<=l)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}
	
	void hollowDiamond(int n) {
		int k=0,l=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(j<=n/2+1)
					k=n/2+2-j;
				else
					k=j-n/2;
				
				if(i<=n/2+1)
					l=i;
				else
					l=n-i+1;
				
				if(k==l)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	
	}
	
	
	public static void main(String args[]) {
		patternPrinting ob = new patternPrinting();
		ob.increasingTriangle(5);
		System.out.println("Pattern printing");
		ob.decreasingTriangle(5);
		System.out.println("Pattern printing");
		ob.rightSidedTriangle1(5);
		System.out.println("Pattern printing");
		ob.rightSidedTriangle2(5);
		System.out.println("Pattern printing");
		ob.leftSidedTriangle(5);
		System.out.println("Pattern printing");
		ob.hill(9);
		System.out.println("Pattern printing");
		ob.diamond(5);
		System.out.println("Pattern printing");
		ob.reverseHill(9);
		System.out.println("Pattern printing");
		ob.hollowDiamond(5);
		
	}
	

}
