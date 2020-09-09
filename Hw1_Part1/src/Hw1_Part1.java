
public class Hw1_Part1 {
	
	// Receives an array of integers and calculates minimum, maximum, and average
	// Input: an array of integers, a
	//        an array that will have min, max, and average, statistics
	// Output: No explicit return value
	//         Calculated statistics are returned through the input argument statistics array
	public static void getStatistic(int[] a, double[] statistic) {
		// calculate min., max, and average
		statistic[0] = a[0];
		statistic[1] = a[a.length-1];
		statistic[2] = calculateAverage(a);		
	}
	
	// Receives an array of integers and a percentile, and calculates the percentile rank
	// Input: an array of integers, a
	//        percentile, p
	// Output: the rank of the pth percentile
	public static double getRank(int[] a, int p) {
		double rank = (double)p/100*(a.length+1);
//		System.out.println("length of array = " + a.length);
//		System.out.println("p = " + p);		
//		System.out.println("p/100 = " + (double)p/100);
//		System.out.println("a + 1  = " + (a.length+1));	
//		System.out.println("Rank = " + rank);
		return rank;
	}
	
	// Receives an array of integers and a percentile, and calculates the percentile
	// Input: an array of integers, a
	//        percentile, p
	// Output: the pth percentile
	public static double percentile(int[] a, int p) {
		double rank = getRank(a,p);
//		System.out.println("In percentile, rank = " + rank);
		if(rank%1 == 0) {
			return a[(int)(rank-1)];
		}
		else {
//			System.out.println("rank = " + (rank));
//			System.out.println("Rank%1 = " + (rank%1));
//			System.out.println("(int)rank-1 = " + ((int)rank-1));			
			return a[(int)rank-1] + rank%1 * (a[(int)rank] - a[(int)rank-1]);
		}
	}
	
	public static int percentileCount25(int[] intArray) {
		double percentile = percentile(intArray,25);
		int count = 0;
		
		for(int i : intArray) {
			if(i <= percentile) {
				count++;
			}
		}
		return count;
	}
	
	public static int percentileCount25to50(int[] intArray) {
		double percentile25th = percentile(intArray,25);
		double percentile50th = percentile(intArray,50);
		
		int count = 0;
		
		for(int i : intArray) {
			if(i > percentile25th && i <= percentile50th) {
				count++;
			}
		}
		return count;
	}
	
	public static int percentileCount50to75(int[] intArray) {
		double percentile50th = percentile(intArray,50);
		double percentile75th = percentile(intArray,75);
		
		int count = 0;
		
		for(int i : intArray) {
			if(i > percentile50th && i <= percentile75th) {
				count++;
			}
		}
		return count;
	}
	
	public static int percentileCountAbove75(int[] intArray) {
		double percentile75th = percentile(intArray,75);
		
		int count = 0;
		
		for(int i : intArray) {
			if(i > percentile75th) {
				count++;
			}
		}
		return count;
	}
	
	public static double calculateAverage(int[] intArray) {
		int total = 0;		
		for(int i : intArray) {
//			System.out.println("i = " + i);
			total+=i;			
//			System.out.println("Total = " + total);
		}			
//		System.out.println("Number of observations = " + intArray.length);		
		return (double)total/intArray.length;
	}
	
	
	public static void main(String[] args) {
		
		int[] intArray = {66, 72, 73, 74, 76, 77, 78, 80, 81, 82, 83, 86, 87, 89, 90, 92, 93, 94, 95, 98, 99, 100};
//		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		double[] statistic = new double[3];
		getStatistic(intArray, statistic);
		
		// print min, max, and average
		System.out.println("Smallest = " + statistic[0] + " Largest = " + statistic[1] + " Average = " + statistic[2]);	
		
		double percentile;
		// calculate the 25th percentile
		percentile = percentile(intArray, 25);
		System.out.println("25th percentile is: " + percentile);
		
		// calculate the 50th percentile
		percentile = percentile(intArray, 50);
		System.out.println("50th percentile is: " + percentile);
				
		// calculate the 75th percentile
		percentile = percentile(intArray, 75);
		System.out.println("75th percentile is: " + percentile);
				
		// calculate the number of values in each group
		System.out.println("The number of integers in group 1 is " + percentileCount25(intArray));
		System.out.println("The number of integers in group 2 is " + percentileCount25to50(intArray));
		System.out.println("The number of integers in group 3 is " + percentileCount50to75(intArray));
		System.out.println("The number of integers in group 4 is " + percentileCountAbove75(intArray));
			
	}

}
