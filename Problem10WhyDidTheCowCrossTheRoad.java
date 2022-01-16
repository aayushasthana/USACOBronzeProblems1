import java.util.*;
import java.io.*;

public class Problem10WhyDidTheCowCrossTheRoad {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("crossroad.in"));
		PrintWriter w = new PrintWriter("crossroad.out");
		
		int N = sc.nextInt();
		int[] cows = new int[N+1];
		int[] positions = new int[N+1];
		
		cows[0] = -1;
		positions[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			cows[i] = sc.nextInt();
			positions[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i=0; i<N+1; i++) {
			System.out.print(cows[i] + " " + positions[i] + "\n");
		}
		
		int curr = -1;
		int count = 0;

		for (int id=1; id<=10; id++) {
			for (int i=1; i<=N; i++) {
				if (cows[i] == id) {
					if (curr == -1) {
						curr = positions[i];
					}
					
					else if (curr != positions[i]) {
						count++;
						curr = positions[i];
					}
				}
			}
			curr = -1;
		}
		
		w.println(count);
		
		w.close();
	}

}
