package textAnalysis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Processor {
	List<Character> c = Arrays.asList('.', ',', '<','>','?','!',';',':','\"','`','~','[',']','\\','|','=','+','-','_','/','(',')','@','#','$','%','^','&','*');
	List<String> stopW = Arrays.asList("a","about","above","after","again","against","all","am","an","and","any","are","aren't","as","at","be","because","been","before","being","below","between","both","but","by","can't","cannot","could","couldn't","did","didn't","do","does","doesn't","doing","don't","down","during","each","few","for","from","further","had","hadn't","has","hasn't","have","haven't","having","he","he'd","he'll","he's","her","here","here's","hers","herself","him","himself","his","how","how's","i","i'd","i'll","i'm","i've","if","in","into","is","isn't","it","it's","its","itself","let's","me","more","most","mustn't","my","myself","no","nor","not","of","off","on","once","only","or","other","ought","our","ours","ourselves","out","over","own","same","shan't","she","she'd","she'll","she's","should","shouldn't","so","some","such","than'that","that's","the","their","theirs","them","themselves","then","there","there's","these","they","they'd","they'll","they're","they've","thi","those","through","to","too","under","until","up","very","was","wasn't","we","we'd","we'll","we're","we've","were","weren't","what","what's","when","when's","where","where's","which","while","who","who's","whom","why","why's","with","won't","would","wouldn't","you","you'd","you'll","you're","you've","your","yours","yourself","yourselves");
	
	static Map<Character, Integer> chars;  //every punctuation except for ' because of edge cases with apostrophe + s
	
	
	
	public Processor() {
		chars = new HashMap<Character, Integer>();
		for(Character x : c) {
			chars.put(x, 0);
		}
	}
	
	public void stripPunc(Article temp) {//STRIPS PUNCTUATION
		//String article = thisArticle.getText();
		String article = temp.getPreProcArticleBody();//GET THE BODY OF THE ARTICLE
		Character tempCharacter;
		for(int i = 0; i<article.length(); i++) { //for every character in the article
			tempCharacter = article.charAt(i);//convert primitive char to Character
			if(chars.containsKey(tempCharacter)) {//if char is punctuation
				chars.put(tempCharacter, chars.get(tempCharacter)+1);//replace the current number with number +1, keeping track of 
				if(i==0) {//first char is punctuation
					article = " " + article.substring(1); //replace punctuation with space
				} else if(i+1<article.length()){//any char but first or last is punctuation
					article = article.substring(0, i) + " " + article.substring(i+1);
				} else {//last char is punctuation
					article = article.substring(0, i) + " ";
				}
			}
		}
		
		temp.setNoPunc(article);//UPDATE THE PUNCTUATION-LESS STRING IN THE ARTICLE
		temp.setPuncMap(chars);//update the number of each punctuation mark in the article
	}
	
	public void wordCountAnalysis(Article temp) {//strip stop words, also updates word count of article
		String[] article = temp.getNoPunc().split("\\s+");//regex, splits article into words. uses 1-n spaces as delimiters
		
		temp.setWordCount(article.length);

		Map<String, Integer> words = new HashMap<String, Integer>();//words in the article
		
		for(String s: article) {
			if(words.containsKey(s)) {
				words.put(s, words.get(s)+1);//if word already in map, increment
			} else {
				words.put(s, 1);//base case - word not in map yet
			}
		}
		
		Map<String, Integer> sortedWords = new LinkedHashMap<String, Integer>();//words in the article SORTED (empty rn)
		
		while(!words.isEmpty()) {
			int high = 0;
			String highKey = "";
			for(String s: words.keySet()) {
				if(words.get(s)>high) {//if the current word has occurred more times than the previous most common word has
					high = words.get(s); //store the new number as highest yet found
					highKey = new String(s); //store the key as most common word so far
				}
			}//gone through the whole list, we have the most common word stored in highKey
			sortedWords.put(highKey, words.get(highKey));//put the most common word into sorted word set
			words.remove(highKey);//remove the most common word from the original set of words
		}//eventually words will be empty, and sortedWords will be the complete and sorted set of words in the article
		
		temp.setWords(sortedWords);//send the list of words sorted by frequency into the article object
		
		Map<String, Integer> processedWords = new LinkedHashMap<String, Integer>(sortedWords); //not sure if this is necessary, just being paranoid about memory ref issues
		for(String s: stopW) {//strip stopwords
			if(processedWords.containsKey(s)) {
				processedWords.remove(s);
			}
		}
		
		temp.setProcessedArticle(processedWords);//set processed version of article
		
	}
	
}
