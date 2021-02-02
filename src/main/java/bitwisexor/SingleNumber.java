package bitwisexor;

/**
 * Input: 1, 4, 2, 1, 3, 2, 3
 * Output: 4
 */
class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}
/**
 * Time: O(N) as we iterate through all numbers of the input once.
 * Space: O(1)
 */
