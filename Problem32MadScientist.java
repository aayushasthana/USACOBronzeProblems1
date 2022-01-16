import java.util.*;
import java.io.*;

public class Problem32MadScientist {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("breedflip.in"));
		PrintWriter w = new PrintWriter("breedflip.out");
		
		int N = sc.nextInt();
		String goal = sc.next();
		String initial = sc.next();
		
		sc.close();
		
		int[] diff = new int[N];
		
		for (int i=0; i<N; i++) {
			if (goal.charAt(i) == initial.charAt(i)) {
				diff[i] = 0;
			}
			
			else {
				diff[i] = 1;
			}
		}
		
		int count = 0;
		boolean start = true;
		for (int i=0; i<N; i++) {
			if (diff[i] == 1 && start) {
				count++;
				start = false;
			}
			
			else if (diff[i] == 0) {
				start = true;
			}
		}
		
		w.println(count);
		
		w.close();
		
	}

}
