import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class cowntacttracing {

	public static void main(String[] args) throws Exception{

		PrintWriter w = new PrintWriter("tracing.out");
		Scanner sc = new Scanner(new File("tracing.in"));
		
		tracing t = new tracing(sc,w);
		t.algo();
		
		w.close();
		sc.close();
	}

}

class tracing {
	PrintWriter w;
	Scanner sc; 
	
	int N;
	int T;
	int K;
	cow[] finalConditions;
	//int[][] interactions;
	int cowsWorked;
	
	HashMap<Integer, Integer> interactionsCow1;
	HashMap<Integer, Integer> interactionsCow2;
	
	public tracing(Scanner sc, PrintWriter w) {
		this.sc = sc;
		this.w = w;
	}
	
	public void interact(cow cow1, cow cow2) {
		if (cow1.isSick == 1 & cow2.isSick == 0) {
			cow1.myK++;
			cow2.isSick = 1;
		}
		
		else if (cow2.isSick == 1 & cow1.isSick == 0) {
			cow2.myK++;
			cow1.isSick = 1;
		}
	}
	
	public void getInputs(){
		
		N = sc.nextInt();
		T = sc.nextInt();
		K = sc.nextInt();
		
		finalConditions = new cow[N+1];
		finalConditions[0] = new cow(-1);
		
		for (int i=1; i<finalConditions.length; i++) {
			finalConditions[i] = new cow(1);
		}
		
		for (int i=1; i<=N; i++) {
			finalConditions[i].isSick = sc.nextInt();
		}
		
		interactionsCow1 = new HashMap<Integer, Integer>();
		interactionsCow2 = new HashMap<Integer, Integer>();

		for (int i=0; i<T*3; i++) {
			
		}
	}
	
	public void showInputs() {
		System.out.printf("N: %d\n", N);
		System.out.printf("T: %d\n", T);
		System.out.printf("K: %d\n", K);

		for (int i=1; i<=N; i++) {
			System.out.printf("Cow %d : %d\n", i, finalConditions[i].isSick);
		}
		
		/*
		System.out.println("Interactions:");
		for (int i=0; i<T; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(interactions[i][j] + " ");
			}
		}
		*/
	}
	
	public void algo() {
		getInputs();
		showInputs();
		
		cow[] currentCows = new cow[N+1];
		currentCows[0] = new cow(1);
		
		for (int i=1; i<currentCows.length; i++) {
			currentCows[i] = new cow(1);
		}
		
	}
}

class cow {
	boolean canInfect;
	int isSick;
	int myK=0;
	
	cow(int isDef) {
		if (isDef == -1) {
			isSick=-1;
			canInfect=false;
			myK=-1;
		}
		
		else {
			isSick=0;
			canInfect=false;
			myK=0;
		}
	}
	
}