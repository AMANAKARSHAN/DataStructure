package Matrix;
import java.util.*;

public class MatrixApplication {
	int row;
	int col;
	int mat[][];
	
	public void insertElement(int mat[][]) {
		this.mat=mat;
		col=mat.length;
		row=mat[0].length;
	}
	
	public void printElement() {
		System.out.println();
		System.out.println("Matrix : ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
	
	//Find element in row & column wise Sorted Matrix
	public List<Integer> findElementInSortedMatrix(int ele){
		List<Integer> result = new ArrayList<>();
		int j=col-1;
		int i=0;
		
		while(i<row && j>=0) {
			if(mat[i][j]<ele)
				i++;
			else if(mat[i][j]>ele)
				j--;
			else {
				result.add(i);
				result.add(j);
				break;
			}
				
		}
		return result;	
	}
	
	//Find number of elements lesser than or equal to given value in Sorted Matrix
		public int NumOfElementLessThanOrEqualToGivenValue(int ele){
			int j=col-1;
			int i=0;
			int count=0;
			
			while(i<row && j>=0) {
				if(mat[i][j]<=ele) {
					count=count+j+1;
					i++;
				}
				else if(mat[i][j]>ele)
					j--;
					
			}
			return count;	
		}
		
		
		
	//Find number of elements greater than given value in row & column wise Sorted Matrix
		public int NumOfElementGreaterThanGivenValue(int ele){
			int j=0;
			int i=row-1;
			int count=0;
			
			while(j<col && i>=0) {
				if(mat[i][j]>ele) {
					count=count+col-j;
					i--;
				}
				else
					j++;
			}
			return count;	
		}
		
		
	 //Rotate matrix by 90 degree clockwise
		public void rotateMatrixBy90() {
			for(int i=0;i<row;i++) {
				for(int j=i+1;j<col;j++) {
					int temp=mat[i][j];
					mat[i][j]=mat[j][i];
					mat[j][i]=temp;
				}
			}
			
			int low=0;
			int high=0;
			for(int i=0;i<row;i++) {
				low=0;
				high=row-1;
				while(low<high) {
					int temp=mat[i][low];
					mat[i][low]=mat[i][high];
					mat[i][high]=temp;
					low++;
					high--;
				}
			}
		}
		
		
		// Spiral Traversal of Matrix
		public void spiralTraversalOfMatrix() {
			int top=0;
			int buttom=row-1;
			int left=0;
			int right=col-1;
			int dir=0;
			
			List<Integer> result = new ArrayList<>();
			
			while(top<=buttom && left<=right) {
				if(dir==0) {
					for(int i=left;i<=right;i++) 
						result.add(mat[top][i]);
					top++;
				}
				else if(dir==1) {
					for(int i=top;i<=buttom;i++) 
						result.add(mat[i][right]);
					right--;
					}
				else if(dir==2) {
					for(int i=right;i>=left;i--) 
						result.add(mat[buttom][i]);
					buttom--;
					}
				else if(dir==3) {
					for(int i=buttom;i>=top;i--) 
						result.add(mat[left][i]);
					left++;
				}
				
				dir=(dir+1)%4;
			}
			
			
			System.out.println(result);
			
			
		}
		
		
		
	
	public static void main(String args[]) {
		MatrixApplication ob = new MatrixApplication();
		int[][] mat= {{2,7,15},{4,9,19},{6,10,24}};
		ob.insertElement(mat);
//		System.out.println(ob.findElementInSortedMatrix(6));
//		System.out.println(ob.NumOfElementLessThanOrEqualToGivenValue(19));
//		System.out.println(ob.NumOfElementGreaterThanGivenValue(10));
		ob.printElement();
//		ob.rotateMatrixBy90();
//		ob.printElement();
		ob.spiralTraversalOfMatrix();
	}
	

}
