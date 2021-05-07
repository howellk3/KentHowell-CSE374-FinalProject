
public class PancakeSort {
	
	/**
	 * Sorts an array using the pancake sort algorithm
	 * @param arr array to be sorted
	 * @return sorted array
	 */
	public static int[] pancakeSort(int[] arr) {
		int i = arr.length;
		while (i > 0) {
			int max = Integer.MIN_VALUE;
			int index = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			reverse(arr, index + 1);
			reverse(arr, i);
			i--;
		}
		return arr;
	}
	
	/**
	 * Function to reverse the array up to the input index
	 * @param arr array whose elements will be reversed
	 * @param end index where the reveresal will stop. 
	 * @return array with reversed elements
	 */
	public static int[] reverse (int[] arr, int end) {
		for (int i = 0; i < end / 2; i++) {
			swap(arr, i, end - 1);
			end--;
		}
		return arr;
	}
	
	/**
	 * Helper function to swap two array elements
	 * @param arr array whose elements will be swapped
	 * @param i index of element to be swapped
	 * @param j index of element to be swapped
	 * @return array with swapped elements
	 */
	public static int[] swap(int[] arr, int i, int j) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 3, 5, 8, 1, 5, 9, 10, 6, 17, 12, 15};
		int[] result = pancakeSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
}
