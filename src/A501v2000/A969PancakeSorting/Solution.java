package A501v2000.A969PancakeSorting;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<Integer>();
        if(A == null || A.length == 0) {
            return list;
        }
        for(int i = 0, max = A.length; i < A.length; i++, max--) {
            for(int j = 0; j < max; j++) {
                if(A[j] == max) {
                    reverse(A, 0, j);
                    reverse(A, 0, max - 1);
                    list.add(j + 1);
                    list.add(max);
                    break;
                }
            }
        }
        return list;
    }

    private void reverse(int[] arr, int s, int e) {
        while(s < e) {
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }

}