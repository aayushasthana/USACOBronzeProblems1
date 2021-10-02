import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class fieldReduction {
	
	public static void main(String[] args) throws Exception{
		PrintWriter w = new PrintWriter("reduce.out");
		Scanner sc = new Scanner(new File("reduce.in"));
		
		//Getting Inputs
		int N = sc.nextInt();
		int[] xLocations = new int[N];
		int[] yLocations = new int[N];
		HashMap<Integer, Integer> coordinatesKeysX = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> coordinatesKeysY = new HashMap<Integer, Integer>();
		
		for (int i=0; i<N; i++) {
			xLocations[i] = sc.nextInt();
			yLocations[i] = sc.nextInt();
			
			coordinatesKeysX.put(xLocations[i], yLocations[i]);
			coordinatesKeysY.put(yLocations[i], xLocations[i]);
			
		}
		
		//Sorting Xs and Ys
		Arrays.sort(xLocations);
		Arrays.sort(yLocations);
		
		//Printing sorted Xs and Ys
		System.out.print("X locations: ");
		for (int i=0; i<xLocations.length; i++) {
			System.out.print(xLocations[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("Y locations: ");
		for (int i=0; i<yLocations.length; i++) {
			System.out.print(yLocations[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		//Printing Coordinates
		System.out.println(coordinatesKeysX);
		System.out.println(coordinatesKeysY);
		
		int xMin = xLocations[0];
		int yMin = yLocations[0];
		int xMax = xLocations[xLocations.length-1];
		int yMax = yLocations[xLocations.length-1];
		
		int[] possibleAreas = new int[4];
		int Area = (xMax-xMin)*(yMax-yMin);
		
		System.out.println("Original Area: "+ Area);
		System.out.println();
		
		int[] xLocationsTemp;
		int[] yLocationsTemp;
		
		//X Min Test
		xLocationsTemp = Arrays.copyOf(xLocations, xLocations.length);
		yLocationsTemp = Arrays.copyOf(yLocations, yLocations.length);
		
		for (int i=0; i<yLocationsTemp.length; i++) {
			if (yLocationsTemp[i] == coordinatesKeysX.get(xLocationsTemp[0])) {
				yLocationsTemp[i] = 0;
				break;
			}
		}
		
		xLocationsTemp[0] = 0;
		
		Arrays.sort(xLocationsTemp);
		Arrays.sort(yLocationsTemp);
		possibleAreas[0] = Math.abs(xMax-xLocationsTemp[1]) * Math.abs(yMax-yLocationsTemp[1]);
		
		//Y Min Test
		xLocationsTemp = Arrays.copyOf(xLocations, xLocations.length);
		yLocationsTemp = Arrays.copyOf(yLocations, yLocations.length);
		
		for (int i=0; i<xLocationsTemp.length; i++) {
			if (xLocationsTemp[i] == coordinatesKeysY.get(yLocationsTemp[0])) {
				xLocationsTemp[i] = 0;
				break;
			}
		}
		
		yLocationsTemp[0] = 0;
		
		Arrays.sort(xLocationsTemp);
		Arrays.sort(yLocationsTemp);
		
		possibleAreas[1] = Math.abs(xMax-xLocationsTemp[1]) * Math.abs(yMax-yLocationsTemp[1]);
		
		//X Max test
		xLocationsTemp = Arrays.copyOf(xLocations, xLocations.length);
		yLocationsTemp = Arrays.copyOf(yLocations, yLocations.length);
		
		for (int i=0; i<yLocationsTemp.length; i++) {
			if (yLocationsTemp[i] == coordinatesKeysX.get(xLocationsTemp[xLocations.length-1])) {
				yLocationsTemp[i] = 0;
			}
		}
		
		xLocationsTemp[xLocations.length-1] = 0;
		
		Arrays.sort(xLocationsTemp);
		Arrays.sort(yLocationsTemp);
		
		possibleAreas[2] = Math.abs(xLocationsTemp[xLocations.length-1]-xMin) * Math.abs(yLocationsTemp[yLocations.length-1]-yMin);
		
		//Y Max test
		xLocationsTemp = Arrays.copyOf(xLocations, xLocations.length);
		yLocationsTemp = Arrays.copyOf(yLocations, yLocations.length);
		
		for (int i=0; i<xLocationsTemp.length; i++) {
			if (xLocationsTemp[i] == coordinatesKeysY.get(yLocationsTemp[yLocations.length-1])) {
				xLocationsTemp[i] = 0;
				break;
			}
		}
		
		yLocationsTemp[yLocations.length-1] = 0;
		
		Arrays.sort(xLocationsTemp);
		Arrays.sort(yLocationsTemp);
		
		possibleAreas[3] = Math.abs(xLocationsTemp[yLocations.length-1]-xMin) * Math.abs(yLocationsTemp[yLocations.length-1]-yMin);
		
		/*
		int xMinTemp = xLocations[1];
		System.out.println("New X min: " + xMinTemp);
		AreaTemp = Math.abs(xMax-xMinTemp)*Math.abs(yMax-coordinatesKeysX.get(xMinTemp));
		possibleAreas[1] = AreaTemp;
		System.out.println(AreaTemp);
		System.out.println();
		
		
		//Calculating Area With new yMin
		int yMinTemp = yLocations[1];
		System.out.println("New Y min: " + yMinTemp);
		AreaTemp = Math.abs(xMax-coordinatesKeysY.get(yMinTemp))*Math.abs(yMax-yMinTemp);
		possibleAreas[2] = AreaTemp;
		System.out.println(AreaTemp);
		System.out.println();
		
		//Calculating Area With new xMax
		int xMaxTemp = xLocations[xLocations.length-2];
		System.out.println("New X max: " + xMaxTemp);
		AreaTemp = Math.abs(xMaxTemp-xMin)*Math.abs(coordinatesKeysX.get(xMaxTemp)-yMin);
		possibleAreas[3] = AreaTemp;
		System.out.println(AreaTemp);
		System.out.println();
		
		//Calculating Area With new yMax
		int yMaxTemp = yLocations[yLocations.length-2];
		System.out.println("New Y max: " + yMaxTemp);
		AreaTemp = Math.abs(coordinatesKeysY.get(yMaxTemp)-xMin)*Math.abs(yMaxTemp-yMin);
		possibleAreas[4] = AreaTemp;
		System.out.println(AreaTemp);
		System.out.println();
		*/
		
		
		for (int i=0; i<possibleAreas.length; i++) {
			System.out.println(possibleAreas[i]);
		}
		
		Arrays.sort(possibleAreas);
		w.println(possibleAreas[0]);
		
		w.close();
		sc.close();
	}
}

