package slidingwindows;

import java.util.Arrays;

class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int K, int[] arr){
        double[] result = new double[arr.length-K+1];
        for (int i = 0; i <= arr.length-K; i++){
            //find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i+K; j++)
                sum += arr[j];
            result[i] = sum/K; //calculate average
        }
        return result;
    }
    public static void main(String[] args){
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1,3,2,6,-1,4,1,8,2});
        System.out.println("Averages of SubArrays of size K: " + Arrays.toString(result));
    }
}

//Time complexity: since for every element fo the input array, we are calculating the sum fo its next 'K' elements,
//the time complexity of the above algorithm will be O(N*K) where 'N' is the number of elements in the input array.
