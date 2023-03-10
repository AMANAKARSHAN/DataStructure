package Array;
	
import java.util.*;
	
public class ArrayApplication {
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
	
	
	
	//Find Largest Contiguous Sum Subarray 
	public int largestContiguousSubArrayNegative() {
		int max_so_far,curr_max;
		max_so_far = curr_max = arr[0];
		for(int i=0;i<len;i++) {
			curr_max=Math.max(arr[i],curr_max+arr[i]);
			max_so_far=Math.max(curr_max,max_so_far);
		}
		return max_so_far;
	}
	
	
	//Sort an array of 0s, 1s, 2s | Dutch National Flag Problem
	public void sortedArrayWith0s1s2sbest() {
		int low=0;
		int high=len-1;
		int mid=0;
		while(mid<=high) {
			switch(arr[mid]) {
			case 0:
				if(arr[low]!=arr[mid]) {
					int t=arr[low];
					arr[low]=arr[mid];
					arr[mid]=t;
					}
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				if(arr[high]!=arr[mid]) {
					int t=arr[high];
					arr[high]=arr[mid];
					arr[mid]=t;
					}
				high--;
			}
		}
	}
	
	
	
	//Find Equilibrium point where elements before & after it has equal sum
	public int equilibriumPoint() {
		int sum=0,sum_so_far=0;
		for(int i=0;i<len;i++) {
			sum=sum+arr[i];
		}
		for(int j=0;j<len;j++) {
			sum=sum-arr[j];
			sum_so_far=sum_so_far+arr[j];
			if(sum==sum_so_far)
				return j+1;
		}
		return -1;
	}
	
	
	
	//Leaders in Array | Print Elements which are greater than all it's right elements
	public int leader(){
		int max=arr[len-1];
		for(int j=len-2;j>=0;j--) {
			if(arr[j]>max)
				max=arr[j];
		}
		return max;
	}
	
	                                                         
	
	//Find Missing Number from 1 to n range in Unsorted array
	public int missingNum() {
		int sum= len*(len-1)/2;
		for(int i=0;i<len;i++)
			sum=sum-arr[i];
		
		return sum;
	}
	
	
	
	//Search element using iterative binary Search 
	public int itebinarySearch(int val) {
		int l=0;
		int h=len-1,mid;
		while(l<=h) {
			mid=(l+h)/2;
			if(arr[mid]==val)
				return mid;
			else if(arr[mid]<val)
				l=mid+1;
			else
				h=mid-1;
		}
		
	return -1;	
	}
	
	
	//Search element using recursive binary Search	
	public int recbinarySearch(int val,int low,int high) {
		int mid=low+(high-low)/2;
		if(arr[mid]==val)
			return mid;
		else if(arr[mid]<val)
			return recbinarySearch(val,mid+1,high);
		else
			return recbinarySearch(val,low,mid-1);
	}
	
	
	//Check if there exists a pair which matches given Sum using Sorting
	public boolean pairExistOrNotAddition_sorting(int sum) {
		Arrays.sort(arr);
		int low=0;
		int high=len-1,val;
		val=arr[low]+arr[high];
		while(low<high) {
			val=arr[low]+arr[high];
			if(val==sum)
				return true;
			else if(val<sum) {
				low=low+1;
			}
			else {
				high=high-1;
			}
		}
		return false;
	}
	
	
	//Check if there exists a pair which matches given Sum using Hashing	
	public boolean pairExistOrNotAddition_hashing(int sum) {
		Set <Integer> st= new HashSet<Integer>();
		for(int i=0;i<len;i++) {
			if(st.contains(sum-arr[i]))
				return true;
			else
				st.add(arr[i]);
		}
		
		return false;
	}
	
	
	//Check if there exists a pair which matches given Multiplication using Hashing	
	//It can'nt be done by using Sorting (because of comb of -ve and +ve value)
	//we can do it by sorting by iterating first element and applying binary search in second element 
	public boolean pairExistOrNotMul_hashing(int mul) {
		Set <Integer> st= new HashSet<>();
		for(int i=0;i<len;i++) {
			if(mul%arr[i]==0 && st.contains(mul/arr[i]))
				return true;
			else
				st.add(arr[i]);
		}
		
		return false;
	}
	
	
	//Find 1st occurrence of a value in array if adjacent values differ by 1
	public int findFirstOccurenceIfAdjencentValueDiffBy1(int val) {
		int start=0;
		
		while(start<len) {
			if(arr[start]==val)
				return start;
			
			int diff=Math.abs(arr[start]-val);
				start=start+diff;
		}
		return start;
	}
	

