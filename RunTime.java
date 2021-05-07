

/**
 * 
 * This program is to report the execution time 
 * for the different sorting algorithms on different size arrays
 * 
 */
 
import java.util.*;

public class RunTime {

    /** Main function **/

    public static void main(final String[] args) {
        executionTimeReport();
    }

    // Generates a random array of size 'size'.   
    public static int[] generateRandomArray (int len)
	{
		int [] rarr = new int[len];
		Random rand = new Random();
		for (int c= 0; c< rarr.length; c++)
		{				
			rarr[c] = rand.nextInt(100000000);
		}
	 return rarr;
	}
    
    private static int[] SAMPLE_SIZES = new int[] { 100, 1000, 5000, 10000, 50000, 100000 };
    private static void executionTimeReport() {
    	 
    	 long startTime;
    	 long endTime;
         
    	 System.out.println("Arrays size  |   Pancake   |     Stupid    |    Radix     |   Patience  |   Counting  |");
    	 System.out.print("=======================================================================================\n");
    	 
    	 for (int i = 0; i < SAMPLE_SIZES.length; i++) {
        	int size = SAMPLE_SIZES[i]; 
            
            System.out.print(String.format("  %7d    |",size));

            int[] randomArray = generateRandomArray(size);
            startTime = System.currentTimeMillis();
    		PancakeSort.pancakeSort(randomArray);
    		endTime = System.currentTimeMillis();

    		System.out.format("%7d      |", (endTime - startTime));

    		randomArray = generateRandomArray(size);
            startTime = System.currentTimeMillis();
    		StupidSort.stupidSort(randomArray);
    		endTime = System.currentTimeMillis();
 
    		
    		System.out.format("%7d        |", (endTime - startTime));

    		randomArray = generateRandomArray(size);
            startTime = System.currentTimeMillis();
    		RadixSort.radixSort(randomArray);
    		endTime = System.currentTimeMillis();
    		
    		System.out.format("%7d       |", (endTime - startTime));
    		    		
    		randomArray = generateRandomArray(size);
            startTime = System.currentTimeMillis();
    		PatienceSort.patienceSort(randomArray);
    		endTime = System.currentTimeMillis();
    		
    		System.out.format("%7d      |", (endTime - startTime));
    		
    		
    		randomArray = generateRandomArray(size);
            startTime = System.currentTimeMillis();
    		CountingSort.countingSort(randomArray);
    		endTime = System.currentTimeMillis();
    		
    		System.out.format("%7d      |\n", (endTime - startTime));
    		
    		

        }
    	System.out.print("=======================================================================================\n");
     }

}
