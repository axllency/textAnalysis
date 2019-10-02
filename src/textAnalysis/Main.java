package textAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = System.getProperty("user.dir");
		System.out.println(filepath);
		filepath = filepath + "./loremipsum.txt";
		File file = new File("src/textAnalysis/loremipsum.txt");
		
		Scanner in = null;
		System.out.println(file.exists());
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(in.nextLine());
	}
	
	Set<Character> potato = new HashSet<Character>(); //every punctuation except for ' because of edge cases with apostraphe + s
	//add relevant punctuation to potato (also change name of potato and refactor)
	
	public void stripPunc(String article) {//eventually replace string article with article object
		//String article = thisArticle.getText();
		Character tempCharacter;
		for(int i = 0; i<article.length(); i++) { //for every character in the article
			tempCharacter = article.charAt(i);//convert primitive char to Character
			if(potato.contains(tempCharacter)) {//if char is punctuation
				if(i==0) {//first char is punctuation
					article = " " + article.substring(1); //replace punctuation with space
				} else if(i+1<article.length()){//any char but first or last is punctuation
					article = article.substring(0, i) + " " + article.substring(i+1);
				} else {//last char is punctuation
					article = article.substring(0, i) + " ";
				}
			}
		}
	}
}