	 //Find 1st occurrence of a value if adjacent values differ by at most K
	public int findFirstOccurenceIfAdjencentValueDiffByAtMostk(int val,int k) {
		int start=0;
		
		while(start<len-1) {
			if(arr[start]==val)
				return start;
			
			int diff=Math.abs(arr[start]-val)/k;
				diff=Math.max(diff, 1);
				start=start+diff;
		}
		return start;
	}
	
	
	
	//Find the first repeating value in array
	public int firstRepeatingValueInArray() {
		int firstRepeat=-1;
		Set<Integer> st = new HashSet<>();
		
		for(int i=len-1;i>=0;i--) {
			if(st.contains(arr[i]))
				firstRepeat=arr[i];
			else
				st.add(arr[i]);
		}
		
		return firstRepeat;
	}
	
	
	
	//Find max multiplication of any two numbers in array
	public int pairMaxMultiplication() {
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++) {
			if(arr[i]<min1) {
				min2=min1;
				min1=arr[i];
			}
			
			else if(arr[i]<min2)
				min2=arr[i];
			
			if(arr[i]>max1) {
				max2=max1;
				max1=arr[i];
			}
			
			else if(arr[i]>max2)
				max2=arr[i];
		}
		
		if(min1*min2 > max1*max2)
			return min1*min2;
		else
			return max1*max2;
		
	}

	
	//Find Sub-array whose sum is equal to given sum
	public void subArrayOfGivenSum1(int given_sum) {
		int sum=0;
		for(int i=0;i<len;i++) {
			sum=0;
			for(int j=i;j<len;j++) {
				sum=sum+arr[j];
				if(sum==given_sum)
					System.out.println("Subarray : "+i+" "+j);
			}
		}
	}
	
	//Find Sub-array whose sum is equal to given sum
	public void subArrayOfGivenSum2(int given_sum) {
		HashMap<Integer,Integer> mp = new HashMap<>();
		int totalSumTillNow=0;
		for(int end=0;end<len;end++) {
			totalSumTillNow = totalSumTillNow+arr[end];
			
			if(totalSumTillNow==given_sum) {
				System.out.println("Subarray : "+0+" "+end);
				//return;
			}
			int windowSum=totalSumTillNow-given_sum;
			if(mp.containsKey(windowSum)) {
				int start=mp.get(windowSum);
				System.out.println("Subarray : "+ (start+1) + " "+ end);
			}
		mp.put(totalSumTillNow, end);
		}
	}
	
	
	//Find Maximum Sum of sub-array with given size K
	public int maxSumSubArrayWithSizeK1(int k) {
		int kthSum=0,j=0,maxSum;
		while(j<k) {
			kthSum=kthSum+arr[j++];
		}
		maxSum=Integer.MIN_VALUE;
		for(int i=0;i<len-k;i++) {
			if(maxSum<kthSum) 
				maxSum=kthSum;
//			else {
//				System.out.println(kthSum +" "+ (i-1) +" "+ (i+k-1));
//				kthSum=kthSum-arr[i-1]+arr[i+k-1];
//				System.out.println(kthSum);
//				}
			if(i!=0)	
				kthSum=kthSum-arr[i-1]+arr[i+k-1];
		}
		
	return maxSum;	
	}
	
	//Find Maximum Sum of sub-array with given size K
	public int maxSumSubArrayWithSizeK2(int k) {
		int kthSum=0,j=0,maxSum;
		int high=k;
		int low=0;
		while(j<k) {
			kthSum=kthSum+arr[j++];
		}
		maxSum=Integer.MIN_VALUE;
		while(high<len) {
			if(maxSum<kthSum)
				maxSum=kthSum;
			kthSum=kthSum-arr[low++]+arr[high++];
			
		}
		
	return maxSum;	
	}
	
	
	//Find sub-array with maximum sum | Kadane Algo | Largest Subarray Sum
	public int maxSumSubArray() {
		int maxSum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<len;i++) {
			sum=sum+arr[i];
			if(sum>maxSum)
			maxSum=sum;
			
			if(sum<0)
				sum=0;
		}
		return maxSum;
	}
	
	
	//Find smallest sub-array length with given Sum
	public int smallestSubArrayOfGivenSum(int given_sum) {
		HashMap<Integer,Integer> mp = new HashMap<>();
		int totalSumTillNow=0;
		int smallestLen=Integer.MAX_VALUE;
		for(int end=0;end<len;end++) {
			totalSumTillNow = totalSumTillNow+arr[end];
			
			if(totalSumTillNow==given_sum) {
				//System.out.println("Subarray : "+0+" "+end);
				smallestLen=Math.min(smallestLen, end+1);
			}
			int windowSum=totalSumTillNow-given_sum;
			if(mp.containsKey(windowSum)) {
				int start=mp.get(windowSum);
				//System.out.println("Subarray : "+ (start+1) + " "+ end);
				smallestLen=Math.min(smallestLen, end-start);
			}
		mp.put(totalSumTillNow, end);
		}
		return smallestLen;
	}
	
	
	//Shuffle the array number | Shuffle the Cards
	 public void shuffleNumbers() {
		 Random randomObject = new Random();
		 
		 for(int i=0;i<len;i++)
		 { int randomValue=randomObject.nextInt(len);
		   int currentValue=arr[i];
		   arr[i]=arr[randomValue];
		   arr[randomValue]=currentValue;
		 }
		 
	 }
	
	 
	 
	 // Remove all duplicates from Sorted Array
	 public int removeDuplicate() {
		 int start=1;
		 for(int i=1;i<len;i++) {
			 if(arr[i]!=arr[i-1]) {
				 arr[start]=arr[i];
			 }
		}
		 
		 return start;
	 }
	 
	 //Square a sorted array of +/- numbers in sorted way
	 public void SquareInSortedManner() {
		 int ar[]=new int[len];
		 int j=len-1;
		 int start=0;
		 int end=len-1;
		 while(start<=end) {
			 if(arr[start]*arr[start] >= arr[end]*arr[end]) {
				 ar[j--]=arr[start]*arr[start];
				 start++;
			 }
			 else {
				 ar[j--]=arr[end]*arr[end];
				 end--;
			 }
				 
		 }
		 System.out.println("Array=");
		 for(int i=0;i<len;i++)
			 System.out.print(ar[i]+" ");
		 
	 }
	 
	 //Find all Triplets for given Sum | Check if Triplet exists for given Sum
	 public List<List<Integer>> findTriplets(int targetSum){
		 Arrays.sort(arr);
		 
		 
		 List<List<Integer>> allTriplets = new ArrayList<>();
		 
		 for(int i=0;i<len-2;i++) {
			 int Sum=targetSum-arr[i];
			 int low=i+1;
			 int high=len-1;
			 while(low<high) {
				 if(arr[low]+arr[high]==Sum) {
					 allTriplets.add(Arrays.asList(arr[low],arr[high],arr[i]));
					 low++;
					 high--;
				 }
				 else if(arr[low]+arr[high]<Sum)
					 low++;
				 else
					 high--;
			}
		 }
		 
		 
	return allTriplets;	 
	 }
	 
	 
	 
	 
	 //Find all Quadruple for given Sum
	 public List<List<Integer>> findQuadruple(int targetSum){
		 Arrays.sort(arr);
		 
		 List<List<Integer>> allquadruples = new ArrayList<>();
		 
		 for(int j=0;j<len-3;j++) {
		 for(int i=j+1;i<len-2;i++) {
			 int Sum=targetSum-arr[i]-arr[j];
			 int low=i+1;
			 int high=len-1;
			 while(low<high) {
				 if(arr[low]+arr[high]==Sum) {
					 allquadruples.add(Arrays.asList(arr[low],arr[high],arr[i],arr[j]));
					 low++;
					 high--;
				 }
				 else if(arr[low]+arr[high]<Sum)
					 low++;
				 else
					 high--;
			}
		 }
		 }
		 
	return allquadruples;	 
	 }
	
	 
	 //Find Triplets with sum smaller than Target Sum
	 public int tripletsWithLessThanGivenSum(int targetSum){
		 Arrays.sort(arr);
		 int tripletCount=0;
		 
		 for(int i=0;i<len-2;i++) {
			 int low=i+1;
			 int high=len-1;
			 while(low<high) {
				 if(arr[low]+arr[high]+arr[i] < targetSum) {
					 tripletCount = tripletCount + high - low;
					 low++;
				 }
				 else
					 high--;
				 }
		 }
	return tripletCount; 
	 }
	 
	 
	 //Find Triplet Sum which is closest to target Sum
	 //Find Minimum subarray length such that If we sort this subarray, whole array be Sorted
	 
	public int getMinSubarrayLengthForSorting() {
		if(len==0)
			return -1;
		
		int start=0;
		while(start<len-1 && arr[start]<arr[start+1])
			start++;
		
		if(start==len-1)
			return 0;
		
		int end=len-1;
		while(end>0 && arr[end]>arr[end-1])
			end--;
		
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=start;i<end;i++) {
			min=Math.min(arr[i],min);
			max=Math.max(arr[i], max);
		}
		while(start>=0 && arr[start]>min)
			start--;
		
		while(end<=len-1 && arr[end]<max)
			end++;
		
		return end-start-1;
		
	}
	
	
	//Find Subarrays with Multiplication of elements less than given Number
	public List<List<Integer>> subarrayMultiLessThanNum(int val){
		int mulOfEle=1;
		int start=0;
		
		List<List<Integer>> solution = new ArrayList<>();
		
		for(int i=0;i<len;i++) {
			mulOfEle=mulOfEle*arr[i];
			
			while(mulOfEle>=val) {
				mulOfEle=mulOfEle/arr[start];
				start++;
			}
			
			List<Integer> list=new ArrayList<>();
			for(int j=i;j>=start;j--) {
				list.add(0,arr[j]);
				solution.add(new ArrayList<>(list));
			}
		}
		
	 return solution;	
	}
	
	//Check if cycle is present in Circular array
	public boolean checkIfCircularArrayHasCycle() {
		if(len<=1)
			return false;
		for(int i=0;i<len;i++) {
			int slow,fast;
			slow=fast=i;
			boolean ifForward=arr[i]>0;
			
			while(true) {
				slow=getNextPosition(slow,ifForward);
				if(slow==-1)
					break;
				
				fast=getNextPosition(fast,ifForward);
				if(fast==-1)
					break;
				
				fast=getNextPosition(fast,ifForward);
				if(fast==-1)
					break;
				
				if(slow==fast)
					return true;
				
			}
		}
	return false;
	} 
	
	
	//Check if cycle is present in Circular array
	public int getNextPosition(int index, boolean ifForward) {
		boolean direction=arr[index] >= 0;
		if(direction != ifForward)
			return -1;
		int nextIndex=(index+arr[index])%len;
		
		if(nextIndex<0)
			nextIndex = nextIndex + len;
		
		if(nextIndex==index)
			return -1;
		
		return nextIndex;
	}
	
