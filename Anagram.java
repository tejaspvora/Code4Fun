import java.util.HashMap;
import java.util.Map;


public class Anagram {
	/* Assumptions:
  1) Capital and non capital letters are considered same . Example "a" is same as "A"
  2) Spaces between the phrases will be considered as a character
  3) Numbers can also be part of the input phrase or string
*/
public static void main (String args[]){

	System.out.println(isAnagram("Tejas","Saaatej"));
	System.out.println(isAnagram("Tejas","Satej"));
	System.out.println(isAnagram("Te jas","Satej"));
	System.out.println(isAnagram("Tejas1","1Satej"));
	System.out.println(isAnagram("Tejas","Saatejjjjjjjjjjj"));




}

		public static Boolean isAnagram(String input1 , String input2){
    
    if(input1 == null || input2==null || (input1.length()!=input2.length()))
    		return false;
    
    StringBuffer in1 = new StringBuffer(input1.trim().toLowerCase());
    StringBuffer in2 = new StringBuffer(input2.trim().toLowerCase());
    
    Map<Character,Integer> hs = new HashMap<Character,Integer>();
    hs.put((in1.charAt(0)),1); 
  
    for(int i = 1 ; i < in1.length(); i++){
    	if(hs.containsKey(in1.charAt(i)))
      	hs.put(in1.charAt(i),hs.get(in1.charAt(i))+1);
      hs.put(in1.charAt(i),1);
    }
   
    for(int j = 0 ; j < in2.length(); j++){
    		
        if(hs.get(Character.valueOf(in2.charAt(j)))>1)
        		hs.put(in2.charAt(j),hs.get(in2.charAt(j)-1));
         hs.remove(in2.charAt(j));   
    }
   return hs.isEmpty();
	}
}
