import java.util.*;
import java.io.*;

public class Teleportation {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("teleport.in"));
		PrintWriter w = new PrintWriter("teleport.out");
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		int teleport1 = sc.nextInt();
		int teleport2 = sc.nextInt();
		
		int noTeleport = Math.abs(end - start);
		
		//Find if teleporter is used
		int possible1 = Math.abs(teleport1-start)+Math.abs(teleport2-end);
		int possible2 = Math.abs(teleport2-start)+Math.abs(teleport1-end);
		
		w.println(Math.min(noTeleport, Math.min(possible1, possible2)));
		
		w.close();
		sc.close();
	}

}
