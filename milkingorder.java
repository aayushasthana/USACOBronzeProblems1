import java.io.*;
import java.util.*;

public class milkingorder {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("1.in"));
		PrintWriter w = new PrintWriter("my1.out");
		
		milkorder mo = new milkorder(sc, w);
		mo.algo();
		sc.close();
	}

}

class milkorder {
	Scanner sc;
	PrintWriter w;
	int totalCows;
	int[] finalPositions;
	int cowsInSocialOrder;
	int[] socialOrder;
	int totalGivenPositions;
	HashMap<Integer,Integer> givenPositions;
	
	public milkorder(Scanner sc, PrintWriter w) {
		this.sc = sc;
		this.w = w;
	}
	
	private void getInputs() {
		totalCows = sc.nextInt();
		finalPositions = new int[totalCows];
		
		cowsInSocialOrder = sc.nextInt();
		socialOrder = new int[cowsInSocialOrder];
		
		totalGivenPositions = sc.nextInt();
		givenPositions = new HashMap<Integer,Integer>();
		
		for (int i=0; i<cowsInSocialOrder; i++) {
			socialOrder[i] = sc.nextInt();
		}
		
		for (int i=0; i<totalGivenPositions; i++) {
			givenPositions.put(sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
	}
	
	private void showInputs() {
			//Final Positions
			System.out.println("Final Positions");
			System.out.println(totalCows + " = # of cows");
			for (int i=0; i<totalCows; i++) {
				System.out.print(finalPositions[i]+" ");
			}
			System.out.print("= final postions");
			System.out.println();
			System.out.println();
			
			//Social Order
			System.out.println("Social Order");
			System.out.println(cowsInSocialOrder + " = # of cows in social order");
			for (int i=0; i<cowsInSocialOrder; i++) {
				System.out.print(socialOrder[i]+" ");
			}
			System.out.print("= social order");
			System.out.println();
			System.out.println();
			
			//Given Positions
			System.out.println("Given Positions");
			System.out.println(totalGivenPositions + " = # of cows with given positions");
			System.out.println(givenPositions + " = given positions");
			System.out.println();	
	}
	
	private int check1Given() {
		int retval = -1;
		if (givenPositions.containsKey(1)) {
			retval = givenPositions.get(1);
		}
		return retval;
	}
	
	private void showFinalPositions() {
		System.out.println("Final positions: ");
		for (int i=0; i<totalCows; i++) {
			System.out.print(finalPositions[i]+" ");
		}
		System.out.println();
		System.out.println();
	}
	
	private void placeGivenPositions() {
		Iterator hmIterator = givenPositions.entrySet().iterator();
		
		while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            finalPositions[(int)mapElement.getValue()-1] = (int)mapElement.getKey();
		}
	}
	
	private void place1Earliest() {
		for (int a = 0; a < finalPositions.length; a++) {
			if (finalPositions[a]==0) {
				a++;
				System.out.println("Final position of 1 = " + a);
				w.println(a);
				w.close();
				System.exit(0);
			}
		}
	}
	
	private void checkAllSections() {
		if (givenPositions.size() == socialOrder.length) {
			Iterator hmIterator = givenPositions.entrySet().iterator();
			
			boolean retval = true;
			
			for (int i=0; i<socialOrder.length; i++) {
				Map.Entry mapElement = (Map.Entry)hmIterator.next();
				if ((int)mapElement.getKey() == socialOrder[i]) {
					continue;
				}
				else {
					retval = false;
					break;
				}
			}
			
			if (retval) {
				System.out.printf("checkAllSections CASE\n");
				place1Earliest();
			}
		}
	}
	
	public void algo() {
		
		getInputs();
		showInputs();
		int check1 = check1Given();
		
		if (check1 == -1) {
			
			//1 not found
			placeGivenPositions();
			checkAllSections();
			showFinalPositions();
			
			//Sections
			
			//x is # of cows in socialOrder before section index cow
			int x=0;
			int gapsInSection=0;
			int k=0;
			
			for (int i = 0; i < socialOrder.length; i++) {
	            for (int j = 0; j < finalPositions.length; j++) {
	                if (socialOrder[i] == finalPositions[j]) {
	                	//Section found
	                	x = i;
	                	k = j;
	                	
                		System.out.printf("Before for gapsInSection:%d, x:%d, j:%d\n", gapsInSection, x, j);
	                	while (finalPositions[k-1]==0) {
	                		System.out.printf("In while gapsInSection:%d, x:%d, j:%d\n", gapsInSection, x, j);
	                		gapsInSection++;
	                		k--;
	                	}
	                	
	                	if (gapsInSection>x) {
	                		System.out.printf("After for gapsInSection:%d, x:%d\n", gapsInSection, x);
	                		place1Earliest();
	                	}
	                	
	                	else {
	                		gapsInSection = 0;
	                		finalPositions[j] = socialOrder[i];
	                		socialOrder[i] = 0;
	                		
	                		if (i==0) {
	                			continue;
	                		}
	                		else {
		                		for (int b = j-1; finalPositions[b] == 0; b--) {
		                			finalPositions[b] = socialOrder[i-1];
		                			socialOrder[i-1] = 0;
		                		}
	                		}
	                	}
	                }
	            }
	        }
			
			place1Earliest();
			
		}
		
		else {
			System.out.println("Case: 1 given");
			System.out.println("Final position of 1 = " + check1);
			w.println(check1);
			w.close();
		}
	}
}
