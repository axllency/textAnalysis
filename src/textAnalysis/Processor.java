package textAnalysis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Processor {
	static List<Character> c = Arrays.asList('.', ',', '<','>','?','!',';',':','\"','`','~','[',']','\\','|','=','+','-','_','/','(',')','@','#','$','%','^','&','*');
	static Set<Character> chars = new HashSet<Character>(c); //every punctuation except for ' because of edge cases with apostrophe + s
	
	public static String stripPunc(String article) {//eventually replace string article with article object
		//String article = thisArticle.getText();
		Character tempCharacter;
		for(int i = 0; i<article.length(); i++) { //for every character in the article
			tempCharacter = article.charAt(i);//convert primitive char to Character
			if(chars.contains(tempCharacter)) {//if char is punctuation
				if(i==0) {//first char is punctuation
					article = " " + article.substring(1); //replace punctuation with space
				} else if(i+1<article.length()){//any char but first or last is punctuation
					article = article.substring(0, i) + " " + article.substring(i+1);
				} else {//last char is punctuation
					article = article.substring(0, i) + " ";
				}
			}
		}
		return article;
	}
	
}
