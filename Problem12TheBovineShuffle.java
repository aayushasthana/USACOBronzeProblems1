import java.util.*;
import java.io.*;

public class Problem12TheBovineShuffle {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("shuffle.in"));
		PrintWriter w = new PrintWriter("shuffle.out");
		
		int N = sc.nextInt();
		int[] shuffler = new int[N+1];
		int[] current = new int[N+1];
		int[] previous = new int[N+1];
		
		shuffler[0] = -1;
		current[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			shuffler[i] = sc.nextInt();
		}
		
		for (int i=1; i<N+1; i++) {
			current[i] = sc.nextInt();
		}
		
		for (int i=0; i<3; i++) {
			for (int j=1; j<N+1; j++) {
				previous[j] = current[shuffler[j]];
			}
			current = Arrays.copyOf(previous, N+1);
		}
		
		for (int i=1; i<previous.length; i++) {
			System.out.println(current[i]);
		}
		
		for (int i=1; i<previous.length; i++) {
			w.println(current[i]);
		}
		
		w.close();
	}

}