// Cyclic Sort | Sort the elements from 1 to n
	public void cyclicSort1ToN() {
		int i=0;
		while(i<len) {
			if(arr[i]!=i+1) {
				int index=arr[i]-1;
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
			else
			  i++;
		}
	}
	
	// Cyclic Sort | Sort the elements from n to n+k
		public void cyclicSortNtoK() {
			int i=0;
			int min=Integer.MAX_VALUE;
			
			for(int j=0;j<len;j++) {
				if(arr[j]<min)
					min=arr[j];
			}
			
			while(i<len) {
				if(arr[i]!=i+min) {
					int index=arr[i]-min;
					int temp=arr[i];
					arr[i]=arr[index];
					arr[index]=temp;
				}
				else 
				i++;
			}
		}	
	
	
// Find Missing Number in 1 to n+1 numbers range
public int findMissingNumber() {
			if(len==0)
				return -1;
			int i=0;
			while(i<len) {
				if(arr[i]<=len && arr[i]!=i+1) {
					int index=arr[i]-1;
					int temp=arr[i];
					arr[i]=arr[index];
					arr[index]=temp;
				}
				else
					i++;
			}
			
			for(int j=0;j<len;j++) {
				if(arr[j]!=j+1)
					return j+1;
			}
			return -1;
			
		}

		
// Find Corrupt Pair in 1 to n numbers range
public void corruptPair() {
		int i=0;
		while(i<len) {
			if(arr[i]!=arr[arr[i]-1]) {
				int index=arr[i]-1;
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
			else
				i++;
		}
					
		for(int j=0;j<len;j++) {
			if(arr[j]!=j+1)
				System.out.println("Duplicate = "+arr[j] +" Missing Value = "+ (j+1));
				}
	}
	

//Find Duplicate value present in 1 to n numbers range
public int duplicateNumber() {
			if(len==0)
				return -1;
			int i=0;
			while(i<len) {
				if(arr[i]!=arr[arr[i]-1]) {
					int index=arr[i]-1;
					int temp=arr[i];
					arr[i]=arr[index];
					arr[index]=temp;
				}
				else
					i++;
			}
			
			return arr[len-1];
			
		}


	
//Find all Missing and Duplicate values present in 1 to n numbers range
public List<List<Integer>> findAllDuplicateAndMissingValue() {
		int i=0;
		
		while(i<len) {
			if(arr[i]!=arr[arr[i]-1]) {
				int index=arr[i]-1;
				int temp=arr[i];
				arr[i]=arr[index];
				arr[index]=temp;
			}
			else
				i++;
		}
					
		List<Integer> missingValue=new ArrayList<>();
		List<Integer> duplicateValue=new ArrayList<>();
		
		for(int j=0;j<len;j++) {
			if(arr[j]!=j+1) {
				missingValue.add(j+1);
				duplicateValue.add(arr[j]);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		result.add(missingValue);
		result.add(duplicateValue);
		
		return result;
	}


//Longest Sub-array with all 1s if at max ?k? 0s can be replaced with 1s
public int longestSubarrayLengthWithAll1sWithkAllowedToReplace(int k) {
	if(arr==null || k>len || len==0 || k==0)
		return -1;
	int maxLength=0;
	int start,end;
	start=end=0;
	int numberOfZero=0;
	
	while(end<len) {
		if(arr[end]==0)
			numberOfZero=numberOfZero+1;
		if(arr[end]==1)
			maxLength=maxLength+1;
		if(numberOfZero>k) {
			if(arr[start]==0)
				numberOfZero--;
			start++;
		}
		maxLength=Math.max(maxLength,start-end+1);
		end++;
	}
	return maxLength;
}

// Reverse array	
public void reverseArray() {
	int start=0;
	int end=len-1;
	while(start<end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		start++;
		end--;
	}
}



//Find first missing positive number in given array
public int smallestMissingPositiveNumber() {
			if(len==0)
				return -1;
			int i=0;
			while(i<len) {
				if(arr[i]<=len && arr[i]>0 && arr[i]!=arr[arr[i]-1]) {
					int index=arr[i]-1;
					int temp=arr[i];
					arr[i]=arr[index];
					arr[index]=temp;
				}
				else
					i++;
			}
			
			for(int j=0;j<len;j++) {
				if(arr[j]!=j+1)
					return j+1;
			}
			return len+1;
			
		}


//Find the first K missing Positive number
//public List<Integer> findFirstKMissingPositiveNumber(int k) {
//	if(len==0 || k<1)
//		return new ArrayList<>();
//	int i=0;
//	while(i<len) {
//		if(arr[i]<=len && arr[i]>0 && arr[i]!=arr[arr[i]-1]) {
//			int index=arr[i]-1;
//			int temp=arr[i];
//			arr[i]=arr[index];
//			arr[index]=temp;
//		}
//		else
//			i++;
//	}
//	
//	List<Integer> missing=new ArrayList<>();
//	Set<Integer>
//	
//	for(int j=0;j<len;j++) {
//		if(arr[j]!=j+1 && k>0) {
//			result.add(j+1);
//			k--;
//		}
//	}
//	return result;
//	
//}

//Segregate Odd & Even Numbers in given Array
void  segregateOddEvenNumber() {
	int low=0;
	int high=len-1;
	while(low<high) {
		while(arr[low]%2==0 && low<high)
			low++;
		while(arr[high]%2!=0 && low<high) 
			high--;
		
		if(low<high) {
		int temp=arr[low];
		arr[low]=arr[high];
		arr[high]=temp;
		low++;
		high--;
		
		}
		}
	}

//Segregate 0's & 1's in given Array
void  segregate0And1Number() {
	int low=0;
	int high=len-1;
	while(low<high) {
		while(arr[low]==0 && low<high)
			low++;
		while(arr[high]==1 && low<high) 
			high--;
		
		if(low<high) {
		int temp=arr[low];
		arr[low]=arr[high];
		arr[high]=temp;
		low++;
		high--;
		
		}
	}
	}
	
	
	public static void main(String[] args) {
		ArrayApplication ob = new ArrayApplication();
		int arr[]= {-10,1,2,5,20};
		ob.insertElement(arr);
//		System.out.println("Largest Contiguous SubArray = " + ob.largestContiguousSubArrayNegative());
		//ob.sortedArrayWith0s1s2sbest();
		//ob.printElement();
//		System.out.println("Equilibrium Point : "+ob.equilibriumPoint());
//		System.out.println("Binary Search Recursive : "+ob.recbinarySearch(4,0,6));
//		System.out.println("Binary Search Itirative : "+ob.itebinarySearch(4));
//		System.out.println("Leader in Array : "+ob.leader());
//	    System.out.println("Pair exist or Not for given add: "+ob.pairExistOrNotAddition_sorting(20));
//		System.out.println("Pair exist or Not for given add: "+ob.pairExistOrNotAddition_hashing(20));
//     	System.out.println("Find First Occurence If Adjencent Value Diff By 1 : "+ob.findFirstOccurenceIfAdjencentValueDiffBy1(0));
//		System.out.println("Find First Occurence If Adjencent Value Diff By 1 : "+ob.findFirstOccurenceIfAdjencentValueDiffByAtMostk(2));
//		System.out.println("First repeating value in array : "+ob.firstRepeatingValueInArray());
//		System.out.println("Pair exist or Not for given Multiplication: "+ob.pairExistOrNotMul_hashing(7));
		System.out.println("Find max multiplication of any two numbers in array: " + ob.pairMaxMultiplication());
//		//ob.subArrayOfGivenSum1(4);
//		ob.subArrayOfGivenSum2(0);
//		System.out.println("Find Maximum Sum of sub-array with given size K : "+ob.maxSumSubArrayWithSizeK1(3));
//		System.out.println("Find Maximum Sum of sub-array with given size K : "+ob.maxSumSubArrayWithSizeK2(3));
//		System.out.println("Find smallest sub-array length with given Sum : "+ob.smallestSubArrayOfGivenSum(0));
//		System.out.println("Find sub-array with maximum sum | Kadane Algo | Largest Subarray Sum :"+ ob.maxSumSubArray());
//		ob.SquareInSortedManner();
//		System.out.println(ob.findTriplets(1));
//		System.out.println(ob.findQuadruple(1));
//		System.out.println(ob.tripletsWithLessThanGivenSum(1));
//		System.out.println(ob.checkIfCircularArrayHasCycle());
//		ob.cyclicSortNtoK();
//		ob.printElement();
//		System.out.println(ob.findMissingNumber());
//		ob.corruptPair();
//		System.out.println(ob.duplicateNumber());
//		System.out.println(ob.findAllDuplicateAndMissingValue());
//		System.out.println(ob.longestSubarrayLengthWithAll1sWithkAllowedToReplace(2));
//		ob.reverseArray();
//		ob.printElement();
//		System.out.println(ob.smallestMissingPositiveNumber());
//		ob.segregateOddEvenNumber();
//		System.out.println("Segregate Odd and Even : ");
//		ob.printElement();
		
//		ob.segregate0And1Number();
//		System.out.println("Segregate Odd and Even : ");
//		ob.printElement();
		
		
		} 
	}
