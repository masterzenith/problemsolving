package modifiedbinarysearch;

/**
 * Input: [3, 8, 3, 1]
 * Output: 8
 */
class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // at the end of the while loop, 'start == end'
        return arr[start];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(MaxInBitonicArray.findMax(new int[]{3, 8, 3, 1}));
        System.out.println(MaxInBitonicArray.findMax(new int[]{1, 3, 8, 12}));
        System.out.println(MaxInBitonicArray.findMax(new int[]{10, 9, 8}));
    }
}
/**
 * Time: Since we are reducing the search range by half at every step,
 * this means that the time complexity of our algorithm will be O(logN) where ‘N’ is the total
 * elements in the given array.
 * Space: O(1)
 */
