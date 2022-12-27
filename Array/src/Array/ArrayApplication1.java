package Array;
import java.util.*;

public class ArrayApplication1 {

	int len1;
	int arr1[];
	int len2;
	int arr2[];
	
	public void insertElement(int arr1[],int arr2[]) {
		this.arr1=arr1;
		len1=arr1.length;
		this.arr2=arr2;
		len2=arr2.length;
	}
	
	public void printElement() {
		System.out.println();
		System.out.print("Array: ");
		for(int i=0;i<len1;i++)
			System.out.print(arr1[i]+" ");
	}
	
	
	//Union of Two Sorted Arrays
	public void unionOrdered() {
		int arr[]=new int[len1+len2];
		int i=0;
		int j=0;
		int z=0;
		while(i<len1&& j<len2) {
			while(i<len1-1 && arr1[i]==arr1[i+1])
				i++;
			while(j<len2-1 && arr2[j]==arr2[j+1])
				j++;
			
			if(arr1[i]<arr2[j])
				arr[z++]=arr1[i++];
				
			else if(arr2[j]<arr1[i])
				arr[z++]=arr2[j++];
			else {
				arr[z++]=arr2[j++];
				i++;
			}
			
		}
		
		System.out.println();
		System.out.print("Array: ");
		for(int l=0;l<z;l++)
			System.out.print(arr[l]+" ");
	}
	
	//Intersection of two Sorted array | Find common elements of two sorted arrays
	public void intersectionOrdered() {
		int arr[]=new int[len1+len2];
		int i=0;
		int j=0;
		int z=0;
		while(i<len1&& j<len2) {
			while(i<len1-1 && arr1[i]==arr1[i+1])
				i++;
			while(j<len2-1 && arr2[j]==arr2[j+1])
				j++;
			
			if(arr1[i]<arr2[j])
				i++;
				
			else if(arr2[j]<arr1[i])
				j++;
			else {
				arr[z++]=arr2[j++];
				i++;
			}
		}
		
		System.out.println();
		System.out.print("Array: ");
		for(int l=0;l<z;l++)
			System.out.print(arr[l]+" ");
	}
	
	//Union of Two Unsorted Arrays
	public void unionUnordered() {
		int i=0,j=0;
		Set<Integer> st = new HashSet<>();
		while(i<len1 && j<len2) {
			if(i<len1 && !st.contains(arr1[i]))
				st.add(arr1[i++]);
			else if(j<len2 && !st.contains(arr1[i]))
				st.add(arr2[j++]);
		}
	}
	
	
	//Intersection of Two UnSorted arrays | Find common elements of two UnSorted arrays
	public void intersectionUnordered() {
		Set<Integer> st=new HashSet<>();
		for(int i=0;i<len1;i++) {
			st.add(arr1[i]);
		}
		
		for(int j=0;j<len2;j++) {
			if(st.contains(arr2[j]))
				System.out.println(arr2[j]);
		}
		
	}
	

	public static void main(String[] args) {
		ArrayApplication1 ob = new ArrayApplication1();
		int arr1[]= {1,2,7,9,2,6,10};
		int arr2[]= {0,3,6,3,8,7,0,8,1};
		ob.insertElement(arr1,arr2);
		//ob.unionOrdered();
		//ob.intersectionOrdered();
		ob.unionUnordered();
		//ob.intersectionUnordered();

	}

}
