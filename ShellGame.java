import java.util.*;
import java.io.*;

public class ShellGame {

	public static void main(String[] args) throws Exception {
		shell s = new shell();
		s.algo();
	}

}

class shell {
	Scanner sc;
	PrintWriter w;
	int N;
	int count1;
	int count2;
	int count3;
	int[] arr1;
	int[] arr2;
	int[] arr3;
	int[] swappers1;
	int[] swappers2;
	int[] guesses;
	int temp1;
	int temp2;
	
	shell() throws Exception {
		sc = new Scanner(new File("shell.in"));
		w = new PrintWriter("shell.out");
	}
	
	void algo() {
		getInputs();
		showInputs();
		
		for (int i=0; i<N; i++) {
			temp1 = arr1[swappers1[i]];
			temp2 = arr1[swappers2[i]];
			
			arr1[swappers1[i]] = temp2;
			arr1[swappers2[i]] = temp1;
			
			if (arr1[guesses[i]]==1) {
				count1++;
			}
			
			temp1 = 0;
			temp2 = 0;
		}
		
		System.out.println("count 1: "+ count1);
		
		for (int i=0; i<N; i++) {
			temp1 = arr2[swappers1[i]];
			temp2 = arr2[swappers2[i]];
			
			arr2[swappers1[i]] = temp2;
			arr2[swappers2[i]] = temp1;
			
			if (arr2[guesses[i]]==1) {
				count2++;
			}
			
			temp1 = 0;
			temp2 = 0;
		}
		
		System.out.println("count 2: "+ count2);
		
		for (int i=0; i<N; i++) {
			temp1 = arr3[swappers1[i]];
			temp2 = arr3[swappers2[i]];
			
			arr3[swappers1[i]] = temp2;
			arr3[swappers2[i]] = temp1;
			
			if (arr3[guesses[i]]==1) {
				count3++;
			}
			
			temp1 = 0;
			temp2 = 0;
		}
		
		System.out.println("count 3: "+ count3);
		
		System.out.println(Math.max(count3, Math.max(count1, count2)));
		w.println(Math.max(count3, Math.max(count1, count2)));
		
		w.close();
	}
	
	void getInputs() {
		N = sc.nextInt();
		
		count1 = 0;
		arr1 = new int[4];
		arr1[1] = 1;
		
		count2 = 0;
		arr2 = new int[4];
		arr2[2] = 1;
		
		count3 = 0;
		arr3 = new int[4];
		arr3[3] = 1;
		
		swappers1 = new int[N];
		swappers2 = new int[N];
		guesses = new int[N];
		
		for (int i=0; i<N; i++) {
			swappers1[i] = sc.nextInt();
			swappers2[i] = sc.nextInt();
			guesses[i] = sc.nextInt();
		}
		
		sc.close();
	}
	
	void showInputs() {
		System.out.println(N);
		for (int i=0; i<swappers1.length; i++) {
			System.out.println(swappers1[i]+" "+swappers2[i]+" "+guesses[i]);
		}
		System.out.println("Array 1: ");
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("Array 2: ");
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("Array 3: ");
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr3[i]);
		}
		
		System.out.println();
		System.out.println();
	}
}
