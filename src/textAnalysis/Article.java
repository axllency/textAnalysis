package textAnalysis;

import java.util.Collection;
import java.io.*;
import java.util.HashMap;

public class Article {

    private static Collection<String> stopWordCol; // Stop Word Collection
    private static Collection<String> punctuationCol; // Punctuation Collection
    private String articleTitle; // Title of the Article
    private String preProcArticleBody; // Article body before stop word and punctuation removal
    private Collection<String> articleBody; // Article body as a collection of its words after processing
    private int wordCount; // Number of words in the article
    private HashMap<String, Integer> wordFrequency; // Map of each unique word in the article with the number of times it appears
    private HashMap<String, Integer> punctuationFrequency; // Map of each unique punctuation in the article with the number of times it appears
    //Statistic Analyzer object

    public Article(String textFile)
    {
        //Convert text file to string and remove stop words and punctuation
    }

    private void calculatePuncFrequency()
    {
        for(char c : preProcArticleBody.toCharArray())
        {
            if(punctuationFrequency.containsKey(c)); // doesn't work
        }
    }

    /**
     * Calculates the number of words within the Article using their frequencies
     */
    private void calculateWordCount()
    {
        wordCount = 0;
        for(Integer i: wordFrequency.values())
        {
            wordCount += i;
        }
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
    public Collection<String> getArticleBody()
    {
        return articleBody;
    }

    /**
     * Gets the number of words in the article body
     * @return Word count
     */
    public int getWordCount()
    {
        return wordCount;
    }

    /**
     * Gets the frequency of a specified String within the article body
     * @param word String tested for frequency
     * @return Number of times specified word appears in article body
     */
    public int getFrequencyOf(String word)
    {
        if(wordFrequency.containsKey(word))
        {
            return wordFrequency.get(word);
        }
        else if(punctuationFrequency.containsKey(word))
        {
            return punctuationFrequency.get(word);
        }
        else return 0;
    }




        //InputStream in = this.getClass().getResourceAsStream("stopWords.txt");
        //String stopWords = in.toString();


}
