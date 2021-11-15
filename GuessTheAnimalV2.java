import java.util.*;
import java.io.*;

public class GuessTheAnimalV2 {

	public static void main(String[] args) throws Exception {
		guess g = new guess();
		g.algo();
	}

}

class guess {
	Scanner sc;
	PrintWriter w;
	int N;
	ArrayList<String>[] animals;
	ArrayList<Integer> possible = new ArrayList<Integer>();
	
	guess() throws Exception {
		sc = new Scanner(new File("guess.in"));
		w = new PrintWriter("guess.out");
	}
	
	void algo() {
		getInputs();
		int commonTraitCount;

		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++)  {
				commonTraitCount = 0;
				for (int l=0; l<animals[i].size(); l++) {
					for (int k=0; k<animals[j].size(); k++) {
						if (animals[i].get(l).equals(animals[j].get(k))) {
							commonTraitCount++;
						}
					}
				}
				possible.add(commonTraitCount);
			}
		}
		
		System.out.println(Collections.max(possible)+1);
		w.print(Collections.max(possible)+1);
		w.close();
	}
	
	void getInputs() {
		N = sc.nextInt();
		animals = (ArrayList<String>[]) new ArrayList[N];
		int traitsCount;
		String animalName;
		
		for (int i=0; i<N; i++) {
			
			animalName = sc.next();
			traitsCount = sc.nextInt();
			animals[i] = new ArrayList<String>();
			
			for (int j=0; j<traitsCount; j++) {
				animals[i].add(sc.next());
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.println(animals[i]);
		}

	}
}
