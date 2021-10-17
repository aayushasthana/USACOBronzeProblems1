import java.io.File;
import java.util.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class mowingTheField {

	public static void main(String[] args) throws Exception {
		
		mowing mo = new mowing();
		mo.algo();
		
	}
	
}

class mowing {
	int N;
	point currentPosition;
	int currentTime;
	point[] points;
	PrintWriter w;
	Scanner sc;
	List<Integer> possibleX = new ArrayList<Integer>();
	
	public mowing() throws Exception {
		w = new PrintWriter("mowing.out");
		sc = new Scanner(new File("mowingw.in"));
	}
	
	public void getInputs() {
		N = sc.nextInt();
		points = new point[(N*10)+1];
		for (int i=0; i<points.length; i++) {
			points[i] = new point();
		}
		
		
		currentPosition = new point();
		points[0].x = 0;
		points[0].y = 0;
		
		currentTime = 0;
	}
	
	public void algo() throws Exception {
		getInputs();
		
		for (int i=0; i<N; i++) {
			move(sc.next(), sc.nextInt());
		}
		
		/*
		for (int i=0; i<points.length; i++) {
			System.out.println("i: " + i + " " + points[i].x+" "+points[i].y);
		}
		*/
		
		for (int i=0; i<possibleX.size(); i++) {
			if (i%10 == 0) {
				System.out.println();
			}
			System.out.printf("%d:%d  ", i, possibleX.get(i));
		}
		
		if (possibleX.size() != 0) {
			System.out.println(Collections.min(possibleX));
			w.println(Collections.min(possibleX));
		}
		else {
			System.out.println(-1);
			w.println(-1);
		}
		
		sc.close();
		w.close();
	}
	
	private void move(String direction, int mag) {
		if (direction.equals("N")) {
			for (int i=0; i<mag; i++) {
				currentPosition.y++;
				updatePoints(i);
			}
		}
		
		else if (direction.equals("S")) {
			for (int i=0; i<mag; i++) {
				currentPosition.y--;
				updatePoints(i);
			}
		}
		
		else if (direction.equals("E")) {
			for (int i=0; i<mag; i++) {
				currentPosition.x++;
				updatePoints(i);
			}
		}
		
		else if (direction.equals("W")) {
			for (int i=0; i<mag; i++) {
				currentPosition.x--;
				updatePoints(i);
			}
		}
	}

	
	private void updatePoints(int i) {
		currentTime++;
		int j=findIndex(currentPosition);
		if (j!=-1) {
			possibleX.add(currentTime - findIndex(currentPosition));
		}
		
		points[currentTime].x = currentPosition.x;
		points[currentTime].y = currentPosition.y;		
	}
	
	
	private int findIndex(point t) {
 
        int retval = -1;
        
        for (int i=0; i<points.length; i++) {
        	if ((points[i].x == t.x) && (points[i].y == t.y)) {
        		retval = i;
        		break;
        	}
        }
        return retval;
    }
}

class point {
	public int x;
	public int y;
}
