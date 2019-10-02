/**
 * 
 */
package textAnalysis;

import java.io.*;

/**
 * @author ajfre
 *
 */
public class Article {
	/**
	 * 
	 */
	//VARS:
	//stop word collection/set/map? 'Stop words' are never going to change as far as this is concerned

	//article title; type:string/ static
	//article body; type:string?/ static
	//article body preprocessed; type:string?
	
	//number of words/maybe just use a collection? can preprocess through a collection as well
	//number of sentences
	//collection of positive words. map? probably library
	//collection of negative words. map? probably library
	//map of word:frequency
	//map of punctuation:frequency
	//some sort of sentiment analysis object tbd
	
	
	public Article(File txt) {
		//Create a new 'article' object based off of a chosen text document. 
		//Attributes of article ON CREATION: body of article
		
		//First step is try/catch: parse file to string.
		//Can add in counters for # words, statements? (May need to count words later if line-based parsing)
		
		//Step 2: Regex to remove stop words based on a preset dictionary(?), string up to starting char + string after ending char. 
		//Foreseeable issues with this approach: iterator? May need to change iteration numbers based on char index removal
	}
	
	
	//METHODS: 	get # words, get # sentences, get # etc.
	//			get preproc version, get full version
	//			create a method to do all the heavy-duty calculations instead of adding load to creation
	//			unrolled loop? worth doing?
	//			define a custom equal-to method defined based on article text
	
	//			may theoretically require a setter for body/preprocessed body if an external class is used 
	

}
