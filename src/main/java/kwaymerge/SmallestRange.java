package kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
 * Output: [4, 7]
 * Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
 */

class SmallestRange {

    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                (n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;
        // put the 1st element of each array in the min heap
        for (int i = 0; i < lists.size(); i++)
            if (lists.get(i) != null) {
                minHeap.add(new Node(0, i));
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
            }

        // take the smallest (top) element form the min heap, if it gives us smaller range, update the ranges
        // if the array of the top element has more elements, insert the next element in the heap
        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();
            if (rangeEnd - rangeStart > currentMaxNumber - lists.get(node.arrayIndex)[node.elementIndex]) {
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMaxNumber;
            }
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node); // insert the next element in the heap
                currentMaxNumber = Math.max(currentMaxNumber, lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }
        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 5, 8};
        Integer[] l2 = new Integer[]{4, 12};
        Integer[] l3 = new Integer[]{7, 8, 10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
/**
 * Time: Since, at most, we’ll be going through all the elements of all the arrays and will remove/add
 * one element in the heap in each step, the time complexity of the above algorithm will be
 * O(N*logM) where ‘N’ is the total number of elements in all the ‘M’ input arrays.
 * Space: The space complexity will be O(M) because, at any time,
 * our min-heap will be store one number from all the ‘M’ input arrays.
 */