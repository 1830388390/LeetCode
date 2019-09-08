package A111v120.A120Triangle;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height  = triangle.size();
        if (height == 1){
            return triangle.get(0).get(0);
        }
        int minPath = Integer.MAX_VALUE;
        for (int h = 1;h<=height - 1;h++){
            for (int index = 0;index<=h;index++){
                if (index == 0){
                    int sum = triangle.get(h - 1).get(0) +triangle.get(h).get(0);
                    triangle.get(h).set(0,sum);
                    if (h == height - 1){
                        minPath = Integer.min(sum,minPath);
                    }
                }else
                if (index == h){
                    int sum = triangle.get(h - 1).get(h-1) +triangle.get(h).get(h);
                    triangle.get(h).set(h,sum);
                    if (h == height - 1){
                        minPath = Integer.min(sum,minPath);
                    }
                }else {
                    int add = Integer.min(triangle.get(h - 1).get(index-1) ,triangle.get(h-1).get(index));
                    int sum = add + triangle.get(h).get(index);
                    triangle.get(h).set(index,sum);
                    if (h == height - 1){
                        minPath = Integer.min(sum,minPath);
                    }
                }

            }
        }
        return minPath;
    }
}