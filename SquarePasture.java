import java.util.*;
import java.io.*;

public class SquarePasture {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("square.in"));
		PrintWriter w = new PrintWriter("square.out");
		
		/*
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		int x3 = sc.nextInt();
		int y3 = sc.nextInt();
		int x4 = sc.nextInt();
		int y4 = sc.nextInt();
		
		int xMin = Math.min(x1, x3);
		int yMin = Math.min(y1, y3);
		int xMax = Math.max(x2, x4);
		int yMax = Math.max(y2, y4);
		*/
		
		ArrayList<Integer> xValues = new ArrayList<Integer>();
		ArrayList<Integer> yValues = new ArrayList<Integer>();
		
		for (int i=0; i<4; i++) {
			xValues.add(sc.nextInt());
			yValues.add(sc.nextInt());
		}
		
		int xMin = Collections.min(xValues);
		int yMin = Collections.min(yValues);
		int xMax = Collections.max(xValues);
		int yMax = Collections.max(yValues);
		
		System.out.println((yMax-yMin)*(xMax-xMin));
		int sidelength = Math.max(yMax-yMin, xMax-xMin);
		System.out.println(sidelength*sidelength);
		w.println(sidelength*sidelength);
		
		sc.close();
		w.close();
	}

}
