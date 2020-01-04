package LeetCode.A1v300.A11v20.A11ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int j = height.length -1;
        int i = 0;
        int area = 0;
        while (i < j) {
            area = Math.max((j-i)*Math.min(height[j],height[i]),area);
            if (height[i]>=height[j]){
                j--;
            }else {
                i++;
            }
        }
        return area;
    }
}