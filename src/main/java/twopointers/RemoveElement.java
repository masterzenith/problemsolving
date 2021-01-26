package twopointers;

/**
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 */
public class RemoveElement {
    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(RemoveElement.remove(arr, 3));
        arr = new int[]{2, 11, 2, 2, 1};
        System.out.println(RemoveElement.remove(arr, 2));
    }
}
/**
 * Time: O(N), where N is the total number of elements in the given array
 * Space: the algo will run in constant space O(1)
 */