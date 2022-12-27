package Sorting;

public class Sorting {
	int len;
	int arr[];
	
	public void insertElement(int arr[]) {
		this.arr=arr;
		len=arr.length;
	}
	
	public void printElement() {
		System.out.println();
		System.out.print("Array: ");
		for(int i=0;i<len;i++)
			System.out.print(arr[i]+" ");
	}
	
	
	public void insertionSort() {
		for(int i=1;i<len;i++) {
			int key=arr[i];
			int j=i-1;
			 while (j>=0 && arr[j]>key)
		        {
		            arr[j+1] = arr[j];
		            j=j-1;
		        }
		        arr[j+1]=key;
		}
}   
	
	
	public void selectionSort() {
		int j, min_ind;
		int temp;
		
		for(int i=0;i<len;i++) {
			min_ind=i;
			for(j=i+1;j<len;j++) {
				if(arr[min_ind]>arr[j])
					min_ind=j;
			}
			if(min_ind!=i)
			{
			temp=arr[i];
			arr[i]=arr[min_ind];
			arr[min_ind]=temp;
			}
		}
	}
	
	public void bubbleSort() {
		int temp;
		boolean swapped=false;
		for(int i=0;i<len-1;i++) {
			for(int j=0;j<len-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			if(!swapped)
				break;
		}
	}
	
	
	// worst case when when pivot is always the smallest or the largest element.(rare)
	// for that we use randomized sort
	// advantage = it doesn't use extra array memory but merge sort use that's why quick sort used
	// instead of merge sort
	public void quickSort(int low , int high) {
		if(low < high) {
		
			int pi = partition(low,high);
			quickSort(low,pi-1);
			quickSort(pi+1,high);
		
		}
	}
	
	public int partition(int low , int high) {
		int pivot = arr[high];
		int i=low-1;
		for(int j=low;j<=high-1;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
		}
		}	
         i++;
         int temp=arr[i];
         arr[i]=arr[high];
         arr[high]=temp;		
		
		return i;
	}
	

	public void mergeSort(int l,int u) {
		int mid;
		if(l<u) {
			mid=l+(u-l)/2;
			mergeSort(l,mid);
			mergeSort(mid+1,u);
			merge(l,mid,mid+1,u);
			}
}
	
	public void merge(int l1,int u1,int l2,int u2) {
		int temp[]= new int[len];
		int i=l1;
		int j=l2;
		int k=0;
		
		
		while(i<=u1 && j<=u2) {
			if(arr[i]<arr[j])
				temp[k++]=arr[i++];
			else
				temp[k++]=arr[j++];
		}
		
		while(i<=u1) {
			temp[k++]=arr[i++];
		}
		
		while(j<=u2) {
			temp[k++]=arr[j++];
		}
		
		for(i=l1,j=0;i<=u2;i++,j++)
			arr[i]=temp[j];
		
	}
	
	
	public static void main(String[] args) {
		Sorting ob = new Sorting();
		int arr[]= {11,2,5,7,1};
		ob.insertElement(arr);
		ob.printElement();
		ob.insertionSort();
		ob.printElement();
//		ob.selectionSort();
//		ob.printElement();
		//ob.bubbleSort();
		//ob.printElement();
//		ob.mergeSort(0,arr.length-1);
//		ob.printElement();
		ob.quickSort(0, arr.length-1);
		ob.printElement();

	}

}
