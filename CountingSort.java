
public class CountingSort {
	public static int[] countingSort(int[] arr) {
		
		//Loop to find the max so that counts has the correct length
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		int[] counts = new int[max + 1]; //Array to store counts
		
		//Counting the occurence of each of the elements
		//and storing them in the proper index
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i]] = counts[arr[i]] + 1;
		}
		
		//Changing counts elements to be sum of previous counts
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i - 1] + counts[i];
		}
		
		int[] temp = new int[arr.length + 1];
		
		//Saves the numbers in the correct place
		//in temp and decrements its value in count
		for (int i = 0; i < arr.length; i++) {
			int index = counts[arr[i]];
			temp[index] = arr[i];
			counts[arr[i]] = counts[arr[i]] - 1;
		}
		
		//Copies temp but gets rid of the original index
		int[] result = new int[temp.length - 1];
		for (int i = 1, k = 0; i < temp.length; i++, k++) {
			result[k] = temp[i];
		}
		
		return result;
	}
	
	public static void main(String [] args) {
		int[] arr = {3, 5, 6, 1, 1, 3, 2};
		int[] hello = countingSort(arr);
	}
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}
}
