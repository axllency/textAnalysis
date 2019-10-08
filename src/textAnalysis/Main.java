package textAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String filepath = System.getProperty("user.dir");
		//System.out.println(filepath);
		//filepath = filepath + "./loremipsum.txt";
		
		Processor p = new Processor();
		File file = new File("src/textAnalysis/loremipsum.txt");
		
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(in.nextLine());
		String body= "";
		while(in.hasNext()) {
			body+= in.nextLine();
			body += "\n";
		}
		System.out.println(body);
		System.out.println(p.stripPunc(body));
	}
	
}
