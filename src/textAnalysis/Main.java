package textAnalysis;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String filepath = System.getProperty("user.dir");
		//System.out.println(filepath);
		//filepath = filepath + "./loremipsum.txt";
		
		Processor p = new Processor();
		File file = new File("src/textAnalysis/loremipsum.txt");
		
		Article test = new Article(file);
		p.stripPunc(test);
		p.wordCountAnalysis(test);
		
		
		System.out.println("This article has " + test.getWordCount()+ " words written in " + test.getNumStatements() + " sentences.");	
		
		test.printCharStats();
		test.printWordStats();
		
	}
	
}
