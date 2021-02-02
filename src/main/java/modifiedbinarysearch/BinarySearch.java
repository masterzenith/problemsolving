package modifiedbinarysearch;

/**
 * Input: [4, 6, 10], key = 10
 * Output: 2
 */
class BinarySearch {

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            // calculate the middle of the current range
            int mid = start + (end - start) / 2;

            if (key == arr[mid])
                return mid;

            if (isAscending) { // ascending order
                if (key < arr[mid]) {
                    end = mid - 1; // the 'key' can be in the first half
                } else { // key > arr[mid]
                    start = mid + 1; // the 'key' can be in the second half
                }
            } else { // descending order
                if (key > arr[mid]) {
                    end = mid - 1; // the 'key' can be in the first half
                } else { // key < arr[mid]
                    start = mid + 1; // the 'key' can be in the second half
                }
            }
        }
        return -1; // element not found
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[]{4, 6, 10}, 10));
        System.out.println(BinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(BinarySearch.search(new int[]{10, 6, 4}, 10));
        System.out.println(BinarySearch.search(new int[]{10, 6, 4}, 4));
    }
}
/**
 * Time: Since, we are reducing the search range by half at every step, this means that the time
 * complexity of our algo will be O(logN) where 'N' is the total elements in the given array.
 * Space: O(1)
 */
