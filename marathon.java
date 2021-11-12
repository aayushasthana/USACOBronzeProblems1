import java.io.*;
import java.util.*;

public class marathon {

	public static void main(String[] args) throws Exception {
		
		mara m = new mara();
		m.algo();
		
	}

}

class mara {
	Scanner sc;
	PrintWriter w;
	int N;
	ArrayList <Integer> xLocations = new ArrayList<Integer>();
	ArrayList <Integer> yLocations = new ArrayList<Integer>();
	int noSkip;
	int ifSkip;
	int mostSkip = 0;
	int totalDistance = 0;
	
	public mara() throws Exception {
		sc = new Scanner(new File("marathon.in"));
		w = new PrintWriter("marathon.out");
	}
	
	public void algo() {
		getInputs();
		System.out.println(xLocations);
		System.out.println(yLocations);
		
		calculateTotalDistance();
		System.out.println(totalDistance);
		
		for (int i=0; i<N-2; i++) {
			noSkip = Math.abs(xLocations.get(i)-xLocations.get(i+1)) + 
					Math.abs(xLocations.get(i+1)-xLocations.get(i+2)) +
					Math.abs(yLocations.get(i)-yLocations.get(i+1)) +
					Math.abs(yLocations.get(i+1)-yLocations.get(i+2));
			ifSkip = Math.abs(xLocations.get(i)-xLocations.get(i+2)) +
					Math.abs(yLocations.get(i)-yLocations.get(i+2));
			mostSkip = Math.max(mostSkip, noSkip-ifSkip);
		}
		
		System.out.println(totalDistance-mostSkip);
		w.print(totalDistance-mostSkip);
		
		sc.close();
		w.close();
	}
	
	public void getInputs() {
		N = sc.nextInt();
		for (int i=0; i<N; i++) {
			xLocations.add(sc.nextInt());
			yLocations.add(sc.nextInt());
		}
	}
	
	public void calculateTotalDistance() {
		for (int i=0; i<N-1; i++) {
			totalDistance += Math.abs(xLocations.get(i)-xLocations.get(i+1)) +
					Math.abs(yLocations.get(i)-yLocations.get(i+1));
		}
	}
}

class point {
	public int x;
	public int y;
}