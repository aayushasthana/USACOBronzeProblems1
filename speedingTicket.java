import java.util.*;
import java.io.*;

public class speedingTicket {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("speeding.in"));
		PrintWriter w = new PrintWriter("speeding.out");
		
		ArrayList<Integer> speedLimit = new ArrayList<Integer>();
		ArrayList<Integer> bessieSpeed = new ArrayList<Integer>();
		
		ArrayList<Integer> segments1 = new ArrayList<Integer>();
		ArrayList<Integer> speeds1 = new ArrayList<Integer>();
		ArrayList<Integer> segments2 = new ArrayList<Integer>();
		ArrayList<Integer> speeds2 = new ArrayList<Integer>();
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			segments1.add(sc.nextInt());
			speeds1.add(sc.nextInt());
		}
		
		for (int i=0; i<M; i++) {
			segments2.add(sc.nextInt());
			speeds2.add(sc.nextInt());
		}
		
		System.out.println(segments1);
		System.out.println(speeds1);
		System.out.println(segments2);
		System.out.println(speeds2);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<segments1.get(i); j++) {
				speedLimit.add(speeds1.get(i));
			}
		}
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<segments2.get(i); j++) {
				bessieSpeed.add(speeds2.get(i));
			}
		}
		
		for (int i=0; i<100; i++) {
			results.add(bessieSpeed.get(i)-speedLimit.get(i));
		}
		
		System.out.println(speedLimit);
		System.out.println(bessieSpeed);
		System.out.println(results);
		
		if (Collections.max(results) > 0) {
			System.out.println(Collections.max(results));
			w.println(Collections.max(results));
		}
		
		else {
			System.out.println(0);
			w.println(0);
		}

		sc.close();
		w.close();
	}

}
