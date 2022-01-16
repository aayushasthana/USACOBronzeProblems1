import java.io.*;
import java.util.*;


public class Problem20Lifeguards {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("lifeguards.in"));
		PrintWriter w = new PrintWriter("lifeguards.out");
		
		int N = sc.nextInt();
		int[] startTimes = new int[N];
		int[] endTimes = new int[N];
		
		for (int i=0; i<N; i++) {
			startTimes[i] = sc.nextInt();
			endTimes[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println();
		System.out.println();
		
		int maxTimeCovered = 0;
		int time = 0;
		int[] shifts = new int[1001];
		
		for (int i=0; i<N; i++) {
			
			for (int k=0; k<N; k++) {
				if (k != i) {
					for (int j=startTimes[k]; j<endTimes[k]; j++) {
						if (shifts[j] == 0) {
							shifts[j] = 1;
							time++;
						}
					}
				}
			}
			
			for (int a=0; a<15; a++) {
				System.out.print(shifts[a]+" ");
			}
			
			
			System.out.println(time);
			maxTimeCovered = Math.max(time, maxTimeCovered);
			time = 0;
			shifts = new int[1001];
		}
		
		w.println(maxTimeCovered);
		w.close();
	}

}
