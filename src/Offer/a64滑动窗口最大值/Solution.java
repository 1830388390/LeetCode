package Offer.a64滑动窗口最大值;

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int n = num.length;
        if (n * size == 0) {
            return new ArrayList<>();
        }

        int[] left = new int[n];
        left[0] = num[0];
        int[] right = new int[n];
        right[n - 1] = num[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % size == 0) {
                left[i] = num[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], num[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % size == 0) {
                right[j] = num[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], num[j]);
            }
        }

        ArrayList<Integer> output = new ArrayList<>(n - size + 1);
        for (int i = 0; i < n - size + 1; i++) {
            output.add(Math.max(left[i + size - 1], right[i]));
        }

        return output;
    }
}