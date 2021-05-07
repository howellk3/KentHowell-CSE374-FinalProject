import java.util.*;

public class PatienceSort {

	/**
	 * Inner class to create Pile that uses Comparable
	 * 
	 * NOTE: This Pile class code was taken from "https://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Patience_sort#Java"
	 * Complete citation and credit contained within full report under "Patience Sort"
	 */
	private static class Pile<E extends Comparable<? super E>> extends Stack<E> implements Comparable<Pile<E>> {
		public int compareTo(Pile<E> y) {
			return peek().compareTo(y.peek());
		}
	}

	public static int[] patienceSort(int[] arr) {
		List<Pile<Integer>> allPiles = new ArrayList<Pile<Integer>>(); // Creating list of ALL piles

		// Creates the intitial pile
		Pile<Integer> init = new Pile<Integer>();
		init.push(arr[0]);
		allPiles.add(init);

		// Overall Loop to Construct the piles
		for (int i = 1; i < arr.length; i++) { // This specifically loops through the array elements
			for (int j = 0; j < allPiles.size(); j++) { // Checks the current amount of piles
				// If the current piles top element is > arr[i] then we add arr[i] to the pile
				// and break
				if (arr[i] < allPiles.get(j).peek()) {
					allPiles.get(j).push(arr[i]);
					break;
				}
				// If we have reached the end of the piles then we make a new pile with arr[i]
				// and break
				if (j >= allPiles.size() - 1) {
					Pile<Integer> newPile = new Pile<Integer>();
					newPile.push(arr[i]);
					allPiles.add(newPile);
					break;
				}
			}
		}

		PriorityQueue<Pile<Integer>> queue = new PriorityQueue<Pile<Integer>>(allPiles); // contructs prioirty queue

		int[] result = new int[arr.length]; // result array

		// loops through result array adds from priority queue
		for (int i = 0; i < result.length; i++) {
			Pile<Integer> leastPile = queue.poll(); // gets the least pile from the priority queue
			result[i] = leastPile.pop(); // adds top element to array
			if (!leastPile.isEmpty()) { // if more elements in pile adds pile back into queue in proper place
				queue.offer(leastPile);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 6, 8, 9, 4, 7, 12, 2, 76, 19, 34, 26 };
		int[] result = patienceSort(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
}
