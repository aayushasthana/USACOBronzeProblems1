import java.io.*;
import java.util.*;

public class Problem26TheBucketList {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("blist.in"));
		PrintWriter w = new PrintWriter("blist.out");
				
		int N = sc.nextInt();

		int buckets = 0;
		int[] startTimes = new int[N+1];
		int[] endTimes = new int[N+1];
		int[] bucketsRequired = new int[N+1];

		startTimes[0] = -1;
		endTimes[0] = -1;
		bucketsRequired[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			startTimes[i] = sc.nextInt();
			endTimes[i] = sc.nextInt();
			bucketsRequired[i] = sc.nextInt();
		}
				
		sc.close();
		
		int maxBuckets = 0;
		
		for (int time=1; time<1001; time++) {
			for (int i=1; i<N+1; i++) {
				if (time == startTimes[i]) {
					buckets += bucketsRequired[i];
				}
				
				else if (time == endTimes[i]) {
					buckets -= bucketsRequired[i];
				}
			}
			maxBuckets = Math.max(buckets, maxBuckets);
		}
		
		w.print(maxBuckets);
		
		w.close();
	}

}