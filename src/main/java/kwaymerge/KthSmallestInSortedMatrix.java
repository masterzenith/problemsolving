package kwaymerge;

import java.util.PriorityQueue;

/**
 * Input: Matrix=[
 * [2, 6, 8],
 * [3, 7, 10],
 * [5, 8, 11]
 * ],
 * K=5
 * Output: 7
 * Explanation: The 5th smallest number in the matrix is 7.
 */

class Node1 {
    int row;
    int col;

    Node1(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class KthSmallestInSortedMatrix {

    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node1> minHeap = new PriorityQueue<Node1>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node1(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node1 node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k)
                break;
            node.col++;
            if (matrix[0].length > node.col)
                minHeap.add(node);
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
/**
 * Time: First, we inserted at most ‘K’ or one element from each of the ‘N’ rows, which will take
 * O(min(K, N)). Then we went through at most ‘K’ elements in the matrix and remove/add one element
 * in the heap in each step. As we can’t have more than ‘N’ elements in the heap in any condition,
 * therefore, the overall time complexity of the above algorithm will be O(min(K,N)+K∗logN).
 * Space: The space complexity will be O(N) because, in the worst case, our min-heap will be
 * storing one number from each of the ‘N’ rows.
 */