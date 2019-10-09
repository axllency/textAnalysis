package textAnalysis;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Article {

    private Map<Character, Integer> punctuation; // Map of each unique punctuation in the article with the number of times it appears
    private Map<String, Integer> words; // Map of each unique word in the article with the number of times it appears

    private Map<String, Integer> processedArticle; //word information sans punctuation and stop words, using a map for easy checking of frequency
    
    private String articleTitle; // Title of the Article
    private String preProcArticleBody; // Article body before stop word and punctuation removal
    private String noPuncBody; //article body sans punctuation - intermediate step

    private int wordCount; // Number of words in the article

    public Article(File file)    {
        //Convert text file to string and remove stop words and punctuation
    	
    	this.articleTitle = file.getName();
    	Scanner in = null;
    	
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String body= "";
		while(in.hasNext()) {//stores file in string
			body+= in.nextLine();
			body += "\n";
		}
		
		this.preProcArticleBody = body;
    }

    public void setPuncMap(Map<Character, Integer> charMap) {
    	this.punctuation = charMap;
    }
    
    public void printCharStats() {//print the types and amounts of punctuation used in the article (excludes apostrophes, however)
    	for(Character z : this.punctuation.keySet()) {
    		if(this.punctuation.get(z)!=0) {
    			System.out.println("Punctuation: ["+ z + "]   |   Occurences: " + this.punctuation.get(z));
    		}
    	}
    }
    
    public void printWordStats() {//print the types and amounts of punctuation used in the article (excludes apostrophes, however)
    	for(String z : this.words.keySet()) {
    		if(this.words.get(z)!=0) {
    			System.out.println("Word: ["+ z + "]   \n  |     Occurrences: " + this.words.get(z));
    		}
    	}
    }
    
    public String getNoPunc() {
    	return noPuncBody;
    }
    
    public void setNoPunc(String s) {//store the non-punctuated version of the article's body || primarily for access by processor
    	this.noPuncBody = s;
    }
  
    public void setWords(Map<String, Integer> wordMap) {
    	this.words = wordMap;
    }

    /**
     * Set the number of words within the article - accessed by processor
     */   
    public void setWordCount(int count) {
    	this.wordCount = count;
    }

    /**
     * Gets the Title of the Article
     * @return Article Title
     */
    public String getArticleTitle()
    {
        return articleTitle;
    }

    /**
     * Gets the article body as a string before processing
     * @return Preprocessed Article Body
     */
    public String getPreProcArticleBody()
    {
        return preProcArticleBody;
    }

    /**
     * Gets the Article body as a collection of strings after processing
     * @return Article body
     */
    public Map<String, Integer> getProcessedArticle()
    {
        return this.processedArticle;
    }
 
    public void setProcessedArticle(Map<String, Integer> art) {
    	this.processedArticle = art;
    }
    
    /**
     * Gets the number of words in the article body
     * @return Word count
     */
    public int getWordCount()
    {
        return this.wordCount;
    }

    /**
     * Gets the frequency of a specified String within the article body
     * @param word String tested for frequency
     * @return Number of times specified word appears in article body
     */
    public int getFrequencyOf(String word)
    {
        if(words.containsKey(word))
        {
            return words.get(word);
        }
        else return 0;
    }


    public int getNumStatements() {
    	int n = punctuation.get('.') + punctuation.get('!') + punctuation.get('?'); //not 100% guaranteed to be accurate [ellipses, '?!', decimals, date formatting, european number formatting]
    	return n;
    }


        //InputStream in = this.getClass().getResourceAsStream("stopWords.txt");
        //String stopWords = in.toString();


}
