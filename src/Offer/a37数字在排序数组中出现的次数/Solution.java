package Offer.a37数字在排序数组中出现的次数;

public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int f = findStart(array, k, 0, array.length - 1);
        int e = findEnd(array, k, 0, array.length - 1);
        if (f == -1 || e == -1) {
            return 0;
        }
        return e - f + 1;
    }

    private int findStart(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                if (mid - 1 >= 0 && array[mid - 1] != k || mid == 0) {
                    return mid;
                } else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    private int findEnd(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                if (mid + 1 < array.length && array[mid + 1] != k || mid == array.length - 1) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        new Solution().GetNumberOfK(new int[]{0, 1, 1, 1, 2, 3, 4, 5, 6}, 7);
    }
}