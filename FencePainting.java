import java.util.*;
import java.io.*;

public class FencePainting {

	public static void main(String[] args) throws Exception {
		PrintWriter w = new PrintWriter("paint.out");
		Scanner sc = new Scanner(new File("paint.in"));
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int area = (b-a)+(d-c);
		
		int overlap = Math.max(Math.min(b, d)-Math.max(a, c), 0);
		System.out.println(area-overlap);
		w.println(area-overlap);
			
		sc.close();
		w.close();
	}

}
