import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class BlockedBillboardV2 {

	public static void main(String[] args) throws Exception {
		bill b = new bill();
		b.algo();
	}

}

class bill {
	int[][] map;
	Scanner sc;
	PrintWriter w;
	int bill1_x1;
	int bill1_y1;
	int bill1_x2;
	int bill1_y2;
	int bill2_x1;
	int bill2_y1;
	int bill2_x2;
	int bill2_y2;
	int truck_x1;
	int truck_y1;
	int truck_x2;
	int truck_y2;
	int area1;
	int area2;
	int overlap1x;
	int overlap1y;
	int overlap1;
	int overlap2x;
	int overlap2y;
	int overlap2;
	
	bill() throws Exception {
		sc = new Scanner(new File("billboard.in"));
		w = new PrintWriter("billboard.out");
	}
	
	void algo() {
		getInputs();
		
		area1 = (bill1_y2-bill1_y1)*(bill1_x2-bill1_x1);
		overlap1x = Math.max(Math.min(bill1_x2, truck_x2)-Math.max(bill1_x1, truck_x1), 0);
		overlap1y = Math.max(Math.min(bill1_y2, truck_y2)-Math.max(bill1_y1, truck_y1), 0);
		overlap1 = overlap1x * overlap1y;
		System.out.println(area1 - overlap1);
		
		area2 = (bill2_y2-bill2_y1)*(bill2_x2-bill2_x1);
		overlap2x = Math.max(Math.min(bill2_x2, truck_x2)-Math.max(bill2_x1, truck_x1), 0);
		overlap2y = Math.max(Math.min(bill2_y2, truck_y2)-Math.max(bill2_y1, truck_y1), 0);
		overlap2 = overlap2x * overlap2y;
		System.out.println(area2 - overlap2);
		
		System.out.println(area1+area2-overlap1-overlap2);
		w.println(area1+area2-overlap1-overlap2);
		
		sc.close();
		w.close();
	}
	
	void getInputs() {
		bill1_x1 = sc.nextInt();
		bill1_y1 = sc.nextInt();
		bill1_x2 = sc.nextInt();
		bill1_y2 = sc.nextInt();
		
		bill2_x1 = sc.nextInt();
		bill2_y1 = sc.nextInt();
		bill2_x2 = sc.nextInt();
		bill2_y2 = sc.nextInt();
		
		truck_x1 = sc.nextInt();
		truck_y1 = sc.nextInt();
		truck_x2 = sc.nextInt();
		truck_y2 = sc.nextInt();
	}
}
