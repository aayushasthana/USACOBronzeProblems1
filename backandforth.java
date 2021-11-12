import java.io.*;
import java.util.*;

public class backandforth {
	static PrintWriter w;
	static Scanner sc;
	static ArrayList<Integer> barn1Buckets = new ArrayList<Integer>();
	static ArrayList<Integer> barn2Buckets = new ArrayList<Integer>();
	static HashSet<Integer> possibleResults = new HashSet<Integer>();
	static int barn1Capicity;
	
	public static void main(String[] args) throws Exception {
		w = new PrintWriter("backforth.out");
		sc = new Scanner(new File("backforth.in"));
		
		getInputs();
		showInputs();
		
		barn1Capicity = 1000;
		
		moveBuckets(0, barn1Buckets, barn2Buckets, barn1Capicity);
		System.out.println(possibleResults);		
		w.print(possibleResults.size());
		
		w.close();
		sc.close();
	}
	
	public static void getInputs() {
		for (int i=0; i<10; i++) {
			barn1Buckets.add(sc.nextInt());
		}
		
		for (int i=0; i<10; i++) {
			barn2Buckets.add(sc.nextInt());
		}
	}
	
	public static void showInputs() {
		System.out.println("Barn 1: ");
		for (int i=0; i<10; i++) {
			System.out.printf("%d ", barn1Buckets.get(i));
		}
		
		System.out.printf("\n\n");
		
		System.out.println("Barn 2: ");
		for (int i=0; i<10; i++) {
			System.out.printf("%d ", barn2Buckets.get(i));
		}
	}
	
	public static void moveBuckets(int depth, ArrayList<Integer> A, 
			ArrayList<Integer> B, int C) {
		
		if (depth < 4) {
			//Moving Barn 1 to Barn 2
			if (depth%2 == 0) {
				for (int i=0; i<A.size(); i++) {
					
					C -= A.get(i);
					int temp = A.remove(i);
					B.add(temp);
					
					moveBuckets(depth+1, A, B, C);
					
					temp = B.remove(B.size()-1);
					A.add(i, temp);
					C += A.get(i);
				}
			}
			
			//Moving Barn 2 to Barn 1
			else if (depth%2 == 1) {
				for (int j=0; j<B.size(); j++) {					
					C += B.get(j);
					int temp = B.remove(j);
					A.add(temp);
					
					moveBuckets(depth+1, A, B, C);
					
					temp = A.remove(A.size()-1);
					B.add(j, temp);
					C -= B.get(j);
				}
			}
		}
		
		else {
			possibleResults.add(C);
			return;
		}	
	}
}
