import java.util.*;
import java.io.*;

public class FindTheCow {

	static PrintWriter w;
	static Scanner sc;
	static String str;
	static ArrayList<Integer> pattern1Locations = new ArrayList<Integer>();
	static ArrayList<Integer> pattern2Locations = new ArrayList<Integer>();
	static int count;
	
	public static void main(String[] args) throws Exception {
		w = new PrintWriter("cowfind.out");
		sc = new Scanner(new File("cowfind.in"));
				
		getInputs();
		findPatterns();
		showPatternArrays();
		
		count = 0;
		
		for (int i=0; i<pattern1Locations.size(); i++) {
			for (int j=0; j<pattern2Locations.size(); j++) {
				if (pattern1Locations.get(i) < pattern2Locations.get(j)) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		w.print(count);
		w.close();
	}
	

	public static void getInputs() {
		str = sc.nextLine();
	}
	
	public static void findPatterns() {
		String temp;
		for (int i=0; i<str.length()-1; i++) {
			temp = str.substring(i, i+2);
			if (temp.compareTo("((") == 0) {
				pattern1Locations.add(i);
			}
		}
		
		for (int i=0; i<str.length()-1; i++) {
			temp = str.substring(i, i+2);
			if (temp.compareTo("))") == 0) {
				pattern2Locations.add(i);
			}
		}
	}
	
	public static void showPatternArrays() {
		for (int i=0; i<pattern1Locations.size(); i++) {
			System.out.println(pattern1Locations.get(i));
		}
		
		for (int i=0; i<pattern2Locations.size(); i++) {
			System.out.println(pattern2Locations.get(i));
		}
	}

}

