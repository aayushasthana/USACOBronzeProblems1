import java.io.*;
import java.util.*;

public class Problem15HoofPaperScissors {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("hps.in"));
		PrintWriter w = new PrintWriter("hps.out");
		
		int N = sc.nextInt();
		
		//cow1[index] returns cow1's move at the respective game
		//cow2[index] returns cow2's move at the respective game
		
		int[] cow1 = new int[N+1];
		int[] cow2 = new int[N+1];
		
		cow1[0] = -1;
		cow2[0] = -1;
		
		for (int i=1; i<N+1; i++) {
			cow1[i] = sc.nextInt();
			cow2[i] = sc.nextInt();
		}
		
		sc.close();
		
		ArrayList<Integer> possibleWins = new ArrayList<Integer>();
		
		
		int wins = 0;
		
		//1 = Rock, 2 = Paper, 3 = Scissors
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 1) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 2) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		//1 = Rock, 2 = Scissors, 3 = Paper
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 2) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 1) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		//1 = Scissors, 2 = Paper, 3 = Rock
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 2) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 1) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		//1 = Scissors, 2 = Rock, 3 = Paper
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 1) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 2) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		//1 = Paper, 2 = Scissors, 3 = Rock
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 1) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 2) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		//1 = Paper, 2 = Rock, 3 = Scissors
		for (int i=1; i<N+1; i++) {
			if (cow1[i] == 1 && cow2[i] == 2) {
				wins++;
			}
			
			else if (cow1[i] == 2 && cow2[i] == 3) {
				wins++;
			}
			
			else if (cow1[i] == 3 && cow2[i] == 1) {
				wins++;
			}
		}
		
		possibleWins.add(wins);
		wins = 0;
		
		w.println(Collections.max(possibleWins));
		
		w.close();
	}

}
