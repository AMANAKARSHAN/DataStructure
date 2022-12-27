package String;
import java.util.*;

public class StringApplication {
	int len;
	String str;
	
	public void insertElement(String str) {
		this.str=str;
		len=str.length();
	}
	
	public void printString() {
		System.out.println(str);
	}
	
	
	//Print first character of every word
	public void firstCharacterOfEveryWord() {
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ') {
				if(i==0)
					System.out.print(str.charAt(0)+" ");
				else if(str.charAt(i-1)==' ')
					System.out.print(str.charAt(i)+" ");
			}
		}
		System.out.println();
	}
	
	//Remove useless space from string
	public String removeUselessSpaceFromString() {
		String s="";
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ') {
				s=s+str.charAt(i);
			}
			else if(str.charAt(i)==' ' && i!=0 && str.charAt(i-1)!=' ' ) {
				s=s+' ';
			}
		}
		return s;
	}
	
	//Replace the character with different character
	public void replaceCharacter() {
		char ch[]=str.toCharArray();
		
		for(int i=0;i<len;i++) {
			if(ch[i]=='A')
				ch[i]='R';
			else if(ch[i]=='a')
				ch[i]='r';
		}
		System.out.print(ch);
	}
	
	
	//Reverse String using stack
	public void reverseStringStack() {
		Stack<Character> st= new Stack<>();
		
		for(int i=0;i<len;i++)
			st.push(str.charAt(i));
		
		while(!st.empty()) {
			System.out.print(st.pop());
		}
	}
	
	
	////Reverse String using Recursion
	public void reverseStringRecursion(String str) {
		if(str==null || str.length()<=1)
			System.out.print(str);
		else {
			System.out.print(str.charAt(str.length()-1));
			reverseStringRecursion(str.substring(0,str.length()-1));
		}
	}

	
	//Reverse String iterative
	public void reverseStringiterative() {
		int low=0;
		int high=len-1;
		char ch[]=str.toCharArray();
		
		while(low<high) {
		char temp=ch[low];
		ch[low]=ch[high];
		ch[high]=temp;
		low++;
		high--;
		}
		
		String s=String.copyValueOf(ch);
		System.out.println(s);
	}
	
	
	//Reverse Individual Words in Given String
	public String reverseIndividualWordsGivenString() {
		String finalStr="";
		String tempStr=" ";
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ')
				tempStr=str.charAt(i)+tempStr;
			else {
				finalStr = finalStr + tempStr;
				tempStr=" ";
			}
		}
		
		finalStr = finalStr + tempStr;
		return finalStr;
	}
	
	
	//Reverse words in given String
	public String reverseWordsGivenString() {
		String finalStr="";
		String tempStr="";
		for(int i=0;i<len;i++) {
			if(str.charAt(i)!=' ')
				tempStr=tempStr+str.charAt(i);
			else {
				finalStr = tempStr+" "+ finalStr ;
				tempStr="";
			}
		}
		
		finalStr = tempStr+" " + finalStr;
		return finalStr;
	}
	
	//Find longest sub-string length with K distinct characters
	
	public Integer longestSubstringLengthWithKDistinctCharacters(int k) {
		if(str==null || len==0 || k<=0 || k>len)
			return -1;
		
		
		int maxLength=0;
		int start,end;
		start=end=0;
		
		Map<Character,Integer> map= new HashMap<>();
		
		while(end<len) {
			char currentChar = str.charAt(end);
			map.put(currentChar,map.getOrDefault(currentChar,0)+1);
			
			while(map.size()>k) {
				char charFromFront = str.charAt(start);
				map.put(charFromFront,map.get(charFromFront)-1);
				
				if(map.get(charFromFront)==0)
					map.remove(charFromFront);
				
			start++;	
			}
			maxLength=Math.max(end-start+1,maxLength);
			end++;
			
		}
		
		return maxLength;
	}
	
	
	
	//Longest sub-string length with no repeating characters
	public Integer longestSubstringLengthWithNoRepeatingCharacters() {
		if(str==null || len==0)
			return -1;
		
		
		int maxLength=0;
		int start,end;
		start=end=0;
		
		Map<Character,Integer> map= new HashMap<>();
		
		while(end<len) {
			char currentChar = str.charAt(end);
			
			
			if(map.containsKey(currentChar))
				start=Math.max(start,map.get(currentChar)+1);
			
			map.put(currentChar, end);
			maxLength=Math.max(end-start+1,maxLength);
			end++;
			
		}
		
		return maxLength;
	}
	
	
	//Compare two Strings with backspace characters
	public boolean ifStringEqualContainingBackspace(String str1, String str2) {
	    int end1 = str1.length() - 1;
	    int end2 = str2.length() - 1;

	    while (end1 >= 0 && end2 >= 0) {
	      int str1Index = getChar(str1, end1);
	      int str2Index = getChar(str2, end2);

	      if (str1Index < 0 && str2Index < 0) {
	        return true;
	      }

	      if (str1Index < 0 || str2Index < 0) {
	        return false;
	      }

	      if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
	        return false;
	      }

	      end1 = str1Index - 1;
	      end2 = str2Index - 1;
	    }
	    
	    if(end1 == -1 && end2 == -1)
	      return true;
	    else 
	      return false;
	  }

	  private int getChar(String str, int end) {
	    int specialChar = 0;

	    while (end >= 0) {
	      if (str.charAt(end) != '#') {
	        if (specialChar == 0) {
	          return end;
	        } else {
	          specialChar--;
	        }
	      } else {
	        specialChar++;
	      }
	      end--;
	    }

	    return end;
	  }
	
	
	  
	//Reverse Vowels order in Given String
	  public void reverseVowelOrderInString() {
		  int low=0;
		  int high=len-1;
		  char ch[]=str.toCharArray();
			
			while(low<high) {
				if(!isVowel(ch[low])) {
					low++;
					continue;
				}
				if(!isVowel(ch[high])) {
					high--;
					continue;
				}
				
			char temp=ch[low];
			ch[low]=ch[high];
			ch[high]=temp;
			low++;
			high--;
			}
			String s=String.copyValueOf(ch);
			System.out.println(s);
			
	}
	  
	private boolean isVowel(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			return true;
		else
			return false;
	}

	
