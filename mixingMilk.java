import java.util.*;
import java.io.*;

public class mixingMilk {

	public static void main(String[] args) throws Exception {
		milk m = new milk();
		m.algo();
	}

}

class milk {
	Scanner sc;
	PrintWriter w;
	int[] capacities = new int[3];
	int[] volumes = new int[3];
	int temp;
	
	milk() throws Exception {
		sc = new Scanner(new File("mixmilk.in"));
		w = new PrintWriter("mixmilk.out");
	}
	
	void algo() {
		getInputs();
		
		for (int i=1; i<=100; i++) {
			if (i%3 == 1) {
				if ((capacities[1]-volumes[1])<volumes[0]) {
					temp = capacities[1]-volumes[1];
					volumes[1] += temp;
					volumes[0] -= temp;
				}
				
				else {
					volumes[1] += volumes[0];
					volumes[0] = 0;
				}
			}
			
			else if (i%3 == 2) {
				if ((capacities[2]-volumes[2])<volumes[1]) {
					temp = capacities[2]-volumes[2];
					volumes[2] += temp;
					volumes[1] -= temp;
				}
				
				else {
					volumes[2] += volumes[1];
					volumes[1] = 0;
				}		
			}
			
			else if (i%3 == 0) {
				if ((capacities[0]-volumes[0])<volumes[2]) {
					temp = capacities[0]-volumes[0];
					volumes[0] += temp;
					volumes[2] -= temp;
				}
				
				else {
					volumes[0] += volumes[2];
					volumes[2] = 0;
				}
			}
		}
		
		printEndResults();
		w.close();
	}
	
	void getInputs() {
		for (int i=0; i<3; i++) {
			capacities[i] = sc.nextInt();
			volumes[i] = sc.nextInt();
		}
	}
	
	void printEndResults() {
		for (int i=0; i<3; i++) {
			System.out.println(volumes[i]);
			w.println(volumes[i]);
		}
	}
}