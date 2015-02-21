import java.util.*;
public class BloombergCodeconProblem4 {
	/*
	 * 
	 * Introduction

Ingrid is designing an IDE for plain English. One might say it's simply a text editor, but let's not get into a semantics argument here. Anyways, Ingrid wants to implement a function that does fuzzy search autocompletion on words that users are typing into their editing window. This means that for a given input, all suggestions returned by her autocomplete function should contain all the letters in the input, in order but not necessarily consecutively.

For example, a user input of 'pale' will return words such as 'pallet' and 'palindrome' and 'acetoxyphthalide', but not 'paltry'.

One might also call this a 'subsequence' match, in which the user input is a subsequence of letters of each word in the set of valid words to be returned. Note that this autocomplete feature should be case sensitive, so in the above example, 'pallet' would be a valid match while 'Pallet' would not.

Help Ingrid knock out this utility and get to more important features, like editor colorschemes!


Input Specifications

Your program will take
A number N.
N strings where each representing a pattern that need to be matched.
An unspecificed number of lines, each representing a word in your autocomplete dictionary, against which those patterns should be matched.

Output Specifications

For each pattern print out all the matched words with one per line. Output should be ordered in the following manner:

Pattern order
Order in autocomplete dictionairy
	 */
	public static void main(String[] args)
    {
       Scanner stdin = new Scanner(System.in);
       int number = stdin.nextInt();
       stdin.nextLine();
       String[] smallStrings = new String[number];
       for(int a = 0; a < number; a++){
    	   smallStrings[a] = stdin.nextLine();
       }
       ArrayList<String> input = new ArrayList<String>();
       
       int number2 = stdin.nextInt();
       stdin.nextLine();
       for(int a = 0; a < number2; a++){
    	   
    	   input.add(stdin.nextLine());
       
       }
       
       /*
       while(stdin.hasNextLine()) 
       {
           input.add(stdin.nextLine());
       }
       */
       stdin.close();
       
       
       String temp2 = "";
       
       for(int a = 0; a < number; a++){
    	   for(String temp: input){
    		    temp2 = isItFound(smallStrings[a], temp);
    		   if(temp2 != ""){
    			   System.out.println(temp2);
    		   }
    	   }
       }
    
    
    
    }
	public static String isItFound(String string1, String string2){
		if(isItFound2(string1, string2)){
			return string2;
		}
		return "";
	}
	public static boolean isItFound2(String string1, String string2){
		if (string1.length() == 0){
			return true;
		}
		if (string2.length() == 0){
			return false;
		}
		for(int a = 0; a < string2.length(); a++){
			if(string1.charAt(0) == string2.charAt(a)){
				return isItFound2(string1.substring(1, string1.length()), string2.substring(a, string2.length()));
			}
		}
		return false;
	}
}
