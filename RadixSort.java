import java.util.Arrays;

public class RadixSort {
	public static int[] radixSort(int[] arr) {
		int d;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i] + "";
			if (str.length() > max) {
				max = str.length();
			}
		}
		d = max;
		for (int i = 1; i <= d; i++) {
			int exp = (int) Math.pow(10, i - 1);
			countSort(arr, exp);
		}
		return arr;
	}
	
	/**
	 * Counting sort function gotten from "https://www.geeksforgeeks.org/radix-sort/" then modified
	 * @param arr array to be sorted
	 * @param exp exponent to get the correct digit to be sorted on
	 */
	static void countSort(int arr[], int exp)
    {
        int output[] = new int[arr.length];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        for (i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        for (i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        for (i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
	
	public static void main(String[] ars) {
		int[] arr = {112, 344, 433, 321, 98, 400, 345, 456, 765, 891};
		arr = radixSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
}
