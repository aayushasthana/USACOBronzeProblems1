import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class cowsignal {

	public static void main(String[] args) throws Exception {
		PrintWriter w = new PrintWriter("cowsignal.out");
		Scanner sc = new Scanner(new File("cowsignal.in"));
		
		int row = sc.nextInt();
		int K = sc.nextInt();
		String temp;
		String doubleString = "";
		sc.nextLine();
		
		for (int k=0; k<row; k++) {
			temp = sc.nextLine();
			
			for (int i=0; i<temp.length(); i++) {
				
				if (temp.charAt(i)=='X') {
					for (int a=0; a<K; a++) {
						doubleString = doubleString + "X";
					}
				}
				
				if (temp.charAt(i)=='.') {
					for (int b=0; b<K; b++) {
						doubleString = doubleString + ".";
					}
				}
			}
			
			if (doubleString != "") {
				for (int c=0; c<K; c++) {
					w.println(doubleString);
				}
			}
				
			doubleString = "";
		}
		
		
		
		w.close();
		sc.close();

	}

}
