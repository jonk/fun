import java.util.Arrays;
import java.util.ArrayList;

class MergeSort {

    public static void main(String[] args) {
        int[] testArr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(mergeSort(testArr));
        
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        } else {
            return merge(mergeSort(Arrays.copyOfRange(arr, 0, Math.floor(arr.length / 2)),
                         mergeSort(Arrays.copyOfRange(arr, Math.floor((arr.length / 2)) + 1, arr.length - 1)));
        }
    }

    public static int[] merge(int[] left, int[] right) {
        return mergeHelper(left, right, new ArrayList<Integer>());
    }

    private static int[] mergeHelper(int[] left, int[] right, ArrayList<Integer> result) {
        if (left.length == 0) {
            for (int val : right) {
                result.add(val);
            }
        } else if (right.length == 0) {
            for (int val : left) {
                result.add(val);
            }
        } else if (right[0] > left[0]) {
            result.add(left[0]);
            return mergeHelper(Arrays.copyOfRange(left, 1, left.length -1), right, result);
        } else {
            result.add(right[0]);
            return mergeHelper(left, Arrays.copyOfRange(right, 1, right.length -1), result);
        }
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}