package textAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

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

}