//Get Most Frequent word in String
//	public List<String> mostFrequentWordInString(String helpText){
//		helpText = helpText.replaceAll("[^a-zA-Z0-9]"," ");
//		String allWords[] = helpText.split(" +");
//		
//		Map<String,Integer> countingMap = new HashMap<>();
//		for(String word:allWords) {
//			word=word.toLowerCase();
//			countingMap.put(word,countingMap.getOrDefault(word,0)+1);
//		}
//		
//		TreeMap<String,Integer> mostFrequentMap=new TreeMap<>(e1,e2)->{
//			int freq1=cou
//		}
//		
//	}
	
	
	
	public static void main(String[] args) {
		StringApplication ob=new StringApplication();
		String str="abubebi";
		ob.insertElement(str);
//		ob.firstCharacterOfEveryWord();
//		System.out.println(ob.removeUselessSpaceFromString());
//		ob.replaceCharacter();
//		ob.reverseStringiterative();
//		ob.reverseStringStack();
//		ob.reverseStringRecursion(str);
//		System.out.println(ob.reverseIndividualWordsGivenString());
//		System.out.println(ob.reverseWordsGivenString());
//		System.out.println(ob.longestSubstringLengthWithKDistinctCharacters(2));
//		System.out.println(ob.longestSubstringLengthWithNoRepeatingCharacters());
//		System.out.println(ob.ifStringEqualContainingBackspace("abcd##e","bd#e"));
		ob.reverseVowelOrderInString();
//		ob.printString();
		

	}

}
