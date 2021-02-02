package topkelements;

import java.util.PriorityQueue;

/**
 * We can iterate the array and use a max-heap to keep track of the top K2 numbers.
 * We can, then, add the top K2-K1-1 numbers in the max-heap to find the sum of
 * all numbers coming between the K1’th and K2’th smallest numbers.
 */
public class SumOfElementsMaxHeap {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // keep smallest k2 numbers in the max heap
        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1) {
                maxHeap.add(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll(); // as we are interested only in the smallest k2 numbers
                maxHeap.add(nums[i]);
            }
        }

        // get the sum of numbers between k1 and k2 indices
        // these numbers will be at the top of the max heap
        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++)
            elementSum += maxHeap.poll();

        return elementSum;
    }

    public static void main(String[] args) {
        int result = SumOfElementsMaxHeap.findSumOfElements(new int[]{1, 3, 12, 5, 15, 11}, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElementsMaxHeap.findSumOfElements(new int[]{3, 5, 8, 7}, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
/**
 * Time: Since we need to put only the top K2 numbers in the max-heap at any time,
 * the time complexity of the above algorithm will be O(N*logK2).
 * Space: The space complexity will be O(K2), as we need to store the smallest ‘K2’ numbers in the heap.
 */