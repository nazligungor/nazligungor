import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordLists {
	
	ArrayList<String> list = new ArrayList<String>();
	
	public WordLists(String fileName) throws FileNotFoundException{
	//a constructor that takes the name of the dictionary file as the only parameter
		Scanner s = new Scanner(new File(fileName + ".txt"));
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
	}
	public String[] lengthN(int n){
	//returns an array of words of length n
		ArrayList<String> nlength = new ArrayList<String>();
		for(String k : list){
			if(k.length() == n){
				nlength.add(k);
			}
		}
		String[] temp = new String[nlength.size()];
		for(int i = 0; i < nlength.size();i++){
			temp[i] = nlength.get(i);
		}
	return temp;
	}
	
	public String[] startsWith(int n, char firstLetter){
	//returns an array of words of length n beginning with the letter firstLetter
		String[] temp = lengthN(n);
		ArrayList<String> temp2 = new ArrayList<String>();
		for(int i = 0; i < temp.length; i++){
			if(temp[i].charAt(0) == firstLetter){
				temp2.add(temp[i]);
			}
		}
		String[] fin = new String[temp2.size()];
		for(int i = 0; i < temp2.size();i++){
			fin[i] = temp2.get(i);
		}
	return fin;
	}
	public String[] containsLetter(int n, char included){
	//returns an array of words of length n containing the letter included but not beginning with it
		String[] temp = lengthN(n);
		ArrayList<String> temp2 = new ArrayList<String>();
		for(int i = 0; i < temp.length; i++){
			if(temp[i].charAt(0) != included){;
				int count = 0;
				for(int j = 1; j < temp[i].length(); j++){
					if(temp[i].charAt(j) == included){
						count ++;
					}
				}
				if(count >= 1) temp2.add(temp[i]);
			}
		}
		String[] fin = new String[temp2.size()];
		for(int i = 0; i < temp2.size();i++){
			fin[i] = temp2.get(i);
		}
	return fin;
	}
	public String[] vowelHeavy(int n, int m){
	//returns an array of words of length n containing at least m vowels
		ArrayList<String> vowel = new ArrayList<String>();
		vowel.add("a");
		vowel.add("e");
		vowel.add("i");
		vowel.add("o");
		vowel.add("u");
	    String[] temp = lengthN(n);
	    ArrayList<String> heavy = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i < temp.length; i++){
			for(int j = 0; j < n; j++){
			if(vowel.contains(temp[i].charAt(j))){
				count++;
			}
			}
			if(count >= m){
				heavy.add(temp[i]);
		}
		count = 0;
			
		}
		String[] fin = new String[heavy.size()];
		for(int i = 0; i < heavy.size();i++){
			fin[i] = heavy.get(i);
		}
	return fin;
	}
	public String[] multiLetter(int m, char included){
	//returns an array of words with at least m occurrences of the letter included 
		ArrayList<String> temp = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).length(); j++){
			if(included == (list.get(i).charAt(j))){
				count++;
			}
			}
			if(count >= m){
				temp.add(list.get(i));
		}
		count = 0;
			
		}
		String[] fin = new String[temp.size()];
		for(int i = 0; i < temp.size();i++){
			fin[i] = temp.get(i);
		}
	return fin;
	}
}
