
public class StupidSort {

	public static int[] stupidSort(int[] arr) {
		int index = 0;
		while (index < arr.length) {
			if (index == 0 || arr[index] >= arr[index - 1]) {
				index++;
			} else {
				arr = swap(arr, index, index - 1);
				index -= 1;
			}
		}
		
		return arr;
	}
	
	public static int[] swap(int[] arr, int i, int j) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 6, 8, 9, 4, 7, 12, 2, 76, 19, 34, 26 };
		int[] result = stupidSort(arr);
	}
}
