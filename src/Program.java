import java.io.IOException;

public class Program {

	public static void main(String[] args) {

//		Example1 prog = new Example1();
//		Example2 prog = new Example2();
//		Example3 prog = new Example3();
//		Example4 prog = new Example4();
//		Example5 prog = new Example5();
		Example6 prog = new Example6();

		try {

			// Ex 1-4
//			int lc = prog.lineCount("Lines.txt");
//			System.out.println("The file has " + lc + " lines");
			
			// Ex 5-6
			prog.readFile("Lines.txt");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
